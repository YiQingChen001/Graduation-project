package com.pcc.booking.service.impl;

import com.pcc.booking.entity.Collection;
import com.pcc.booking.entity.Movie;
import com.pcc.booking.mapper.CollectionMapper;
import com.pcc.booking.mapper.MovieMapper;
import com.pcc.booking.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Override
    @Transactional
    public void insertCollection(long userId, int movieId) {
        collectionMapper.insert(userId,movieId);
    }

    @Override
    @Transactional
    public void deleteCollection(long userId, int movieId) {
        collectionMapper.delete(userId,movieId);
    }

    @Override
    public List<Movie> collectionList(long userId) {
        List<Integer> list=collectionMapper.selectById(userId);
        List<Movie> movies=new ArrayList();
        for (Integer movieId : list) {
            Movie movie=movieMapper.selectByPrimaryKey(movieId);
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public boolean select(long userId, int movieId) {
        int count = collectionMapper.select(userId, movieId);

        if(count==0)return false;
        return true;
    }
}
