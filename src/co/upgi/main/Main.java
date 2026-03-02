package co.upgi.main;

import co.upgi.dao.ReservaDAO;
import co.upgi.model.Reserva;
import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        ReservaDAO dao = new ReservaDAO();

        // 1. Insertar dos reservas
        Reserva r1 = new Reserva("Iveth", Date.valueOf("2026-03-10"), "18:00", 1);
        dao.insertar(r1);

        Reserva r2 = new Reserva("Nohely", Date.valueOf("2026-03-11"), "20:00", 2);
        dao.insertar(r2);

        // 2. Consultar todas las reservas y mostrarlas en consola
        System.out.println("---- CONSULTA INICIAL ----");
        dao.consultar().forEach(res ->
                System.out.println(res.getId() + " - " + res.getNombreCliente() + " - " + res.getHora())
        );

        // 3. Actualizar reservas
        r1.setNombreCliente("Iveth Actualizada");
        r1.setHora("19:00");
        dao.actualizar(r1);

        r2.setNombreCliente("Nohely Actualizada");
        r2.setHora("21:00");
        dao.actualizar(r2);

        System.out.println("---- CONSULTA DESPUÉS DE ACTUALIZAR ----");
        dao.consultar().forEach(res ->
                System.out.println(res.getId() + " - " + res.getNombreCliente() + " - " + res.getHora())
        );

        // 4. Eliminar solo la reserva de Nohely
        dao.eliminar(r2.getId());

        System.out.println("---- CONSULTA FINAL DESPUÉS DE ELIMINAR ----");
        dao.consultar().forEach(res ->
                System.out.println(res.getId() + " - " + res.getNombreCliente() + " - " + res.getHora())
        );
        dao.consultar().forEach(res -> {
            if(res.getNombreCliente().equals("Nohely")) {
                dao.eliminar(res.getId());
            }
        });

    }
}
