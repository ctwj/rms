package d6g.win.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import d6g.win.resource.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper extends BaseMapper<UserEntity> {

    public UserEntity selectUserById(Integer id);

    List<UserEntity> queryUserByUserId (Integer id);

    List<UserEntity> queryUserByEmail (String userEmail, String userPass);

    List<UserEntity> queryUserByName (String userName, String userPass);

    List<UserEntity> queryUserByPhone (String userPhone, String userPass);
}






