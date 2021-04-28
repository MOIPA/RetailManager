package com.dql.retailmanager.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * null
 *
 * @TableName retail_order
 */
@Data
public class RetailOrder implements Serializable {
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

    private Integer accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table retail_order
     *
     * @mbg.generated 2021-04-28 15:07:31
     */
    private static final long serialVersionUID = 1L;
}