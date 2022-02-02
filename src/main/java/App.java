
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
            data.Programadores();
            data.Departamentos();
            data.Proyectos();
            //blog.Logins();
            data.Repositorios();
            data.Tecnologias();
            data.Issues();
            data.Commits();

    }
}