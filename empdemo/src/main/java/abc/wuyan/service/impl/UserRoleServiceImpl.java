package abc.wuyan.service.impl;

import abc.wuyan.mapper.UserRoleMapper;
import abc.wuyan.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    public int findRoleIdByUserId(int user_id) {
        return userRoleMapper.findRoleIdByUserId(user_id);
    }

    @Override
    public void insertByUserId(int userId, int roleId) {
        userRoleMapper.insertByUserId(userId,roleId);
    }

}
