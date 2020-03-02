package com.gaofei.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author qingming.gqm
 * @date 2020/1/3
 */
public class WriteLog {
    /**
     * 写日志
     *
     * @param list
     */
    private void writeLog(List list, String ds, String selectionId, String logDirectory) {
        File fileDirectory = new File(logDirectory);
        if (!fileDirectory.exists()) {
            fileDirectory.mkdirs();
        }
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            File file = new File(logDirectory + "CalculateResult_" + ds + "_" + selectionId + ".txt");
            if (file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            for (int i = 0; i < list.size(); i++) {
                out.println(list.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
