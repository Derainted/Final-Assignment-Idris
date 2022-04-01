package com.grit.javawebservice.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

	@RequestMapping(path = "images", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public void img(HttpServletResponse response) throws IOException {

		var imgFile = new ClassPathResource("a.png");
		if (Math.random() < 0.5) {
			imgFile = new ClassPathResource("b.png");
		}
		if (Math.random() < 0.5) {
			imgFile = new ClassPathResource("c.png");
		}

		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

}
