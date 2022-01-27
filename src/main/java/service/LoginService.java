package service;

import dao.Issue;
import dao.Login;
import dto.IssueDTO;
import dto.LoginDTO;
import mapper.IssueMapper;
import mapper.LoginMapper;
import repository.IssueRepository;
import repository.LoginRepository;

import java.sql.SQLException;
import java.util.List;

public class LoginService extends BaseService<Login, Long, LoginRepository>{

    LoginMapper mapper = new LoginMapper();


    public LoginService(LoginRepository repository) {
        super(repository);
    }

    public List<LoginDTO> getAllLogin() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public LoginDTO getLoginById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public LoginDTO postLogin(LoginDTO loginDTO) throws SQLException {

        Login issue = this.save(mapper.fromDTO(loginDTO));
        return mapper.toDTO(issue);
    }

    public LoginDTO updateLogin(LoginDTO loginDTO) throws SQLException {
        Login issue = this.update(mapper.fromDTO(loginDTO));
        return mapper.toDTO(issue);
    }

    public LoginDTO deleteLogin(LoginDTO loginDTO) throws SQLException {
        Login issue = this.delete(mapper.fromDTO(loginDTO));
        return mapper.toDTO(issue);
    }
}
