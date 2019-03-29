package com.dz.bestnew.mapper.generator;

import com.dz.bestnew.po.generator.UserShare;
import com.dz.bestnew.po.generator.UserShareExample;
import com.dz.bestnew.po.generator.UserShareKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShareMapper {
    long countByExample(UserShareExample example);

    int deleteByExample(UserShareExample example);

    int deleteByPrimaryKey(UserShareKey key);

    int insert(UserShare record);

    int insertSelective(UserShare record);

    List<UserShare> selectByExample(UserShareExample example);

    UserShare selectByPrimaryKey(UserShareKey key);

    int updateByExampleSelective(@Param("record") UserShare record, @Param("example") UserShareExample example);

    int updateByExample(@Param("record") UserShare record, @Param("example") UserShareExample example);

    int updateByPrimaryKeySelective(UserShare record);

    int updateByPrimaryKey(UserShare record);
}