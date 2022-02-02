package dto;

import dao.Programador;
import dao.Proyecto;
import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
public class DepartamentoDTO {

    private Long id;
    private String nombre;
    private double presupuesto;
    private double presupuestoAnual;
    private Set<Programador> programadores = new HashSet<>();
    private Set<Proyecto> proyectos = new HashSet<>();

    @Override
    public String toString() {
        return "DepartamentoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", presupuestoAnual=" + presupuestoAnual +
                ", proyectos=" + proyectos +
                '}';
    }
}