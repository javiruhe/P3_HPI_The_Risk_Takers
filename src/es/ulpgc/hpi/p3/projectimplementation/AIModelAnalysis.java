package es.ulpgc.hpi.p3.projectimplementation;

import java.util.Random;

public class AIModelAnalysis extends Analysis {

    private String modelType;     // Ej: "Neural Network", "Random Forest", "SVM"
    private int epochs;           // Número de ciclos de entrenamiento
    private double accuracy;      // Precisión final del modelo (0.0 a 1.0)

    public AIModelAnalysis(Database database, AnalysisTopic theme, String modelType, int epochs) {
        super(database, theme);
        this.modelType = modelType;
        this.epochs = epochs;
        this.accuracy = 0.0; // Inicialmente 0 hasta que corra el análisis
    }

    @Override
    public void runAnalysis() {
        setStatus(AnalysisStatus.Running);
        long startTime = System.currentTimeMillis();

        System.out.println("--- Initializing AI Training: " + modelType + " ---");

        try {
            // Simulamos el proceso de entrenamiento "Época por Época"
            // (En un caso real, aquí iría el bucle de entrenamiento)

            // Simulación: Tarda más que otros análisis (ej. 2.5 segundos)
            Thread.sleep(2500);

            // Simulación: Calculamos una precisión aleatoria entre 70% y 99%
            Random random = new Random();
            this.accuracy = 0.70 + (0.99 - 0.70) * random.nextDouble();

        } catch (InterruptedException e) {
            setStatus(AnalysisStatus.Failed);
            setResultSummary("AI Model training crashed.");
            return; // Salimos del método
        }

        long endTime = System.currentTimeMillis();

        // Formateamos el resultado para que se vea bonito tipo "95.4%"
        String accuracyPercent = String.format("%.2f", this.accuracy * 100);

        String summary = "Model " + modelType + " trained successfully over " + epochs +
                " epochs. Achieved validation accuracy of " + accuracyPercent + "%.";

        // Guardamos en el padre
        setExecutionTime((double) (endTime - startTime));
        setResultSummary(summary);
        setStatus(AnalysisStatus.Completed);
    }

    @Override
    public void showResults() {
        super.showResults();

        if (getStatus() == AnalysisStatus.Completed) {
            System.out.println("--- AI Model Metrics ---");
            System.out.println("Architecture: " + this.modelType);
            System.out.println("Training Epochs: " + this.epochs);
            // Mostramos la precisión en formato porcentaje
            System.out.printf("Final Accuracy: %.2f%%\n", (this.accuracy * 100));
            System.out.println("------------------------");
        }
    }


    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public double getAccuracy() {
        return accuracy;
    }
}
