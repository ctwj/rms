package d6g.win.resource.utils;

import d6g.win.resource.contants.CodeEnum;
import lombok.Data;
import org.aspectj.apache.bcel.classfile.Code;

@Data
public class JsonResponse {

    private Integer code;
    private String msg;
    private Object data;

    public JsonResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static JsonResponse success(String msg) {
        return new JsonResponse(0, msg, null);
    }

    public static JsonResponse success() {
        return new JsonResponse(0, "", null);
    }

    public static JsonResponse data(Object data) {
        return new JsonResponse(0, "", data);
    }

    public static JsonResponse error(String msg, Integer code) {
        return new JsonResponse(code, msg, null);
    }

    public static JsonResponse error(String msg) {
        return new JsonResponse(CodeEnum.Error.getCode(), msg, null);
    }

    public static JsonResponse error(CodeEnum error) {
        return new JsonResponse(error.getCode(), error.getComment(), null);
    }

    public static JsonResponse error(String msg, Object data) {
        return new JsonResponse(CodeEnum.Error.getCode(), msg, data);
    }
}