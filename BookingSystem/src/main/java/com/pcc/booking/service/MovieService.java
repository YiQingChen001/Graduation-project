package com.pcc.booking.service;

import com.pcc.booking.entity.Movie;
import com.pcc.booking.error.BusinessException;

import java.util.List;


public interface MovieService {
    //添加电影
    void addMovie(Movie movie) throws BusinessException;
    //查看所有电影
    List<Movie> movieList();
    //根据电影名称得到电影详情
    Movie getMovie(String movieName) throws BusinessException;
    //得到票房最高的4部电影
    List<Movie> hotMovieList();
}
