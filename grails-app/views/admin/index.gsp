<!DOCTYPE html>
<html lang="en-us">

<asset:stylesheet src="admin/main.css"/>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Home Overview | Dashboard UI Kit</title>
    <meta name="description" content="Dashboard UI Kit">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Google Font -->

    <!-- Favicon -->
    <link rel="apple-touch-icon" href="https://zawiastudio.com/dashboard/demo/apple-touch-icon.png">
    <link rel="shortcut icon" href="https://zawiastudio.com/dashboard/demo/favicon.ico" type="image/x-icon">


    <!-- Stylesheet -->

</head>
<body class="o-page">
<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

<div class="o-page__sidebar js-page-sidebar">
    <div class="c-sidebar">
        <a class="c-sidebar__brand u-ml-medium" href="#">
                <a href="/">
                    <g:img dir="images" file="img/bg/logo.png"/>
                </a>

        </a>

        <h4 class="c-sidebar__title">Articulos</h4>
        <ul class="c-sidebar__list">

            <li class="c-sidebar__item">
                <a class="c-sidebar__link is-active" href="/articulo/create">
                    <i class="fa fa-home u-mr-xsmall"></i>Crear
                </a>
            </li>

            <li class="c-sidebar__item">
                <a class="c-sidebar__link is-active" href="/articulo/index">
                    <i class="fa fa-home u-mr-xsmall"></i>Ver
                </a>
            </li>

        </ul>

        <h4 class="c-sidebar__title">Usuarios</h4>
        <ul class="c-sidebar__list">
            <li class="c-sidebar__item">
                <a class="c-sidebar__link is-active" href="/usuario/create">
                    <i class="fa fa-home u-mr-xsmall"></i>Crear
                </a>
            </li>
            <li class="c-sidebar__item">
                <a class="c-sidebar__link is-active" href="/usuario/index">
                    <i class="fa fa-home u-mr-xsmall"></i>Ver
                </a>
            </li>
        </ul>



        <h4 class="c-sidebar__title">Ordenes</h4>
        <ul class="c-sidebar__list">


            <li class="c-sidebar__item">
                <a class="c-sidebar__link is-active" href="/orden/index">
                    <i class="fa fa-home u-mr-xsmall"></i>ver
                </a>
            </li>


        </ul>



    </div><!-- // .c-sidebar -->
</div><!-- // .o-page__sidebar -->

<main class="o-page__content">
    <header class="c-navbar u-mb-medium">

        <h2 class="c-navbar__title u-mr-auto">Account</h2>



    </header>

    <div class="container-fluid">
        <div class="row">
            <div class="col-xl-4">
                <div class="c-graph-card">
                    <div class="c-graph-card__content">
                        <h3 class="c-graph-card__title">Despachos del dia</h3>
                    </div>

                    <div class="c-graph-card__chart"><div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                        <canvas id="despachosChart" width="50" height="50"></canvas>

                    </div>
                </div>
            </div>

            <div class="col-xl-4">
                <div class="c-graph-card">
                    <div class="c-graph-card__content">
                        <h3 class="c-graph-card__title">Compras del dia </h3>
                    </div>

                    <div class="c-graph-card__chart"><div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                        <canvas id="comprasChart" width="50" height="50"></canvas>
                    </div>
                </div>
            </div>

            <div class="col-xl-4">
                <div class="c-graph-card">
                    <div class="c-graph-card__content">
                        <h3 class="c-graph-card__title">Pendientes del dia </h3>
                    </div>

                    <div class="c-graph-card__chart"><div style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                        <canvas id="pendientesChart" width="50" height="50"></canvas>
                    </div>
                </div>
            </div>
        </div>

        <span class="c-divider has-text u-mb-medium">Active Projects</span>

    </div><!-- // .container -->


<asset:javascript src="application.js"/>
<asset:javascript src="admin/main.js"/>


<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"
        integrity="sha256-vyehT44mCOPZg7SbqfOZ0HNYXjPKgBCaqxBkW3lh6bg=" crossorigin="anonymous"></script>
<script type="text/javascript">
    var oilCanvas = document.getElementById("comprasChart");
    Chart.defaults.global.defaultFontFamily = "Lato";
    Chart.defaults.global.defaultFontSize = 18;
    var labels=[];
    var datos =[];
    var colors =[];

    $.ajax({
        url: '/admin/compras', success: function (data) {

            var arr = eval(data);

            arr.forEach(function (t) {

                labels.push(Object.keys(t)[0]);

                datos.push(t[Object.keys(t)[0]]);

                colors.push(getRandomColor())
            });

            pieChart.update();
        }
    });


    var oilData = {
        labels: labels,
        datasets: [
            {

                data: datos,
                backgroundColor: colors
            }]
    };
    var pieChart = new Chart(oilCanvas, {
        type: 'pie',
        data: oilData
    });
    console.log();

    console.log("klklklklk")

    function getRandomColor() {
        var letters = '0123456789ABCDEF';
        var color = '#';
        for (var i = 0; i < 6; i++ ) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }



</script>

<script type="text/javascript">
    var oilCanvas1 = document.getElementById("despachosChart");
    Chart.defaults.global.defaultFontFamily = "Lato";
    Chart.defaults.global.defaultFontSize = 18;
    var labels1=[];
    var datos1 =[];
    var colors1 =[];

    $.ajax({
        url: '/admin/despachos', success: function (data) {

            var arr1 = eval(data);

            arr1.forEach(function (t) {

                labels1.push(Object.keys(t)[0]);

                datos1.push(t[Object.keys(t)[0]]);

                colors1.push(getRandomColor())
            });


            pieChart1.update();
        }
    });


    var oilData1 = {
        labels: labels1,
        datasets: [
            {

                data: datos1,
                backgroundColor: colors1
            }]
    };
    var pieChart1 = new Chart(oilCanvas1, {
        type: 'pie',
        data: oilData1
    });
    console.log();



</script>

<script type="text/javascript">
    var oilCanvas2 = document.getElementById("pendientesChart");
    Chart.defaults.global.defaultFontFamily = "Lato";
    Chart.defaults.global.defaultFontSize = 18;
    var labels2=[];
    var datos2 =[];
    var colors2 =[];

    $.ajax({
        url: '/admin/pendientes', success: function (data) {

            var arr2 = eval(data);

            arr2.forEach(function (t) {

                labels2.push(Object.keys(t)[0]);

                datos2.push(t[Object.keys(t)[0]]);

                colors2.push(getRandomColor())
            });


            pieChart2.update();
        }
    });


    var oilData2 = {
        labels: labels2,
        datasets: [
            {

                data: datos2,
                backgroundColor: colors2
            }]
    };
    var pieChart2 = new Chart(oilCanvas2, {
        type: 'pie',
        data: oilData2
    });
    console.log();



</script>
</main><!-- // .o-page__content -->


</body>
</html>