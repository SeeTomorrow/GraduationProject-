package com.dz.bestnew.mapper.generator;

import com.dz.bestnew.po.generator.UserComment;
import com.dz.bestnew.po.generator.UserCommentExample;
import com.dz.bestnew.po.generator.UserCommentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCommentMapper {
    long countByExample(UserCommentExample example);

    int deleteByExample(UserCommentExample example);

    int deleteByPrimaryKey(UserCommentKey key);

    int insert(UserComment record);

    int insertSelective(UserComment record);

    List<UserComment> selectByExample(UserCommentExample example);

    UserComment selectByPrimaryKey(UserCommentKey key);

    int updateByExampleSelective(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    int updateByExample(@Param("record") UserComment record, @Param("example") UserCommentExample example);

    int updateByPrimaryKeySelective(UserComment record);

    int updateByPrimaryKey(UserComment record);
}