package dao;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Programador> programadores;
    private Departamento departamento;

    public Proyecto(String nombre, double presupuesto, Departamento departamento) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.fInicio = new Date(System.currentTimeMillis());
        this.fFin = new Date(System.currentTimeMillis());
        this.programadores = new HashSet<Programador>();
        this.departamento = departamento;
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
    @Column(name = "fInicio", nullable = false, length = 100)
    public Date getfInicio() {
        return fInicio;
    }

    @Basic
    @Column(name = "fFin", nullable = false, length = 100)
    public Date getfFin() {
        return fFin;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "proyecto", orphanRemoval = true, cascade = CascadeType.REMOVE)
    public Set<Programador> getProgramadores() {
        return programadores;
    }

    @ManyToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id", nullable = false)
    public Departamento getDepartamento() {
        return departamento;
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

    public void setProgramadores(Set<Programador> programadores) {
        this.programadores = programadores;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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