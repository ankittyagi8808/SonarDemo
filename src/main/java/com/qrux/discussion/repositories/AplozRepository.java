package com.qrux.discussion.repositories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qrux.discussion.domain.NotificationDto;
@Repository
public class AplozRepository {

	private static final Logger logger = LoggerFactory.getLogger(AplozRepository.class);
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	
	public List<NotificationDto> getNotifications(Long displayerId) {
		List<NotificationDto>	 report=null;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		String sql=	" select * from ViewNotifications where displayerId=:displayerId ";
			try {
				paramSource.addValue("displayerId",displayerId);
				 report=jdbcTemplate.query(sql, paramSource, new BeanPropertyRowMapper(NotificationDto.class));
			}catch (Exception e) {
				e.printStackTrace();
				logger.error("Unable to get Campaigns");
			}
		
		return report;
	}
	
	
}
