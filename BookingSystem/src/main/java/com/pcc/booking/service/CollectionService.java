package com.pcc.booking.service;

import com.pcc.booking.entity.Collection;
import com.pcc.booking.entity.Movie;

import java.util.List;

public interface CollectionService {

    void insertCollection(long userId,int movieId);

    void deleteCollection(long userId,int movieId);

    List<Movie> collectionList(long userId);

    boolean select(long userId, int movieId);
}
