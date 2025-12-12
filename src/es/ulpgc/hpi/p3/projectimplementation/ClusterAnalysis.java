package es.ulpgc.hpi.p3.projectimplementation;

import java.util.Random;

public class ClusterAnalysis extends Analysis {

    private int kValue;
    private String algorithm;
    private int iterations;

    public ClusterAnalysis(Database database, AnalysisTopic theme, int kValue, String algorithm) {
        super(database, theme);
        this.kValue = kValue;
        this.algorithm = algorithm;
        this.iterations = 0;
    }

    @Override
    public void runAnalysis() {
        setStatus(AnalysisStatus.Running);
        long startTime = System.currentTimeMillis();

        System.out.println("--- Starting " + algorithm + " Clustering with K=" + kValue + " ---");

        // Simulación de cálculo
        try {
            // Simulamos que tarda entre 1 y 2 segundos en procesar
            Thread.sleep(1500);

            // Simulamos cálculo de iteraciones
            this.iterations = new Random().nextInt(50) + 10;

        } catch (InterruptedException e) {
            setStatus(AnalysisStatus.Failed);
            setResultSummary("Analysis interrupted due to error.");
            return;
        }

        long endTime = System.currentTimeMillis();

        // Generamos un resumen de resultados
        String summary = "Successfully created " + kValue + " clusters using " + algorithm + ". " +
                "Converged in " + iterations + " iterations. " +
                "Main groups identified: High Value, Loyal, Risk.";

        // Guardamos los resultados en la clase Padre usando los setters protected
        setExecutionTime((double) (endTime - startTime));
        setResultSummary(summary);
        setStatus(AnalysisStatus.Completed);
    }

    @Override
    public void showResults() {
        // Primero muestra la info básica del padre (ID, Status, Time)
        super.showResults();

        // Si terminó, mostramos los detalles exclusivos de Cluster
        if (getStatus() == AnalysisStatus.Completed) {
            System.out.println("--- Cluster Specific Details ---");
            System.out.println("Algorithm Used: " + this.algorithm);
            System.out.println("Clusters (K): " + this.kValue);
            System.out.println("Total Iterations: " + this.iterations);
            System.out.println("--------------------------------");
        }
    }

    public int getkValue() {
        return kValue;
    }

    public void setkValue(int kValue) {
        this.kValue = kValue;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
