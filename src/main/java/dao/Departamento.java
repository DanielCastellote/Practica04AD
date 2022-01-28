package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Programador> programadores;
    private Set<Proyecto> proyectos;


    public Departamento(String nombre, double presupuesto, double presupuestoAnual) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.presupuestoAnual = presupuestoAnual;
        this.programadores= new HashSet<>();
        this.proyectos= new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "departamento",orphanRemoval = true,cascade = CascadeType.REMOVE)
    public Set<Programador> getProgramadores() {
        return programadores;
    }
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "departamento",orphanRemoval = true,cascade = CascadeType.REMOVE)
    public Set<Proyecto> getProyectos() {
        return proyectos;
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

    public void setProgramadores(Set<Programador> programadores) {
        this.programadores = programadores;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
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
