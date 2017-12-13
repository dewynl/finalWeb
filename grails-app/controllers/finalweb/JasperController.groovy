package finalweb

/*import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter*/
import finalweb.reports.ArticlePurchase
import net.sf.jasperreports.engine.JRExporter
import net.sf.jasperreports.engine.JRExporterParameter
import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.JasperPrint
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.export.JRPdfExporter


class JasperController {

    def index() {}

    def reporteOrden(Long id){
        Orden orden = Orden.findById(id)
/*
        File file = new File("resumen_orden.pdf");
        FileOutputStream fileout = new FileOutputStream(file);
        Document document = new Document();
        PdfWriter.getInstance(document, fileout);
        document = generarReporteOrden(orden, document)

        response.setContentType("application/octet-stream") // or or image/JPEG or text/xml or whatever type the file is
        response.setHeader("Content-disposition", "attachment;filename=\"${file.name}\"")
        response.outputStream << file.bytes*/
        /*sendMail {
            multipart false
            subject "Ubei Store Registration"
            text texto
            to usuario.correo
            from "ubei  store@gmail.com"
        }*/
    }

   /* def generarReporteOrden(Orden orden, Document document) {

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font boldFontBig = new Font(Font.FontFamily.TIMES_ROMAN, 23, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);

        PdfPTable table = new PdfPTable(3);

        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("Ubei Store!", boldFontBig));
        cell.setColspan(3);
        cell.setRowspan(3);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Orden para Despachar", boldFont));
        cell.setColspan(3);
        cell.setRowspan(3);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("ID: " + orden.id.toString(), boldFont));
        cell.setColspan(1);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Fecha: " + orden.dateCreated.toString(), boldFont));
        cell.setColspan(2);
        table.addCell(cell);

        orden.itemOrden.each {

            cell = new PdfPCell(new Phrase("Codigo Producto: " + it.id, normalFont));
            cell.setColspan(1);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Nombre Producto: " + it.articulo.nombre, normalFont));
            cell.setColspan(1);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Precio Producto: " + it.articulo.precio, normalFont));
            cell.setColspan(1);
            table.addCell(cell);

        }

        cell = new PdfPCell(new Phrase("Firma: ", boldFont));
        cell.setColspan(1);
        cell.setRowspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(" ", boldFont));
        cell.setColspan(2);
        cell.setRowspan(3);
        table.addCell(cell);

        document.open()
        document.add(table)
        document.close()
        return document
    }*/

    def generar_factura_archivo(long id){

    }

    def generate_invoice(long id){
        def orden = Orden.findById(id)
        ByteArrayOutputStream pdfStream = null
        try {
            String reportName, jrxmlFileName, dotJasperFileName
            jrxmlFileName = "Invoice"
            reportName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jrxml").file.getAbsoluteFile()
            dotJasperFileName = grailsApplication.mainContext.getResource("reports/${jrxmlFileName}.jasper").file.getAbsoluteFile()
            println reportName
            // Report parameter

            Map<String, Object> reportParam = new HashMap<String, Object>()
            def listItems = ArticlePurchase.getArticlesFromPurchase(orden)
            def dataSource = new JRBeanCollectionDataSource(listItems)

            reportParam.put("nombreUsuario", orden.usuario.nombre + " " + orden.usuario.apellido)
            reportParam.put("emailUsuario", orden.usuario.correo)
            reportParam.put("numOrden", "ORD" + orden.id as String)
            reportParam.put("totalOrden",'US$' + orden.total as String)
            reportParam.put("direccion", orden.usuario.direccion)

            // compiles jrxml
            JasperCompileManager.compileReportToFile(reportName);
            // fills compiled report with parameters and a connection
            JasperPrint print = JasperFillManager.fillReport(dotJasperFileName, reportParam, dataSource);

            pdfStream = new ByteArrayOutputStream();
            // exports report to pdf
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
}
