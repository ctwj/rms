package d6g.win.resource.controller.frontend;


import d6g.win.resource.entity.OptionEntity;
import d6g.win.resource.service.IOptionService;
import d6g.win.resource.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommonController {

    @Autowired
    IOptionService IOptionService;

    @GetMapping("/common/config")
    public JsonResponse config () {
        List<OptionEntity> list = IOptionService.allOptions(false);
        Map<String, String> optionsMap = new HashMap<>();
        for (OptionEntity option : list) {
            optionsMap.put(option.getOptionName(), option.getOptionValue());
        }
        return JsonResponse.data(optionsMap);
    }
}
