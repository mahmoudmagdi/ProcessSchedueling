package com.mahmoudmagdioffecial;

class ProcessClass {
    private int Period;
    private int ExecutionTime;
    private String Label;

    void setPeriod(int Period) {
        this.Period = Period;
    }

    void setExecutionTime(int ExecutionTime) {
        this.ExecutionTime = ExecutionTime;
    }

    void setLabel(String label) {
        this.Label = label;
    }

    int getPeriod() {
        return Period;
    }

    int getExecutionTime() {
        return ExecutionTime;
    }

    String getLabel() {
        return Label;
    }

}
