package es.ulpgc.hpi.p3.projectimplementation.model;

/**
 * Abstract base class for data analysis tasks.
 * It manages the analysis unique ID, status,
 * execution results, and the associated database.
 */
public abstract class Analysis {

    private static int ID = 0;

    private final int id;
    private final Database database;
    private final AnalysisTopic theme;

    private AnalysisStatus status;
    private String resultSummary;
    private Double executionTime;

    public Analysis(Database database, AnalysisTopic theme) {
        this.id = ++ID;
        this.database = database;
        this.theme = theme;
        this.status = AnalysisStatus.Pending;
        this.resultSummary = "Analysis not executed yet";
        this.executionTime = 0.0;
    }

    public abstract void runAnalysis();

    public void showResults() {
        System.out.println("====== ANALYSIS REPORT ID: " + this.id + " ======");
        System.out.println("Theme: " + this.theme);
        System.out.println("Status: " + this.status);

        if (this.status == AnalysisStatus.Completed) {
            System.out.println("Execution Time: " + this.executionTime + " ms");
            System.out.println("Summary: " + this.resultSummary);
        } else {
            System.out.println("Results are not available yet (Analysis not completed).");
        }

        System.out.println("==========================================");
    }

    public int getId() {
        return id;
    }

    public Database getDatabase() {
        return database;
    }

    public AnalysisTopic getTheme() {
        return theme;
    }

    public AnalysisStatus getStatus() {
        return status;
    }

    public void setStatus(AnalysisStatus status) {
        this.status = status;
    }

    public String getResultSummary() {
        return resultSummary;
    }

    protected void setResultSummary(String resultSummary) {
        this.resultSummary = resultSummary;
    }

    public Double getExecutionTime() {
        return executionTime;
    }

    protected void setExecutionTime(Double executionTime) {
        this.executionTime = executionTime;
    }
}
