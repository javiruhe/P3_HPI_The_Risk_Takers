package es.ulpgc.hpi.p3.projectimplementation.model;

import java.util.List;

/**
 * Represents a regression analysis that uses multiple independent variables to predict the outcome.
 * It simulates the calculation process and updates the model's accuracy R2 metric.
 */
public class MultivariantRegression extends RegressionAnalysis {

    private List<String> independentVariables;
    private List<Double> coefficients;

    public MultivariantRegression(Database database, AnalysisTopic theme, String dependentVariable, List<String> independentVariables) {
        super(database, theme, dependentVariable);
        this.independentVariables = independentVariables;
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
        Thread.sleep(1500);
        this.rSquared = 0.92;
    }

    private void finalizeSuccess(long startTime, long endTime) {
        String summary = generateSummary();
        setResultSummary(summary);
        setExecutionTime((double) (endTime - startTime));
        setStatus(AnalysisStatus.Completed);
    }

    private String generateSummary() {
        return "Multivariant model calculated using " + independentVariables.size() + " variables.";
    }

    private void handleFailure() {
        setStatus(AnalysisStatus.Failed);
    }
}


