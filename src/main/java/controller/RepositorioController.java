package controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.ProyectoDTO;
import dto.RepositorioDTO;
import repository.ProyectoRepository;
import repository.RepositorioRepository;
import service.ProyectoService;
import service.RepositorioService;

import java.sql.SQLException;
import java.util.List;

public class RepositorioController {
    private static RepositorioController controller = null;

    private final RepositorioService repositorioService;

    private RepositorioController(RepositorioService repositorioService) {
        this.repositorioService = repositorioService;
    }

    public static RepositorioController getInstance() {
        if (controller == null) {
            controller = new RepositorioController(new RepositorioService(new RepositorioRepository()));
        }
        return controller;
    }

    public List<RepositorioDTO> getAllRepositorio() {
        try {
            return repositorioService.getAllRepositorio();
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getAllRepositorio: " + e.getMessage());
            return null;
        }
    }
    public String getAllRepositorioJSON() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.getAllRepositorio());
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getAllRepositorio: " + e.getMessage());
            return "Error RepositorioController en getAllRepositorio: " + e.getMessage();
        }
    }
    public String getRepositorioByIdJSON(Long id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(repositorioService.getRepositorioById(id));
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getRepositorioById: " + e.getMessage());
            return "Error RepositorioController en getRepositorioById: " + e.getMessage();
        }
    }

    public RepositorioDTO getRepositorioById(Long id) {
        try {
            return repositorioService.getRepositorioById(id);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en getRepositorioById " + e.getMessage());
            return null;
        }
    }

    public RepositorioDTO postRepositorio(RepositorioDTO repositorioDTO) {
        try {
            return repositorioService.postRepositorio(repositorioDTO);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en postRepositorio " + e.getMessage());
            return null;
        }
    }

    public RepositorioDTO updateRepositorio(RepositorioDTO repositorioDTO) {
        try {
            return repositorioService.updateRepositorio(repositorioDTO);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en updateRepositorio " + e.getMessage());
            return null;
        }
    }

    public RepositorioDTO deleteRepositorio(RepositorioDTO repositorioDTO) {
        try {
            return repositorioService.deleteRepositorio(repositorioDTO);
        } catch (SQLException e) {
            System.err.println("Error RepositorioController en deleteRepositorio " + e.getMessage());
            return null;
        }
    }

}