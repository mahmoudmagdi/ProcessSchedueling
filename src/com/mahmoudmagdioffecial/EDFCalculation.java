package com.mahmoudmagdioffecial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class EDFCalculation {
    static void EDF(final List<ProcessClass> taskList) {
        List<String> processesList = new ArrayList<>();
        List<List<String>> deadLineList = new ArrayList<>();
        int lcm = Utilities.calcLCM(taskList);
        Map<Integer, List<ProcessClass>> waitingMap = new HashMap<>();
        for (int cycle = -1; cycle < lcm; cycle++) {
            deadLineList.add(cycle + 1, new ArrayList<>());
            for (ProcessClass t : taskList)
                if (cycle + 1 < lcm && (cycle + 1) % t.getPeriod() == 0) {
                    if (!waitingMap.containsKey(cycle + 1 + t.getPeriod()))
                        waitingMap.put(cycle + 1 + t.getPeriod(), new ArrayList<>());
                    for (int i = 0; i < t.getExecutionTime(); i++)
                        waitingMap.get(cycle + 1 + t.getPeriod()).add(t);
                    deadLineList.get(cycle + 1).add(t.getLabel());
                }
            if (!waitingMap.isEmpty()) {
                Integer minKey = waitingMap.keySet().stream().min(Integer::compareTo).get();
                processesList.add(waitingMap.get(minKey).get(0).getLabel());
                waitingMap.get(minKey).remove(0);
                if (waitingMap.get(minKey).isEmpty())
                    waitingMap.remove(minKey);
            } else
                processesList.add(null);
        }
        deadLineList.remove(0);
        processesList.remove(processesList.size() - 1);
        System.out.println("Cycle \t" + "Current \t" + "Deadline \t");
        for (int i = 0; i < processesList.size(); i++) {
            if (processesList.get(i) == null)
                System.out.println(i + "\t \t" + " " + "\t  \t  \t" + deadLineList.get(i));
            else
                System.out.println(i + "\t \t" + processesList.get(i) + "\t  \t  \t" + deadLineList.get(i));
        }
    }
}

