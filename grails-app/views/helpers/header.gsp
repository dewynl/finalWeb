<%@ page import="finalweb.TipoUsuario" %>
<header class="header-section section sticker stick">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <!-- logo -->
                <div class="header-logo float-left">
                    <a href="/">
                        <g:img dir="images" file="img/bg/logo.png"/>
                    </a>

                </div>
                <!-- header-search & total-cart -->
                <div class="float-right">
                    <div class="header-option-btns float-right">
                        <!-- header-search -->
                        <div class="header-search float-left">
                            <a href="/usuario/logout" ><i class="fa fa-user-times"></i>
                            </a>
                        </div>
                        <!-- header Account -->
                        <div class="header-cart float-left">
                            <!-- Cart Toggle -->
                        <a  href="/usuario/logout"><i clas="fa fa-user-times"></i></a>
                         </div>
                        <!-- Header Cart -->
                        <div class="header-cart float-left">
                            <!-- Cart Toggle -->
                            <a class="cart-toggle" href="#"
                               data-toggle="dropdown">
                                <i class="fa fa-shopping-cart"></i>
                                <span id="cant_articulos">2</span>
                            </a>
                            <!-- Mini Cart Brief -->
                            <div class="mini-cart-brief dropdown-menu text-left">
                                <!-- Cart Products -->
                                <div class="all-cart-product clearfix">
                                    <g:each in="${carrito}" var="a">

                                        <div class="single-cart clearfix">
                                        <div class="cart-image">
                                            <a href="/articulo/show/${a.id}"><img
                                                    src="data:image/png;base64,${a.articulo.foto}"
                                                    alt=""/></a>
                                        </div>

                                        <div class="cart-info">
                                            <h5><a >${a.articulo.nombre}</a>
                                            </h5>

                                            <p>${a.cantidad} x $${a.articulo.precio}</p>
                                            <a href="https://devitems.com/preview/outside/register.html#"
                                               class="cart-delete" title="Remove this item"><i
                                                    class="pe-7s-trash"></i></a>
                                        </div>
                                    </div>
                                    </g:each>


                                </div>
                                <!-- Cart Total -->
                                <div class="cart-totals">
                                    <h5>Total <span>$ ${total}</span></h5>
                                </div>
                                <!-- Cart Button -->
                                <div class="cart-bottom clearfix">
                                    <a href="/carrito/index">Check out</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <nav class="main-menu menu-right float-right" style="display: block;">
                        <ul>
                            <li><a href="/">Home</a>
                            </li>
                            <li><a href="/admin/index">Admin</a>
                            </li>

                            <li><a href="/orden/usuarioOrdenes">Mis Ordenes</a>
                            </li>
                        </ul>
                    </nav>
                </div>

                <div class="mobile-menu"></div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
       // $.ajax({url:'/carrito/count/'})
    </script>
</header>
