package com.schedulercommon.dao;

import com.schedulercommon.model.EmailInfo;
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