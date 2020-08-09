package abc.wuyan.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
   public int findRoleIdByUserId(int user_id);

    void insertByUserId(@Param("user_id")int userId, @Param("role_id")int roleId);
}
