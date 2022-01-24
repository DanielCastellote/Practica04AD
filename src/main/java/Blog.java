import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.ProgramadorController;
import dao.Programador;
import dto.ProgramadorDTO;
import manager.HibernateController;

import java.util.List;

public class Blog {
        private static Blog instance;

        private Blog() {
        }

        public static Blog getInstance() {
            if (instance == null) {
                instance = new Blog();
            }
            return instance;
        }

    //TODO BORRAR EJEMPLOS
     public void initDataBase() {
         // Borramos los datos previos
         removeData();

         HibernateController hc = HibernateController.getInstance();
         hc.open();
         //Programadores
         hc.getTransaction().begin();

         System.out.println("Insertando programadores de ejemplo");
         Programador p1 = new Programador("Javier",1200,"javier@gmail.com","1234");
         Programador p2 = new Programador("Daniel",1200,"daniel@gmail.com","5678");
         Programador p3 = new Programador("Jose Luis",2800,"joseluis@gmail.com","12345678");
         Programador p4 = new Programador("Javier Palacios",2800,"javipalacios@gmail.com","87654321");

         hc.getManager().persist(p1);
         hc.getManager().persist(p2);
         hc.getManager().persist(p3);
         hc.getManager().persist(p4);

         hc.getTransaction().commit();

/*
         // Usuarios
         System.out.println("Insertando Usuarios de Ejemplo");

         hc.getTransaction().begin();
         User u1 = new User("Pepe Perez","pepe@pepe.es","1234"); // 5
         User u2 = new User("Ana Anaya","ana@anaya.es","1234"); // 6
         User u3 = new User("Paco Perez","paco@perez.es","1234"); // 7
         User u4 = new User("Son Goku","goku@dragonball.es","1234"); // 8
         User u5 = new User("Chuck Norris","chuck@norris.es","1234");  // 9

         hc.getManager().persist(u1);
         hc.getManager().persist(u2);
         hc.getManager().persist(u3);
         hc.getManager().persist(u4);
         hc.getManager().persist(u5);

         hc.getTransaction().commit();

         // Post
         System.out.println("Insertando Post de Ejemplo");

         hc.getTransaction().begin();
         Post p1 = new Post("Post num 1", "http://post1.com", "Este es el post num 1", u1, c1); //10
         Post p2 = new Post("Post num 2", "http://post2.com", "Este es el post num 1", u2, c2); //11
         Post p3 = new Post("Post num 3", "http://post3.com", "Este es el post num 1", u3, c3); //12
         Post p4 = new Post("Post num 4", "http://post4.com", "Este es el post num 1", u1, c1); //13
         Post p5 = new Post("Post num 5", "http://post5.com", "Este es el post num 1", u2, c3); //14

         hc.getManager().persist(p1);
         hc.getManager().persist(p2);
         hc.getManager().persist(p3);
         hc.getManager().persist(p4);
         hc.getManager().persist(p5);

         hc.getTransaction().commit();

         // Comentarios
         System.out.println("Insertando Comentarios de Ejemplo");

         hc.getTransaction().begin();
         Comment cm1 = new Comment("Comentario 01,", u1, p1);//15
         Comment cm2 = new Comment("Comentario 02,", u2, p2);//16
         Comment cm3 = new Comment("Comentario 03,", u3, p2);//17
         Comment cm4 = new Comment("Comentario 04,", u1, p3);//18
         Comment cm5 = new Comment("Comentario 05,", u4, p4);//19
         Comment cm6 = new Comment("Comentario 06,", u1, p3);//20
         Comment cm7 = new Comment("Comentario 07,", u4, p4);//21
         Comment cm8 = new Comment("Comentario 08,", u2, p3);//22

         hc.getManager().persist(cm1);
         hc.getManager().persist(cm2);
         hc.getManager().persist(cm3);
         hc.getManager().persist(cm4);
         hc.getManager().persist(cm5);
         hc.getManager().persist(cm6);
         hc.getManager().persist(cm7);
         hc.getManager().persist(cm8);

         hc.getTransaction().commit();

 */

         hc.close();

     }

     private void removeData() {
         // Usando Hibernate
//        transactionManager.begin();
//        // Collection == name of the class being saved ⮧
//        entityManager.createNativeQuery("db.GameCharacter.drop()").executeUpdate();
//        transactionManager.commit();
         // Lo sutyo sería un controlador
         ConnectionString connectionString = new ConnectionString("mongodb://mongoadmin:mongopass@localhost/test?authSource=admin");
         //ConnectionString connectionString = new ConnectionString("localhost:8081");
         MongoClient mongoClient = MongoClients.create(connectionString);

         // Obtenemos la base de datos que necesitamos
         MongoDatabase blogDB = mongoClient.getDatabase("blog");
         blogDB.drop(); // Si queremos borrar toda la base de datos
     }

     public void Commits(){

     }
     public void Departamentos(){

     }
     public void Issues(){

     }
     public void Logins(){

     }

     public void Proyectos(){

     }
     public void Repositorios(){

     }
     public void Tecnologias(){

     }

    public void Programadores(){
    System.out.println("INICIO DE PROGRAMADORES")  ;
        ProgramadorController programadorController = ProgramadorController.getInstance();
        System.out.println("GET Todos los programadores");
        List<ProgramadorDTO> listaProgramadores = programadorController.getAllProgramadores();
        System.out.println(listaProgramadores);
        }

     // TODO (BORRAR) EJEMPLOS JOSE LUIS
/*
     public void Comments() {
         System.out.println("INICIO COMENTARIOS");

         CommentController commentController = CommentController.getInstance();

         System.out.println("GET Todos los Comentarios");
         List<CommentDTO> lista = commentController.getAllComments();
         System.out.println(lista);

         System.out.println("GET Comentario con ID: " + lista.get(1).getId());
         System.out.println(commentController.getCommentById(lista.get(1).getId()));

         System.out.println("POST Insertando Comentario 1");

         User user = lista.get(0).getUser(); // Sé que el id existe ...
         // Y un Post
         Post post = lista.get(0).getPost();

         CommentDTO commentDTO1 = CommentDTO.builder()
                 .texto("Comentario 1 - " + Instant.now().toString())
                 .user(user)
                 .post(post)
                 .build();
         commentDTO1 = commentController.postComment(commentDTO1);
         System.out.println(commentDTO1);

         System.out.println("POST Insertando Comentario 2");

         user = lista.get(3).getUser();
         // Y un Post
         post = lista.get(3).getPost();

         CommentDTO commentDTO2 = CommentDTO.builder()
                 .texto("Comentario 2 - " + Instant.now().toString())
                 .user(user)
                 .post(post)
                 .build();
         commentDTO2 = commentController.postComment(commentDTO2);
         System.out.println(commentDTO2);

         System.out.println("UPDATE Comentario con ID: " + commentDTO1.getId());
         Optional<CommentDTO> optionalCommentDTO = commentController.getCommentByIdOptional(commentDTO1.getId());
         if (optionalCommentDTO.isPresent()) {
             optionalCommentDTO.get().setTexto("Update " + LocalDateTime.now());
             System.out.println(commentController.updateComment(optionalCommentDTO.get()));
         }

         System.out.println("DELETE Comentario con ID: " + commentDTO2.getId());
         optionalCommentDTO = commentController.getCommentByIdOptional(commentDTO2.getId());
         if (optionalCommentDTO.isPresent()) {
             System.out.println(commentController.deleteComment(optionalCommentDTO.get()));
         }

         System.out.println("GET Dado un post ID: " + post.getId() + " Obtener sus Comentarios Post --> Comentarios");
         // No deja hacerlo porque JPA no permite Join con Mongo
         // postController.getPostById(2L).getComments().forEach(System.out::println);
         post.getComments().forEach(System.out::println);

         System.out.println("GET Dado un usuario ID: " + user.getId() + " obtener sus comentarios Usuario --> Comentarios");
         // JPA en Mongo no permite las Queris con Joins
         // userController.getUserById(1L).getComentarios().forEach(System.out::println);
         user.getComments().forEach(System.out::println);

         System.out.println("GET Dado un comentario ID: " + commentDTO1.getId() + " saber su Post Comentario --> Post");
         // System.out.println(commentController.getCommentById(2L).getPost());
         System.out.println(commentDTO1.getPost());

         System.out.println("GET Dado un comentario ID: " + commentDTO1.getId() + " saber su Autor Comentario --> Comentario");
         // System.out.println(commentController.getCommentById(2L).getUser());
         System.out.println(commentDTO1.getUser());

         System.out.println("DELETE Borrrando un post ID: " + post.getId() + " se borran sus comentarios? Post --> Comentario"); // Cascada
         PostController postController = PostController.getInstance();
         PostMapper postMapper = new PostMapper();
         System.out.println(postController.deletePost(postMapper.toDTO(post)));

         System.out.println("DELETE Borrrando un usuario usuario ID: " + user.getId() + "  se borran comentarios User --> Comentarios"); // Cascada
         // Cascada de post y de post comentarios
         UserController userController = UserController.getInstance();
         UserMapper userMapper = new UserMapper();
         System.out.println(userController.deleteUser(userMapper.toDTO(user)));

         System.out.println("FIN COMENTARIOS");



 */
     }
