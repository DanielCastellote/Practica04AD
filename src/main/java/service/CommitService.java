package service;

import dao.Commit;
import dao.Programador;
import dto.CommitDTO;
import dto.ProgramadorDTO;
import mapper.CommitMapper;
import mapper.ProgramadorMapper;
import repository.CommitRepository;
import repository.ProgramadorRepository;
import utils.Cifrador;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CommitService extends BaseService<Commit, Long, CommitRepository>{

    CommitMapper mapper = new CommitMapper();


    public CommitService(CommitRepository repository) {
        super(repository);
    }

    public List<CommitDTO> getAllCommit() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public CommitDTO getCommitById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public CommitDTO postCommit(CommitDTO CommitDTO) throws SQLException {

        Commit commit = this.save(mapper.fromDTO(CommitDTO));
        return mapper.toDTO(commit);
    }

    public CommitDTO updateCommit(CommitDTO commitDTO) throws SQLException {
        Commit commit = this.update(mapper.fromDTO(commitDTO));
        return mapper.toDTO(commit);
    }

    public CommitDTO deleteCommit(CommitDTO commitDTO) throws SQLException {
        Commit commit = this.delete(mapper.fromDTO(commitDTO));
        return mapper.toDTO(commit);
    }
}
