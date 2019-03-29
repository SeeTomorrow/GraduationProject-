package com.dz.bestnew.mapper.generator;

import com.dz.bestnew.po.generator.UserSubscription;
import com.dz.bestnew.po.generator.UserSubscriptionExample;
import com.dz.bestnew.po.generator.UserSubscriptionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSubscriptionMapper {
    long countByExample(UserSubscriptionExample example);

    int deleteByExample(UserSubscriptionExample example);

    int deleteByPrimaryKey(UserSubscriptionKey key);

    int insert(UserSubscription record);

    int insertSelective(UserSubscription record);

    List<UserSubscription> selectByExample(UserSubscriptionExample example);

    UserSubscription selectByPrimaryKey(UserSubscriptionKey key);

    int updateByExampleSelective(@Param("record") UserSubscription record, @Param("example") UserSubscriptionExample example);

    int updateByExample(@Param("record") UserSubscription record, @Param("example") UserSubscriptionExample example);

    int updateByPrimaryKeySelective(UserSubscription record);

    int updateByPrimaryKey(UserSubscription record);
}