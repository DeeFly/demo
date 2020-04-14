package com.gaofei.Date;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Created by GaoQingming on 2018/1/19 0019.
 */
public class Main {
    public static void main(String[] args) throws ParseException, InvocationTargetException, IllegalAccessException {
        //String s = "{\"innerMonthsSalesGoalGmv_1_2020_03\":1600304.0,\"submitGroupedCargoBuyOrderPrice\":11.5,\"submitGroupedCargoGmvRatio\":8.75,"
        //    + "\"submitBondedBuyOrderPrice\":22.0,\"ind1Id\":999999105,\"confirmTargetGmv\":50801.0,\"submitTargetGmv\":2660.0,"
        //    + "\"submitGfcBuyOrderPrice\":14.0,\"ind2Id\":999999263,\"innerMonthsSalesGoalGmv_1_2020_04\":1600305.0,\"submitGfcQtyOrderPrice\":13"
        //    + ".25,\"confirmMonthsTargetGmv_1_2020_04\":1600303.0,\"innerSalesGoalGmv\":70402.0,\"sellerGiftQty\":36.5,"
        //    + "\"confirmMonthsTargetGmv_1_2020_03\":1600302.0,\"submitGfcGmvRatio\":10.75,\"submitBondedGmvRatio\":2.0,"
        //    + "\"submitBondedQtyOrderPrice\":15.0,\"submitDynamicTargetGmv_1_2020_03\":910.0,\"phTargetSellerNum\":4,"
        //    + "\"submitDynamicTargetGmv_1_2020_04\":1350.0,\"cate1Id\":0,\"submitSoldOutRatio\":8.25}";
        //
        //
        //Map<String, Object> map = JSON.parseObject(s, new TypeReference<HashMap<String, Object>> () {});
        //map.put("name", "gaofei");
        //map.put("age", 13.2);
        //Person person = new Person();
        //BeanUtils.populate(person, map);
        //System.out.println(JSON.toJSONString(person));


        IndustryRowOverviewDO industryRowOverviewDO = new IndustryRowOverviewDO();
        industryRowOverviewDO.setBondedBuyOrderPrice(123D);
        System.out.println(industryRowOverviewDO.getBondedBuyOrderPrice());
    }
}
