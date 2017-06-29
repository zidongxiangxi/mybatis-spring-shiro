package com.xw.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;

public class JedisSessionDAO extends AbstractSessionDAO implements SessionDAO {
    /**日志*/
    private Logger logger = LoggerFactory.getLogger(getClass());

//    /**获取session前缀*/
//    private String sessionKeyPrefix = PropertiesUtil.getProperties("shiro.session.redis.namespace");
//
//    /**获取缓存超时时间*/
//    private String expireTimeConfig = PropertiesUtil.getProperties("shiro.session.expireTime");

    /**进行转化后的时间*/
    private Long expireTime;

//    /**初始化参数*/
//    public JedisSessionDAO(){
//        try {
//            expireTime = new Long(expireTimeConfig);
//        } catch (NumberFormatException e) {
//            throw new UnknownSessionException("expireTime should be long type,"
//                    + "please define it in system.properties again ");
//        }
//    }

    /**
     * 创建
     * @param session session id 创建，使用默认java的uuid
     * */
    @Override
    public  Serializable doCreate(Session session) {
        Serializable sessionId = getSessionIdGenerator().generateId(session);
        this.assignSessionId(session, sessionId);
        this.update(session);
        return sessionId;
    }

    /**
     * 更新session
     *
     * */
    @Override
    public void update(Session session) throws UnknownSessionException {
        //校验session
        if (session == null || session.getId() == null) {
            throw new UnknownSessionException("session is null");
        }
//        JedisUtils.setSession(sessionKeyPrefix + session.getId(), session, expireTime);
        logger.debug("{} is updated", session.getId());
    }

    /**
     * 删除session对象
     * @param session session对象
     * */
    @Override
    public  void delete(Session session) {
//        JedisUtils.delSession(sessionKeyPrefix + session.getId());
    }

    /**
     * 获取session对象
     * @param sessionID  sessionID
     * */
    @Override
    public  Session doReadSession(Serializable sessionID) {
//        return (Session) JedisUtils.getSession(sessionKeyPrefix + sessionID);
        return null;
    }

    /**
     * 获取在线人数
     * */
    @Override
    public Collection<Session> getActiveSessions() {
//        return JedisUtils.getActiveSession(sessionKeyPrefix + "*");
        return null;
    }
}
