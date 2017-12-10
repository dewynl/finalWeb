package finalweb

import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter


class JasperController {

    def index() {}

    def reporteOrden(Long id){
        Orden orden = Orden.findById(id)

        File file = new File("resumen_orden.pdf");
        FileOutputStream fileout = new FileOutputStream(file);
        Document document = new Document();
        PdfWriter.getInstance(document, fileout);
        document = generarReporteOrden(orden, document)

        response.setContentType("application/octet-stream") // or or image/JPEG or text/xml or whatever type the file is
        response.setHeader("Content-disposition", "attachment;filename=\"${file.name}\"")
        response.outputStream << file.bytes
        /*sendMail {
            multipart false
            subject "Ubei Store Registration"
            text texto
            to usuario.correo
            from "ubei  store@gmail.com"
        }*/
    }

    def generarReporteOrden(Orden orden, Document document) {

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
    }


}
