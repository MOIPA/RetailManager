package com.dql.retailmanager.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * null
 *
 * @TableName purchase
 */
@Data
public class Purchase implements Serializable {
    /**
     * 供应商名称
     *
     * @mbg.generated 2021-04-27 14:58:45
     */
    private String supplier;

    /**
     * @mbg.generated 2021-04-27 14:58:45
     */
    private String ticketCode;

    /**
     * @mbg.generated 2021-04-27 14:58:45
     */
    private Integer itemId;

    /**
     * @mbg.generated 2021-04-27 14:58:45
     */
    private Integer userId;

    /**
     * @mbg.generated 2021-04-27 14:58:45
     */
    private Date ticketDate;

    /**
     * @mbg.generated 2021-04-27 14:58:45
     */
    private Double totalMoney;

    private Integer number;

    private Integer storageId;

    private Integer accountId;

    private Integer sellOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table purchase
     *
     * @mbg.generated 2021-04-27 14:58:45
     */
    private static final long serialVersionUID = 1L;
}