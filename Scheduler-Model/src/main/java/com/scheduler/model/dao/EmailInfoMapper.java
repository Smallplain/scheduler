package com.scheduler.model.dao;

import com.scheduler.model.model.EmailInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailInfoMapper {
    int deleteByPrimaryKey(Integer emailId);

    int insert(EmailInfo record);

    int insertSelective(EmailInfo record);

    EmailInfo selectByPrimaryKey(Integer emailId);

    int updateByPrimaryKeySelective(EmailInfo record);

    int updateByPrimaryKey(EmailInfo record);
}