import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.ProgramadorController;
import dao.Departamento;
import dao.Login;
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
         System.out.println("Insertando programadores de ejemplo");
         hc.getTransaction().begin();

         Programador p1 = new Programador("Javier",1200,"javier@gmail.com","1234");
         Programador p2 = new Programador("Daniel",1200,"daniel@gmail.com","5678");
         Programador p3 = new Programador("Jose Luis",2800,"joseluis@gmail.com","12345678");
         Programador p4 = new Programador("Javier Palacios",2800,"javipalacios@gmail.com","87654321");

         hc.getManager().persist(p1);
         hc.getManager().persist(p2);
         hc.getManager().persist(p3);
         hc.getManager().persist(p4);
         hc.getTransaction().commit();

         System.out.println("Insertando departamentos de ejemplo");
         hc.getTransaction().begin();
         Departamento d1 = new Departamento("Recursos Humanos",20500,125000);
         Departamento d2 = new Departamento("Informatica",30000,250000);
         Departamento d3 = new Departamento("Limpieza",5000,75000);
         Departamento d4 = new Departamento("Ciberseguridad",27500,160000);

         hc.getManager().persist(d1);
         hc.getManager().persist(d2);
         hc.getManager().persist(d3);
         hc.getManager().persist(d4);
         hc.getTransaction().commit();

         System.out.println("Insertando logins de las personas");
         hc.getTransaction().begin();
         Login l1 = new Login(1234,true);
         Login l2 = new Login(5678,false);
         Login l3 = new Login(1357,true);
         Login l4 = new Login(2468,false);

         hc.getManager().persist(l1);
         hc.getManager().persist(l2);
         hc.getManager().persist(l3);
         hc.getManager().persist(l4);
         hc.getTransaction().commit();

         System.out.println("Insertando proyectos para trabajar");
         System.out.println("Insertando repositorios");
         System.out.println("Insertando tecnologias");


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
