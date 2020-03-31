<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Microblog</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/Carousel_Image_Slider-1.css">
        <link rel="stylesheet" href="assets/css/Carousel_Image_Slider.css">
        <link rel="stylesheet" href="assets/css/ensign-form-1.css">
        <link rel="stylesheet" href="assets/css/ensign-form.css">
        <link rel="stylesheet" href="assets/css/Footer-Basic.css">
        <link rel="stylesheet" href="assets/css/GradeJS-the-preview-image-do-not-reflect-the-effect.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link rel="stylesheet" href="assets/css/Image-slider-carousel-With-arrow-buttons-1.css">
        <link rel="stylesheet" href="assets/css/Image-slider-carousel-With-arrow-buttons.css">
        <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
        <link rel="stylesheet" href="assets/css/Navigation-with-Button.css">
        <link rel="stylesheet" href="assets/css/Pretty-Registration-Form.css">
        <link rel="stylesheet" href="assets/css/Projects-Horizontal.css">
        <link rel="stylesheet" href="assets/css/simple-footer.css">
        <link rel="stylesheet" href="assets/css/Simple-Slider.css">
        <link rel="stylesheet" href="assets/css/styles-1.css">
        <link rel="stylesheet" href="assets/css/styles.css">
    </head>

    <body><div>
            <nav class="navbar navbar-light navbar-expand-md pulse animated navigation-clean-button">
                <div class="container"><a class="navbar-brand" href="/" style="color: rgb(66,191,56);">MicroBlog</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navcol-1">
                        <ul class="nav navbar-nav mr-auto">
                            <li class="nav-item" role="presentation"><a class="nav-link" href="index.html">Home</a></li>
                            <li class="nav-item" role="presentation"><a class="nav-link" href="PostServlet">Post</a></li>


                        </ul><span class="navbar-text actions"> <a href="login.html" class="login">Accedi</a><a class="btn btn-light action-button" role="button" href="registration.html" style="background-color: rgb(66,191,56);">Registrati</a></span></div>
                </div>
            </nav>
        </div>
        <div></div>
        <div class="card"></div>
        <div class="simple-slider">
            <div class="swiper-container">
                <div class="swiper-pagination"></div>
                <div class="swiper-button-prev" style="filter: brightness(136%);"></div>
                <div class="swiper-button-next"></div>
            </div>
        </div>
        <div>
            <div class="containerSlider"></div>
            <div class="containerSlider"></div>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-animation.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect-1.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
        <script src="assets/js/Image-slider-carousel-With-arrow-buttons.js"></script>
        <script src="assets/js/Simple-Slider.js"></script>
        <div class="row">
        <div class="col-12 col-sm-6 col-md-6 col-xl-7 offset-xl-3 site-form">
            <%@ page import="it.marconivr.microblog.entity.*" %> 
            <%@ page import="it.marconivr.microblog.dao.*" %> 
            <%@ page import="java.util.List" %>
            <% long postId = (long) request.getAttribute("postId"); %>
            <% BlogPost p = PostDao.findPost(postId); %>
            <div class="card">
                <h2 class="card-title"><% out.print(p.getTitolo()); %></h2> <br>
                <h5 class="card-text"> <% out.print("Utente: "+p.getUtente().getUsername() + "<br> In data: " + p.getDataOra().toString()); %></h5> 
                <p  class="card-text" ><h5><font face="verdana"> <% out.print(p.getContenuto()); %></font></p></h5>
                <h4>Commenti</h4>
                <div>
                    <% List<BlogCommento> commentiList = (List<BlogCommento>) CommentoDao.findByPost(p);%>
                    <% for (int j = 0; j < commentiList.size(); j++) { %>
                    <% BlogCommento c = commentiList.get(j); %>
                    <div class="commento">
                        <p> <% out.print("Utente: " + c.getUtente().getUsername() + "<br> In data: " + c.getDataOra().toString()); %></p>
                        <p><font face="verdana"> <% out.print(c.getContenuto()); %></font></p>
                    </div>
                    <% }%>
                </div>
            </div>
        </div>
            <div></div>
        
            <div class="col-12 col-sm-6 col-md-6 col-xl-7 offset-xl-3 site-form">
                <form id="my-form" action="SaveCommentoServlet" method="POST">

                    <input type="hidden" name="postId" value="<%=postId%>">

                    <div class="form-group">
                        <label class="sr-only" for="messages">Last Name</label><textarea class="form-control" rows="8" name="testo" required="" placeholder="Inserisci un commento..."></textarea></div><button class="btn btn-light btn-lg" type="submit" id="form-btn"
                            style="background-color: rgb(99,204,62);"><strong>Commenta</strong></button>
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
        <div></div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/bs-animation-1.js"></script>
        <script src="assets/js/bs-animation.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect-1.js"></script>
        <script src="assets/js/GradeJS-the-preview-image-do-not-reflect-the-effect.js"></script>
        <script src="assets/js/Image-slider-carousel-With-arrow-buttons.js"></script>
        <script src="assets/js/Simple-Slider.js"></script>
    </body>

</html>