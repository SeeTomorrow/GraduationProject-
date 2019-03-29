package com.dz.bestnew.mapper;

import com.dz.bestnew.po.RoleExtent;
import com.dz.bestnew.po.RoleExtentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleExtentMapper {
    long countByExample(RoleExtentExample example);

    int deleteByExample(RoleExtentExample example);

    int deleteByPrimaryKey(Integer roleExtentId);

    int insert(RoleExtent record);

    int insertSelective(RoleExtent record);

    List<RoleExtent> selectByExample(RoleExtentExample example);

    RoleExtent selectByPrimaryKey(Integer roleExtentId);

    int updateByExampleSelective(@Param("record") RoleExtent record, @Param("example") RoleExtentExample example);

    int updateByExample(@Param("record") RoleExtent record, @Param("example") RoleExtentExample example);

    int updateByPrimaryKeySelective(RoleExtent record);

    int updateByPrimaryKey(RoleExtent record);
}