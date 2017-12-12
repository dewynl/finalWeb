package finalweb


import com.google.gson.Gson
import org.grails.web.json.JSONArray


class AdminController {

    def index() {

    }
    def compras(){
        def comprasList = Orden.findAll()
        Map<String, Integer> mapa = new HashMap<>()
        def datos = new ArrayList<>()

        comprasList.each { d ->
            def articulos = d.itemOrden

            articulos.each {

                if(mapa.keySet().contains(it.articulo.nombre)){
                    mapa.put(it.articulo.nombre, mapa.get(it.articulo.nombre) + 1);
                }else{
                    mapa.put(it.articulo.nombre,it.cantidad)
                }
            }

        }

        mapa.each {
            def map = new HashMap<>()
            map.put(it.key,it.value)
            datos.add(map)
        }

        Gson gson = new Gson()
       // JSONArray list = new JSONArray(datos);
        render(gson.toJson(datos))


    }

    def pendientes(){
        List<Orden> despachosList = new ArrayList<>()
        Map<String, Integer> mapa = new HashMap<>()
        def datos = new ArrayList<>()

        for(Orden o : Orden.findAll()) {
            if (!o.despachado) despachosList.add(o)
        }

        despachosList.each { d ->
            def articulos = d.itemOrden

            articulos.each {

                if(mapa.keySet().contains(it.articulo.nombre)){

                    mapa.put(it.articulo.nombre, mapa.get(it.articulo.nombre) + 1);
                }else{
                    mapa.put(it.articulo.nombre,it.cantidad)
                }



            }


        }
        println("Pendientes-> "+mapa)

        mapa.each {
            def map = new HashMap<>()
            map.put(it.key,it.value)
            datos.add(map)
        }


        Gson gson = new Gson()
        render(gson.toJson(datos))


    }

    def despachos(){
        List<Orden> despachosList = new ArrayList<>()
        Map<String, Integer> mapa = new HashMap<>()
        def datos = new ArrayList<>()

        for(Orden o : Orden.findAll()) {
            if (o.despachado) despachosList.add(o)
        }

        despachosList.each { d ->
            def articulos = d.itemOrden

            articulos.each {

                if(mapa.keySet().contains(it.articulo.nombre)){

                    mapa.put(it.articulo.nombre, mapa.get(it.articulo.nombre) + 1);
                }else{
                    mapa.put(it.articulo.nombre,it.cantidad)
                }



            }


        }
        println(mapa)

        mapa.each {
            def map = new HashMap<>()
            map.put(it.key,it.value)
            datos.add(map)
        }

        Gson gson = new Gson()
        render(gson.toJson(datos))


    }


}
