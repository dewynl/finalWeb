<!DOCTYPE html>
<!-- saved from url=(0050)https://devitems.com/preview/outside/register.html -->
<html class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange
history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow
opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface
generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths"
      lang="en" style=""><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Outside - Minimalist Ecommerce HTML Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="https://devitems.com/preview/outside/img/favicon.ico">

    <asset:stylesheet src="application.css"/>


    <!-- Modernizr JS -->
    <g:javascript src="modernizr-2.8.3.min.js"/>

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
                        <h1>Crear Articulo</h1>
                        <ul class="breadcrumb">
                            <li><a href="/home">Home</a></li>
                            <li class="active">Crear Artículo</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- PAGE SECTION START -->
    <div class="page-section section pt-120 pb-120">
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 col-xs-12">
                    <div class="login-reg-form">
                        <g:form controller="articulo" action="save" method="POST" enctype="multipart/form-data">
                            <div class="row">
                                <div class="form-group">
                                    <label for="r_f_name">Nombre:<span class="required">*</span></label>
                                    <input name="nombre" id="r_f_name" type="text" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="r_email">Precio:<span class="required">*</span></label>
                                    <input name="precio" id="r_email" type="number" min="0" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="r_city">Peso: <span class="required">*</span></label>
                                    <input name="peso" id="r_city" type="number" min="0" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="r_phone">Cantidad:  <span class="required">*</span></label>
                                    <input name="cantidad" id="r_phone" type="number" min="0" class="form-control">
                                </div>

                                <div class="form-group">
                                    <label for="r_pic">Foto: <span class="required">*</span></label>
                                    <input name="file" id="r_pic" type="file" class="">
                                </div>
                                <div class="">
                                    <input value="register" type="submit">
                                </div>
                            </div>
                        </g:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- PAGE SECTION END -->
    <g:include view="helpers/footer.gsp"/>
</div>
<!-- Body main wrapper end -->

<!-- Placed JS at the end of the document so the pages load faster -->
<asset:javascript src="application.js"/>

</body>
</html>