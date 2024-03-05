package d6g.win.resource.service.impl;

import d6g.win.resource.contants.StatusConstant;
import d6g.win.resource.contants.WebsiteStatus;
import d6g.win.resource.entity.OptionEntity;
import d6g.win.resource.mapper.OptionMapper;
import d6g.win.resource.service.IOptionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class IOptionServiceImpl implements IOptionService {


    Map<String, String> options = null;

    @Autowired
    private OptionMapper optionMapper;

    @PostConstruct
    private void initializeOptions() {
        allOptions(true);
    }

    @Override
    @Cacheable(cacheNames = "options", unless = "#noCache == true")
    public List<OptionEntity> allOptions(boolean noCache) {
        List<OptionEntity> options = optionMapper.selectList(null);
        this.options = new HashMap<String, String>();
        for (OptionEntity option: options) {
            this.options.put(option.getOptionName(), option.getOptionValue());
        }
        return options;
    }


    @Override
    public boolean isWebsiteMaintian() {
        return Objects.equals(this.options.get("website_status"), WebsiteStatus.Maintain.getStatus());
    }

    @Override
    public boolean isEnableRegister() {
        return Objects.equals(this.options.get("auth_enable_register"), StatusConstant.OPEN);
    }

    @Override
    public boolean isEnableCaptcha() {
        return Objects.equals(this.options.get("auth_enable_captcha"), StatusConstant.OPEN);
    }

    @Override
    public boolean isEnableActive() {
        return Objects.equals(this.options.get("auth_enable_active"), StatusConstant.OPEN);
    }

    @Override
    public String captchaType() {
        return this.options.get("auth_captcha_type");
    }
}
