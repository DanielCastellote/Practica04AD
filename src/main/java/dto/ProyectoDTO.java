package dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProyectoDTO {

    private Long id;
    private String nombre;
    private double presupuesto;
    private Date fInicio;
    private Date fFin;

    @Override
    public String toString() {
        return "ProyectoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presupuesto=" + presupuesto +
                ", fInicio=" + fInicio +
                ", fFin=" + fFin +
                '}';
    }
}
