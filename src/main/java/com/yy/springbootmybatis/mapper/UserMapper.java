package com.yy.springbootmybatis.mapper;

import com.yy.springbootmybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from tb_user")
    List<User> getAllUsers();

//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "username", column = "u"),
//            @Result(property = "address", column = "a")
//    })
    @Select("select id,username as userName,password,birthday,createtime as createTime from tb_user where id=#{id}")
    User getUserById(Long id);

    @Select("select id,username as userName,password,birthday,createtime as createTime from tb_user where username like concat('%',#{name},'%')")
    List<User> getUsersByName(String name);

    @Insert({"insert into tb_user(username,password,birthday,createtime) values(#{userName},#{password},#{birthday},#{createTime})"})
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer addUser(User user);

    @Update("update tb_user set username=#{userName},password=#{password},birthday=#{birthday},createtime=#{createTime} where id=#{id}")
    Integer updateUserById(User user);

    @Delete("delete from tb_user where id=#{id}")
    Integer deleteUserById(Integer id);
}
