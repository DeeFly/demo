package com.gaofei.qlexpress;

import java.util.HashMap;
import java.util.Map;

import com.gaofei.SpringContextUtils;
import com.ql.util.express.IExpressContext;

/**
 * @author yichang
 * @date 2020/06/02
 */
public class ExpressSpringBeanContext extends HashMap<String, Object> implements IExpressContext<String, Object> {


    public ExpressSpringBeanContext(Map<String, Object> aProperties) {
        super(aProperties);
        initRunnerWithBizLogic();
    }

    /**
     * 根据key从容器里面获取对象
     *
     * @param key
     * @return
     */
    @Override
    public Object get(Object key) {
        Object object = super.get(key);
        try {
            if (object == null && SpringContextUtils.containsBean((String) key)) {
                object = SpringContextUtils.getBean((String) key);
            }
        } catch (Exception e) {
            throw new RuntimeException("表达式容器获取对象失败", e);
        }
        return object;
    }

    /**
     * 把key-value放到容器里面去
     *
     * @param key
     * @param value
     */
    @Override
    public Object put(String key, Object value) {
        return super.put(key, value);
    }

    public void initRunnerWithBizLogic() {
        //更多初始化的内容
    }

}
