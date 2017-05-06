package com.mahmoudmagdioffecial;

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public static ArrayList<ProcessClass> rearrange(ArrayList<ProcessClass> StartArray) {
        ArrayList<ProcessClass> EndArray = new ArrayList<>();
        ArrayList<ProcessClass> temp = StartArray;
        ProcessClass minimum = StartArray.get(0);
        for (ProcessClass p : StartArray) {
            if (p.getExecutionTime() < minimum.getExecutionTime()) {
                minimum = p;
            }
            StartArray.remove(minimum);
        }
        EndArray.add(minimum);
        return EndArray;
    }

    static int calcLCM(List<ProcessClass> taskList) {
        int lcm = taskList.get(0).getPeriod();
        for (boolean flag = true; flag; ) {
            for (ProcessClass x : taskList) {
                if (lcm % x.getPeriod() != 0) {
                    flag = true;
                    break;
                }
                flag = false;
            }
            lcm = flag ? (lcm + 1) : lcm;
        }
        return lcm;
    }

    static float getUtilization(ArrayList<ProcessClass> PList, float NoProcesses) {
        float uSum = 0;
        for (int j = 0; j < NoProcesses; j++) {
            float BT = PList.get(j).getExecutionTime();
            float P = PList.get(j).getPeriod();
            uSum = +(BT / P);
        }
        return uSum;
    }

    static float getTotalExTime(float NoProcesses) {
        float Exp = (float) Math.pow(2, 1 / NoProcesses);
        float sub = Exp - 1;
        return NoProcesses * sub;
    }
}
