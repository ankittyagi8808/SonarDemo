package com.qrux.discussion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qrux.discussion.domain.Post;

public interface PostRepository extends JpaRepository<Post,Integer>  {

	@Query(value = "select p from Post p where p.topic.topicId= :topicId order by p.lastUpdatedDate desc")
	List<Post> getAllPostByTopicId(@Param("topicId") long topicId);
	
	@Modifying(flushAutomatically=true,clearAutomatically=true)
	@Query(value = "Update Post p set p.postDescription= :postDescription,p.lastUpdatedDate=CURRENT_TIMESTAMP where p.postId= :postId")
     void updatePost(@Param("postId") int postId,@Param("postDescription") String postDescription);

	@Modifying(flushAutomatically=true, clearAutomatically=true)
	@Query(value="update Post p set p.noOflikes=p.noOflikes+1,p.lastUpdatedDate=CURRENT_TIMESTAMP where p.postId= :postId")
	 void updateNoOfLikes(@Param("postId") final int postId);
	
	@Modifying(flushAutomatically=true, clearAutomatically=true)
	@Query(value="update Post p set p.noOflikes=p.noOflikes-1,p.lastUpdatedDate=CURRENT_TIMESTAMP where p.postId= :postId")
	 void decrementNoOfLikes(@Param("postId") final int postId);


}
