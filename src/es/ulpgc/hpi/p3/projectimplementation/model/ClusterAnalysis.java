package es.ulpgc.hpi.p3.projectimplementation.model;

import java.util.Random;

/**
 * Represents a clustering analysis using a specific algorithm and K value.
 * It simulates the process of grouping data and tracks the iterations required for the analysis.
 */
public class ClusterAnalysis extends Analysis {

    private int kValue;
    private String algorithm;
    private int iterations;

    public ClusterAnalysis(Database database, AnalysisTopic theme, int kValue, String algorithm) {
        super(database, theme);
        this.kValue = kValue;
        this.algorithm = algorithm;
        this.iterations = 0;
    }

    @Override
    public void runAnalysis() {
        setStatus(AnalysisStatus.Running);
        long startTime = System.currentTimeMillis();

        printStartMessage();

        try {
            executeSimulation();
            long endTime = System.currentTimeMillis();
            finalizeSuccess(startTime, endTime);
        } catch (InterruptedException e) {
            handleFailure();
        }
    }

    private void printStartMessage() {
        System.out.println("--- Starting " + algorithm + " Clustering with K=" + kValue + " ---");
    }

    private void executeSimulation() throws InterruptedException {
        Thread.sleep(1500);
        this.iterations = new Random().nextInt(50) + 10;
    }

    private void finalizeSuccess(long startTime, long endTime) {
        String summary = generateSummary();
        setExecutionTime((double) (endTime - startTime));
        setResultSummary(summary);
        setStatus(AnalysisStatus.Completed);
    }

    private String generateSummary() {
        return "Successfully created " + kValue + " clusters using " + algorithm + ". " +
                "Converged in " + iterations + " iterations. ";
    }

    private void handleFailure() {
        setStatus(AnalysisStatus.Failed);
        setResultSummary("Analysis interrupted due to error.");
    }

    @Override
    public void showResults() {
        super.showResults();

        if (getStatus() == AnalysisStatus.Completed) {
            printClusterDetails();
        }
    }

    private void printClusterDetails() {
        System.out.println("--- Cluster Specific Details ---");
        System.out.println("Algorithm Used: " + this.algorithm);
        System.out.println("Clusters (K): " + this.kValue);
        System.out.println("Total Iterations: " + this.iterations);
        System.out.println("--------------------------------");
    }

    public int getkValue() {
        return kValue;
    }

    public void setkValue(int kValue) {
        this.kValue = kValue;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}

