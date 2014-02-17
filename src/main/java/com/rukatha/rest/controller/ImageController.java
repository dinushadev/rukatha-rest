package com.rukatha.rest.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.OutputSettings;
import com.google.appengine.api.images.Transform;
import com.rukatha.rest.dto.ImageReqDto;



@Controller
@RequestMapping("/image")
public class ImageController {

	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String uploadImage(@RequestBody ImageReqDto image){
		
		
		 // 1. get received JSON data from request
/*	       BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
	       String json = null;
	       if(br != null){
	           json = br.readLine();
	       }
	       
	       Gson gson = new Gson();

	       @SuppressWarnings("unchecked")
			HashMap<String, String> jsonImgObject = gson.fromJson(json, HashMap.class);
	       
	       String imageAsURL = jsonImgObject.get("img");*/
//	       System.out.println(imageAsURL);
//	       System.out.println(imageAsURL.split("base64,")[0]);
//	       System.out.println(imageAsURL.split("base64,")[1]);
//	       String headOfImg = imageAsURL.split(",")[0];
	       String base64Str = image.getImg().split("base64,")[1];
	       
	       
	       byte[] originalImgBA = DatatypeConverter.parseBase64Binary(base64Str); 
//	       ByteArrayInputStream is = new ByteArrayInputStream(buf);
//	       
//	       BufferedImage bim = ImageIO.read(originalImgBA);
//	       System.out.println(is);
//			response.setContentType("application/json");
//			response.getWriter().println(result);
	       
	       //I am using GAE image transformations to manipulate the image. Might need to change to make the app portable.
	       
	       ImagesService imagesService = ImagesServiceFactory.getImagesService();

	       Image originalImg = ImagesServiceFactory.makeImage(originalImgBA);
//	       Transform resize = ImagesServiceFactory.makeResize(1024,768);
//	       Transform resize = ImagesServiceFactory.makeResize(1000,600);
//	       BufferedImage thumbnail = Scalr.resize(originalImg, 150);
	       
//	    compress & resize it
	       OutputSettings settings = new OutputSettings(ImagesService.OutputEncoding.JPEG);
	       settings.setQuality(100);
	       Transform resize = ImagesServiceFactory.makeResize(1100,700);

	       Image newImage = imagesService.applyTransform(resize, originalImg, settings);
	       
	       byte[] newImageData = newImage.getImageData();
	       String newImgFormat = newImage.getFormat().toString().toLowerCase(); 
	       System.out.println(newImgFormat);
	       System.out.println(newImage.getHeight()+","+newImage.getWidth());
	       
//	       String newB64ImgTail = Base64.encodeBase64URLSafeString(newImageData);
	       
	       String newB64ImgTail = DatatypeConverter.printBase64Binary(newImageData);
	       
//	       System.out.println(headOfImg+","+newB64ImgTail);
	       
	       String headOfImg = "data:image/"+newImgFormat+";base64";
	       System.out.println(headOfImg);
	       
	       String newB64Img = headOfImg+","+newB64ImgTail;
	       
//	       String newImgJson = "{\"imgResult\":\""+newB64Img+"\"}";
	       String newImgJson = "{\"imgResult\":\""+newB64Img+"\"}";
	       
	       return newImgJson;
	}
}
