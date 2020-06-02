package com.gaofei.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yichang
 * @date 2020/06/02
 */
@Service
@Slf4j
public class FunctionService {
    public String calculate(Integer value) {
        log.info("calculate param :{}", value);
        return value + "test";
    }
}
