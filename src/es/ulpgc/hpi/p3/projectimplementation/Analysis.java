package es.ulpgc.hpi.p3.projectimplementation;

public abstract class Analysis {
    private static int ID = 0;
    private final int id;
    private final String resultSummary;
    private Double executionTime;

    public Analysis(String resultSummary, Double executionTime) {
        this.id = ++ID;
        this.resultSummary = resultSummary;
        this.executionTime = executionTime;
    }

    public int getId() {
        return id;
    }

    public String getResultSummary() {
        return resultSummary;
    }

    public Double getExecutionTime() {
        return executionTime;
    }

    public void runAnalysis(){

    }

    public void showResults(){

    }

}

