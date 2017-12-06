package finalweb

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/"(view:"/articulo")
        "/"{
            controller = "articulo"
            action = "index"
        }
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
