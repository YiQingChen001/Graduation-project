package com.pcc.booking.mapper;

import com.pcc.booking.entity.Movie;

import java.util.List;

public interface MovieMapper {
    int deleteByPrimaryKey(Integer movieId);

    int insert(Movie record);

    int insertSelective(Movie record);

    Movie selectByPrimaryKey(Integer movieId);

    int updateByPrimaryKeySelective(Movie record);

    int updateByPrimaryKey(Movie record);

    Movie selectByMovieName(String movieName);

    List<Movie> movieList();

    List<Movie> hotMovieList();
}