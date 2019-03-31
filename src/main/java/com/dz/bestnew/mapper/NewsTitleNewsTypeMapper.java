package com.dz.bestnew.mapper;

import com.dz.bestnew.po.NewsTitleNewsTypeExample;
import com.dz.bestnew.po.NewsTitleNewsTypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsTitleNewsTypeMapper {
    long countByExample(NewsTitleNewsTypeExample example);

    int deleteByExample(NewsTitleNewsTypeExample example);

    int deleteByPrimaryKey(NewsTitleNewsTypeKey key);

    int insert(NewsTitleNewsTypeKey record);

    int insertSelective(NewsTitleNewsTypeKey record);

    List<NewsTitleNewsTypeKey> selectByExample(NewsTitleNewsTypeExample example);

    int updateByExampleSelective(@Param("record") NewsTitleNewsTypeKey record, @Param("example") NewsTitleNewsTypeExample example);

    int updateByExample(@Param("record") NewsTitleNewsTypeKey record, @Param("example") NewsTitleNewsTypeExample example);
}