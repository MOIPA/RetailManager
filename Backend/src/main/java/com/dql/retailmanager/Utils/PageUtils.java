package com.dql.retailmanager.Utils;

import com.dql.retailmanager.entity.page.PageRequest;
import com.dql.retailmanager.entity.page.PageResult;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setCount(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setData(pageInfo.getList());
        pageResult.setCode(0);
        return pageResult;
    }
}