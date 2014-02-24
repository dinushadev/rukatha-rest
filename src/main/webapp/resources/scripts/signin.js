	/* Executed when the APIs finish loading */
	
				var access_token; 
				var id_token;
	
				function render() {

				  // Additional params
				  var additionalParams = {
				    'theme' : 'dark',
				    'scope': 'email profile'
				  };

				  gapi.signin.render('googleSigninBtn', additionalParams);
				}


				function signinCallback(authResult) {

					//alert(authResult['access_token']);
					if (authResult['access_token'] && authResult['g-oauth-window']) {			    	
				    	//get Email of the user
				    	access_token = authResult['access_token'];
				    	gapi.auth.setToken(authResult); 	
				    	id_token=authResult['id_token'];  
				    	
				    	// Load the oauth2 libraries to enable the userinfo methods.
					    gapi.client.load('oauth2', 'v2', function() {
					    	var request = gapi.client.oauth2.userinfo.get();
					    	request.execute(getUserInfoCallback);
					    });
				    } 
				    else if (authResult['error']) {
				    // do nothing? maybe the user can login with other networks.
					}
				}

				function getUserInfoCallback(obj){
					//alert(JSON.stringify(obj));
					//User is avilable on the RuKatha
					var isUserRegistered = false;
			
						$.ajax({
					        type: 'POST',              
					        url: '../rest/user/check',
					        headers: {
								'Accept': 'application/json',
								'Content-Type': 'application/json',
								'Authorization':'token GOOGLE:'+id_token+':'+ obj.email
							},
					        dataType: 'json',
					         data: JSON.stringify({ email: obj.email, givenName: obj.given_name, familyName: obj.family_name, gender:obj.gender, potourl:obj.picture,authProvider:'GOOGLE'}),
						      success: function (data) {
						    	  
						    //	  alert("data.status "+data.status+"  "+JSON.stringify(data) );
						    	  isUserRegistered= data.status;
						    	//  alert("isUserRegistered: "+isUserRegistered);
					    	  	if(!isUserRegistered){
					    	  		regConformation(obj);
					    	  	}else{
					    	  		prepareUserFront();
					    	  	}
						      }
					    });

						
				

					var email;

					if (obj['email']) {
						email = obj['email'];
					}
					//alert(email);
					
			}
				
				
			function regConformation(obj){
				var em = document.getElementById('email');
				var bodyText = "Hi, "+obj.given_name+","+em+" Welcom to RuKatha."
				$('#regConformBodyModal').text(bodyText);
				$('#regConformModal').modal('show');
				$('#regConformModalRegBtn').click(function(){
					//register user
							
					$.ajax({
				        type: 'POST',              
				        url: '../rest/user/reg',
				        dataType: 'json', 
				        headers: {
							'Accept': 'application/json',
							'Content-Type': 'application/json',
							'Authorization':'token GOOGLE:'+id_token+':'+ obj.email
						},
				         data: JSON.stringify({ email: obj.email, givenName: obj.given_name, familyName: obj.family_name, gender:obj.gender, potourl:obj.picture,authProvider:'GOOGLE' }),
				        success: function (data) {
				        	if(data.email == obj.email){
				        		//alert( "User Registered: " + data.status );
							//    isUserRegistered= msg.status;
								//rediret to home page
								prepareUserFront();
				        	}else{
				        		alert( "Error while User Registration " );
				        	}
				        	  	
				        ; }
				    });

					
					//rediret to home page
					//prepareUserFront();
				});
				$('#regConformModalCancelBtn').click(function(){
					//got to login page
				});
			}	