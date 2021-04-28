package com.dql.retailmanager.entity;

import lombok.Data;

import java.util.Date;

@Data
public class RetailOrderVO {
    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private String retailCode;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private Integer memberId;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private Integer userId;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private String remark;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private Integer itemId;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private Integer storageId;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private Integer itemNumber;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private Double money;

    /**
     * @mbg.generated 2021-04-28 15:07:31
     */
    private Date tradeTime;

    private String memberNumber;

    private String userName;

    private String itemName;

    private String itemCode;

    private String price;

    private String storageName;

    private String accountCode;

    private String bankName;

}
