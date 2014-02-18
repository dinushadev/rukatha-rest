
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Signin to Rukata</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/signin.css" rel="stylesheet">
	<link href="../resources/starter-template.css" rel="stylesheet">
	
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

 <!-- Place this asynchronous JavaScript just before your </body> tag -->
    <script type="text/javascript">
      (function() {
       var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
       po.src = 'https://apis.google.com/js/client:plusone.js';
       var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
     })();
    </script>



    <div class="container">
		<!-- <div class="navbar-form navbar-right"> -->
		  <form class="form-signin" class="navbar-form navbar-right" role="form">
		  
			<!-- <h3 class="form-signin-heading text-center">Sign in with RuKata</h3> -->
			<input type="text" class="form-control" placeholder="Email address" required autofocus>
			<p></p>
			<input type="password" class="form-control" placeholder="Password" required>
			<label class="checkbox">
			  <input type="checkbox" value="remember-me"> Remember me
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			
			<h3 class="text-center">Or</h3>
<!-- 		
			--Logins with bigger images--
			<img border="0" src="res/facebook.png" alt="facebook login" width="49%">
			<img border="0" src="res/twitter.png" alt="twitter login" width="49%">
			<img border="0"  src="res/google.png" alt="google login" width="100%"> -->
			
			<div class="row">
				<a href="#"><img class="img-responsive col-md-4" src="../resources/res/facebook.png" alt="facebook login"></a>
				<a href="#"><img class="img-responsive col-md-4" src="../resources/res/twitter.png" alt="twitter login"></a>
				<div id="gSignInWrapper">
				  <div id="googleSigninBtn" class="classesToStyleWith">
				   <img class="img-responsive col-md-4" src="../resources/res/Google-G-Logo.png" alt="google login"></a>
				  </div>
				</div>

			<!--	<a href="#" onclick="prepareUserFront()"><img class="img-responsive col-md-4" src="res/Google-G-Logo.png" alt="google login"></a>
-->

				<meta name="google-signin-clientid" content="293977541097-e4ofc9qf74g8crdjqhmce7vk7ju3urus.apps.googleusercontent.com" />
				<meta name="google-signin-scope" content="https://www.googleapis.com/auth/plus.login" />
				<meta name="google-signin-requestvisibleactions" content="http://schemas.google.com/AddActivity" />
				<meta name="google-signin-cookiepolicy" content="single_host_origin" />
				<meta name="google-signin-callback" content="signinCallback" />
				<script type="text/javascript">
				(function() {
				  var po = document.createElement('script');
				  po.type = 'text/javascript'; po.async = true;
				  po.src = 'https://apis.google.com/js/client:plusone.js?onload=render';
				  var s = document.getElementsByTagName('script')[0];
				  s.parentNode.insertBefore(po, s);
				})();

			

				</script>
<!-- In the callback, you would hide the gSignInWrapper element on a
successful sign in -->

			</div>
		  </form>
		  
		<!-- </div> -->
    </div> <!-- /container -->

<!-- Modal -->
<div class="modal fade" id="regConformModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="regConformTitleModalLabel">Hi, Welcom to RuKatha,</h4>
      </div>
      <div class="modal-body" id="regConformBodyModal">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" id="regConformCancelModal" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary" id="regConformModalRegBtn">Registor</button>
      </div>
    </div>
  </div>
</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	 <script src="../resources/assets/js/jquery.js"></script>
   <script src="../resources/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../resources/LoadEnvironment.js"></script>
		<script type="text/javascript" src="../resources/scripts/signin.js"></script>
  </body>
</html>
