package com.dz.bestnew.mapper.generator;

import com.dz.bestnew.po.generator.NewsContext;
import com.dz.bestnew.po.generator.NewsContextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsContextMapper {
    long countByExample(NewsContextExample example);

    int deleteByExample(NewsContextExample example);

    int deleteByPrimaryKey(Integer newsContextId);

    int insert(NewsContext record);

    int insertSelective(NewsContext record);

    List<NewsContext> selectByExampleWithBLOBs(NewsContextExample example);

    List<NewsContext> selectByExample(NewsContextExample example);

    NewsContext selectByPrimaryKey(Integer newsContextId);

    int updateByExampleSelective(@Param("record") NewsContext record, @Param("example") NewsContextExample example);

    int updateByExampleWithBLOBs(@Param("record") NewsContext record, @Param("example") NewsContextExample example);

    int updateByExample(@Param("record") NewsContext record, @Param("example") NewsContextExample example);

    int updateByPrimaryKeySelective(NewsContext record);

    int updateByPrimaryKeyWithBLOBs(NewsContext record);

    int updateByPrimaryKey(NewsContext record);
}