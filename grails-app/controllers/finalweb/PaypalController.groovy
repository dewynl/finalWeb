package finalweb

import com.paypal.api.payments.Links
import com.paypal.base.Constants
import groovy.json.JsonSlurper

class PaypalController {

    def paypalService
    String clientId = "AajZmPyuHTh3UV7GmFqDe245_mifd65fgsx7r0nin4nnVBW0qiQEz2kuoKrnwnasQ4cRpT1nNsIgS6CY"
    String clientSecret = "EJFZNmbmj-bjthzbJZQiMyKaUJ0jquMeizGY8Mw8MmuhC_lJxJX13b3Cd6Hh4hwTgBqXJt9qs4xKPtwX"

    def index() {
        println "Carrito Index"
        Usuario currentUser = null
        Carrito carritoUsuario = null;
        if (session.usuario){
            currentUser = session.usuario
            carritoUsuario = Carrito.findByUsuario(currentUser)
        }

        def total = 0d
        carritoUsuario.itemOrdenes.each {
            total += it.articulo.precio * it.cantidad
        }

        String endpoint = "https://api.sandbox.paypal.com"
        Map sdkConfig = [(Constants.CLIENT_ID)    : clientId,
                         (Constants.CLIENT_SECRET): clientSecret,
                         (Constants.ENDPOINT)     : endpoint]

        def accessToken = paypalService.getAccessToken(clientId, clientSecret, sdkConfig)
        def apiContext = paypalService.getAPIContext(accessToken, sdkConfig)

        def details = paypalService.createDetails(subtotal: total)
        def amount = paypalService.createAmount(currency: "USD", total: total.toString(), details: details)

        def transaction = paypalService.createTransaction(amount: amount, description: "Venta Ibei Store", details: details)
        def transactions = [transaction]

        def payer = paypalService.createPayer(paymentMethod: 'paypal')
        def cancelUrl = "http://localhost:7878/carrito/index"
        def returnUrl = "http://localhost:7878/paypal/realizar_pago"

        def redirectUrls = paypalService.createRedirectUrls(cancelUrl: cancelUrl, returnUrl: returnUrl)

        def payment
        try {
            // create the paypal payment
            payment = paypalService.createPayment(
                    payer: payer, intent: 'sale',
                    transactionList: transactions,
                    redirectUrls: redirectUrls,
                    apiContext: apiContext)
        }
        catch (e) {
            flash.message = "Could not complete the transaction because: ${e.message ?: ''}"
            redirect controller: 'bill', action: "show", id: params.refId
            return
        }

        def approvalUrl = ""
        def retUrl = ""
        // retrieve links from returned paypal object
        for (Links links in payment?.links) {
            if (links?.rel == 'approval_url') {
                approvalUrl = links.href
            }
            if (links?.rel == 'return_url') {
                retUrl = links.href
            }
        }
        redirect url: approvalUrl ?: '/', method: 'POST'
    }

    def realizar_pago() {
        if(params.paymentId && params.PayerID) {
            println 'Realizar Pago'
            String endpoint = "https://api.sandbox.paypal.com"
            Map sdkConfig = [:] //= grailsApplication.config.paypal.sdkConfig//[mode: 'live']
            //sdkConfig['grant-type'] = "client_credentials"
            sdkConfig[Constants.CLIENT_ID] = clientId
            sdkConfig[Constants.CLIENT_SECRET] = clientSecret
            sdkConfig[Constants.ENDPOINT] = endpoint
            def accessToken = paypalService.getAccessToken(clientId, clientSecret, sdkConfig)
            def apiContext = paypalService.getAPIContext(accessToken, sdkConfig)
            //the paypal website will add params to the call to your app. Eg. PayerId, PaymentId
            // you will use the params to 'execute' the payment
            def paypalPayment = paypalService.createPaymentExecution(paymentId: params.paymentId, payerId: params.PayerID, apiContext)

            def map = new JsonSlurper().parseText(paypalPayment.toString())
            println map

            forward(controller: 'orden', action: 'recibo_compra', params: ['correcto':true])
        }
        else {
            redirect url: "http://localhost:7878"
        }
    }


}
