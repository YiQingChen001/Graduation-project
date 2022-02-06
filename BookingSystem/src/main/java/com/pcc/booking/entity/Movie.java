package com.pcc.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Movie {
    private Integer movieId;

    private String movieName;

    private String movieActors;

    private String movieDirector;

    private String movieDetail;

    private String movieDuration;

    private String movieType;

    private Float movieScore;

    private Float movieBoxoffice;

    private String moviePicture;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date movieReleasetime;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(String movieActors) {
        this.movieActors = movieActors;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieDetail() {
        return movieDetail;
    }

    public void setMovieDetail(String movieDetail) {
        this.movieDetail = movieDetail;
    }

    public String getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(String movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Float getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(Float movieScore) {
        this.movieScore = movieScore;
    }

    public Float getMovieBoxoffice() {
        return movieBoxoffice;
    }

    public void setMovieBoxoffice(Float movieBoxoffice) {
        this.movieBoxoffice = movieBoxoffice;
    }

    public String getMoviePicture() {
        return moviePicture;
    }

    public void setMoviePicture(String moviePicture) {
        this.moviePicture = moviePicture;
    }

    public Date getMovieReleasetime() {
        return movieReleasetime;
    }

    public void setMovieReleasetime(Date movieReleasetime) {
        this.movieReleasetime = movieReleasetime;
    }
}