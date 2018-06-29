/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadTemporal;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Basti
 */
public class TicketLogin {

    private String user_rol;
    private Date fecha_creacion;
    private Date fecha_expiracion;

    public TicketLogin() {
    }

    public TicketLogin(String user_rol, Date fecha_creacion) {
        this.user_rol = user_rol;
        this.fecha_creacion = fecha_creacion;
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha_creacion);
        cal.add(Calendar.DATE, 7);
        this.fecha_expiracion = cal.getTime();
    }

    public String getUser_rol() {
        return user_rol;
    }

    public void setUser_rol(String user_rol) {
        this.user_rol = user_rol;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(Date fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    @Override
    public String toString() {
        return "TicketLogin{" + "user_rol=" + user_rol + ", fecha_creacion=" + fecha_creacion + ", fecha_expiracion=" + fecha_expiracion + '}';
    }

}
