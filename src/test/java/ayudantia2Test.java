import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class ayudantia2Test {

    @Test
    public void testAgregarProducto() {
        Object[][] productos = new Object[10][3];
        productos[0][0] = "1";
        productos[0][1] = "Platanos";
        productos[0][2] = 50;

        ayudantia2.agregarProducto(productos, "1", 20);
        assertEquals(70, productos[0][2]);
    }

    @Test
    public void testRestarProductos() {
        Object[][] productos = new Object[10][3];
        productos[0][0] = "1";
        productos[0][1] = "Platanos";
        productos[0][2] = 50;

        ayudantia2.restarProductos(productos, "1", 20);
        assertEquals(30, productos[0][2]);
        ayudantia2.restarProductos(productos, "1", 40);
    }

    @Test
    public void testConsultarDisponibilidad() {
        Object[][] productos = new Object[10][3];
        productos[0][0] = "1";
        productos[0][1] = "Platanos";
        productos[0][2] = 50;

        int cantidad = ayudantia2.consultarDisponibilidad(productos, "1");
        assertEquals(50, cantidad);

        int cantidadNoExistente = ayudantia2.consultarDisponibilidad(productos, "2");
        assertEquals(-1, cantidadNoExistente);
    }


}