package com.dql.retailmanager.entity.page;

import lombok.Data;

/**
 * 分页请求
 */
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int page;
    /**
     * 每页数量
     */
    private int limit;

}
