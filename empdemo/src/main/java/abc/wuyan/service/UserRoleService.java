package abc.wuyan.service;

public interface UserRoleService {
    int findRoleIdByUserId(int user_id);

    void insertByUserId(int userId, int roleId);
}
