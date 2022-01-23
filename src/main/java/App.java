import
import Utils.ApplicationProperties;

public class App {
    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();
        System.out.println("BIENVENID@ A " +
                properties.readProperty("app.title") + " "
                + properties.readProperty("app.version") + " de " +
                properties.readProperty("app.curso")+" creada por "+
                properties.readProperty("app.creadores"));

        Blog blog = Blog.getInstance();

        if (properties.readProperty("database.init").equals("true"))
            blog.initDataBase();

        // Categorías
        blog.Categories();

        // Usuarios
        blog.Users();

        // Login
        blog.Login();

        // Posts
        blog.Posts();

        // Comments
        blog.Comments();
    }
}