package dto;

import dao.Programador;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TecnologiaDTO {

    private long id;
    private String nombre;
    private Programador programador;

    @Override
    public String toString() {
        return "TecnologiaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
