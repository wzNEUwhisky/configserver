package edu.neu.springcloud.provider_1.repository;

import edu.neu.springcloud.provider_1.bean.TbUser;
import edu.neu.springcloud.provider_1.bean.TbUserExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TbUserMapper {
    int countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    @Delete({
        "delete from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tb_user (id, login_name, ",
        "username, password)",
        "values (#{id,jdbcType=INTEGER}, #{loginName,jdbcType=VARCHAR}, ",
        "#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR})"
    })
    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    @Select({
        "select",
        "id, login_name, username, password",
        "from tb_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    TbUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    @Update({
        "update tb_user",
        "set login_name = #{loginName,jdbcType=VARCHAR},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TbUser record);
}