package mapper;

import dao.Departamento;
import dao.Issue;
import dto.DepartamentoDTO;
import dto.IssueDTO;

public class IssueMapper extends BaseMapper<Issue, IssueDTO>{

    @Override
    public Issue fromDTO(IssueDTO item) {
        Issue issue = new Issue();
        if (item.getId() != null) {
            issue.setId(item.getId());
        }
        issue.setTitulo(item.getTitulo());
        issue.setTexto(item.getTexto());
        issue.setfCreacion(item.getFCreacion());
        issue.setEstado(item.getEstado());
        issue.setRepositorio(item.getRepositorio());
        return issue;
    }
    @Override
    public IssueDTO toDTO(Issue item) {
        return IssueDTO.builder()
                .id(item.getId())
                .titulo(item.getTitulo())
                .texto(item.getTexto())
                .fCreacion(item.getfCreacion())
                .estado(item.getEstado())
                .repositorio(item.getRepositorio())
                .build();
    }
}
