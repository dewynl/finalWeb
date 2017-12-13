package finalweb

/*import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter*/
import finalweb.reports.ResumenOrden
import net.sf.jasperreports.engine.JRExporter
import net.sf.jasperreports.engine.JRExporterParameter
import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.export.JRPdfExporter


class JasperController {

    def index() {}

    def generar_archivo_factura(long id){
        def orden = Orden.findById(id)
        ByteArrayOutputStream pdfStream = null
        try {
            String reportName, jrxmlFileName, dotJasperFileName
            jrxmlFileName = "Invoice"
            reportName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jrxml").file.getAbsoluteFile()
            dotJasperFileName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jasper").file.getAbsoluteFile()
            println reportName
            Map<String, Object> reportParam = new HashMap<String, Object>()
            def lista = ResumenOrden.generarListaResumen(orden)
            def dataSource = new JRBeanCollectionDataSource(lista)

            reportParam.put("nombreUsuario", orden.usuario.nombre + " " + orden.usuario.apellido)
            reportParam.put("emailUsuario", orden.usuario.correo)
            reportParam.put("numOrden", "ORD" + orden.id as String)
            reportParam.put("totalOrden",'US$' + orden.total as String)
            reportParam.put("direccion", orden.usuario.direccion)

            JasperCompileManager.compileReportToFile(reportName);
            JasperPrint print = JasperFillManager.fillReport(dotJasperFileName, reportParam, dataSource);

            pdfStream = new ByteArrayOutputStream()

            JRExporter exporter = new JRPdfExporter()
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print)
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, pdfStream) // your output goes here

            exporter.exportReport()
        } catch (Exception e) {
            println e
            println e.message
            throw new GroovyRuntimeException("It's not possible to generate the pdf report.", e)
        } finally {
            //render(file: pdfStream.toByteArray(), contentType: 'application/pdf')
            render file: pdfStream.toByteArray(), fileName: 'resumen_venta.pdf', contentType: 'application/pdf'
        }
    }

    def generar_archivo_despacho(long id) {

        Orden orden = Orden.findById(id)
        ByteArrayOutputStream pdfStream = null
        try {
            String reportName, jrxmlFileName, dotJasperFileName
            jrxmlFileName = "Dispatch"
            reportName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jrxml").file.getAbsoluteFile()
            dotJasperFileName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jasper").file.getAbsoluteFile()
            println reportName

            Map<String, Object> reportParam = new HashMap<String, Object>()
            def listItems = ResumenOrden.generarListaResumen(orden)
            println orden
            def dataSource = new JRBeanCollectionDataSource(listItems)

            reportParam.put("nombreUsuario", orden.usuario.nombre + " " + orden.usuario.apellido)
            reportParam.put("emailUsuario", orden.usuario.correo)
            reportParam.put("numeroOrden", "ORD" + orden.id as String)
            reportParam.put("totalFactura",'US$' + orden.total as String)
            reportParam.put("direccion", orden.usuario.direccion)

            JasperCompileManager.compileReportToFile(reportName)
            JasperPrint print = JasperFillManager.fillReport(dotJasperFileName, reportParam, dataSource);

            pdfStream = new ByteArrayOutputStream()
            JRExporter exporter = new JRPdfExporter()
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print)
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, pdfStream) // your output goes here

            exporter.exportReport()

        } catch (Exception e) {
            println e
            println e.message
        } finally {

            // EMAIL SUPPLIERS:
            def sendTo = []
            sendTo.add("dewyn.liriano@gmail.com")
           /* def supplyRole = Role.findByAuthority("ROLE_SUPPLY")
            def users = UserRole.findAllByRole(supplyRole)*/
           /* users.each {
                sendTo.add(it.user.email)
            }*/

            sendMail {
                multipart true
                subject "Dispatch Request"
                text "You will be finding a dispatch request attached bellow."
                to sendTo
                from "ubeistore@gmail.com"
                attach "dispatch.pdf", "application/pdf", pdfStream.toByteArray()
            }
            render file: pdfStream.toByteArray(), fileName: 'dispatch.pdf', contentType: 'application/pdf'
        }
    }


}
