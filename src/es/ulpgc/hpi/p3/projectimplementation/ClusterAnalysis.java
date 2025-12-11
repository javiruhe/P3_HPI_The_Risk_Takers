package es.ulpgc.hpi.p3.projectimplementation;

public class ClusterAnalysis extends Analysis {
    private int clusters;
    private String algorithm;

    public ClusterAnalysis(String resultSummary, Double executionTime, int clusters, String algorithm) {
        super(resultSummary, executionTime);
        this.clusters = clusters;
        this.algorithm = algorithm;
    }

    public void calculateOptimalK(){

    }
}
