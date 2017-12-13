<!doctype html>
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths"
      lang="en" style=""><head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Outside - Minimalist Ecommerce HTML Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

    <!-- All CSS Files -->
    <!-- Bootstrap css -->
    <asset:stylesheet src="application.css"/>
    <g:javascript src="modernizr-2.8.3.min.js"/>
</head>

<body>

<!-- Body main wrapper start -->
<div class="wrapper">

    <!-- START HEADER SECTION -->
    <g:include view="helpers/header.gsp"/>
    <!-- END HEADER SECTION -->
    <div id="show-orden" class="content scaffold-show" role="main">

    </div>
    <!-- PAGE BANNER SECTION -->
    <!-- END PAGE BANNER SECTION -->
    <!-- PAGE SECTION START -->
    <div class="page-section section pt-120 pb-120">
        <div class="container">
            <div class="modal-content row">
                <div class="modal-body">
                    <!-- QuickView Product Details -->
                    <div class="col-md-7 col-sm-6 col-xs-12 mb-40">
                        <div class="product-details section">
                            <!-- Title -->
                            <h1 class="title">Orden No: ${orden.id}</h1>

                            <h3 class="title">Usuario: ${orden.usuario.nombre}</h3>

                            <h3 class="pd-sub-title">Direccion: ${orden.usuario.direccion}</h3>
                            <!-- Price Ratting -->
                            <div class="price-ratting section">
                                <!-- Price -->
                                <h5 class="pd-sub-title">Total:</h5>
                                <span class="price float-left"><span class="new">$ ${orden.total}</span></span>

                            </div>

                            <!-- Short Description -->
                            <div class="short-desc section">
                                <h5 class="pd-sub-title">Articulos</h5>

                                <div class="cart-table table-responsive mb-40">
                                    <table>
                                        <thead>
                                        <tr>
                                            <th class="pro-thumbnail">Imagen</th>
                                            <th class="pro-title">Producto</th>
                                            <th class="pro-price">Precio</th>
                                            <th class="pro-quantity">Cantidad</th>
                                            <th class="pro-subtotal">Total</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <g:each in="${orden.itemOrden}" var="a">

                                            <tr>
                                                <td class="pro-thumbnail"><a href="#"><img
                                                        src="data:image/png;base64,${a.articulo.foto}" alt=""></a></td>
                                                <td class="pro-title"><a href="#">${a.articulo.nombre}</a></td>
                                                <td class="pro-price"><span class="amount">${a.articulo.precio}</span>
                                                </td>
                                                <td class="pro-quantity"><span class="amount">${a.cantidad}</span></td>
                                                <td class="pro-quantity"><span class="amount">${a.cantidad * a.articulo.precio}</span></td>
                                            </tr>
                                        </g:each>

                                        </tbody>
                                    </table>
                                </div>

                            </div>
                            <!-- Product Size -->
                            <!-- Quantity Cart -->
                            <div class="quantity-cart section">
                                <a href="/jasper/generar_archivo_factura/${orden.id}" class="add-to-cart">Resumen Orden</a>
                                <button href="/oden/despachar/${orden.id}" class="add-to-cart">Despachar</button>
                            </div>

                            <div class="share-icons section">
                                <span>share :</span>
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-pinterest"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- PAGE SECTION END -->
    <!-- FOOTER TOP SECTION START -->
    <g:include view="helpers/footer.gsp"/>

</div>
<!-- Body main wrapper end -->
<asset:javascript src="application.js"/>
</body></html>

