package com.pcc.booking.service.impl;

import com.pcc.booking.entity.Movie;
import com.pcc.booking.error.BusinessException;
import com.pcc.booking.error.EmBusinessError;
import com.pcc.booking.mapper.MovieMapper;
import com.pcc.booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Override
    public void addMovie(Movie movie) throws BusinessException {
        if(movie==null)throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"电影信息为空");
        if(movie.getMovieId()==null||
                movie.getMovieName()==null||
                movie.getMovieActors()==null||
                movie.getMovieDetail()==null||
                movie.getMovieBoxoffice()==null||
                movie.getMovieScore()==null||
                movie.getMoviePicture()==null||
                movie.getMovieType()==null||
                movie.getMovieDirector()==null||
                movie.getMovieDuration()==null||
                movie.getMovieReleasetime()==null
        )throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"电影信息不完整");
        movieMapper.insertSelective(movie);
    }

    @Override
    public List<Movie> movieList() {
        return movieMapper.movieList();
    }

    /**
     * 根据电影名称得到电影详情
     * @param movieName
     * @return 电影详情
     * @throws BusinessException
     */
    @Override
    public Movie getMovie(String movieName) throws BusinessException {
        Movie movie = movieMapper.selectByMovieName(movieName);
        if(movie==null)throw new BusinessException(EmBusinessError.MOIVE_NOT_EXIST);
        return movie;
    }

    /**
     * 得到所有正在上映电影
     * @return 电影列表
     */
    @Override
    public List<Movie> hotMovieList() {
        return movieMapper.hotMovieList();
    }
}
