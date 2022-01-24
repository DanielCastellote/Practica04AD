package dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@Table(name = "repositorio")
@NamedQuery(name = "Repositorio.findAll", query = "SELECT c FROM Repositorio c")
public class Repositorio {

    private long id;
    private Date fCreacion;
    private Set<Issue> issues;
    private Set<Commit> commits;

    public Repositorio() {
        this.fCreacion = new Date(System.currentTimeMillis());
        this.issues = new HashSet<>();
        this.commits = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public Date getfCreacion() {
        return fCreacion;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "repositorio", orphanRemoval = true, cascade = CascadeType.REMOVE)
    public Set<Issue> getIssues() {
        return issues;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "repositorio", orphanRemoval = true, cascade = CascadeType.REMOVE)
    public Set<Commit> getCommits() {
        return commits;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setfCreacion(Date fCreacion) {
        this.fCreacion = fCreacion;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public void setCommits(Set<Commit> commits) {
        this.commits = commits;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "id=" + id +
                ", fCreacion=" + fCreacion +
                '}';
    }
}
