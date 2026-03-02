package co.upgi.dao;

import co.upgi.model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

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
