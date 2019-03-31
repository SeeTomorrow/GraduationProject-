package com.dz.bestnew.mapper;

import com.dz.bestnew.po.NewsTitle;
import com.dz.bestnew.po.NewsTitleExample;
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