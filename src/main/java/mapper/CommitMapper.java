package mapper;

import dao.Commit;
import dao.Departamento;
import dto.CommitDTO;
import dto.DepartamentoDTO;

public class CommitMapper extends BaseMapper<Commit, CommitDTO>{

    @Override
    public Commit fromDTO(CommitDTO item) {
        Commit commit = new Commit();
        if (item.getId() != null) {
            commit.setId(item.getId());
        }
        commit.setTitulo(item.getTitulo());
        commit.setTexto(item.getTexto());
        commit.setfCreacion(item.getFCreacion());
        commit.setAutor(item.getAutor());
        commit.setRepositorio(item.getRepositorio());
        return commit;
    }
    @Override
    public CommitDTO toDTO(Commit item) {
        return CommitDTO.builder()
                .id(item.getId())
                .titulo(item.getTitulo())
                .texto(item.getTexto())
                .fCreacion(item.getfCreacion())
                .autor(item.getAutor())
                .repositorio(item.getRepositorio())
                .build();
    }
}
