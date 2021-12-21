package org.spoto.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.spoto.dto.UsersDto;
import org.spoto.model.Users;

import java.util.List;

public interface UsersMapper {
    //如果方法仅有一个参数，可以直接放在配置文件里面用parameterType指定
    /*
    当然也可以在接口外面指定：Integer add(@Param("user") Users user);
    配置文件里面不需要再指定parameterType，但是sql语句需要改为：
    <insert id="add">
        INSERT INTO users (username, password, nickname)
        VALUES (#{user.username}, #{user.password}, #{user.nickname})
    </insert>
     */
    Integer add(Users user);

    //如果方法有多个参数，要在接口外面用注解的方式指定
    Integer update(@Param("id") Integer id, @Param("username") String username, @Param("password") String password);

    Integer delete(@Param("id") Integer id);

    //Mybatis通过RowBounds实现分页
    List<Users> getList(RowBounds rowBounds, @Param("username") String username, @Param("password") String password, @Param("nickname") String nickname);

    //统计查询条目
    Integer getListCount(@Param("username") String username, @Param("password") String password, @Param("nickname") String nickname);

    //联表查询
    List<UsersDto> getUsersAndMoney();

    //批量删除，参数为数组，需要在xml里面for循环遍历数组
    Integer deletes(@Param("ids") List<Integer> ids);
}
