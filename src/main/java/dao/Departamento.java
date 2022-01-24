package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departamento")
@NamedQuery(name = "Departamento.findAll", query = "SELECT c FROM Departamento c")
public class Departamento {

    private long id;
    private String nombre;
    private double presupuesto;
    private double presupuestoAnual;


    public Departamento(String nombre, double presupuesto, double presupuestoAnual) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.presupuestoAnual = presupuestoAnual;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
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
    @Column(name = "presupuestoAnual", nullable = false, length = 100)
    public double getPresupuestoAnual() {
        return presupuestoAnual;
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

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", presupuestoAnual=" + presupuestoAnual +
                '}';
    }
}
