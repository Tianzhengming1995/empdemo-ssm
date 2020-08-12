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

    List<User> findByGender(String gender);

    List<User> findByName(String username);

    List<User> findByGenderAndAttend(String gender, String attendance);

    List<User> findByNameAndAttend(String username, String attendance);

    List<User> findByNameAndGender(String username, String gender);

    List<User> findByNameAndGenderAndAttend(String username, String gender, String attendance);
}
