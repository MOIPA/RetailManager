package com.dql.retailmanager.service.socket;


import com.dql.retailmanager.entity.PushMessage;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/4/23 10:41
 */
public interface SocketIOService {

    //推送的事件
    public static final String PUSH_EVENT = "push_event";

    // 启动服务
    void start() throws Exception;

    // 停止服务
    void stop();

    // 推送信息
    void pushMessageToUser(PushMessage pushMessage);

}