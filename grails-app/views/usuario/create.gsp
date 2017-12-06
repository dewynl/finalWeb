<!DOCTYPE html>
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths"
      lang="en" style=""><head><style type="text/css">.gm-style .gm-style-mtc label, .gm-style .gm-style-mtc div {
    font-weight: 400
}
</style><link type="text/css" rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"><style
        type="text/css">.gm-style .gm-style-cc span, .gm-style .gm-style-cc a, .gm-style .gm-style-mtc div {
    font-size: 10px
}
</style><style type="text/css">@media print {
    .gm-style .gmnoprint, .gmnoprint {
        display: none
    }
}

@media screen {
    .gm-style .gmnoscreen, .gmnoscreen {
        display: none
    }
}</style><style type="text/css">.gm-style-pbc {
    transition: opacity ease-in-out;
    background-color: rgba(0, 0, 0, 0.45);
    text-align: center
}

.gm-style-pbt {
    font-size: 22px;
    color: white;
    font-family: Roboto, Arial, sans-serif;
    position: relative;
    margin: 0;
    top: 50%;
    -webkit-transform: translateY(-50%);
    -ms-transform: translateY(-50%);
    transform: translateY(-50%)
}
</style>
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
    <!-- Modernizr JS -->
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>

    <script type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/common.js"></script><script type="text/javascript"
                                                                                                 charset="UTF-8"
                                                                                                 src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/map.js"></script><script
            type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/util.js"></script><script type="text/javascript"
                                                                                               charset="UTF-8"
                                                                                               src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/marker.js"></script><style
            type="text/css">.gm-style {
        font: 400 11px Roboto, Arial, sans-serif;
        text-decoration: none;
    }

    .gm-style img {
        max-width: none;
    }</style><script type="text/javascript" charset="UTF-8"
                     src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/onion.js"></script><script
            type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/controls.js"></script><script
            type="text/javascript" charset="UTF-8"
            src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/stats.js"></script></head>

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
                <div class="col-lg-12">
                    <div class="page-banner-content">
                        <h1>Crear Usuario</h1>
                        <ul class="breadcrumb">

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- END PAGE BANNER SECTION -->

    <!-- PAGE SECTION -->
    <div class="page-section section pt-120 pb-90">
        <div class="container">
            <div class="row mb-40">
                <!-- Contact Map -->

                <!-- Contact Form -->

                <div id="create-usuario" class="content scaffold-create" role="main">

                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <g:hasErrors bean="${this.usuario}">
                        <ul class="errors" role="alert">
                            <g:eachError bean="${this.departamento}" var="error">
                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                                        error="${error}"/></li>
                            </g:eachError>
                        </ul>
                    </g:hasErrors>

                    <div class="contact-form col-md-6 col-xs-12 mb-40">
                        <g:form controller="usuario" action="save" method="POST">
                            <div class="row">
                                <div class="col-sm-12 col-xs-12 mb-20">
                                    <input type="email" name="correo" placeholder="Email">
                                </div>

                                <div class="col-sm-12 col-xs-12 mb-20">
                                    <input type="text" name="nombre" placeholder="Name">
                                </div>

                                <div class="col-sm-12 col-xs-12 mb-20">
                                    <input type="text" name="apellido" placeholder="Last Name">
                                </div>

                                <div class="col-sm-12 col-xs-12 mb-20">
                                    <input type="password" name="clave" placeholder="Password">
                                </div>

                                <div class="col-sm-12 col-xs-12 mb-20">
                                    <input type="number" name="telefono" placeholder="Phone number">
                                </div>

                                <div class="col-sm-12 col-xs-12 mb-20">
                                    <input type="text" name="direccion" placeholder="Address">
                                </div>

                                <div class="col-sm-12 col-xs-12 mb-20">
                                    <label>Tipo de Usuario:</label>
                                    <select name="tipo" class="form-control js-example-basic-single">
                                        <g:each in="${tipos}" var="t">
                                            <option value="${t.key}">${t.val}</option>
                                        </g:each>
                                    </select>
                                </div>

                                <div class="col-xs-12">
                                    <input type="submit" value="CREAR">
                                </div>
                            </div>
                        </g:form>
                    </div>
                </div>

            </div>
            <!-- Contact Info -->

        </div>
    </div>
    <!-- END PAGE SECTION -->

    <!-- FOOTER TOP SECTION START -->
    <div class="footer-top-section section pt-100 pb-60">
        <div class="container">
            <div class="row">

                <!-- Footer Widget -->
                <div class="footer-widget col-md-4 col-sm-6 col-xs-12 mb-40">
                    <h5 class="widget-title">ABOUT THE STORE</h5>

                    <p>There are many variations of passages of Lor available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable</p>
                </div>

                <!-- Footer Widget -->
                <div class="footer-widget col-md-3 col-sm-6 col-xs-12 mb-40">
                    <h5 class="widget-title">CUSTOMER SERVICE</h5>
                    <ul>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Returns &amp; Refunds</a></li>
                        <li><a href="#">Terms &amp; Conditions</a></li>
                        <li><a href="#">online store</a></li>
                    </ul>
                </div>

                <!-- Footer Widget -->
                <div class="footer-widget col-md-2 col-sm-6 col-xs-12 mb-40">
                    <h5 class="widget-title">PROFILE</h5>
                    <ul>
                        <li><a href="#">my Account</a></li>
                        <li><a href="#">Checkout</a></li>
                        <li><a href="#">help</a></li>
                        <li><a href="#">support</a></li>
                    </ul>
                </div>

                <!-- Footer Widget -->
                <div class="footer-widget col-md-3 col-sm-6 col-xs-12 mb-40">
                    <h5 class="widget-title">SIGN UP FOR OUR AWESOME NEWS</h5>

                    <form action="http://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef"
                          method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form"
                          class="sunscribe-form validate" target="_blank" novalidate="">
                        <div id="mc_embed_signup_scroll">
                            <label for="mce-EMAIL" class="hidden">Subscribe to our mailing list</label>
                            <input type="email" value="" name="EMAIL" class="email" id="mce-EMAIL"
                                   placeholder="Email Address" required="">
                            <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups-->
                            <div style="position: absolute; left: -5000px;" aria-hidden="true"><input type="text"
                                                                                                      name="b_6bbb9b6f5827bd842d9640c82_05d85f18ef"
                                                                                                      tabindex="-1"
                                                                                                      value=""></div>

                            <div class="clear"><input type="submit" value="Subscribe" name="subscribe"
                                                      id="mc-embedded-subscribe" class="button"></div>
                        </div>
                    </form>

                    <div class="footer-social fix">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                        <a href="#"><i class="fa fa-pinterest"></i></a>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- FOOTER TOP SECTION END -->

    <!-- FOOTER BOTTOM SECTION START -->
    <div class="footer-bottom-section section">
        <div class="container">
            <div class="row">
                <!-- Copyright -->
                <div class="copyright text-left col-sm-6 col-xs-12">
                    <p>Powered by <a href="https://hastech.company/">HasTech</a></p>
                </div>
                <!-- Payment Method -->
                <div class="footer-menu text-right col-sm-6 col-xs-12">
                    <a href="#">Help &amp; Support</a>
                </div>
            </div>
        </div>
    </div>
    <!-- FOOTER BOTTOM SECTION END -->

</div>
<!-- Body main wrapper end -->


<!-- Placed JS at the end of the document so the pages load faster -->

<!-- jQuery latest version -->
<script src="js/vendor/jquery-3.1.1.min.js"></script>
<!-- Bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<!-- Plugins js -->
<script src="js/plugins.js"></script>
<!-- Google Map APi -->

<!-- Ajax Mail js -->
<script src="js/ajax-mail.js"></script>
<!-- Main js -->
<script src="js/main.js"></script><a id="scrollUp" href="#top"
                                     style="position: fixed; z-index: 2147483647; display: none;"><i
            class="fa fa-angle-up"></i></a>

<asset:javascript src="application.js"/>

</body></html>

