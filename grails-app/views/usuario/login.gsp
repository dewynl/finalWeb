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
                        <h1>LogIN</h1>
                        <ul class="breadcrumb">

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
                <div class="col-xs-12">
                    <div class="wishlist-table table-responsive mb-40">
                        <form action="/usuario/login" method="POST" id="loginForm">
                            <div class="form-group has-feedback">
                                <input type="text" class="form-control" placeholder="Usuario" name="username" id="username">
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="password" class="form-control" placeholder="Contraseña" name="password" id="password">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                            <div class="row">

                                <!-- /.col -->
                                <div class="col-xs-12">
                                    <button type="submit" class="btn btn-primary btn-block btn-flat">Iniciar Sesión</button>
                                </div>
                                <!-- /.col -->
                            </div>
                        </form>


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



