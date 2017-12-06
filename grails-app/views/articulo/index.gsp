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

            <div class="row">
                <!-- Isotop Product Filter -->
                <div class="isotope-product-filter col-xs-8">
                    <button class="active" data-filter="*">all</button>
                    <button data-filter=".chair">chair</button>
                    <button data-filter=".ptable">table</button>
                    <button data-filter=".home-decor">home decor</button>
                    <button data-filter=".lighting">lighting</button>
                </div>
                <!-- Product Filter Toggle -->
                <div class="col-xs-4">
                    <button class="product-filter-toggle">filter</button>
                </div>
            </div>

            <!-- Product Filter Wrapper -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="product-filter-wrapper">
                        <!-- Product Filter -->
                        <div class="product-filter col-md-3 col-sm-6 col-xs-12 mb-30">
                            <h5>Sort by</h5>
                            <ul class="sort-by">
                                <li><a href="#">Default</a></li>
                                <li><a href="#">Popularity</a></li>
                                <li><a href="#">Average rating</a></li>
                                <li><a href="#">Newness</a></li>
                                <li><a href="#">Price: Low to High</a></li>
                                <li><a href="#">Price: High to Low</a></li>
                            </ul>
                        </div>
                        <!-- Product Filter -->
                        <div class="product-filter col-md-3 col-sm-6 col-xs-12 mb-30">
                            <h5>color filters</h5>
                            <ul class="color-filter">
                                <li><a href="#"><i style="background-color: #000000;"></i>Black</a></li>
                                <li><a href="#"><i style="background-color: #663300;"></i>Brown</a></li>
                                <li><a href="#"><i style="background-color: #FF6801;"></i>Orange</a></li>
                                <li><a href="#"><i style="background-color: #ff0000;"></i>red</a></li>
                                <li><a href="#"><i style="background-color: #FFEE00;"></i>Yellow</a></li>
                            </ul>
                        </div>
                        <!-- Product Filter -->
                        <div class="product-filter col-md-3 col-sm-6 col-xs-12 mb-30">
                            <h5>product tags</h5>
                            <div class="product-tags">
                                <a href="#">New</a>,
                                <a href="#">brand</a>,
                                <a href="#">black</a>,
                                <a href="#">white</a>,
                                <a href="#">chire</a>,
                                <a href="#">table</a>,
                                <a href="#">Lorem</a>,
                                <a href="#">ipsum</a>,
                                <a href="#">dolor</a>,
                                <a href="#">sit</a>,
                                <a href="#">amet</a>
                            </div>
                        </div>
                        <!-- Product Filter -->
                        <div class="product-filter col-md-3 col-sm-6 col-xs-12 mb-30">
                            <h5>Filter by price</h5>
                            <div id="price-range" class="ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"><div class="ui-slider-range ui-corner-all ui-widget-header" style="left: 10%; width: 61.4286%;"></div><span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default" style="left: 10%;"></span><span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default" style="left: 71.4286%;"></span></div>
                            <div class="price-values">
                                <span>Price:</span>
                                <input type="text" class="price-amount">
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div id="list-articulo" class="content scaffold-list" role="main">
                
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
                <div class="isotope-grid row" style="position: relative; height: 4961.38px;">

                    <g:each in="${articulos}" var="a">
                    <!-- product-item product-item-2 start -->
                    <div class="isotope-item chair home-decor col-lg-3 col-md-4 col-sm-6 col-xs-12 mb-50" style="position: absolute; left: 0px; top: 0px;">
                        <div class="product-item product-item-2 text-center">
                            <!-- Product Image -->
                            <div class="product-img">
                                <!-- Image -->
                                <a class="image" href="product-details.html"><img src="data:image/png;base64,${a.foto}" alt=""></a>
                                <!-- Action Button -->
                                <div class="action-btn-2">
                                    <a href="/articulo/show/${a.id}" title="Add to Cart"><i class="pe-7s-cart"></i></a>
                                    <a href="#" data-toggle="modal" data-target="#quickViewModal" title="Quick View"><i class="pe-7s-look"></i></a>
                                    <a class="wishlist" href="#" title="Wishlist"><i class="pe-7s-like"></i></a>
                                </div>
                            </div>
                            <!-- Portfolio Info -->
                            <div class="product-info">
                                <!-- Title -->
                                <h5 class="title"><a href="product-details.html">${a.nombre}</a></h5>
                                <!-- Price -->
                                <div class="price-ratting fix">
                                    <span class="price"><span class="new">${a.precio}</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- product-item product-item-2 end -->
                    </g:each>

                </div>


                <div class="pagination">
                    <g:paginate total="${articuloCount ?: 0}" />
                </div>
            </div>

            <div class="row">
                <div class="text-center col-xs-12 mt-30">
                    <a href="#" class="btn load-more-product">load more</a>
                </div>
            </div>
        </div>
    </div>
    <!-- PAGE SECTION END -->

    <!-- QUICK VIEW MODAL START-->
    <div id="quickViewModal" class="modal fade">
        <div class="container">
            <div class="modal-content row">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal"><span aria-hidden="true">×</span></button>
                    <!-- QuickView Product Images -->
                    <div class="col-md-5 col-sm-6 col-xs-12 mb-40">
                        <!-- Tab panes -->
                        <div class="tab-content mb-10">
                            <div class="pro-large-img tab-pane active" id="pro-large-img-1">
                                <img src="img/product/19.jpg" alt="">
                            </div>
                            <div class="pro-large-img tab-pane" id="pro-large-img-2">
                                <img src="img/product/18.jpg" alt="">
                            </div>
                            <div class="pro-large-img tab-pane" id="pro-large-img-3">
                                <img src="img/product/20.jpg" alt="">
                            </div>
                            <div class="pro-large-img tab-pane" id="pro-large-img-4">
                                <img src="img/product/22.jpg" alt="">
                            </div>
                            <div class="pro-large-img tab-pane" id="pro-large-img-5">
                                <img src="img/product/23.jpg" alt="">
                            </div>
                        </div>
                        <!-- QuickView Product Thumbnail Slider -->
                        <div class="pro-thumb-img-slider slick-initialized slick-slider"><button type="button" class="arrow-prev slick-arrow" style=""><i class="fa fa-angle-left"></i></button>





                            <div aria-live="polite" class="slick-list draggable"><div class="slick-track" role="listbox" style="opacity: 1; width: 1386px; transform: translate3d(-378px, 0px, 0px);"><div class="slick-slide slick-cloned" tabindex="-1" role="option" aria-describedby="slick-slide02" style="width: 126px;" data-slick-index="-3" aria-hidden="true"><a href="#pro-large-img-3" data-toggle="tab" tabindex="-1"><img src="img/product/20.jpg" alt=""></a></div><div class="slick-slide slick-cloned" tabindex="-1" role="option" aria-describedby="slick-slide03" style="width: 126px;" data-slick-index="-2" aria-hidden="true"><a href="#pro-large-img-4" data-toggle="tab" tabindex="-1"><img src="img/product/22.jpg" alt=""></a></div><div class="slick-slide slick-cloned" tabindex="-1" role="option" aria-describedby="slick-slide04" style="width: 126px;" data-slick-index="-1" aria-hidden="true"><a href="#pro-large-img-5" data-toggle="tab" tabindex="-1"><img src="img/product/23.jpg" alt=""></a></div><div class="slick-slide slick-current slick-active" tabindex="-1" role="option" aria-describedby="slick-slide00" style="width: 126px;" data-slick-index="0" aria-hidden="false"><a href="#pro-large-img-1" data-toggle="tab" tabindex="0"><img src="img/product/19.jpg" alt=""></a></div><div class="slick-slide slick-active" tabindex="-1" role="option" aria-describedby="slick-slide01" style="width: 126px;" data-slick-index="1" aria-hidden="false"><a href="#pro-large-img-2" data-toggle="tab" tabindex="0"><img src="img/product/18.jpg" alt=""></a></div><div class="slick-slide slick-active" tabindex="-1" role="option" aria-describedby="slick-slide02" style="width: 126px;" data-slick-index="2" aria-hidden="false"><a href="#pro-large-img-3" data-toggle="tab" tabindex="0"><img src="img/product/20.jpg" alt=""></a></div><div class="slick-slide" tabindex="-1" role="option" aria-describedby="slick-slide03" style="width: 126px;" data-slick-index="3" aria-hidden="true"><a href="#pro-large-img-4" data-toggle="tab" tabindex="-1"><img src="img/product/22.jpg" alt=""></a></div><div class="slick-slide" tabindex="-1" role="option" aria-describedby="slick-slide04" style="width: 126px;" data-slick-index="4" aria-hidden="true"><a href="#pro-large-img-5" data-toggle="tab" tabindex="-1"><img src="img/product/23.jpg" alt=""></a></div><div class="slick-slide slick-cloned" tabindex="-1" role="option" aria-describedby="slick-slide00" style="width: 126px;" data-slick-index="5" aria-hidden="true"><a href="#pro-large-img-1" data-toggle="tab" tabindex="-1"><img src="img/product/19.jpg" alt=""></a></div><div class="slick-slide slick-cloned" tabindex="-1" role="option" aria-describedby="slick-slide01" style="width: 126px;" data-slick-index="6" aria-hidden="true"><a href="#pro-large-img-2" data-toggle="tab" tabindex="-1"><img src="img/product/18.jpg" alt=""></a></div><div class="slick-slide slick-cloned" tabindex="-1" role="option" aria-describedby="slick-slide02" style="width: 126px;" data-slick-index="7" aria-hidden="true"><a href="#pro-large-img-3" data-toggle="tab" tabindex="-1"><img src="img/product/20.jpg" alt=""></a></div></div></div><button type="button" class="arrow-next slick-arrow" style=""><i class="fa fa-angle-right"></i></button></div>
                    </div>
                    <!-- QuickView Product Details -->
                    <div class="col-md-7 col-sm-6 col-xs-12 mb-40">
                        <div class="product-details section">
                            <!-- Title -->
                            <h1 class="title">High Tops</h1>
                            <!-- Price Ratting -->
                            <div class="price-ratting section">
                                <!-- Price -->
                                <span class="price float-left"><span class="new">€ 120.00</span></span>
                                <!-- Ratting -->
                                <span class="ratting float-right">
                                    <i class="fa fa-star active"></i>
                                    <i class="fa fa-star active"></i>
                                    <i class="fa fa-star active"></i>
                                    <i class="fa fa-star active"></i>
                                    <i class="fa fa-star active"></i>
                                    <span> (01 Customer Review)</span>
                                </span>
                            </div>
                            <!-- Short Description -->
                            <div class="short-desc section">
                                <h5 class="pd-sub-title">Quick Overview</h5>
                                <p>There are many variations of passages of Lorem Ipsum avaable, b majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. make an ami jani na.</p>
                            </div>
                            <!-- Product Size -->
                            <div class="product-size section">
                                <h5 class="pd-sub-title">Select Size</h5>
                                <button>s</button>
                                <button class="active">m</button>
                                <button>x</button>
                                <button>xl</button>
                            </div>
                            <!-- Product Color -->
                            <div class="color-list section">
                                <h5 class="pd-sub-title">Select Color</h5>
                                <button class="active" style="background-color: #51bd99;"><i class="fa fa-check"></i></button>
                                <button style="background-color: #ff7a5f;"><i class="fa fa-check"></i></button>
                                <button style="background-color: #baa6c2;"><i class="fa fa-check"></i></button>
                                <button style="background-color: #414141;"><i class="fa fa-check"></i></button>
                            </div>
                            <!-- Quantity Cart -->
                            <div class="quantity-cart section">
                                <div class="product-quantity">
                                    <input type="text" value="0">
                                    <span class="dec qtybtn"><i class="fa fa-angle-left"></i></span><span class="inc qtybtn"><i class="fa fa-angle-right"></i></span></div>
                                <button class="add-to-cart">add to cart</button>
                            </div>
                            <!-- Usefull Link -->
                            <ul class="usefull-link section">
                                <li><a href="#"><i class="pe-7s-mail"></i> Email to a Friend</a></li>
                                <li><a href="#"><i class="pe-7s-like"></i> Wishlist</a></li>
                                <li><a href="#"><i class="pe-7s-print"></i> print</a></li>
                            </ul>
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
    </div>
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

