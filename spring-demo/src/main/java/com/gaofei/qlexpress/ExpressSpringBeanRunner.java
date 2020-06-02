package com.gaofei.qlexpress;

import java.util.Map;

import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author yichang
 * @date 2020/06/02
 */
@Component
@Slf4j
public class ExpressSpringBeanRunner implements InitializingBean {

    private ExpressRunner runner;

    public Object executeExpress(String text, Map<String, Object> context) {
        IExpressContext<String, Object> expressContext = new ExpressSpringBeanContext(context);
        try {
            return runner.execute(text, expressContext, null, true, false);
        } catch (Exception e) {
            log.error("qlExpress运行出错！", e);
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        runner = new ExpressRunner();
    }
}

