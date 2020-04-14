package com.gaofei.batch;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author qingming.gqm
 * @date 2020/3/12
 */
public class BatchOperations {
    public static final int BATCH_INSERT_COUNT = 10;

    /**
     * 根据一个长list，分批次做某种行为
     * 最终list中所有的数据都会执行这种行为
     * @param list
     * @param insertor
     * @param <T>
     * @return
     */
    private <T> Boolean batchOperate(List<T> list, Function<List<T>, Boolean> insertor) {
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }
        int startPos = 0;
        int endPos = 100;
        do {
            List<T> tempList = list.subList(startPos, Math.min(endPos, list.size()));
            boolean insertResult = insertor.apply(tempList);
            if (!insertResult) {
                return insertResult;
            }
            startPos += BATCH_INSERT_COUNT;
            endPos += BATCH_INSERT_COUNT;
        } while (endPos - BATCH_INSERT_COUNT < list.size() );
        return true;
    }
}
