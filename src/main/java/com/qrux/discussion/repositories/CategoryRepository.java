package com.qrux.discussion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrux.discussion.domain.Categories;

public interface CategoryRepository extends JpaRepository<Categories,Integer>{

}
