package com.dz.bestnew.utils.user;

import com.dz.bestnew.po.Extent;
import com.dz.bestnew.po.myPOJO.UserExtent;
import net.sf.json.JSONObject;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述:
 * 加密工具类
 *
 * @author 秃头的安娜
 * @create 2019-03-24 20:44
 */

@Component
public class UserUtils {


    //加密
    public static String encrypt(String password, String email){
        String hashAlgorithmName = "MD5";
        ByteSource salt = ByteSource.Util.bytes(email);//以账号作为盐值
        int hashIterations = 1024;//加密1024次
        return new SimpleHash(hashAlgorithmName,password,salt,hashIterations).toString();
    }

    /*
     * @Title: getUUID
     * @Description:
     *  id的算法：取当前时间单位毫秒的后31位与上用户邮箱
     * @date: 2019/3/25 16:49
     * @param: []
     * @return: int
     *
     */
    public static int getUUID(String email){
        int i = Math.toIntExact(System.currentTimeMillis() & Integer.MAX_VALUE);
        return i^(i>>16);
    }



    /*
     * @Title: getSecurity
     * @Description: 
     *  随机生成四位数验证码
     * @date: 2019/3/27 16:06
     * @param: []
     * @return: int
     *
     */
    public static int getSecurity(){
      return (int)((Math.random()*9+1)*1000);
    }
    

    /*
     * @Title: getDate
     * @Description:
     *  获取当前时间并格式化为 "yyyy-MM-dd HH:mm:ss" 格式
     * @date: 2019/3/27 16:09
     * @param: []
     * @return: java.lang.String
     *
     */
    public static String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
    
    
    public static JSONObject getJson(){
        return new JSONObject();
    }


    public static Set<String> getExtents(UserExtent userExtent){
        List<Extent> extents = userExtent.getExtents();
        if(extents.size()>0) {
            Set<String> extentsName = new HashSet<>();
            for (Extent extent : extents) {
                extentsName.add(extent.getExtentName());
            }
            return extentsName;
        }
        return null;
    }
}