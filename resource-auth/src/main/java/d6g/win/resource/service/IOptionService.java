package d6g.win.resource.service;


import d6g.win.resource.entity.OptionEntity;

import java.util.List;

/**
 *
 */
public interface IOptionService {

    /**
     * 获取所有配置项
     * @param noCache
     * @return List<OptionEntity>
     */
    public List<OptionEntity> allOptions(boolean noCache);


    /**
     * 判断网站是否正在维护
     * @return true 标示维护中
     */
    public boolean isWebsiteMaintian();


    /**
     * 判断网站是否开启注册
     * @return true 表示已开启
     */
    public boolean isEnableRegister();

    /**
     * 判断是否开启了验证码
     * @return true 表示开启
     */
    public boolean isEnableCaptcha();

    /**
     * 判断是否需要激活
     * @return true 表示需要激活
     */
    public  boolean isEnableActive();


    /**
     * 验证码类型
     * @return string’
     */
    public String captchaType();

}
