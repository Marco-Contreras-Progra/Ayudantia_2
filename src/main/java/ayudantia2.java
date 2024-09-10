import java.util.Scanner;

public class ayudantia2 {
    public static void main(String[] args) {
        Object[][] productos = new Object[10][3];

        productos[0][0] = "1";
        productos[0][1] = "Platanos";
        productos[0][2] = 50;

        productos[1][0] = "2";
        productos[1][1] = "Naranjas";
        productos[1][2] = 100;

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Gestión de Inventario:");
            System.out.println("1. Agregar Productos");
            System.out.println("2. Restar Productos");
            System.out.println("3. Consultar Disponibilidad");
            System.out.println("4. Listar Productos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID del producto: ");
                    String idAgregar = scanner.nextLine();
                    System.out.print("Ingrese cantidad a agregar: ");
                    int cantidadAgregar = scanner.nextInt();
                    agregarProducto(productos,idAgregar, cantidadAgregar);
                    break;

                case 2:
                    System.out.print("Ingrese ID del producto: ");
                    String idRestar = scanner.nextLine();
                    System.out.print("Ingrese cantidad a restar: ");
                    int cantidadRestar = scanner.nextInt();
                    restarProductos(productos,idRestar, cantidadRestar);
                    break;

                case 3:
                    System.out.print("Ingrese ID del producto: ");
                    String idConsultar = scanner.nextLine();
                    int cantidadDisponible = consultarDisponibilidad(productos, idConsultar);
                    if (cantidadDisponible != -1) {
                        System.out.println("Cantidad disponible para el producto " + idConsultar + ": " + cantidadDisponible);
                    }
                    break;

                case 4:
                    listarProductos(productos);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }

    public static void agregarProducto(Object[][]productos, String idProducto, int cantidad){
        boolean productoEncontrado = false;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null && productos[i][0].equals(idProducto)) {
                int cantidadActual = (Integer) productos[i][2];
                productos[i][2] = cantidadActual + cantidad;
                productoEncontrado = true;
                System.out.println("Cantidad actualizada para el producto con id: " + idProducto);
                break;
            }
        }
        if (!productoEncontrado) {
            System.out.println("Producto con el id:" +idProducto +"no encontrado.");
        }
    }

    public static void restarProductos(Object[][] productos, String idProducto, int cantidad) {
        boolean productoEncontrado = false;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null && productos[i][0].equals(idProducto)) {
                int cantidadActual = (Integer) productos[i][2];
                try {
                    if (cantidad > cantidadActual) {
                        throw new Exception("Error: La cantidad a restar es mayor que la cantidad disponible");
                    }
                    productos[i][2] = cantidadActual - cantidad;
                    productoEncontrado = true;
                    System.out.println("Cantidad actualizada para el producto con id: " + idProducto);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
        if (!productoEncontrado) {
            System.out.println("Producto con el id:" +idProducto +"no encontrado.");
        }
    }

    public static int consultarDisponibilidad(Object[][] productos, String idProducto) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null && productos[i][0].equals(idProducto)){
                return (Integer) productos[i][2];
            }
        }
        System.out.println("Producto con el id:" +idProducto +"no encontrado.");
        return -1;
    }

    public static void listarProductos(Object[][] productos) {
        System.out.println("Listado de Productos:");
        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0] != null) {
                String idProducto = (String) productos[i][0];
                String nombreProducto = (String) productos[i][1];
                int cantidadDisponible = (Integer) productos[i][2];

                System.out.println("id:"+ idProducto + "Nombre:" + nombreProducto + "Cantidad:" + cantidadDisponible);
            }
        }
    }
}


