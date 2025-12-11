package es.ulpgc.hpi.p3.projectimplementation;

import java.util.List;
public class AIModelAnalysis extends Analysis{
    private String modelArchitecture;

    private double accuracy;

    private Boolean isPreTrained;

    private List<Integer> confusionMatrix;

    public AIModelAnalysis(String resultSummary, Double executionTime, String modelArchitecture, double accuracy, Boolean isPreTrained, List<Integer> confusionMatrix) {
        super(resultSummary, executionTime);
        this.modelArchitecture = modelArchitecture;
        this.accuracy = accuracy;
        this.isPreTrained = isPreTrained;
        this.confusionMatrix = confusionMatrix;
    }

    public void trainModel(){

    }

    public void evaluateModel(){

    }
}
