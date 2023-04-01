package com.chatweb.mapper;

import com.chatweb.model.UserContent;
import com.chatweb.model.completion.chat.ChatMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserContentDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserContent record);

    int insertSelective(UserContent record);

    UserContent selectByPrimaryKey(Long id);

    List<UserContent> selectForUser(@Param("user") String user, @Param("size") int size);

    List<ChatMessage> selectMessageForUser(@Param("user") String user, @Param("size") int size, @Param("time") Date time);

    int updateByPrimaryKeySelective(UserContent record);

    int updateByPrimaryKey(UserContent record);
}