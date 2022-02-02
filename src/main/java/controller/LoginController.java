package controller;

import dto.LoginDTO;
import repository.LoginRepository;
import service.LoginService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LoginController {

    private static LoginController controller = null;

    private final LoginService loginService;

    private LoginController(LoginService userService) {
        this.loginService = userService;
    }

    public static LoginController getInstance() {
        if (controller == null) {
            controller = new LoginController(new LoginService(new LoginRepository()));
        }
        return controller;
    }

    public Optional<LoginDTO> login(String userMail, String userPassword) {
        try {
            LoginDTO login = loginService.login(userMail, userPassword);
            if (login != null) {
                return Optional.of(login);
            }
        } catch (SQLException e) {
            Optional.empty();
        }
        return  Optional.empty();
    }

    public boolean logout(Long userId) {
        try {
            if (loginService.logout(userId))
                return true;
            else
                return false;
        } catch (SQLException e) {
            System.err.println("Error Login Controller Logout: " + e.getMessage());
            return false;
        }
    }
}
