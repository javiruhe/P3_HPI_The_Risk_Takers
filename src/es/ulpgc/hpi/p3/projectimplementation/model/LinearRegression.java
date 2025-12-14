package es.ulpgc.hpi.p3.projectimplementation.model;

import java.util.Random;

/**
 * Represents a linear regression model that analyzes the relationship between two variables.
 * It simulates the calculation of the slope, intercept, and R2 metrics.
 */
public class LinearRegression extends RegressionAnalysis {

    private String independentVariable;
    private double slope;
    private double intercept;

    public LinearRegression(Database database, AnalysisTopic theme, String dependentVariable, String independentVariable) {
        super(database, theme, dependentVariable);
        this.independentVariable = independentVariable;
    }

    @Override
    public void runAnalysis() {
        setStatus(AnalysisStatus.Running);
        long startTime = System.currentTimeMillis();

        try {
            executeSimulation();
            long endTime = System.currentTimeMillis();
            finalizeSuccess(startTime, endTime);
        } catch (InterruptedException e) {
            handleFailure();
        }
    }

    private void executeSimulation() throws InterruptedException {
        Thread.sleep(1000);
        calculateRegressionMetrics();
    }

    private void calculateRegressionMetrics() {
        Random rand = new Random();
        this.slope = 1.5 + rand.nextDouble();
        this.intercept = 10 + rand.nextDouble();
        this.rSquared = 0.85;
    }

    private void finalizeSuccess(long startTime, long endTime) {
        String summary = generateEquationSummary();
        setResultSummary(summary);
        setExecutionTime((double) (endTime - startTime));
        setStatus(AnalysisStatus.Completed);
    }

    private String generateEquationSummary() {
        return String.format("Linear Model: %s = %.2f * %s + %.2f",
                dependentVariable, slope, independentVariable, intercept);
    }

    private void handleFailure() {
        setStatus(AnalysisStatus.Failed);
    }
}