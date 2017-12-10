<!DOCTYPE html>
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths" lang="en" style=""><head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Outside - Minimalist Ecommerce HTML Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

    <asset:stylesheet src="application.css"/>

    <g:javascript src="modernizr-2.8.3.min.js" />



</head>

<body>

<!-- Body main wrapper start -->
<div class="wrapper">

    <!-- START HEADER SECTION -->
    <g:include view="helpers/header.gsp"/>
    <!-- END HEADER SECTION -->

    <!-- PAGE BANNER SECTION -->
    <div class="page-banner-section section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="page-banner-content">
                        <h1>Cart page</h1>
                        <ul class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active">Cart page</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- PAGE SECTION START -->
    <div class="page-section section pt-120 pb-80">
        <div class="container">
            <div class="row">
                <form action="#">
                    <div class="col-xs-12">
                        <div id="list-orden" class="content scaffold-list" role="main">
                            <div class="cart-table table-responsive mb-40">
                                <table>
                                    <thead>
                                    <tr>

                                        <th class="pro-title">Id</th>
                                        <th class="pro-title">Usuario</th>
                                        <th class="pro-title">Direccion Usuario</th>
                                        <th class="pro-quantity">Cantidad articulos</th>
                                        <th class="pro-subtotal">Total</th>
                                        <th class="pro-remove"></th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <g:each in="${ordenes}" var="a">


                                        <tr>
                                            <td class="pro-quantity"><a href="/orden/show/${a.id}"><span class="amount">${a.id}</span></a></td>
                                            <td class="pro-title"><a href="#">${a.usuario.nombre}</a></td>
                                            <td class="pro-title"><a href="#">${a.usuario.direccion}</a></td>
                                            <td class="pro-price"><span class="amount">${a.itemOrden.size()}</span></td>
                                            <td class="pro-quantity"><span class="amount">${a.total}</span></td>

                                            <td class="pro-add-to-cart"><a href="/orden/despachar/${a.id}" class="add-to-cart">Despachar</a>
                                            </td>

                                        </tr>
                                    </g:each>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
    <!-- PAGE SECTION END -->




</div>
<!-- Body main wrapper end -->


<!-- Placed JS at the end of the document so the pages load faster -->

<!-- jQuery latest version -->
<script src="js/vendor/jquery-3.1.1.min.js"></script>
<!-- Bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="js/plugins.js"></script>
<!-- Ajax Mail js -->
<script src="js/ajax-mail.js"></script>
<!-- Main js -->
<script src="js/main.js"></script><a id="scrollUp" href="#top" style="position: fixed; z-index: 2147483647;"><i class="fa fa-angle-up"></i></a>
<asset:javascript src="application.js"/>


</body>
</html>