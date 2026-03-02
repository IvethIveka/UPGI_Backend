package co.upgi.dao;

import co.upgi.model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    // Metodo insertar
    public void insertar(Reserva reserva) {
        String sql = "INSERT INTO reserva (nombre_cliente, fecha, hora, cancha) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, reserva.getNombreCliente());
            ps.setDate(2, reserva.getFecha());
            ps.setString(3, reserva.getHora());
            ps.setInt(4, reserva.getCancha());

            ps.executeUpdate();
            System.out.println("Reserva insertada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo consultar
    public List<Reserva> consultar() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reserva";

        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId(rs.getInt("id"));
                r.setNombreCliente(rs.getString("nombre_cliente"));
                r.setFecha(rs.getDate("fecha"));
                r.setHora(rs.getString("hora"));
                r.setCancha(rs.getInt("cancha"));

                lista.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // metodo actualizar
    public void actualizar(Reserva reserva) {
        String sql = "UPDATE reserva SET nombre_cliente=?, fecha=?, hora=?, cancha=? WHERE id=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, reserva.getNombreCliente());
            ps.setDate(2, reserva.getFecha());
            ps.setString(3, reserva.getHora());
            ps.setInt(4, reserva.getCancha());
            ps.setInt(5, reserva.getId()); // importante: el ID de la reserva que queremos actualizar

            ps.executeUpdate();
            System.out.println("Reserva actualizada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo eliminar
    public void eliminar(int id) {
        String sql = "DELETE FROM reserva WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Reserva eliminada");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
