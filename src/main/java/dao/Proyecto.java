package dao;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proyecto")
@NamedQuery(name = "Proyecto.findAll", query = "SELECT c FROM Proyecto c")
public class Proyecto {
    private long id;
    private String nombre;
    private double presupuesto;
    private Date fInicio;
    private Date fFin;

    public Proyecto(String nombre, double presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fInicio = new Date(System.currentTimeMillis());
        this.fFin = new Date(System.currentTimeMillis());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id",nullable = false)
    public long getId(){
        return id;
    }
    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }
    @Basic
    @Column(name = "presupuesto", nullable = false, length = 100)
    public double getPresupuesto() {
        return presupuesto;
    }
    @Basic
    @Column(name = "fechaInicio", nullable = false, length = 100)
    public Date getfInicio() {
        return fInicio;
    }
    @Basic
    @Column(name = "fechaFin", nullable = false, length = 100)
    public Date getfFin() {
        return fFin;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setfInicio(Date fInicio) {
        this.fInicio = fInicio;
    }

    public void setfFin(Date fFin) {
        this.fFin = fFin;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                '}';
    }
}
