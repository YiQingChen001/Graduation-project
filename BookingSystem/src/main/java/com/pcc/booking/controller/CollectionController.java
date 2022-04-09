package com.pcc.booking.controller;


import com.pcc.booking.entity.Collection;
import com.pcc.booking.entity.Movie;
import com.pcc.booking.reponse.CommonReturnType;
import com.pcc.booking.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;


    @RequestMapping("collectionList")
    public CommonReturnType collectionList(@RequestParam("userId") Long userId){
        List<Movie> movies=collectionService.collectionList(userId);
        return new CommonReturnType("success",movies);
    }

    @RequestMapping("/insert")
    public CommonReturnType insertCollection(@RequestParam("userId") Long userId,
                                             @RequestParam("movieId") Integer movieId){

        collectionService.insertCollection(userId,movieId);
        return new CommonReturnType("success",null);
    }

    @RequestMapping("/delete")
    public CommonReturnType deleteCollection(@RequestParam("userId") Long userId,
                                             @RequestParam("movieId") Integer movieId){

        collectionService.deleteCollection(userId,movieId);
        return new CommonReturnType("success",null);
    }

    @RequestMapping("/is_collection")
    public CommonReturnType isCollection(@RequestParam("userId") Long userId,
                                         @RequestParam("movieId") Integer movieId){

        boolean flag = collectionService.select(userId, movieId);

        if(flag)return new CommonReturnType("success",1);
        else return new CommonReturnType("success",0);
    }


}
