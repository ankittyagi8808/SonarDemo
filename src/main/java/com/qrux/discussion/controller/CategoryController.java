package com.qrux.discussion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrux.discussion.request.CategoryRequest;
import com.qrux.discussion.response.CategoryDto;
import com.qrux.discussion.service.CategoryService;
import com.qrux.discussion.service.UserService;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	UserService userService;
        // this is a new branch and original commit and check
	@PostMapping(value="/addCategory",consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryRequest categoryRequest) {
		return new ResponseEntity<CategoryDto>(
				categoryService.addNewCategory(categoryRequest.getCategoryDescription(), categoryRequest.getGroupId(),userService.giveUserId()),
				HttpStatus.OK);

	}
}
