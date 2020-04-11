package com.school.message.web.mapper;

import com.school.message.web.pojo.EmailInfo;
import com.school.message.web.pojo.MessageInfo;
import com.school.message.web.pojo.SendUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SendServiceMapper {
    List<SendUser> getUser();
    List<MessageInfo> getMessage(@Param("from") long from,@Param("to") long to);

    void send( @Param("to") List<Long> to, @Param("from") Long from,@Param("messageId") Long messageId);

    List<EmailInfo> email();
}
