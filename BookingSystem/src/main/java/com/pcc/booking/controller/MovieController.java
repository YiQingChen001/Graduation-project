package com.pcc.booking.controller;

import com.pcc.booking.entity.Movie;
import com.pcc.booking.error.BusinessException;
import com.pcc.booking.reponse.CommonReturnType;
import com.pcc.booking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;
    //添加电影
    @RequestMapping("/add_movie")
    public void add_movie(@RequestBody Movie movie) throws BusinessException {
        movieService.addMovie(movie);
    }
    //得到所有的电影
    @RequestMapping("/movies_list")
    public CommonReturnType movieList(){
        List<Movie> movies = movieService.movieList();
        return new CommonReturnType("success",movies);

    }
    //根据电影名称得到电影详情
    @GetMapping("/getdetail")
    public  CommonReturnType getDetail(@RequestParam("movieName") String movieName) throws BusinessException {
        Movie movie = movieService.getMovie(movieName);
        return new CommonReturnType("success",movie);
    }
    //得到票房最高的4部电影
    @RequestMapping("/get_hotmovie")
    public CommonReturnType getHotMovie(){
        List<Movie> movies = movieService.hotMovieList();
        return new CommonReturnType("success",movies);
    }


}
