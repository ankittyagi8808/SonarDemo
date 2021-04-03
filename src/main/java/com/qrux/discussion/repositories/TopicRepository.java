package com.qrux.discussion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qrux.discussion.domain.Topic;


public interface TopicRepository  extends JpaRepository<Topic,Long>{
    
	@Query(value = "Select t from Topic t where t.status='A' order by lastUpdateDate DESC")
	List<Topic>  getAllActiveTopic();

	@Query(value = "select t from Topic t where t.status='A' and t.form.forumId= :formId order by lastUpdateDate desc")
	List<Topic> getAllTopicByForumId(@Param("formId") int formId);


	@Query(value = "Select t from Topic t where t.topicId= :topicId ")
	Topic  getTopicById(@Param("topicId") long topicId);
	
	@Modifying(flushAutomatically=true, clearAutomatically=true)
	@Query(value="update Topic t set t.noOfLikes=t.noOfLikes+1,t.lastUpdateDate=CURRENT_TIMESTAMP where t.topicId= :topicId")
	 void updateNoOfLikes(final long topicId);
	
	@Modifying(flushAutomatically=true, clearAutomatically=true)
	@Query(value="update Topic t set t.noOfComments=t.noOfComments+1,t.lastUpdateDate=CURRENT_TIMESTAMP where t.topicId= :topicId")
	 void updateNoOfComments(final long topicId);
	
	@Modifying(flushAutomatically=true, clearAutomatically=true)
	@Query(value="update Topic t set t.noOfViews=t.noOfViews+1,t.lastUpdateDate=CURRENT_TIMESTAMP where t.topicId= :topicId")
	 void updateNoOfViews(final long topicId);

}
