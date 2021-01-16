/**
 * 
 */
package com.iii.amirutham.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.service.DeleteMediaService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping("/deleteMedia")
public class DeleteMediaController {
	
	
	@Autowired
	private DeleteMediaService deleteMediaService;
	
	@Autowired
	private MessageSource messages;
	
	@DeleteMapping("/{id}/{page}")
	public ResponseEntity<GenericResponse> downloadFile(@PathVariable Integer id,@PathVariable String page, HttpServletRequest request) {
		// Load file as Resource
		
		if("HOME".equals(page)) 
				deleteMediaService.DeleteMediaHomeBanner(id);
		else if("CATEGORY".equals(page))
				deleteMediaService.DeleteMediaCategoryBanner(id);
		else if("PRODUCT".equals(page))
				deleteMediaService.DeleteMediaCategoryBanner(id);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
				.body(new GenericResponse(messages.getMessage("banner.message.detete.success", null, request.getLocale())));	

	}

}
