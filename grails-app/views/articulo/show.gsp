

<!doctype html>
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths" lang="en" style=""><head>
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

    <g:javascript src="modernizr-2.8.3.min.js" />



</head>

<body>

<!-- Body main wrapper start -->
<div class="wrapper">

    <!-- START HEADER SECTION -->
    <g:include view="helpers/header.gsp"/>
    <!-- END HEADER SECTION -->
    <div id="show-articulo" class="content scaffold-show" role="main">

    <div class="modal-content row">
        <div class="modal-body">
            <button class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>

                <div class="pro-thumb-img-slider slick-initialized slick-slider"><button type="button" class="arrow-prev slick-arrow" style=""><i class="fa fa-angle-left"></i></button>
                    <div class="col-md-5 col-sm-6 col-xs-12 mb-40">

                        <div class="tab-content mb-10">
                        <div class="pro-large-img tab-pane active" id="pro-large-img-1">
                            <img src="data:image/png;base64,${articulo.foto}" alt="">
                        </div>
                        </div>
                    </div>
                </div>
            <!-- QuickView Product Details -->
            <div class="col-md-7 col-sm-6 col-xs-12 mb-40">
                <div class="product-details section">
                    <!-- Title -->
                    <h1 class="title">${articulo.nombre}</h1>
                    <!-- Price Ratting -->
                    <div class="price-ratting section">
                        <!-- Price -->
                        <span class="price float-left"><span class="new">${articulo.precio}</span></span>

                    </div>
                    <div class="price-ratting section">
                        <h5 class="pd-sub-title">Weight</h5>
                        <span class="price float-left"><span class="new">${articulo.peso}</span></span>

                    </div>
                    <!-- Short Description -->
                    <div class="short-desc section">
                        <h5 class="pd-sub-title">Quantity on store</h5>
                        <span class="price float-left"><span class="new">${articulo.cantidad}</span></span>

                </div>
                    <!-- Product Size -->


                    <!-- Quantity Cart -->
                    <div class="quantity-cart section">
                        <div class="product-quantity">
                            <form action="/carrito/agregar">
                                <input type="text" name="cantidad">
                                <input type="number" name="${articulo.id}">
                                <span class="dec qtybtn"><i class="fa fa-angle-left"></i></span><span class="inc qtybtn"><i class="fa fa-angle-right"></i></span></div>
                                <button class="add-to-cart">add to cart</button>
                            </form>


                    </div>



                    <!-- Share -->
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
    <!-- PAGE BANNER SECTION -->
    <div class="page-banner-section section">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="page-banner-content">
                        <h1>shop category</h1>
                        <ul class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active">shop</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END PAGE BANNER SECTION -->

    <!-- PAGE SECTION START -->
    <div class="page-section section pt-120 pb-120">
        <div class="container">






        </div>
    </div>
    <!-- PAGE SECTION END -->

    <!-- QUICK VIEW MODAL START-->
    <!-- QUICK VIEW MODAL END-->

    <!-- FOOTER TOP SECTION START -->
    <g:include view="helpers/footer.gsp"/>

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
<script src="js/main.js"></script><a id="scrollUp" href="#top" style="position: fixed; z-index: 2147483647; display: none;"><i class="fa fa-angle-up"></i></a>
<asset:javascript src="application.js"/>


</body></html>

