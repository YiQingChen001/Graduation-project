package com.pcc.booking.mapper;

import com.pcc.booking.entity.Collection;
import com.pcc.booking.entity.Movie;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectionMapper {
    @Delete("delete from collection where user_id=#{userId} and movie_id=#{movieId}")
    int delete(@Param("userId") Long userId,@Param("movieId") Integer movieId);

    @Insert("insert into collection (user_id,movie_id) values(#{userId},#{movieId})")
    int insert(@Param("userId") Long userId,@Param("movieId") Integer movieId);


    @Select("select movie_id from collection where user_id=#{userId}")
    List<Integer> selectById(Long userId);

    @Select("select count(*) from collection where user_id=#{userId} and movie_id=#{movieId}")
    int select(@Param("userId") Long userId, @Param("movieId") Integer movieId);
}
