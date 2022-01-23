package dto;

import dao.Programador;
import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder
public class CommitDTO {

    private long id;
    private String titulo;
    private String texto;
    private Date fCreacion;
    private Programador autor;

    @Override
    public String toString() {
        return "CommitDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fCreacion=" + fCreacion +
                '}';
    }
}
