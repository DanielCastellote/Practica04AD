package dto;

import dao.Repositorio;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class IssueDTO {

    private Long id;
    private String titulo;
    private String texto;
    private Date fCreacion;
    private Repositorio repositorio;
    private String estado;

    @Override
    public String toString() {
        return "IssueDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fCreacion=" + fCreacion +
                ", estado='" + estado + '\'' +
                '}';
    }
}