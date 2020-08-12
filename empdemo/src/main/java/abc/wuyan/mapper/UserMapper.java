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

    List<User> findByGender(String gender);

    List<User> findByUserName(String username);

    List<User> findByGenderAndAttend(@Param("gender") String gender, @Param("attendance") String attendance);

    List<User> findByNameAndAttend(@Param("username") String username, @Param("attendance") String attendance);

    List<User> findByNameAndGender(@Param("username") String username, @Param("gender") String gender);

    List<User> findByNameAndGenderAndAttend(@Param("username") String username, @Param("gender") String gender,
                                            @Param("attendance") String attendance);
}
