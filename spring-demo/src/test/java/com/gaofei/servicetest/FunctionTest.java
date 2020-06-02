package com.gaofei.servicetest;

import javax.annotation.Resource;

import com.gaofei.AbstractTest;
import com.gaofei.service.FunctionService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author yichang
 * @date 2020/06/02
 */
public class FunctionTest extends AbstractTest {
    @Resource
    private FunctionService functionService;

    @Test
    public void test_calculate() {
        String calculate = functionService.calculate(1);
        System.out.println(calculate);
        Assert.assertTrue("结果应该相同",  "1test".equals(calculate));
    }
}
