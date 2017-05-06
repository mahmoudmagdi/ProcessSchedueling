package com.mahmoudmagdioffecial;

import java.util.ArrayList;
import java.util.Scanner;

public class InputMain {

    public static void main(String[] args) {
        ArrayList<ProcessClass> PList = new ArrayList<>();
        Scanner Processes = new Scanner(System.in);
        System.out.println("How many processes?");
        float NoProcesses = Processes.nextInt();
        for (int i = 0; i < NoProcesses; i++) {
            ProcessClass p = new ProcessClass();
            p.setLabel("P" + (i + 1));
            System.out.println("Enter the Execution time of the process (" + (i + 1) + "):");
            Scanner BurstTime = new Scanner(System.in);
            int BTime = BurstTime.nextInt();
            p.setExecutionTime(BTime);
            System.out.println("Enter the period of the process (" + (i + 1) + "):");
            Scanner Period = new Scanner(System.in);
            int per = Period.nextInt();
            p.setPeriod(per);
            System.out.println("\n \n");
            PList.add(i, p);
        }
        if (Utilities.getTotalExTime(NoProcesses) > Utilities.getUtilization(PList, NoProcesses)) {
            System.out.println("----- Valid Data -----");
            System.out.print("\n");
            System.out.print("LCM = " + Utilities.calcLCM(PList));
            System.out.println("\n");
            RMSCalculation.RMS(PList, NoProcesses);
            System.out.println("\n");
            EDFCalculation.EDF(PList);
        } else {
            System.out.println("Invalid data");
        }
    }

}

