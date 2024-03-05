package d6g.win.resource.service;


import d6g.win.resource.entity.UserEntity;

import java.util.List;


public interface IAuthService {


    /**
     * 注册用户, 返回对应的用户信息
     * @param user
     * @return
     */
    public boolean register(UserEntity user);

    /**
     * 创建一个默认的UserEntiy 并填充对应的数据
     * @param name
     * @param pass
     * @return
     */
    public UserEntity createNewUser(String name, String pass);

    public UserEntity createNewUser(String name, String pass, String email);

    /**
     * 更新用户基本信息
     * @param user
     * @return
     * @throws Exception
     */
    public boolean updateBaseInfo(UserEntity user);

    /**
     * 激活用户
     * @param userId
     * @param activationKey
     * @return
     */
    public boolean activationUser(Integer userId, String activationKey);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    public boolean changePassword(Integer userId, String password);

    /**
     * 封禁用户
     * @param userId
     * @return
     */
    public boolean disableUser(Integer userId);

    /**
     * 判断用户名是否已经存在
     * @param username 用户名
     * @return true 表示已经存在
     */
    public boolean isNameExists(String username);

    /**
     * 判读用户想象是否存在
     * @param email 邮箱地址
     * @return true 表示已经存在
     */
    public boolean isEmailExists(String email);

    /**
     * 判断手机号是否已经存在
     * @param phone
     * @return
     */
    public boolean isPhoneExists(String phone);

    public UserEntity login(String username, String pass);

    /**
     * 检测用户user_email 返回用户实例
     * @param email 邮箱
     * @param pass 密码
     * @return 用户实例
     */
    public List<UserEntity> loginUsername(String email, String pass);

    /**
     * 检测user_login登陆
     * @param email
     * @param pass
     * @return
     */
    public List<UserEntity> loginEmail(String email, String pass);

    /**
     * 检测 user_email 登陆
     * @param email
     * @param pass
     * @return
     */
    public List<UserEntity> loginPhone(String email, String pass);
}
