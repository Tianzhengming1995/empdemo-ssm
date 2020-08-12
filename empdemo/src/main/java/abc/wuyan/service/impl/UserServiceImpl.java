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
        return userMapper.findByNameAndPasswordAndGender(username, password, gender);
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

    @Override
    public List<User> findByAttendance(String attendance) {
        return userMapper.findByAttendance(attendance
        );
    }

    @Override
    public List<User> findByGender(String gender) {
        return userMapper.findByGender(gender);
    }

    @Override
    public List<User> findByName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public List<User> findByGenderAndAttend(String gender, String attendance) {
        return userMapper.findByGenderAndAttend(gender,attendance);
    }

    @Override
    public List<User> findByNameAndAttend(String username, String attendance) {
        return userMapper.findByNameAndAttend(username,attendance);
    }

    @Override
    public List<User> findByNameAndGender(String username, String gender) {
        return userMapper.findByNameAndGender(username,gender);
    }

    @Override
    public List<User> findByNameAndGenderAndAttend(String username, String gender, String attendance) {
        return userMapper.findByNameAndGenderAndAttend(username,gender,attendance);
    }
}
