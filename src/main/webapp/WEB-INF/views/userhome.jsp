
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>RuKata</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/starter-template.css" rel="stylesheet">
	<link href="../resources/shared.css" rel="stylesheet">
	
	<!-- Jquery and Javascript for building the user environment -->
	<!-- <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="LoadEnvironment.js"></script> -->
	
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div id="interactionBtnsDiv" class="navbar-form navbar-right"> <!-- A small hack to align the buttons vertically and horizontally for the time being -->
			
			 <!-- <a href="#" onclick="alert('clicked')"><img src="res/Add_Story.png" alt="add a story"></a> -->
			 <!-- <a href="#" class="btn btn-primary btn-sm" role="button">+</a> -->
			 <a href="kataworkbench.html" class="btn btn-default btn-sm" role="button">
			  <span class="glyphicon glyphicon-plus glyphiconColorGray"></span>
			</a>
			 <a href="/" class="btn btn-primary btn-sm" onclick="logOut()" role="button">Log out</a>
			
		</div>
      <div class="container">
        <div class="navbar-header">
          <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button> -->
          <a class="navbar-brand" href="#">RuKata</a>
		  <!-- <img src="res/logo_v4.png" class="img-responsive" alt="Responsive image"> -->
        </div>
      </div>
    </div>

    <div class="container">

      <div class="starter-template">
        <h1>User customized graphical stories go here</h1>
        <!-- <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p> -->
      </div>

    </div><!-- /.container -->
 <!-- Place this asynchronous JavaScript just before your </body> tag -->
    <script type="text/javascript">
      (function() {
       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
       po.src = 'https://apis.google.com/js/client:plusone.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();
    </script>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   <script src="../resources/assets/js/jquery.js"></script>
    <script src="../resources/dist/js/bootstrap.min.js"></script>

	  <script src="../resources/scripts/user_home.js"></script>
  </body>
</html>
