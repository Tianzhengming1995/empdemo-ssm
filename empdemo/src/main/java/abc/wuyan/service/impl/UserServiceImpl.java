package abc.wuyan.service.impl;

import abc.wuyan.mapper.UserMapper;
import abc.wuyan.model.User;
import abc.wuyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByNameAndPasswordAndGender(String username, String password, String gender) {
        return userMapper.findByNameAndPasswordAndGender(username,password,gender);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteById(id);
    }
}
