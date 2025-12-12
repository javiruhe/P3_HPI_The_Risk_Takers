package es.ulpgc.hpi.p3.projectimplementation;

import java.util.Random;

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
            Thread.sleep(1000);
            Random rand = new Random();

            this.slope = 1.5 + rand.nextDouble();
            this.intercept = 10 + rand.nextDouble();
            this.rSquared = 0.85;

        } catch (InterruptedException e) {
            setStatus(AnalysisStatus.Failed);
            return;
        }

        long endTime = System.currentTimeMillis();

        String summary = String.format("Linear Model: %s = %.2f * %s + %.2f",
                dependentVariable, slope, independentVariable, intercept);

        setResultSummary(summary);
        setExecutionTime((double) (endTime - startTime));
        setStatus(AnalysisStatus.Completed);
    }
}