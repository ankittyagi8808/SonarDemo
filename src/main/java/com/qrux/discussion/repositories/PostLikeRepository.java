package com.qrux.discussion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qrux.discussion.domain.PostLike;

public interface PostLikeRepository extends JpaRepository<PostLike,Long> {
	
	@Query(value = "select p from PostLike p where  p.topicId= :topicId and p.userId= :userId")
	List<PostLike> getCommentLikesUserIdAndTopicID(@Param("topicId") long topicId, @Param("userId") long userId);
	
	@Query(value = "select p from PostLike p where p.postId= :postId and p.userId= :userId")
	PostLike getCommentLikes(@Param("postId")long postId, @Param("userId") long userId);



}
