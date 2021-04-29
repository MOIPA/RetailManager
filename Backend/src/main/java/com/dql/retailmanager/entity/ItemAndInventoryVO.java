package com.dql.retailmanager.entity;

import lombok.Data;

@Data
public class ItemAndInventoryVO {
    private String id;
    private String name;
    private String desc;
    private String itemCode;
    private String price;
    private int inventory;
    private int safeNumber;
}
