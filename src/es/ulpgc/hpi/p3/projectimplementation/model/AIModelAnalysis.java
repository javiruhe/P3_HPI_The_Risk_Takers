package es.ulpgc.hpi.p3.projectimplementation.model;

import java.util.Random;

/**
 * Represents an analysis that simulates the training of an AI model.
 * It manages model parameters like epochs and type, and calculates
 * the final accuracy after a simulated training duration.
 */
public class AIModelAnalysis extends Analysis {

    private String modelType;
    private int epochs;
    private double accuracy;

    public AIModelAnalysis(Database database, AnalysisTopic theme, String modelType, int epochs) {
        super(database, theme);
        this.modelType = modelType;
        this.epochs = epochs;
        this.accuracy = 0.0;
    }

    @Override
    public void runAnalysis() {
        setStatus(AnalysisStatus.Running);
        long startTime = System.currentTimeMillis();

        printStartMessage();

        try {
            executeTrainingSimulation();
            long endTime = System.currentTimeMillis();
            finalizeSuccess(startTime, endTime);
        } catch (InterruptedException e) {
            handleFailure();
        }
    }

    private void printStartMessage() {
        System.out.println("--- Initializing AI Training: " + modelType + " ---");
    }

    private void executeTrainingSimulation() throws InterruptedException {
        Thread.sleep(2500);
        calculateRandomAccuracy();
    }

    private void calculateRandomAccuracy() {
        Random random = new Random();
        this.accuracy = 0.70 + (0.99 - 0.70) * random.nextDouble();
    }

    private void finalizeSuccess(long startTime, long endTime) {
        String summary = generateSuccessSummary();
        setExecutionTime((double) (endTime - startTime));
        setResultSummary(summary);
        setStatus(AnalysisStatus.Completed);
    }

    private String generateSuccessSummary() {
        String accuracyPercent = String.format("%.2f", this.accuracy * 100);
        return "Model " + modelType + " trained successfully over " + epochs +
                " epochs. Achieved validation accuracy of " + accuracyPercent + "%.";
    }

    private void handleFailure() {
        setStatus(AnalysisStatus.Failed);
        setResultSummary("AI Model training crashed.");
    }

    @Override
    public void showResults() {
        super.showResults();

        if (getStatus() == AnalysisStatus.Completed) {
            printMetrics();
        }
    }

    private void printMetrics() {
        System.out.println("--- AI Model Metrics ---");
        System.out.println("Architecture: " + this.modelType);
        System.out.println("Training Epochs: " + this.epochs);
        System.out.printf("Final Accuracy: %.2f%%\n", (this.accuracy * 100));
        System.out.println("------------------------");
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public double getAccuracy() {
        return accuracy;
    }
}