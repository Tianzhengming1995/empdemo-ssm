package abc.wuyan.service;

import abc.wuyan.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    User findByNameAndPasswordAndGender(String username,String password,String gender);
    public void insert(User items);

    public void update(User items);

    public void delete(int id);

    List<User> findByAttendance(String attendance);
}
