package controller;

import dto.IssueDTO;
import dto.ProgramadorDTO;
import repository.IssueRepository;
import repository.ProgramadorRepository;
import service.IssueService;
import service.ProgramadorService;

import java.sql.SQLException;
import java.util.List;

public class IssueController {

    private static IssueController controller = null;

    private final IssueService issueService;


    private IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    public static IssueController getInstance() {
        if (controller == null) {
            controller = new IssueController(new IssueService(new IssueRepository()));
        }
        return controller;
    }

    public List<IssueDTO> getAllIssue() {
        try {
            return issueService.getAllIssue();
        } catch (SQLException e) {
            System.err.println("Error IssueController en getAllIssue: " + e.getMessage());
            return null;
        }
    }

    public IssueDTO getIssueById(Long id) {
        try {
            return issueService.getIssueById(id);
        } catch (SQLException e) {
            System.err.println("Error IssueController en getIssueById " + e.getMessage());
            return null;
        }
    }

    public IssueDTO postIssue(IssueDTO issueDTO) {
        try {
            return issueService.postIssue(issueDTO);
        } catch (SQLException e) {
            System.err.println("Error IssueController en postIssue " + e.getMessage());
            return null;
        }
    }

    public IssueDTO updateIssue(IssueDTO issueDTO) {
        try {
            return issueService.updateIssue(issueDTO);
        } catch (SQLException e) {
            System.err.println("Error IssueController en updateIssue " + e.getMessage());
            return null;
        }
    }

    public IssueDTO deleteIssue(IssueDTO issueDTO) {
        try {
            return issueService.deleteIssue(issueDTO);
        } catch (SQLException e) {
            System.err.println("Error IssueController en deleteIssue " + e.getMessage());
            return null;
        }
    }
}
