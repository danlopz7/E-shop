package Market;

import Market.contenedores.Bolsa;
import Market.contenedores.Caja;
import Market.productos.*;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SuperMercado {

    private static Logger logger = LogManager.getLogger(SuperMercado.class);

    public static void main(String[] args) {

        IContenedor bolsa1 = new Bolsa("B111", 40, 20000, 30);
        IContenedor bolsa2 = new Bolsa("B111", 40, 20000, 30);
        IContenedor bolsa3 = new Bolsa("B111", 40, 20000, 30);
        IContenedor caja1 = new Caja("C222", 30, 50, 75);
        IContenedor caja2 = new Caja("C222", 30, 50, 75);

        IProducto manzanas = new Fresco("MNZ", 500, 1500, 5.00);
        IProducto peras = new Fresco("PER", 800, 1200, 4.95);
        IProducto helado = new Congelado("HLD", 800, 1000, 4.50);
        IProducto mielDeMaple = new NoPerecedero("MIE", 2400, 1000, 2.73);
        IProducto comidaMascota = new Mascotas("MSC", 2400, 1200, 5.00);
        IProducto medicinas = new Drogueria("MED", 500, 60, 12.00);
        IProducto papelToalla = new Higiene("PWC", 500, 2500, 3.25);


        int indice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("================================================================================================");
            System.out.println("Bienvenido al Super, Elige una de las siguientes opciones:");
            System.out.println("   1.  Ver productos disponibles");
            System.out.println("   2.  Ver contenedores disponibles");
            System.out.println("   3.  Crear pedido");
            System.out.println("   4.  SALIR");
            System.out.println("================================================================================================");

            indice = scan.nextInt();
            switch (indice) {
                case 1:
                    System.out.println("Manzanas " + manzanas);
                    System.out.println("peras " + peras);
                    System.out.println("helado " + helado);
                    System.out.println("miel de maple " + mielDeMaple);
                    System.out.println("comidaMascota " + comidaMascota);
                    System.out.println("medicinas " + medicinas);
                    System.out.println("papelToalla " + papelToalla + "\n");
                    System.out.println("================================================================================================");
                    break;
                case 2:
                    System.out.println(bolsa1.imprimirContenedor());
                    System.out.println(caja1.imprimirContenedor());
                    System.out.println("================================================================================================");
                    break;
                case 3:
                    System.out.println("Bienvenido, Para Iniciar su orden ingrese su Nombre Porfavor:");
                    String cliente = scan.next();
                    IPedido miPedido = new Pedido("pedido001");
                    logger.info("Agregando contenedor.");
                    System.out.println("Para continuar con tu orden " + cliente + ", Elige un contenedor que desees agregar:");
                    System.out.println("1. Bolsa");
                    System.out.println("2. Caja");
                    System.out.println("3. Salir");

                    int opcion = scan.nextInt();
                    do {
                        int opcion2 = 0;
                        if (opcion == 1) {
                            miPedido.addContenedor(bolsa1);
                            while(opcion2 < 3){
                                System.out.println("Deseas agregar otra bolsa?");
                                System.out.println("1. Si");
                                System.out.println("2. No");

                                opcion2 = scan.nextInt();
                                if(opcion2 == 1){
                                    miPedido.addContenedor(bolsa2);
                                    miPedido.addContenedor(bolsa3);
                                    opcion2 = 3;
                                } else {
                                    opcion2 = 3;
                                }
                            }
                        } else if (opcion == 2) {
                            miPedido.addContenedor(caja1);
                            while(opcion2 < 3){
                                System.out.println("Deseas agregar otra caja?");
                                System.out.println("1. Si");
                                System.out.println("2. No");

                                opcion2 = scan.nextInt();
                                if(opcion2 == 1){
                                    miPedido.addContenedor(caja2);
                                    opcion2 = 3;
                                } else {
                                    opcion2 = 3;
                                }
                            }

                        }  else if (opcion == 3) {
                            break;
                        } else
                            System.out.println("digita una opciòn valida!");
                    } while (opcion > 3);

                    if(opcion == 3){
                        break;
                    }
                    int i = 0;
                    while (i < 5) {
                        System.out.println("Elige hasta 5 productos que desees llevar:");
                        System.out.println("1. Manzanas " + manzanas);
                        System.out.println("2. peras " + peras);
                        System.out.println("3. helado " + helado);
                        System.out.println("4. miel de maple " + mielDeMaple);
                        System.out.println("5. comidaMascota " + comidaMascota);
                        System.out.println("6. medicinas " + medicinas);
                        System.out.println("7. papelToalla " + papelToalla);
                        System.out.println("8. Listo!");

                        int selection = scan.nextInt();
                        if (selection == 1) {
                            miPedido.addProducto(manzanas);
                            i++;
                        } else if (selection == 2) {
                            miPedido.addProducto(peras);
                            i++;
                        } else if (selection == 3) {
                            miPedido.addProducto(helado);
                            i++;
                        } else if (selection == 4) {
                            miPedido.addProducto(mielDeMaple);
                            i++;
                        } else if (selection == 5) {
                            miPedido.addProducto(comidaMascota);
                            i++;
                        } else if (selection == 6) {
                            miPedido.addProducto(medicinas);
                            i++;
                        } else if (selection == 7) {
                            miPedido.addProducto(papelToalla);
                            i++;
                        } else {
                            i = 5;
                        }
                    }

                    do{
                        System.out.println("Su pedido ha sido creado con exito " + cliente + "!");
                        System.out.println("1. Ver mi carrito de compras");
                        System.out.println("2. Pagar"); //OPCION QUE GENERARIA UNA FACTURA
                        System.out.println("3. Olvidar pedido");

                        System.out.println("================================================================================================");

                        int option = scan.nextInt();
                        if(option == 1){
                            System.out.println(miPedido);
                        } else if(option == 2){
                            Facturacion factura = new Facturacion(cliente, miPedido);
                            System.out.println(factura);
                            factura.imprimirPdf();
                            opcion = 3;
                        } else if(option == 3){
                            logger.info("El usuario decidio eliminar la orden.");
                            opcion = 3;
                            break;
                        }

                    } while (opcion < 3);
                    break;

                case 4:
                    System.out.println("Has salido.");
            }

        } while (indice != 4);
        System.out.println("Hasta Luego!");
    }
}
