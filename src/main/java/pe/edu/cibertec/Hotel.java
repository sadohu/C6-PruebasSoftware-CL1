package pe.edu.cibertec;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Hotel {
    private int piso;
    private int habitacion;
    private String nombreCliente;
    private LocalDate fechaReserva;

    public Hotel() {
    }

    public Hotel(int piso, int habitacion, String nombreCliente, LocalDate fechaReserva) {
        this.piso = piso;
        this.habitacion = habitacion;
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
    }

    public String registrarReserva(String numberoHabitacion, String nombreCliente, String fechaReserva){
        boolean invalid;

        // Validación de números
        invalid = !numberoHabitacion.matches("[\\d+]{3}");
        if(invalid)
            return "Ingrese una habitación válida (Números enteros y máximo tres caracteres).";

        // Validar número de piso
        int piso = Integer.parseInt(numberoHabitacion.substring(0, 1));
        invalid = (piso < 1) || (piso > 3);
        if(invalid)
            return "Ingrese un número de piso válido, del 1 al 3.";


        // CASO 1: Asegurar eliminación de los espacios excesivos
        nombreCliente = nombreCliente.trim();
        nombreCliente = nombreCliente.replaceAll("\\s+", " ");

        // Validar cantidad de caracteres
        invalid = nombreCliente.length() < 4;
        if(invalid)
            return "Recuerde que el nombre del cliente debe contener al menos 4 caracteres.";

        // CASO 2: Controlar los espacios mediante una advertencia al usuario.
        /*
            invalid = !nombre.matches("[a-zA-Zá-úÁ-Ú]+(\\s[a-zA-Zá-úÁ-Ú]+)*");
            assertTrue(valid, "Recuerde que el nombre del cliente debe contener al menos 4 caracteres y contener caracteres alfabéticos.\nPor último, sólo se admiten un espacio entre nombres.");
        */

        invalid = !nombreCliente.matches("[a-zA-Zá-úÁ-Ú ]+");
        if(invalid)
            return "Recuerde que el nombre del cliente debe contener al menos 4 caracteres y contener caracteres alfabéticos.";


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha;

        // Controlar si se ingresa una fecha válida
        try {
            fecha = LocalDate.parse(fechaReserva, formatter);
        } catch (DateTimeParseException e) {
            return "Ingrese un formato de Días/Meses/Año, Ej 01/12/2025";
        }

        LocalDate systemDate = LocalDate.now();
        invalid = !fecha.isAfter(systemDate);
        if(invalid)
            return "Ingrese una fecha superior a la actual.";

        this.piso = piso;
        this.habitacion = Integer.parseInt(numberoHabitacion.substring(1, 3));
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fecha;

        System.out.println(
                "Resúmen de reserva: \n" +
                        "Nombre del cliente: " + this.nombreCliente + "\n" +
                        "Habitación: " + String.valueOf(this.piso) + String.valueOf(this.habitacion) + "\n" +
                        "Fecha de reserva: " + this.fechaReserva);

        return "El registro ha sido exitoso.";
    }
}
