package controller;


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