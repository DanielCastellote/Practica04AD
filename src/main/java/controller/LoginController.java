package controller;

import dto.LoginDTO;
import repository.LoginRepository;
import service.LoginService;

import java.sql.SQLException;
import java.util.List;

public class LoginController {

    private static LoginController controller = null;

    private final LoginService loginService;


    private LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public static LoginController getInstance() {
        if (controller == null) {
            controller = new LoginController(new LoginService(new LoginRepository()));
        }
        return controller;
    }

    public List<LoginDTO> getAllLogin() {
        try {
            return loginService.getAllLogin();
        } catch (SQLException e) {
            System.err.println("Error LoginController en getAllLogin: " + e.getMessage());
            return null;
        }
    }

    public LoginDTO getLoginById(Long id) {
        try {
            return loginService.getLoginById(id);
        } catch (SQLException e) {
            System.err.println("Error LoginController en getLoginById " + e.getMessage());
            return null;
        }
    }

    public LoginDTO postLogin(LoginDTO loginDTO) {
        try {
            return loginService.postLogin(loginDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en postLogin " + e.getMessage());
            return null;
        }
    }

    public LoginDTO updateLogin(LoginDTO loginDTO) {
        try {
            return loginService.updateLogin(loginDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en updateLogin " + e.getMessage());
            return null;
        }
    }

    public LoginDTO deleteLogin(LoginDTO loginDTO) {
        try {
            return loginService.deleteLogin(loginDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en deleteLogin " + e.getMessage());
            return null;
        }
    }
}
