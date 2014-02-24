
function logOut(){
	gapi.auth.signOut();
	
	$.ajax({
				        type: 'GET',              
				        url: '../ui/logout',
				        dataType: 'json', 
				        headers: {
							'Accept': 'application/json',
							'Content-Type': 'application/json'
						},
				        success: function (data) {
				        	if(data.status){
								prepareUserFront();
				        	}else{
				        		alert( "Error while login out " );
				        	}
				        	  	
				        ; }
				    });
}