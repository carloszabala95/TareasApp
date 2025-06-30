package udemy.app.dto;

import java.time.LocalDate;
import java.util.Date;

public class InfoTareaResponse {

    private String titulo;
    private String resumen;
    private boolean realizada;
    private Date fecha;
    //Nombre del tipo de tarea
    private String nombre;
    //Username del usuario de la tarea
    private String username;

    public InfoTareaResponse(String titulo, String resumen, Date fecha, boolean realizada, String username, String nombre) {
        this.titulo = titulo;
        this.resumen = resumen;
        this.fecha = fecha;
        this.realizada = realizada;
        this.username = username;
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
