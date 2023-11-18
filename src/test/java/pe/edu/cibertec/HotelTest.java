package pe.edu.cibertec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {

    @Test
    public void pruebaRegistroExitoso() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("109", "Francis Lostanau", "22/12/2023");
        assertEquals("El registro ha sido exitoso.", resultado);
    }

    @Test
    public void pruebaDatosRequeridos(){
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva(" ", "", "");
        assertEquals("Debe ingresar los datos requeridos.", resultado);
    }

    @Test
    public void pruebaNumeroHabitacionInvalido() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("A#1", "Juan Pérez", "22/12/2023");
        assertEquals("Ingrese una habitación válida (Números enteros y máximo tres caracteres).", resultado);
    }

    @Test
    public void pruebaNumeroPisoInvalido() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("901", "Juan Pérez", "22/12/2023");
        assertEquals("Ingrese un número de piso válido, del 1 al 3.", resultado);
    }

    @Test
    public void pruebaEspaciosNombreCliente() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("101", "   h                u   ", "22/12/2023");
        assertEquals("Recuerde que el nombre del cliente debe contener al menos 4 caracteres.", resultado);
    }

    @Test
    public void pruebaNombreClienteInvalido() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("101", "J1", "22/12/2023");
        assertEquals("Recuerde que el nombre del cliente debe contener al menos 4 caracteres.", resultado);
    }

    @Test
    public void pruebaNombreClienteCaracteresInvalidos() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("101", "@@#%", "22/12/2023");
        assertEquals("Recuerde que el nombre del cliente debe contener al menos 4 caracteres y contener caracteres alfabéticos.", resultado);
    }

    @Test
    public void pruebaFechaFormatoInvalido() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("101", "Juan Pérez", "2023/12/10");
        assertEquals("Ingrese un formato de Días/Meses/Año, Ej 01/12/2025", resultado);
    }

    @Test
    public void pruebaFechaReservaInvalida() {
        Hotel hotel = new Hotel();
        String resultado = hotel.registrarReserva("101", "Juan Pérez", "22/12/2020");
        assertEquals("Ingrese una fecha superior a la actual.", resultado);
    }

}
