package Market;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Facturacion {

    private static Logger logger = LogManager.getLogger(Facturacion.class);
    private static int numeroFactura;
    private LocalDate date;
    private String cliente;
    private IPedido pedido;
    private double subTotal;
    private double total;

    public Facturacion(String cliente, IPedido pedido) {
        numeroFactura++;
        this.date = LocalDate.now();
        this.cliente = cliente;
        this.pedido = pedido;
        this.subTotal = calcularSubtotal(pedido.getProductos());
        this.total = calcularTotal(subTotal);
    }

    private double calcularTotal(double subTotal) {
        double impuesto = 13;
        return subTotal + (subTotal * (impuesto / 100));
    }

    private double calcularSubtotal(Set<IProducto> productos) {
        double subTotal = 0;
        for (IProducto p : productos) {
            subTotal += p.getPrecio();
        }
        return subTotal;
    }

    public void imprimirPdf() {
        logger.info("Se imprimio la factura en un archivo PDF.");
        String FILE = "C:/Users/josep/Desktop/edu/Clases Kodigo/Proyecto2/SuperMercado-main/SuperMercado3.0/Factura101.pdf";
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            // CENTRO
            Paragraph paragraph = new Paragraph("SUPERMERCADO DEL GRUPO DELTA");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph("Cliente: " + cliente);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph("Fecha: " + date);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph("Numero de Factura: " + numeroFactura);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph("======================================================================");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            // Left with indentation
            paragraph = new Paragraph("Productos: " + pedido);
            paragraph.setAlignment(Element.ALIGN_LEFT);
            paragraph.setIndentationLeft(50);
            document.add(paragraph);

            paragraph = new Paragraph("======================================================================");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            paragraph = new Paragraph("Subtotal: " + subTotal);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            paragraph.setIndentationLeft(50);
            document.add(paragraph);

            paragraph = new Paragraph("Total: " + total);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            paragraph.setIndentationLeft(50);
            document.add(paragraph);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("\n" +
                "=================================================================\n" +
                "Numero de Factura: 000" + numeroFactura + " A nombre de: " + cliente + "\n" +
                "Fecha: " + date + "\n");
        int i = 1;
        for (IProducto prod : pedido.getProductos()) {
            sb.append(i + " - " + prod.getReferencia() + "  " + prod.getPrecio() + "\n");
            i++;
        }
        //sb.append("SubTotal: " + subTotal + "\n" + "Total: " + total);
        sb.append("SubTotal: " + subTotal + "\n");
        //System.out.printf("Total: " + "%3.2f%n" ,total);
        sb.append("Total: " + total);
        sb.append("\n=================================================================\n");

        return sb.toString();
    }
}
