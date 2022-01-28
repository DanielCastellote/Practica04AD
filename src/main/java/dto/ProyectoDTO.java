package dto;

import dao.Departamento;
import dao.Programador;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
public class ProyectoDTO {

    private Long id;
    private String nombre;
    private double presupuesto;
    private Date fInicio;
    private Date fFin;
    private Set<Programador> programadores= new HashSet<>();
    private Departamento departamento;

    @Override
    public String toString() {
        return "ProyectoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                ", programadores=" + programadores +
                ", departamento=" + departamento +
                '}';
    }
}