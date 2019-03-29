package com.dz.bestnew.mapper.generator;

import com.dz.bestnew.po.generator.RoleExtentExample;
import com.dz.bestnew.po.generator.RoleExtentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleExtentMapper {
    long countByExample(RoleExtentExample example);

    int deleteByExample(RoleExtentExample example);

    int deleteByPrimaryKey(RoleExtentKey key);

    int insert(RoleExtentKey record);

    int insertSelective(RoleExtentKey record);

    List<RoleExtentKey> selectByExample(RoleExtentExample example);

    int updateByExampleSelective(@Param("record") RoleExtentKey record, @Param("example") RoleExtentExample example);

    int updateByExample(@Param("record") RoleExtentKey record, @Param("example") RoleExtentExample example);
}