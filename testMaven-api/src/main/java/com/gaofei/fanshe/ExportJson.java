package com.gaofei.fanshe;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by GaoQingming on 2018/11/2 0002.
 */
public class ExportJson {
    public static void main(String[] args) throws URISyntaxException {
        //String objectJSONString = toJSONString("net.xuele.eduinfo.domain.StudentInfo");
        String objectJSONString = toJSONString("net.xuele.eduinfo.dto.StudentInfoDTO");
        //System.out.println(objectJSONString);
        String frameString = "{" + "\"errorMsg\": \"测试内容\"," + "\"status\": \"1\"," + "    \"wrapper\": []" + "}";
        frameString = frameString.replace("[]", objectJSONString);
        //frameString = frameString.replaceAll(",\"serialVersionUID.*0,?", "");
        System.out.println(frameString);
    }

    private static String toJSONString(String className) {
        Class classType = null;
        try {
            classType = ExportJson.class.getClassLoader().loadClass(className);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        return toJSONString(classType);
    }

    private static String toJSONString(Class classType) {
        StringBuilder stringBuilder = new StringBuilder("{");
        ReflectionUtils.doWithFields(classType, (Field field) -> {
            //内部类持有外部类，跳过
            if ("this$0".equals(field.getName())) {
                return;
            }
            stringBuilder.append("\"").append(field.getName()).append("\" : ");
            //TODO 没有处理单个引用 思路：判断是不是jdk工具类，不是的话就反射处理
            if (String.class.isAssignableFrom(field.getType())) {
                stringBuilder.append("\"\",");
            } else if (List.class.isAssignableFrom(field.getType())) {
                ParameterizedType type = (ParameterizedType) field.getGenericType();
                stringBuilder.append("[")
                        .append(toJSONString((Class)type.getActualTypeArguments()[0]))
                        .append("],");
            } else {
                stringBuilder.append("0,");
            }
        });
        if (",".equals(stringBuilder.charAt(stringBuilder.length()  - 1) + "")) {
            stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
