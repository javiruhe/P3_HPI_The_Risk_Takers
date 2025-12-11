package es.ulpgc.hpi.p3.projectimplementation;

import java.util.List;
public class MultivariantRegression extends RegressionAnalysis{
    private List<String> independentVariables;

    public MultivariantRegression(String resultSummary, Double executionTime, String dependentVariable, double rSquared, List<String> independentVariables) {
        super(resultSummary, executionTime, dependentVariable, rSquared);
        this.independentVariables = independentVariables;
    }

    public List<String> getIndependentVariables() {
        return independentVariables;
    }

    public void setIndependentVariables(List<String> independentVariables) {
        this.independentVariables = independentVariables;
    }
}

