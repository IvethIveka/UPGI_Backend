package co.upgi.model;

import java.sql.Date;

public class Reserva {

    private int id;
    private String nombreCliente;
    private Date fecha;
    private String hora;
    private int cancha;

    public Reserva() {}

    public Reserva(String nombreCliente, Date fecha, String hora, int cancha) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.hora = hora;
        this.cancha = cancha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }

    public int getCancha() { return cancha; }
    public void setCancha(int cancha) { this.cancha = cancha; }
}
