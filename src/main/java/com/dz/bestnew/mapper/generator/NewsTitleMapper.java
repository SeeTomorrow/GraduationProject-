package com.dz.bestnew.mapper.generator;

import com.dz.bestnew.po.generator.NewsTitle;
import com.dz.bestnew.po.generator.NewsTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsTitleMapper {
    long countByExample(NewsTitleExample example);

    int deleteByExample(NewsTitleExample example);

    int deleteByPrimaryKey(Integer newsTitleId);

    int insert(NewsTitle record);

    int insertSelective(NewsTitle record);

    List<NewsTitle> selectByExample(NewsTitleExample example);

    NewsTitle selectByPrimaryKey(Integer newsTitleId);

    int updateByExampleSelective(@Param("record") NewsTitle record, @Param("example") NewsTitleExample example);

    int updateByExample(@Param("record") NewsTitle record, @Param("example") NewsTitleExample example);

    int updateByPrimaryKeySelective(NewsTitle record);

    int updateByPrimaryKey(NewsTitle record);
}