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
                        <h1>Usuarios</h1>
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
                <form action="#">
                    <div class="col-xs-12">
                        <div class="wishlist-table table-responsive mb-40">


                            <div id="list-usuario" class="content scaffold-list" role="main">
                                <g:if test="${flash.message}">
                                    <div class="message" role="status">${flash.message}</div>
                                </g:if>

                                <table>
                                    <thead>
                                    <tr>
                                        <th class="pro-remove">Correo</th>
                                        <th class="pro-title">Nombre</th>
                                        <th class="pro-title">Apellido</th>
                                        <th class="pro-title">Clave</th>
                                        <th class="pro-title">Telefono</th>
                                        <th class="pro-title">Direccion</th>
                                        <th class="pro-title">Tipo</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <g:each in="${usuarios}" var="c">
                                        <tr>
                                            <td><a href="/usuario/show/${c.id}">${c.correo}</a></td>
                                            <td>${c.nombre}</td>
                                            <td>${c.apellido}</td>
                                            <td>${c.clave}</td>
                                            <td>${c.telefono}</td>
                                            <td>${c.direccion}</td>
                                            <td>${c.tipo}</td>


                                        </tr>
                                    </g:each>
                                    </tbody>
                                </table>
                                <div class="pagination">
                                    <g:paginate total="${usuarioCount ?: 0}"/>
                                </div>
                            </div>

                        </div>
                    </div>
                </form>
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

