package com.xw.service.user.impl;

import com.xw.common.service.BaseService;
import com.xw.model.XwUser;
import com.xw.service.user.IUserService;
import com.xw.utils.PasswordHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class UserService extends BaseService<UserService, XwUser> implements IUserService {
    @Resource
    private PasswordHelper passwordHelper;

    @Override
    public XwUser createUser(XwUser user) {
        return null;
    }

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public void correlationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    @Override
    public XwUser findByUsername(String username) {
        logger.debug("查询用户{}", username);
        Example example = new Example(XwUser.class);
        example.createCriteria().andEqualTo("username", username);

        List<XwUser> list = mapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Set<String> findRoles(String username) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String username) {
        return null;
    }
}