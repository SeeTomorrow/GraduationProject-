package com.dz.bestnew.mapper;

import com.dz.bestnew.po.UserCollectionExample;
import com.dz.bestnew.po.UserCollectionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCollectionMapper {
    long countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

    int deleteByPrimaryKey(UserCollectionKey key);

    int insert(UserCollectionKey record);

    int insertSelective(UserCollectionKey record);

    List<UserCollectionKey> selectByExample(UserCollectionExample example);

    int updateByExampleSelective(@Param("record") UserCollectionKey record, @Param("example") UserCollectionExample example);

    int updateByExample(@Param("record") UserCollectionKey record, @Param("example") UserCollectionExample example);
}