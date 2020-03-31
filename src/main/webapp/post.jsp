<!DOCTYPE html>
<html h1="dmiadmia">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Microblog</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/Carousel_Image_Slider-1.css">
        <link rel="stylesheet" href="assets/css/Carousel_Image_Slider.css">
        <link rel="stylesheet" href="assets/css/Footer-Basic.css">
        <link rel="stylesheet" href="assets/css/GradeJS-the-preview-image-do-not-reflect-the-effect.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
        <link rel="stylesheet" href="assets/css/Image-slider-carousel-With-arrow-buttons-1.css">
        <link rel="stylesheet" href="assets/css/Image-slider-carousel-With-arrow-buttons.css">
        <link rel="stylesheet" href="assets/css/Pretty-Registration-Form.css">
        <link rel="stylesheet" href="assets/css/Pretty-Login-Form.css">
        <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
        <link rel="stylesheet" href="assets/css/Navigation-with-Button.css">
        <link rel="stylesheet" href="assets/css/Projects-Horizontal.css">
        <link rel="stylesheet" href="assets/css/simple-footer.css">
        <link rel="stylesheet" href="assets/css/Simple-Slider.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body class="text-left">
        <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
            <div class="container"><a class="navbar-brand" href="index.html" style="color: rgb(66,191,56);">MicroBlog</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav mr-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="/">Home</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="AddPostServlet">Aggiungi</a></li>
                    </ul><span class="navbar-text actions"> <a href="login.html" class="login">Accedi</a><a class="btn btn-light shake animated action-button" role="button" href="registration.html" style="background-color: rgb(66,191,56);">Registrati</a></span></div>
            </div>
        </nav>
        <div>
            <%@ page import="it.marconivr.microblog.entity.*" %> 
            <%@ page import="it.marconivr.microblog.dao.*" %> 
            <%@ page import="java.util.List" %>

            <% List<BlogPost> postList = PostDao.findPostEntities(); %>
            <% for (int i = 0; i < postList.size(); i++) { %>  
                <% BlogPost p = postList.get(i);%>
                <div class="card">
                    <h1 class="card-title"><% out.print(p.getTitolo()); %></h1> <br>
                    <p class="card-text"> <% out.print(p.getUtente().getUsername() + " " + p.getDataOra().toString()); %></p>
                    <p class="card-text"> <% out.print(p.getContenuto()); %></p>
                     <h4>Commenti</h4>
                     <div>
                         <% List<BlogCommento> commentiList = (List<BlogCommento>) CommentoDao.findByPost(p);%>
                        <% for (int j = 0; j < commentiList.size(); j++) { %>
                        <% BlogCommento c = commentiList.get(j); %>
                        <div class="commento">
                            <p> <% out.print(c.getUtente().getUsername() + " " + c.getDataOra().toString()); %></p>
                            <p> <% out.print(c.getContenuto()); %></p>
                     </div>
                      <% } %>
                      <form action="CommentoServlet">
                         <% long postId = p.getId();%>
                        <input type="hidden" name="postId" value="<%=postId%>">
                        <button class="btn btn-light btn-lg" type="submit" style="background-color: rgb(66,191,56);">Commenta</button>
                      </form>
                </div>
        </div>
                   
          <% }%>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-animation.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect-1.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
        <script src="assets/js/Image-slider-carousel-With-arrow-buttons.js"></script>
        <script src="assets/js/Simple-Slider.js"></script>
    </body>

</html>