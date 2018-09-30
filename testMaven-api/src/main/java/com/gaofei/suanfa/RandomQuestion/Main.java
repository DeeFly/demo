package com.gaofei.suanfa.RandomQuestion;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by GaoQingming on 2018/8/24 0024.
 */
public class Main {
    private static List<Object> originQuestions = new ArrayList<>();

    public static void main(String[] args) {
        if (CollectionUtils.isEmpty(originQuestions)) {
            return;
        }
        List<Object> englishToChinese = buildEnglishToChines(originQuestions);
        //List<Object> chineseToEnglish = buildChineseToEnglish(originQuestions);
        //List<Object> voiceToEnglish = buildVoiceToEnglish(originQuestions);
    }

    private static List<Object> buildEnglishToChines(List<Object> originQuestions) {
        List<Object> result = new LinkedList<>();
        int length = originQuestions.size();
        Set<Integer> tempPostions = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < length; i += 3) {
            tempPostions.clear();
            tempPostions.add(i);
            Object question = new Object();//新建一个题目对象
            Object originQuestion = originQuestions.get(i);
            //把原题目中不变的东西设置到question中....

            //获取其他题目中
            for (int i1 = 0; i1 < 3; i1++) {
                int randomPostion;
                while (tempPostions.contains((randomPostion = random.nextInt(length))));
                tempPostions.add(randomPostion);
                originQuestions.get(randomPostion);
            }
            result.add(question);
        }
        return result;
    }
}
