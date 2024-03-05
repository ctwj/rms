package d6g.win.resource.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import d6g.win.resource.contants.MetaConstant;
import d6g.win.resource.entity.UserEntity;
import d6g.win.resource.entity.UserMetaEntity;
import d6g.win.resource.mapper.UserMetaMapper;
import d6g.win.resource.mapper.UsersMapper;
import d6g.win.resource.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class IAuthServiceImpl implements IAuthService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    UserMetaMapper userMetaMapper;


    @Override
    @Transactional
    public boolean register(UserEntity user) {
        try {
            // 插入用户信息
            int result = usersMapper.insert(user);

            // 插入用户元数据信息
            List<UserMetaEntity> metas = user.getMetaEntities();
            metas.forEach(meta -> {
                System.out.println(meta);
                meta.setUserId(user.getId());
                int metaResult = userMetaMapper.insert(meta);
                if (metaResult != 1) {
                    throw new RuntimeException("Failed to insert user meta");
                }
            });

            // 提交事务
            return result == 1;
        } catch (Exception e) {
            // 回滚事务
            throw new RuntimeException("Failed to register user", e);
        }
    }

    // 添加一个普通权限的role到meta 中
    private void addUserMetas(UserEntity user) {
        // 添加默认角色
        List<UserMetaEntity> list = new ArrayList<UserMetaEntity>();
        UserMetaEntity role = new UserMetaEntity();
        role.setMetaKey(MetaConstant.UserMetaRole);
        role.setMetaValue(MetaConstant.MetaRoleUser);
        role.setUserId(user.getId());
        list.add(role);
        user.setMetaEntities(list);
    }

    @Override
    public UserEntity createNewUser(String name, String pass) {
        UserEntity user = new UserEntity();
        user.setUserLogin(name);
        user.setUserPass(pass);
        addUserMetas(user);
        return user;
    }

    @Override
    public UserEntity createNewUser(String name, String pass, String email) {
        UserEntity user = this.createNewUser(name, pass);
        user.setUserEmail(email);
        addUserMetas(user);
        return user;
    }

    @Override
    public boolean updateBaseInfo(UserEntity user) {
        return false;
    }

    @Override
    public boolean activationUser(Integer userId, String activationKey) {
        return false;
    }

    @Override
    public boolean changePassword(Integer userId, String password) {
        return false;
    }

    @Override
    public boolean disableUser(Integer userId) {
        return false;
    }

    @Override
    public boolean isNameExists(String username) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_login", username);
        return usersMapper.exists(wrapper);
    }

    @Override
    public boolean isEmailExists(String email) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_email", email);
        return usersMapper.exists(wrapper);
    }

    @Override
    public boolean isPhoneExists(String phone) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_phone", phone);
        return usersMapper.exists(wrapper);
    }

    @Override
    public UserEntity login(String username, String pass) {
        List<UserEntity> users = null;
        System.out.println(username + pass);
        if (Validator.isEmail(username)) {
            users = this.loginEmail(username, pass);
        } else if (Validator.isMobile(username)) {
            users = this.loginPhone(username, pass);
        } else {
            users = this.loginUsername(username, pass);
        }
        if (users != null) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public List<UserEntity> loginUsername(String username, String pass) {
        return usersMapper.queryUserByName(username, pass);
    }

    @Override
    public List<UserEntity> loginEmail(String email, String pass) {
        return usersMapper.queryUserByEmail(email, pass);
    }

    @Override
    public List<UserEntity> loginPhone(String phone, String pass) {
        return usersMapper.queryUserByPhone(phone, pass);
    }
}
