package service;

import dao.Issue;
import dto.IssueDTO;
import mapper.IssueMapper;
import repository.IssueRepository;
import java.sql.SQLException;
import java.util.List;

public class IssueService extends BaseService<Issue, Long, IssueRepository>  {

    IssueMapper mapper = new IssueMapper();


    public IssueService(IssueRepository repository) {
        super(repository);
    }

    public List<IssueDTO> getAllIssue() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public IssueDTO getIssueById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public IssueDTO postIssue(IssueDTO issueDTO) throws SQLException {

        Issue issue = this.save(mapper.fromDTO(issueDTO));
        return mapper.toDTO(issue);
    }

    public IssueDTO updateIssue(IssueDTO issueDTO) throws SQLException {
        Issue issue = this.update(mapper.fromDTO(issueDTO));
        return mapper.toDTO(issue);
    }

    public IssueDTO deleteIssue(IssueDTO issueDTO) throws SQLException {
        Issue issue = this.delete(mapper.fromDTO(issueDTO));
        return mapper.toDTO(issue);
    }
}
