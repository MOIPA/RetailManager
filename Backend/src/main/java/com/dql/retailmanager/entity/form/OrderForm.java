package com.dql.retailmanager.entity.form;

import lombok.Data;

@Data
public class OrderForm {
    private int itemId;
    private int storageId;
    private String supplier;
    private int number;
    private int sellOrder;

    // default value
//    private int accountId;
    private int userId;

    private String ticketCode;
    private float totalPrice;
}
