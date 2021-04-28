package com.dql.retailmanager.entity;

import lombok.Data;

@Data
public class PurchaseOrderVO {
    private String itemName;
    private String itemDesc;
    private String itemPrice;
    private int itemId;
    private String itemCode;

    private String storageName;
    private int storageId;
    private String storageDesc;

    private String userName;
    private String userPhone;
    private String userEmail;
    private int userId;

    private String ticketCode;
    private String ticketDate;
    private String totalMoney;

    private int accountId;
    private String accountName;
    private String accountCode;
}
