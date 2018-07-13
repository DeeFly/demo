package com.gaofei.suanfa.mars;

import com.gaofei.suanfa.mars.exception.MarsMissionExcepton;
import com.gaofei.suanfa.mars.rovers.Rover;
import com.gaofei.suanfa.mars.rovers.RoverFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2018/7/13 0013.
 */
public class MarsMission {

    private Rover rover;
    int roverSeq = 1;

    private int maxX;
    private int maxY;

    public void startMission() {
        List<String> info = readInfo();
        checkInput(info);

        while (roverSeqExists(roverSeq, info)) {
            rover = getRover(roverSeq, info);
            String directive = info.get(2 * roverSeq);
            executMission(rover,directive);
            roverSeq++;
        }
    }

    private void executMission(Rover rover, String directive) {
        if (StringUtils.isBlank(directive)) {
            return;
        }

        char[] directives = directive.toCharArray();
        for (char command : directives) {
            if ("M".equals(command + "")) {
                rover.move();
            } else {
                rover = rover.switchDirection(command + "");
            }
        }

        rover.printPostion();
    }

    private void checkInput(List<String> info) {
        if (info == null || info.size() < 4) {
            throw new MarsMissionExcepton("您的输入有误");
        }
    }

    private Rover getRover(int roverSeq, List<String> info) {
        if (!checkMaxXY()) {
            setMaxXY(info);
        }

        Rover result = getRover(info.get(2 * roverSeq -1));
        return result;
    }

    private Rover getRover(String roverInfo) {
        String[] roverInfos = roverInfo.split(" ");
        int x = string2int(roverInfos[0]);
        int y = string2int(roverInfos[1]);
        return doGetRover(x, y, roverInfos[2]);
    }

    private Rover doGetRover(int x, int y, String direction) {
        switch (direction) {
            case "E":
                return RoverFactory.getEDirectionRover(x, y, maxX, maxY);
            case "S":
                return RoverFactory.getSDirectionRover(x, y, maxX, maxY);
            case "W":
                return RoverFactory.getWDirectionRover(x, y, maxX, maxY);
            case "N":
                return RoverFactory.getNDirectionRover(x, y, maxX, maxY);
            default:
                throw new MarsMissionExcepton("unknown direction");
        }
    }

    private void setMaxXY(List<String> info) {
        String plateauInfo = info.get(0);
        if (StringUtils.isBlank(plateauInfo)) {
            throw new MarsMissionExcepton("plateauInfo is wrong");
        }

        String[] plateauXY = plateauInfo.split(" ");
        maxX = string2int(plateauXY[0]);
        maxY = string2int(plateauXY[1]);
    }

    private int string2int(String s) {
        int result = Integer.parseInt(s);
        if (result <= 0) {
            throw new MarsMissionExcepton("plateauInfo should not below zero:" + s);
        }
        return result;
    }

    private boolean checkMaxXY() {
        return maxX > 0 && maxY > 0;
    }

    private boolean roverSeqExists(int roverSeq, List<String> info) {
        if (info == null) {
            return false;
        }

        return info.size() >= (2 * roverSeq + 1);
    }

    public static void main(String[] args) {
        MarsMission marsMission = new MarsMission();
        List<String> info = marsMission.readInfo();
        info.forEach(System.out::println);
    }

    private List<String> readInfo() {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;

        while (!"".equals(inputString)) {
            try {
                inputString = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            result.add(inputString);
        }

        return result;
    }
}
