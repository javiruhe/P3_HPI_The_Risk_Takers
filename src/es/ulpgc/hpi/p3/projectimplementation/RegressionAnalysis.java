package es.ulpgc.hpi.p3.projectimplementation;

public class RegressionAnalysis extends Analysis{
    private String dependentVariable;
    private double rSquared;

    public RegressionAnalysis(String resultSummary, Double executionTime, String dependentVariable, double rSquared) {
        super(resultSummary, executionTime);
        this.dependentVariable = dependentVariable;
        this.rSquared = rSquared;
    }

    public void setDependentVariable(String dependentVariable) {
        this.dependentVariable = dependentVariable;
    }

    public void setrSquared(double rSquared) {
        this.rSquared = rSquared;
    }

    public String getDependentVariable() {
        return dependentVariable;
    }

    public double getrSquared() {
        return rSquared;
    }

    public void selectVariables(){

    }


}
