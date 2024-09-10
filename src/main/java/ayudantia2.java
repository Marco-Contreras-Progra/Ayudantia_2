import java.util.Scanner;

public class ayudantia2 {
    public static void main(String[] args) {

        Object[][] productos = new Object[10][3];

    }
    public static void agregarProducto(Object[][] productos, String idProducto, int cantidad){
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

}
