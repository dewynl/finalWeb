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
                        <form action="https://devitems.com/preview/outside/register.html#">
                            <div class="row">
                                <div class="col-sm-6 col-xs-12 mb-20">
                                    <label for="r_f_name">First Name <span class="required">*</span></label>
                                    <input id="r_f_name" type="text">
                                </div>

                                <div class="col-sm-6 col-xs-12 mb-20">
                                    <label for="r_l_name">Last Name <span class="required">*</span></label>
                                    <input id="r_l_name" type="text">
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <label for="r_c_name">Company Name</label>
                                    <input id="r_c_name" type="text">
                                </div>

                                <div class="col-sm-6 col-xs-12 mb-20">
                                    <label for="r_email">Email Address <span class="required">*</span></label>
                                    <input id="r_email" type="email">
                                </div>

                                <div class="col-sm-6 col-xs-12 mb-20">
                                    <label for="r_phone">Phone  <span class="required">*</span></label>
                                    <input id="r_phone" type="text">
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <label for="r_country">Country <span class="required">*</span></label>
                                    <select id="r_country">
                                        <option value="1">Select a country</option>
                                        <option value="2">bangladesh</option>
                                        <option value="3">Algeria</option>
                                        <option value="4">Afghanistan</option>
                                        <option value="5">Ghana</option>
                                        <option value="6">Albania</option>
                                        <option value="7">Bahrain</option>
                                        <option value="8">Colombia</option>
                                        <option value="9">Dominican Republic</option>
                                    </select>
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <label>Address <span class="required">*</span></label>
                                    <input type="text" placeholder="Street address">
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <input type="text" placeholder="Apartment, suite, unit etc. (optional)">
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <label for="r_city">Town / City <span class="required">*</span></label>
                                    <input id="r_city" type="text">
                                </div>

                                <div class="col-sm-6 col-xs-12 mb-20">
                                    <label>State / County <span class="required">*</span></label>
                                    <input type="text">
                                </div>

                                <div class="col-sm-6 col-xs-12 mb-20">
                                    <label for="r_zip">Postcode / Zip <span class="required">*</span></label>
                                    <input id="r_zip" type="text">
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <label class="" for="r_password">Account password<span class="required">*</span>
                                    </label>
                                    <input id="r_password" type="password">
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <label class="" for="r_c_password">Confirm password<span class="required">*</span>
                                    </label>
                                    <input id="r_c_password" type="password">
                                </div>

                                <div class="col-xs-12 mb-20">
                                    <input id="rememberme" type="checkbox">
                                    <label for="rememberme">I agree <a
                                            href="https://devitems.com/preview/outside/register.html#">Terms &amp; Condition</a>
                                    </label>
                                </div>

                                <div class="col-xs-12">
                                    <input value="register" type="submit">
                                </div>
                            </div>
                        </form>
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