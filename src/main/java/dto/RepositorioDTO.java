package dto;

import dao.Commit;
import dao.Issue;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Builder
@Data
public class RepositorioDTO {

    private Long id;
    private Date fCreacion;
    private Set<Issue> issues;
    private Set<Commit> commits;

    @Override
    public String toString() {
        return "RepositorioDTO{" +
                "id=" + id +
                ", fCreacion=" + fCreacion +
                '}';
    }
}
