package com.dql.retailmanager.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ItemAndStorageInfo {
    /**
     * item name
     */
    private String name;
    private String desc;
    private String itemCode;
    private int number;
    private int safeNumber;
    private int itemId;
    private Date updateTime;
}
