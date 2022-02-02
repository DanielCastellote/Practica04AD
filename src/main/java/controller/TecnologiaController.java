package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.LoginDTO;
import dto.TecnologiaDTO;
import repository.LoginRepository;
import repository.TecnologiaRepository;
import service.LoginService;
import service.TecnologiaService;

import java.sql.SQLException;
import java.util.List;

public class TecnologiaController {

    private static TecnologiaController controller = null;

    private final TecnologiaService tecnologiaService;


    private TecnologiaController(TecnologiaService tecnologiaService) {
        this.tecnologiaService = tecnologiaService;
    }

    public static TecnologiaController getInstance() {
        if (controller == null) {
            controller = new TecnologiaController(new TecnologiaService(new TecnologiaRepository()));
        }
        return controller;
    }

    public List<TecnologiaDTO> getAllTecnologias() {
        try {
            return tecnologiaService.getAllTecnologias();
        } catch (SQLException e) {
            System.err.println("Error TecnologiaController en getAllTecnologia: " + e.getMessage());
            return null;
        }
    }
    public String getAllTecnologiaJSON() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(tecnologiaService.getAllTecnologias());
        } catch (SQLException e) {
            System.err.println("Error TecnologiaController en getAllTecnologia: " + e.getMessage());
            return "Error TecnologiaController en getAllTecnologia: " + e.getMessage();
        }
    }
    public String getTecnologiaByIdJSON(Long id) {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(tecnologiaService.getTecnologiaById(id));
        } catch (SQLException e) {
            System.err.println("Error TecnologiaController en getTecnologiaById: " + e.getMessage());
            return "Error TecnologiaController en getTecnologiaById: " + e.getMessage();
        }
    }

    public TecnologiaDTO getTecnologiaById(Long id) {
        try {
            return tecnologiaService.getTecnologiaById(id);
        } catch (SQLException e) {
            System.err.println("Error LoginController en getLoginById " + e.getMessage());
            return null;
        }
    }

    public TecnologiaDTO postTecnologia(TecnologiaDTO tecnologiaDTO) {
        try {
            return tecnologiaService.postTecnologia(tecnologiaDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en postLogin " + e.getMessage());
            return null;
        }
    }

    public TecnologiaDTO updateTecnologia(TecnologiaDTO tecnologiaDTO) {
        try {
            return tecnologiaService.updateTecnologia(tecnologiaDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en updateLogin " + e.getMessage());
            return null;
        }
    }

    public TecnologiaDTO deleteTecnologia(TecnologiaDTO tecnologiaDTO) {
        try {
            return tecnologiaService.deleteTecnologia(tecnologiaDTO);
        } catch (SQLException e) {
            System.err.println("Error LoginController en deleteLogin " + e.getMessage());
            return null;
        }
    }
}
