package co.upgi.main;

import co.upgi.dao.ReservaDAO;
import co.upgi.model.Reserva;
import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        ReservaDAO dao = new ReservaDAO();

        // Insertar una nueva reserva
        Reserva r = new Reserva("Iveth", Date.valueOf("2026-03-10"), "18:00", 1);
        dao.insertar(r);

        // Consultar todas las reservas y mostrarlas en consola
        dao.consultar().forEach(res ->
                System.out.println(res.getNombreCliente())
        );
    }
}
