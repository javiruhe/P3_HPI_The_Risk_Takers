package es.ulpgc.hpi.p3.projectimplementation;

public abstract class Analysis {
    private static int ID = 0;
    private final int id;
    private String resultSummary;
    private Double executionTime;
    // Relaciones con enumeraciones y database
    private AnalysisTopic theme;
    private AnalysisStatus status;
    private Database database;

    public Analysis(Database database, AnalysisTopic theme) {
        this.database = database;
        this.theme = theme;

        // Inicializamos valores internos automáticamente
        this.status = AnalysisStatus.Pending;
        this.id = ++ID;

        // Valores por defecto para resultados (se llenarán al ejecutar runAnalysis)
        this.resultSummary = "Analysis not executed yet";
        this.executionTime = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getResultSummary() {
        return resultSummary;
    }

    public Double getExecutionTime() {
        return executionTime;
    }

    public AnalysisStatus getStatus() {
        return status;
    }

    public AnalysisTopic getTheme() {
        return theme;
    }

    public Database getDatabase() {
        return database;
    }

    protected void setResultSummary(String resultSummary) {
        this.resultSummary = resultSummary;
    }

    protected void setExecutionTime(Double executionTime) {
        this.executionTime = executionTime;
    }

    public void setStatus(AnalysisStatus status) {
        this.status = status;
    }

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

    public abstract void runAnalysis();
}

