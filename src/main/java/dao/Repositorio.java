package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "repositorio")
@NamedQuery(name = "Repositorio.findAll", query = "SELECT c FROM Repositorio c")
public class Repositorio {

    private long id;
    private Date fCreacion;
    private Set<Issue> issues;
    private Set<Commit> commits;

    public Repositorio(Date fCreacion, Set<Issue> issues, Set<Commit> commits) {
        this.fCreacion = fCreacion;
        this.issues = issues;
        this.commits = commits;
    }
}
