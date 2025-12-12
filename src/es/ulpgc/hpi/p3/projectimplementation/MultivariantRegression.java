package es.ulpgc.hpi.p3.projectimplementation;

import java.util.List;
import java.util.Random;

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
            Thread.sleep(1500);
            this.rSquared = 0.92;

        } catch (InterruptedException e) {
            setStatus(AnalysisStatus.Failed);
            return;
        }

        long endTime = System.currentTimeMillis();

        String summary = "Multivariant model calculated using " + independentVariables.size() + " variables.";

        setResultSummary(summary);
        setExecutionTime((double) (endTime - startTime));
        setStatus(AnalysisStatus.Completed);
    }
}


