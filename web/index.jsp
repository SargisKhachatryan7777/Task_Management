
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Task</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/slideStyle.css">
  </head>
  <body>

  <!-- Slideshow container -->
  <div class="slideshow-container">

    <!-- Full-width images with number and caption text -->
    <div class="mySlides fade">
      <div class="numbertext">1 / 5</div>
      <img src="/img/img1.jpg" style="width: 1000px;height: 500px">
      <div class="text">Caption Text</div>
    </div>

    <div class="mySlides fade">
      <div class="numbertext">2 / 5</div>
      <img src="/img/img2.jpg" style="width: 1000px;height: 500px">
      <div class="text">Caption Two</div>
    </div>
    <div class="mySlides fade">
      <div class="numbertext">3 / 5</div>
      <img src="/img/img3.jpg" style="width: 1000px;height: 500px">
      <div class="text">Caption Three</div>
    </div>
    <div class="mySlides fade">
      <div class="numbertext">4 / 5</div>
      <img src="/img/img4.jpg" style="width: 1000px;height: 500px">
      <div class="text">Caption Text</div>
    </div> <div class="mySlides fade">
    <div class="numbertext">5 / 5</div>
    <img src="/img/img5.jpg" style="width: 1000px;height: 500px">
    <div class="text">Caption Text</div>
  </div>

    <!-- Next and previous buttons -->
    <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    <a class="next" onclick="plusSlides(1)">&#10095;</a>
  </div>
  <br>

  <!-- The dots/circles -->
  <div style="text-align:center">
    <span class="dot" onclick="currentSlide(1)"></span>
    <span class="dot" onclick="currentSlide(2)"></span>
    <span class="dot" onclick="currentSlide(3)"></span>
    <span class="dot" onclick="currentSlide(4)"></span>
    <span class="dot" onclick="currentSlide(5)"></span>
  </div>


  <div class="login">
    <div class="login-header">
      <h1>Login</h1>
    </div>
    <div class="login-form">
  <form action="/login" method="post">
    <input class="l" type="text" name="email" placeholder="Input your email"><br>
    <input class="l" type="password" name="password" placeholder="Input your passwprd"><br>
    <input type="submit" value="Login" class="login-button">
  </form>
  </div>
  </div>
</body>
  <script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
  <script src="js/slider.js" type="text/javascript"></script>
</html>
