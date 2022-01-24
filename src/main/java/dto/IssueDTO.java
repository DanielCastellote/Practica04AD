package dto;

import dao.Repositorio;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class IssueDTO {
    private long id;
    private String titulo;
    private String texto;
    private Date fCreacion;
    private String estado;
    private Repositorio repositorio;

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
