package com.dql.retailmanager.entity;

import lombok.Data;

@Data
public class ItemAndStorageInfo {
    private String name;
    private String desc;
    private String itemCode;
    private int number;
    private int safeNumber;
    private int itemId;
}
