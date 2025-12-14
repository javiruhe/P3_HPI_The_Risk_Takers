package es.ulpgc.hpi.p3.projectimplementation.model;

import java.time.LocalDate;

/**
 * Represents a dataset with metadata such as source path, size, and update status.
 * It provides a method to clean the data and filter it based on a given criteria.
 */
public class Database {

    private static int ID = 0;

    private final int id;
    private final int size;
    private final String sourcePath;
    private final LocalDate lastUpdate;
    private final FileType fileType;

    private Boolean isTidy;

    public Database(Boolean isTidy, int size, String sourcePath, LocalDate lastUpdate, FileType fileType) {
        this.id = ++ID;
        this.isTidy = isTidy;
        this.size = size;
        this.sourcePath = sourcePath;
        this.lastUpdate = lastUpdate;
        this.fileType = fileType;
    }

    public void cleanData() {
        if (this.isTidy) {
            printAlreadyCleanMessage();
        } else {
            performCleaning();
        }
    }

    private void printAlreadyCleanMessage() {
        System.out.println("Database (ID: " + id + ") is already tidy. No action needed.");
    }

    private void performCleaning() {
        System.out.println("Cleaning data from: " + sourcePath + "...");
        this.isTidy = true;
        System.out.println("Data cleaning completed. Status set to Tidy.");
    }

    public void filterBy(String criteria) {
        checkTidinessBeforeFilter();
        applyFilter(criteria);
    }

    private void checkTidinessBeforeFilter() {
        if (!this.isTidy) {
            System.out.println("Warning: Filtering untidy data might yield incorrect results.");
        }
    }

    private void applyFilter(String criteria) {
        System.out.println("Filtering database (ID: " + id + ") by criteria: [" + criteria + "]");
        System.out.println("Filter applied. Returning subset of " + size + " rows.");
    }

    public int getId() {
        return id;
    }

    public Boolean getTidy() {
        return isTidy;
    }

    public int getSize() {
        return size;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public FileType getFileType() {
        return fileType;
    }
}