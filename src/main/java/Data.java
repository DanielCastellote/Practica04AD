import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import controller.*;
import dao.*;
import dto.*;
import manager.HibernateController;

import java.util.List;

public class Data {
        private static Data instance;

        private Data() {
        }

        public static Data getInstance() {
            if (instance == null) {
                instance = new Data();
            }
            return instance;
        }

    //TODO BORRAR EJEMPLOS
     public void initDataBase() {
         // Borramos los datos previos
         removeData();

         HibernateController hc = HibernateController.getInstance();
         hc.open();
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

         System.out.println("Insertando proyectos para trabajar");
         hc.getTransaction().begin();
         Proyecto proy1 = new Proyecto("Gestion Polideportivo",250000,d1);
         Proyecto proy2 = new Proyecto("Gestion Peluqueria",125000,d2);
         Proyecto proy3 = new Proyecto("Gestion Restaurante",275000,d3);
         Proyecto proy4 = new Proyecto("Gestion Baños",50000,d4);
         hc.getManager().persist(proy1);
         hc.getManager().persist(proy2);
         hc.getManager().persist(proy3);
         hc.getManager().persist(proy4);
         hc.getTransaction().commit();

         //Programadores
         System.out.println("Insertando programadores de ejemplo");
         hc.getTransaction().begin();

         Programador p1 = new Programador("Javier",1200,"javier@gmail.com","1234",proy1,d1);
         Programador p2 = new Programador("Daniel",1200,"daniel@gmail.com","5678",proy2,d2);
         Programador p3 = new Programador("Jose Luis",2800,"joseluis@gmail.com","12345678",proy3,d3);
         Programador p4 = new Programador("Javier Palacios",2800,"javipalacios@gmail.com","87654321",proy3,d4);
         Programador p5 = new Programador("Carmen FOL",2800,"carmenfol@gmail.com","54321678",proy4,d4);

         hc.getManager().persist(p1);
         hc.getManager().persist(p2);
         hc.getManager().persist(p3);
         hc.getManager().persist(p4);
         hc.getManager().persist(p5);
         hc.getTransaction().commit();



         System.out.println("Insertando repositorios");
         hc.getTransaction().begin();
         Repositorio r1 = new Repositorio();
         Repositorio r2 = new Repositorio();
         Repositorio r3 = new Repositorio();
         Repositorio r4 = new Repositorio();
         hc.getManager().persist(r1);
         hc.getManager().persist(r2);
         hc.getManager().persist(r3);
         hc.getManager().persist(r4);
         hc.getTransaction().commit();

         System.out.println("Insertando tecnologias");
         hc.getTransaction().begin();
         Tecnologia tc1= new Tecnologia("Java",p1);
         Tecnologia tc2= new Tecnologia("Phyton",p1);
         Tecnologia tc3= new Tecnologia("C++",p2);
         Tecnologia tc4= new Tecnologia("Java",p2);
         Tecnologia tc5= new Tecnologia("Spring",p3);
         Tecnologia tc6= new Tecnologia("Vue",p4);
         Tecnologia tc7= new Tecnologia("Kotlin",p4);
         Tecnologia tc8= new Tecnologia("Php",p4);
         Tecnologia tc9= new Tecnologia("Office",p5);
         hc.getManager().persist(tc1);
         hc.getManager().persist(tc2);
         hc.getManager().persist(tc3);
         hc.getManager().persist(tc4);
         hc.getManager().persist(tc5);
         hc.getManager().persist(tc6);
         hc.getManager().persist(tc7);
         hc.getManager().persist(tc8);
         hc.getManager().persist(tc9);
         hc.getTransaction().commit();

         System.out.println("Insertando Commits");
         hc.getTransaction().begin();
         Commit c1 = new Commit("Readme Update","Subida readme con lenguaje",p1,r1);
         Commit c2 = new Commit("Diagrama Update","Relaciones actualizadas",p2,r2);
         Commit c3 = new Commit("Subida de fotos","Imagenes a color",p2,r3);
         Commit c4 = new Commit("Controller correccion","Faltas ortograficas",p3,r4);
         Commit c5 = new Commit("Proyect Update","Version actual",p3,r4);
         Commit c6 = new Commit("Readme Update 3.0 correccion","Nuevo readme del becario",p3,r4);
         Commit c7 = new Commit("Inyeccion dependencias update","Inyeccion exitosa",p1,r2);
         Commit c8 = new Commit("Creators update","Actualizada",p3,r1);
         hc.getManager().persist(c1);
         hc.getManager().persist(c2);
         hc.getManager().persist(c3);
         hc.getManager().persist(c4);
         hc.getManager().persist(c5);
         hc.getManager().persist(c6);
         hc.getManager().persist(c7);
         hc.getManager().persist(c8);

         hc.getTransaction().commit();

         System.out.println("Insertando Issues");
         hc.getTransaction().begin();
         Issue issu1 = new Issue("Problema ordenador","no me funciona el ordenador",r1,"Terminado");
         Issue issu2 = new Issue("Problema descanso","no tenemos suficiente descanso",r1,"En proceso");
         Issue issu3 = new Issue("Cafeteria precios","los cafes son muy caros",r1,"Terminado");
         Issue issu4 = new Issue("Horario flexible","necesito recoger a mis hijos",r2,"En proceso");
         Issue issu5 = new Issue("Guarderia niños","necesito dejar a mis niños aqui",r3,"Terminado");
         Issue issu6 = new Issue("Gotera techo","me caen gotas en mi escritorio",r3,"Terminado");
         Issue issu7 = new Issue("Baño planta 3","está muy sucio el suelo",r4,"Terminado");
         Issue issu8 = new Issue("Escaleras","necesito que habiliten escaleras mecanicas",r4,"En proceso");
         hc.getManager().persist(issu1);
         hc.getManager().persist(issu2);
         hc.getManager().persist(issu3);
         hc.getManager().persist(issu4);
         hc.getManager().persist(issu5);
         hc.getManager().persist(issu6);
         hc.getManager().persist(issu7);
         hc.getManager().persist(issu8);
         hc.getTransaction().commit();


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
         MongoDatabase dataDJ = mongoClient.getDatabase("DataDJ");
         dataDJ.drop(); // Si queremos borrar toda la base de datos
     }

     public void Commits(){
         System.out.println("INICIO DE COMMITS")  ;
         CommitController commitController = CommitController.getInstance();
         List<CommitDTO> listaCommits = commitController.getAllCommit();
         System.out.println("GET Todos los COMMITS" +"\n"+listaCommits);
     }
     public void CommitsJson(){
            CommitController commitController = CommitController.getInstance();
            System.out.println("GET Todos los COMMITS por JSON" +"\n"+ commitController.getAllCommitsJSON());
            System.out.println("GET COMMIT por ID (=30) por JSON"+"\n"+ commitController.getCommitByIdJSON(30L));
            System.out.println("GET COMMIT por ID (=34) por JSON"+"\n"+ commitController.getCommitByIdJSON(34L));
     }

     public void Departamentos(){
         System.out.println("INICIO DE DEPARTAMENTOS")  ;
         DepartamentoController departamentoController = DepartamentoController.getInstance();
         List<DepartamentoDTO> listaDepartamentos = departamentoController.getAllDepartamento();
         System.out.println("GET Todos los DEPARTAMENTOS" +"\n"+listaDepartamentos);
     }
     public void DepartamentosJson(){
         DepartamentoController departamentoController = DepartamentoController.getInstance();
         System.out.println("GET Todos los DEPARTAMENTOS por JSON" +"\n"+ departamentoController.getAllDepartamentoJSON());
         System.out.println("GET DEPARTAMENTOS por ID (=1) por JSON"+"\n"+ departamentoController.getDepartamentoByIdJSON(1L));
         System.out.println("GET DEPARTAMENTOS por ID (=4) por JSON"+"\n"+ departamentoController.getDepartamentoByIdJSON(4L));
     }

    public void Issues(){
        System.out.println("INICIO DE ISSUES")  ;
        IssueController issueController = IssueController.getInstance();
        List<IssueDTO> listaIssue = issueController.getAllIssue();
        System.out.println("GET Todos los ISSUES" +"\n"+listaIssue);
    }
    public void IssuesJson(){
        IssueController issueController = IssueController.getInstance();
        System.out.println("GET Todos los ISSUE por JSON" +"\n"+ issueController.getAllIssueJSON());
        System.out.println("GET ISSUE por ID (=40) por JSON"+"\n"+ issueController.getIssueByIdJSON(40L));
        System.out.println("GET ISSUE por ID (=36) por JSON"+"\n"+ issueController.getIssueByIdJSON(36L));
    }
/*
     public void Logins(){
         System.out.println("INICIO DE LOGINS")  ;
         LoginController loginController = LoginController.getInstance();
         System.out.println("GET Todos los programadores");
         List<LoginDTO> listaLogin = loginRepository
         System.out.println(listaLogin);
     }

 */

     public void Proyectos(){
         System.out.println("INICIO DE PROYECTOS")  ;
         ProyectoController proyectoController = ProyectoController.getInstance();
         List<ProyectoDTO> listaProyectos = proyectoController.getAllProyectos();
         System.out.println("GET Todos los PROYECTOS" +"\n"+listaProyectos);
     }
    public void ProyectosJson(){
        ProyectoController proyectoController = ProyectoController.getInstance();
        System.out.println("GET Todos los PROYECTO por JSON" +"\n"+ proyectoController.getAllProyectoJSON());
        System.out.println("GET PROYECTO por ID (=5) por JSON"+"\n"+ proyectoController.getProyectoByIdJSON(5L));
        System.out.println("GET PROYECTO por ID (=8) por JSON"+"\n"+ proyectoController.getProyectoByIdJSON(8L));
    }

     public void Repositorios(){
         System.out.println("INICIO DE REPOSITORIOS") ;
         RepositorioController repositorioController = RepositorioController.getInstance();
         List<RepositorioDTO> listaRepositorios = repositorioController.getAllRepositorio();
         System.out.println("GET Todos los REPOSITORIOS"+"\n"+listaRepositorios);
     }
    public void RepositoriosJson(){
        RepositorioController repositorioController = RepositorioController.getInstance();
        System.out.println("GET Todos los PROYECTO por JSON" +"\n"+ repositorioController.getAllRepositorioJSON());
        System.out.println("GET PROYECTO por ID (=14) por JSON"+"\n"+ repositorioController.getRepositorioByIdJSON(14L));
        System.out.println("GET PROYECTO por ID (=17) por JSON"+"\n"+ repositorioController.getRepositorioByIdJSON(17L));
    }

     public void Tecnologias(){
         System.out.println("INICIO DE TECNOLOGIAS")  ;
         TecnologiaController tecnologiaController = TecnologiaController.getInstance();
         List<TecnologiaDTO> listaTecnologia = tecnologiaController.getAllTecnologias();
         System.out.println("GET Todos los TECNOLOGIA"+"\n"+listaTecnologia);
     }
    public void TecnologiasJson(){
        TecnologiaController tecnologiaController = TecnologiaController.getInstance();
        System.out.println("GET Todos los TECNOLOGIA por JSON" +"\n"+ tecnologiaController.getAllTecnologiaJSON());
        System.out.println("GET TECNOLOGIA por ID (=18) por JSON"+"\n"+ tecnologiaController.getTecnologiaByIdJSON(18L));
        System.out.println("GET TECNOLOGIA por ID (=22) por JSON"+"\n"+ tecnologiaController.getTecnologiaByIdJSON(22L));
    }


    public void Programadores(){
        System.out.println("INICIO DE PROGRAMADORES")  ;
        ProgramadorController programadorController = ProgramadorController.getInstance();
        List<ProgramadorDTO> listaProgramadores = programadorController.getAllProgramadores();
        System.out.println("GET Todos los PROGRAMADORES"+"\n"+listaProgramadores);
     }
    public void ProgramadoresJson(){
        ProgramadorController programadorController = ProgramadorController.getInstance();
        System.out.println("GET Todos los PROGRAMADORES por JSON" +"\n"+ programadorController.getAllProgramadorJSON());
        System.out.println("GET PROGRAMADORES por ID (=10) por JSON"+"\n"+ programadorController.getProgramadorByIdJSON(10L));
        System.out.println("GET PROGRAMADORES por ID (=13) por JSON"+"\n"+ programadorController.getProgramadorByIdJSON(13L));
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