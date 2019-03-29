package com.dz.bestnew.mapper.generator;

import com.dz.bestnew.po.generator.NewsType;
import com.dz.bestnew.po.generator.NewsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsTypeMapper {
    long countByExample(NewsTypeExample example);

    int deleteByExample(NewsTypeExample example);

    int deleteByPrimaryKey(Integer newsTypeId);

    int insert(NewsType record);

    int insertSelective(NewsType record);

    List<NewsType> selectByExample(NewsTypeExample example);

    NewsType selectByPrimaryKey(Integer newsTypeId);

    int updateByExampleSelective(@Param("record") NewsType record, @Param("example") NewsTypeExample example);

    int updateByExample(@Param("record") NewsType record, @Param("example") NewsTypeExample example);

    int updateByPrimaryKeySelective(NewsType record);

    int updateByPrimaryKey(NewsType record);
}