package abc.wuyan.service.impl;

import abc.wuyan.mapper.RoleMapper;
import abc.wuyan.model.Role;
import abc.wuyan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findById(int role_id) {
        return roleMapper.findById(role_id);
    }
}
