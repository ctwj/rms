package d6g.win.resource.utils;

import d6g.win.resource.contants.CodeEnum;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    public static JsonResponse HandleInvalidParameter (BindingResult result) {
        List<String> list = new ArrayList<String>();
        List<ObjectError> allErrors = result.getAllErrors();
        allErrors.forEach(item -> {
            list.add(item.getDefaultMessage());
        });
        return JsonResponse.error(list.toString(), CodeEnum.Error_Invalid_Parameter.getCode());
    }
}
