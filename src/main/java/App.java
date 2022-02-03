
import utils.ApplicationProperties;

public class App {
    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();
        System.out.println("BIENVENID@ A " +
                properties.readProperty("app.title") + " "
                + properties.readProperty("app.version") + " de " +
                properties.readProperty("app.curso")+" creada por "+
                properties.readProperty("app.creadores"));

        Data data = Data.getInstance();

        if (properties.readProperty("database.init").equals("true"))
            data.initDataBase();
            runData();


    }

    public static void runData(){
        Data data = Data.getInstance();
        //blog.Logins();

        data.Tecnologias();
        data.TecnologiasJson();

        data.Issues();
        data.IssuesJson();

        data.Commits();
        data.CommitsJson();

        data.Repositorios();
        data.RepositoriosJson();

        data.Proyectos();
        data.ProyectosJson();

        data.Departamentos();
        data.DepartamentosJson();

        data.Programadores();
        data.ProgramadoresJson();
    }
}