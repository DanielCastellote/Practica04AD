package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CommitDTO;
import repository.CommitRepository;
import service.CommitService;

import java.sql.SQLException;
import java.util.List;

public class CommitController {
    private static CommitController controller = null;

    private final CommitService commitService;

    private CommitController(CommitService commitService) {
        this.commitService = commitService;
    }

    public static CommitController getInstance() {
        if (controller == null) {
            controller = new CommitController(new CommitService(new CommitRepository()));
        }
        return controller;
    }

    public List<CommitDTO> getAllCommit() {
        try {
            return commitService.getAllCommit();
        } catch (SQLException e) {
            System.err.println("Error CommitController en getAllCommit: " + e.getMessage());
            return null;
        }
    }

    public String getAllCommitsJSON() {
        try {
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(commitService.getAllCommit());
        } catch (SQLException e) {
            System.err.println("Error CommitController en getAll: " + e.getMessage());
            return "Error CommitController en getAll: " + e.getMessage();
        }
    }
    public String getCommitByIdJSON(Long id) {
        try {
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(commitService.getCommitById(id));
        } catch (SQLException e) {
            System.err.println("Error CommitController en getCommitById: " + e.getMessage());
            return "Error CommitController en getCommitById: " + e.getMessage();
        }
    }

    public CommitDTO getCommitById(Long id) {
        try {
            return commitService.getCommitById(id);
        } catch (SQLException e) {
            System.err.println("Error CommitController en getCommitById " + e.getMessage());
            return null;
        }
    }

    public CommitDTO postCommit(CommitDTO commitDTO) {
        try {
            return commitService.postCommit(commitDTO);
        } catch (SQLException e) {
            System.err.println("Error CommitController en postCommit " + e.getMessage());
            return null;
        }
    }

    public CommitDTO updateCommit(CommitDTO commitDTO) {
        try {
            return commitService.updateCommit(commitDTO);
        } catch (SQLException e) {
            System.err.println("Error CommitController en updateCommit " + e.getMessage());
            return null;
        }
    }

    public CommitDTO deleteCommit(CommitDTO commitDTO) {
        try {
            return commitService.deleteCommit(commitDTO);
        } catch (SQLException e) {
            System.err.println("Error CommitController en deleteCommit " + e.getMessage());
            return null;
        }
    }
}
