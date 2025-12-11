package es.ulpgc.hpi.p3.projectimplementation;

public class LinearRegression extends RegressionAnalysis{
    private String independentVariable;

    public LinearRegression(String resultSummary, Double executionTime, String dependentVariable, double rSquared, String independentVariable) {
        super(resultSummary, executionTime, dependentVariable, rSquared);
        this.independentVariable = independentVariable;
    }

    public String getIndependentVariable() {
        return independentVariable;
    }

    public void setIndependentVariable(String independentVariable) {
        this.independentVariable = independentVariable;
    }
}
