package com.mahmoudmagdioffecial;

import java.util.ArrayList;

class RMSCalculation {
    static void RMS(ArrayList<ProcessClass> array, float NoProcesses) {
        System.out.println("RMS Scheduling: \n");
        System.out.println("No ||00----01----02----03----04----05----06----07----08----09----10----11----12----13----14----15----16----17----18----19----20----21----22----23----24----25----26----27----28----29----30----31----32----33----34----35----36----37----38----39----40----41----42----43----44----45----46----47----48----49----50----51----52----53----54----55----56----57----58----59----60");
        ArrayList<Integer> cycle = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            cycle.add(0);
        }
        int lastEx = 0;
        for (int m = 0; m < NoProcesses; m++) {
            int place = 0;
            float ET = array.get(m).getExecutionTime();
            float P = array.get(m).getPeriod();

            int rep = (int) (60 / P);
            System.out.print("P#" + (m + 1) + "||");
            if (lastEx != 0) {
                for (int before = 0; before < lastEx; before++) {
                    System.out.print("||    ");
                    place++;
                }
            }
            for (int r = 0; r < rep; r++) {
                int exTime = 0;
                do {
                    if (cycle.get(place) != null && cycle.get(place).equals(1)) {
                        System.out.print("||    ");
                        place++;
                    } else {
                        System.out.print("||=P" + (m + 1) + "=");
                        cycle.set(place, 1);
                        place++;
                        exTime++;
                    }
                } while (exTime < ET);
                for (int s = 0; s <= (P - ET - 1); s++) {
                    System.out.print("||    ");
                    place++;
                }
            }
            lastEx = lastEx + (int) ET;
            System.out.print("\n");
        }
    }
}
