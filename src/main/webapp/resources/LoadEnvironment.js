var isUserSignedIn = false;

//Redirects the user to a customized front screen after a successful log in. Future code related to signing in will go here 
function prepareUserFront(){
	// alert('google clicked');
	// isUserSignedIn = true;
	// alert(isUserSignedIn);
	window.location.replace("userhome");
/* 	console.log('clicked');
	window.location.replace("index.html");
	divObj = document.getElementById("interactionBtnsDiv"); */
/* 	$('#interactionBtnsDiv').html('<a href="#"><img src="res/Add_Story.png" alt="add a story"></a>');
	$('#interactionBtnsDiv').html('<a href="signin.html" class="btn btn-primary btn-sm" role="button">Log out</a>'); */
	//document.getElementById('interactionBtnsDiv').innerHTML='<a href="#"><img src="res/Add_Story.png" alt="add a story"></a>';
	// divObj.innerHTML="some words";
//	document.getElementById('interactionBtnsDiv').innerHTML='<a href="signin.html" class="btn btn-primary btn-sm" role="button">Log out</a>';
//	$('#interactionBtnsDiv').html('<a href="signin.html" class="btn btn-primary btn-sm" role="button">Log out</a>');
	// window.location.replace("index.html");

}