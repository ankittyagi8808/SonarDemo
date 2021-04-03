package com.qrux.discussion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qrux.discussion.domain.Group;

public interface GroupRepository  extends JpaRepository<Group,Long> {

	
}
