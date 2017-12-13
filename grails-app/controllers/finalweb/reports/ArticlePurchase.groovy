package finalweb.reports

import finalweb.Orden

class ArticlePurchase {
    String id
    String title
    String quantity
    String price
    String total

    static ArrayList<ArticlePurchase> getArticlesFromPurchase(Orden orden) {
        def list = []
        orden.itemOrden.each {
            def ap = new ArticlePurchase(
                    id: it.articulo.id,
                    title: it.articulo.nombre,
                    quantity: "${it.cantidad}",
                    price: "US\$${it.articulo.precio}",
                    total: "US\$${it.articulo.precio * it.cantidad}"
            )
            list.add(ap)
        }
        return list
    }
}