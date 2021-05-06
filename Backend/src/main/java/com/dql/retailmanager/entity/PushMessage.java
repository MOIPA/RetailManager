package com.dql.retailmanager.entity;

import lombok.*;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PushMessage {

    // 登录用户编号
    private Integer loginUserNum;

    // 推送内容
    private String content;

    private List<ItemAndStorageInfo> itemLists;

}