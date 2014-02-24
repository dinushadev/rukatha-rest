/**
 * Kata workbench ui interactions
 */
//Code to make the div content sortable
$(function () {
	$("#work_area").sortable({
		tolerance: 'pointer',
		opacity: 0.8
	});
});



//************************Testing KineticJS**********************************
//****************In the context of adding images to the canvas**************
/*     var stage = new Kinetic.Stage({
        container: 'work_area',
        width: 1400,
        height: 600,
		draggable: true
      });
     
      var layer = new Kinetic.Layer();*/

//***************************************************************************



//Adding an image to the browser page
$(document)
    .on('change', '.btn-file :file', function() {
        var input = $(this),
            numFiles = input.get(0).files ? input.get(0).files.length : 1,
            label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
            
        console.log(input);    
        input.trigger('fileselect', [input.get(0).files]);
});

/*$(document).ready( function() {
    $('.btn-file :file').on('fileselect', function(event, filesToLoad) {

    	$( filesToLoad ).each(function( k,fileToLoad ) {
    		
            if (fileToLoad.type.match("image.*"))
            {
                var fileReader = new FileReader();
                fileReader.onload = function(fileLoadedEvent) 
                {
                    var imageLoaded = document.createElement("img");
                    imageLoaded.src = fileLoadedEvent.target.result;
//                    document.body.appendChild(imageLoaded);
                    imageLoaded.className = "img-responsive col-md-2 imgStyles";
                    $("#work_area").append(imageLoaded);
                    console.log(fileLoadedEvent.target.result);
                    console.log(fileLoadedEvent.target);
                };
                fileReader.readAsDataURL(fileToLoad);
            }
    	});
        
    });
});*/


//Code that sends the images to the back-end
$(document).ready( function() {
    $('.btn-file :file').on('fileselect', function(event, filesToLoad) {

    	$( filesToLoad ).each(function( k,fileToLoad ) {
    		
            if (fileToLoad.type.match("image.*"))
            {
                var fileReader = new FileReader();
//                fileReader.readAsArrayBuffer(fileToLoad);
//                fileReader.readAsBinaryString(fileToLoad);
                fileReader.readAsDataURL(fileToLoad);
                fileReader.onload = function(fileLoadedEvent) 
                {
                    imageBS = fileLoadedEvent.target.result;
//                    console.log(imageBS);
                    
                    imgJson = JSON.stringify({"img":imageBS});

                    //Sending the binary string of the image to the back-end
    	 			$.ajax({
    		            url: '../rest/image',
    		            type: 'post',
    		            dataType: 'json',
    		            contentType: 'application/json',
    		            success: function (json) {
    		            	console.log("After the transform");
    		            	console.log(JSON.stringify(json));
    		            	
    		            	var imageLoaded = document.createElement("img");
    	                    imageLoaded.src = json.imgResult;
//    		            	imageLoaded.src = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAMAAAF76W4GAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAeUExURdDOzvPz8////9za2u3t7fv6+vLx8fb29uXk5AAAAPSa2dMAAAAKdFJOU////////////wCyzCzPAAAACXBIWXMAABcRAAAXEQHKJvM/AAAAfElEQVQoU72QAQ6AIAwDybb/v9luVEGMIxr0EsB24KCFqA+NOTQwDDWX/tUwE7NqybH5Dok5jmBVleix+21NsKFLr6VBJ9+/gq5VkGkEZeJxMULeFVSNyFWQCVMJnvzfGfUf+AuSVCdlRPLitNsXWAM0zrDWMen9aXktpWyzhgHDi4rvowAAAABJRU5ErkJggg==";
//    		            	b64Img = btoa(json.imgResult);
//    		            	console.log(b64Img);
//    		            	imageLoaded.src="data:image/png;base64,"+b64Img;
//    		            	document.body.appendChild(imageLoaded);
    	                    imageLoaded.className = "img-responsive col-md-2 imgStyles";
    	                    $("#work_area").append(imageLoaded);
    	                    
/*    		            	
    	                    //*************kineticJS - Adding an image******************
    	                    var imageObj = new Image();
    	                    
    	                    imageObj.onload = function() {
    	                      var kataImg = new Kinetic.Image({
    	                        x: 200,
    	                        y: 50,
    	                        image: imageObj
//    	                        width: 106,
//    	                        height: 118
    	                      });

    	                      // add the shape to the layer
    	                      layer.add(kataImg);

    	                      // add the layer to the stage
    	                      stage.add(layer);
    	                    };
    	                    
    	                    console.log(imageObj.src);
    	                    
    	                    imageObj.src = json.imgResult;
    	                    
    	                    console.log(imageObj.src);*/
    	              
    	                //*******************KineticJS - For image scaling*****************************************    
    		              /*  var sources = {
    		                        darthVader: 'http://www.html5canvastutorials.com/demos/assets/darth-vader.jpg',
    		                        yoda: 'http://www.html5canvastutorials.com/demos/assets/yoda.jpg'
    		                };
    		                
    		                loadImages(sources, initStage);*/
    		            },
    		            
    	 				data:imgJson
    		        });                    
                };
            }
    	});        
    });
});


//*************************kineticJS image resize***************************************

/*function update(activeAnchor) {
    var group = activeAnchor.getParent();

    var topLeft = group.get('.topLeft')[0];
    var topRight = group.get('.topRight')[0];
    var bottomRight = group.get('.bottomRight')[0];
    var bottomLeft = group.get('.bottomLeft')[0];
    var image = group.get('.image')[0];

    var anchorX = activeAnchor.getX();
    var anchorY = activeAnchor.getY();

    // update anchor positions
    switch (activeAnchor.getName()) {
      case 'topLeft':
        topRight.setY(anchorY);
        bottomLeft.setX(anchorX);
        break;
      case 'topRight':
        topLeft.setY(anchorY);
        bottomRight.setX(anchorX);
        break;
      case 'bottomRight':
        bottomLeft.setY(anchorY);
        topRight.setX(anchorX); 
        break;
      case 'bottomLeft':
        bottomRight.setY(anchorY);
        topLeft.setX(anchorX); 
        break;
    }

    image.setPosition(topLeft.getPosition());

    var width = topRight.getX() - topLeft.getX();
    var height = bottomLeft.getY() - topLeft.getY();
    if(width && height) {
      image.setSize(width, height);
    }
  }
  function addAnchor(group, x, y, name) {
    var stage = group.getStage();
    var layer = group.getLayer();

    var anchor = new Kinetic.Circle({
      x: x,
      y: y,
      stroke: '#666',
      fill: '#ddd',
      strokeWidth: 2,
      radius: 8,
      name: name,
      draggable: true,
      dragOnTop: false
    });

    anchor.on('dragmove', function() {
      update(this);
      layer.draw();
    });
    anchor.on('mousedown touchstart', function() {
      group.setDraggable(false);
      this.moveToTop();
    });
    anchor.on('dragend', function() {
      group.setDraggable(true);
      layer.draw();
    });
    // add hover styling
    anchor.on('mouseover', function() {
      var layer = this.getLayer();
      document.body.style.cursor = 'pointer';
      this.setStrokeWidth(4);
      layer.draw();
    });
    anchor.on('mouseout', function() {
      var layer = this.getLayer();
      document.body.style.cursor = 'default';
      this.setStrokeWidth(2);
      layer.draw();
    });

    group.add(anchor);
  }
  function loadImages(sources, callback) {
    var images = {};
    var loadedImages = 0;
    var numImages = 0;
    for(var src in sources) {
      numImages++;
    }
    for(var src in sources) {
      images[src] = new Image();
      images[src].onload = function() {
        if(++loadedImages >= numImages) {
          callback(images);
        }
      };
      images[src].src = sources[src];
    }
  }
  function initStage(images) {
    var stage = new Kinetic.Stage({
      container: 'work_area',
      width: 578,
      height: 400
    });
    var darthVaderGroup = new Kinetic.Group({
      x: 270,
      y: 100,
      draggable: true
    });
    var yodaGroup = new Kinetic.Group({
      x: 100,
      y: 110,
      draggable: true
    });
    var layer = new Kinetic.Layer();

    
     * go ahead and add the groups
     * to the layer and the layer to the
     * stage so that the groups have knowledge
     * of its layer and stage
     
    layer.add(darthVaderGroup);
    layer.add(yodaGroup);
    stage.add(layer);

    // darth vader
    var darthVaderImg = new Kinetic.Image({
      x: 0,
      y: 0,
      image: images.darthVader,
      width: 200,
      height: 138,
      name: 'image'
    });

    darthVaderGroup.add(darthVaderImg);
    addAnchor(darthVaderGroup, 0, 0, 'topLeft');
    addAnchor(darthVaderGroup, 200, 0, 'topRight');
    addAnchor(darthVaderGroup, 200, 138, 'bottomRight');
    addAnchor(darthVaderGroup, 0, 138, 'bottomLeft');

    darthVaderGroup.on('dragstart', function() {
      this.moveToTop();
    });
    // yoda
    var yodaImg = new Kinetic.Image({
      x: 0,
      y: 0,
      image: images.yoda,
      width: 93,
      height: 104,
      name: 'image'
    });

    yodaGroup.add(yodaImg);
    addAnchor(yodaGroup, 0, 0, 'topLeft');
    addAnchor(yodaGroup, 93, 0, 'topRight');
    addAnchor(yodaGroup, 93, 104, 'bottomRight');
    addAnchor(yodaGroup, 0, 104, 'bottomLeft');

    yodaGroup.on('dragstart', function() {
      this.moveToTop();
    });

    stage.draw();
  }*/

//  var sources = {
//    darthVader: 'http://www.html5canvastutorials.com/demos/assets/darth-vader.jpg',
//    yoda: 'http://www.html5canvastutorials.com/demos/assets/yoda.jpg'
//  };
//  loadImages(sources, initStage);