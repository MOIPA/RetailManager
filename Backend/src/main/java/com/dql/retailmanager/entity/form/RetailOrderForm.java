package com.dql.retailmanager.entity.form;

import lombok.Data;

@Data
public class RetailOrderForm {
    private int itemId;
    private int storageId;
    private int memberId;
    private String remark;
    private int itemNumber;
    private double money;

    private int userId;

    private String retailCode;
}
