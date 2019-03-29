package com.dz.bestnew.mapper;

import com.dz.bestnew.po.Extent;
import com.dz.bestnew.po.ExtentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtentMapper {
    long countByExample(ExtentExample example);

    int deleteByExample(ExtentExample example);

    int deleteByPrimaryKey(Integer extentId);

    int insert(Extent record);

    int insertSelective(Extent record);

    List<Extent> selectByExample(ExtentExample example);

    Extent selectByPrimaryKey(Integer extentId);

    int updateByExampleSelective(@Param("record") Extent record, @Param("example") ExtentExample example);

    int updateByExample(@Param("record") Extent record, @Param("example") ExtentExample example);

    int updateByPrimaryKeySelective(Extent record);

    int updateByPrimaryKey(Extent record);
}