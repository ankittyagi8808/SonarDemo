package com.qrux.discussion.service;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrux.discussion.domain.Categories;
import com.qrux.discussion.domain.Group;
import com.qrux.discussion.repositories.CategoryRepository;
import com.qrux.discussion.response.CategoryDto;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

  
	@Autowired
	ModelMapper  modelMapper;
	 
	@Transactional
	public CategoryDto addNewCategory(final CategoryDto categoryDto) {
		Categories categories = new Categories();
		categories.setCatDescription(categoryDto.getCategoryDescription());
		Group group = new Group();
		group.setGroupId(categoryDto.getGroup().getGroupId());
		categories.setGroup(group);
		categoryRepository.save(categories);
		return categoryDto;
	}

	public CategoryDto addNewCategory(final String categoryDescription, final int groupId, final int userId) {
		Categories categories = new Categories();
		categories.setCatDescription(categoryDescription);
		categories.setCreatedBy(userId);
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		categories.setCreationDate(timeStamp);
		categories.setLastUpdateDate(timeStamp);
		Group group = new Group();
		group.setGroupId(groupId);
		categories.setGroup(group);
		categoryRepository.save(categories);
		return modelMapper.map(categories, CategoryDto.class);
		
	}
}
