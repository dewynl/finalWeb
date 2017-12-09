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
                            <button class="search-toggle" data-toggle="dropdown"><i class="fa fa-search"></i>
                            </button>

                            <div class="dropdown-menu header-search-form">
                                <form action="#">
                                    <input type="text" placeholder="Search">
                                    <button><i class="fa fa-long-arrow-right"></i></button>
                                </form>
                            </div>
                        </div>
                        <!-- header Account -->
                        <div class="header-account float-left">
                            <ul>
                                <li><a href="#"
                                       data-toggle="dropdown"><i class="fa fa-cogs"></i></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="https://devitems.com/preview/outside/login.html">Log in</a>
                                        </li>
                                        <li><a href="https://devitems.com/preview/outside/register.html">Register</a>
                                        </li>
                                        <li><a href="https://devitems.com/preview/outside/register.html#">My Account</a>
                                        </li>
                                        <li><a href="https://devitems.com/preview/outside/wishlist.html">Wish list</a>
                                        </li>
                                        <li><a href="https://devitems.com/preview/outside/checkout.html">Checkout</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
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
                                    <a href="https://devitems.com/preview/outside/checkout.html">Check out</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <nav class="main-menu menu-right float-right" style="display: block;">
                        <ul>
                            <li><a href="/">Home</a>
                            </li>
                            <li><a href="/shop">Tienda</a>
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
