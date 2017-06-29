package com.xw.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

public class XwSessionListener implements SessionListener {

    /**日志*/
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**注入sessionDao*/
    @Resource
    private JedisSessionDAO sessionDao;


    /***/
    @Override
    public void onStart(Session session) {
        // 会话创建时触发
        logger.info("PlsSessionListener session {} 被创建", session.getId());
    }

    @Override
    public void onStop(Session session) {
        sessionDao.delete(session);
        // 会话被停止时触发
        logger.info("PlsSessionListener session {} 被销毁", session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        sessionDao.delete(session);
        //会话过期时触发
        logger.info("PlsSessionListener session {} 过期", session.getId());
    }
}
