package dto;

import dao.Programador;
import dao.Repositorio;
import lombok.Builder;
import lombok.Data;


import java.util.Date;

@Data
@Builder
public class CommitDTO {

    private Long id;
    private String titulo;
    private String texto;
    private Date fCreacion;
    private Programador autor;
    private Repositorio repositorio;

    @Override
    public String toString() {
        return "CommitDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", fCreacion=" + fCreacion +
                ", autor=" + autor +
                ", repositorio=" + repositorio +
                '}';
    }
}