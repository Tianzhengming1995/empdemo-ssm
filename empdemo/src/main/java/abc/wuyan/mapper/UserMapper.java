package abc.wuyan.mapper;

import abc.wuyan.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    User findById(int id);

    public void insert(User items);

    public void update(User items);

    public void deleteById(int id);

    User findByNameAndPasswordAndGender(@Param("username") String username, @Param("password") String password, @Param("gender") String gender);

    List<User> findByAttendance(String attendance);
}
