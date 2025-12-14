package es.ulpgc.hpi.p3.projectimplementation.model;

/**
 * Abstract base class for regression analysis models.
 * It manages the dependent variable target and the R-squared accuracy metric.
 */
public abstract class RegressionAnalysis extends Analysis {

    protected String dependentVariable;
    protected double rSquared;

    public RegressionAnalysis(Database database, AnalysisTopic theme, String dependentVariable) {
        super(database, theme);
        this.dependentVariable = dependentVariable;
        this.rSquared = 0.0;
    }

    @Override
    public void showResults() {
        super.showResults();

        if (getStatus() == AnalysisStatus.Completed) {
            printRegressionDetails();
        }
    }

    private void printRegressionDetails() {
        System.out.println("--- General Regression Results ---");
        System.out.println("Target Variable (Y): " + dependentVariable);
        System.out.printf("Model Accuracy (R^2): %.4f\n", rSquared);
    }

    public String getDependentVariable() {
        return dependentVariable;
    }

    public void setDependentVariable(String dependentVariable) {
        this.dependentVariable = dependentVariable;
    }

    public double getrSquared() {
        return rSquared;
    }

    protected void setrSquared(double rSquared) {
        this.rSquared = rSquared;
    }
}