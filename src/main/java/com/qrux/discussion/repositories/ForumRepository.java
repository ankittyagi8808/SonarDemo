package com.qrux.discussion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrux.discussion.domain.Forum;

public interface ForumRepository extends  JpaRepository<Forum,Integer>{
	

}
