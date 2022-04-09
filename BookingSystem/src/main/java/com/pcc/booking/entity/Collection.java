package com.pcc.booking.entity;


import lombok.Data;

@Data
public class Collection {
    private Integer collectionId;
    private long userId;
    private Integer movieId;
}
