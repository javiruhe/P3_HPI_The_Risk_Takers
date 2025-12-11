package es.ulpgc.hpi.p3.projectimplementation;

import java.util.Date;

public class Database {
    private static int ID = 0;
    private final int id;
    private final Boolean isTidy;
    private final int size;
    private final String sourcePath;
    private final Date lastUpdate;

    public Database(Boolean isTidy, int size, String sourcePath, Date lastUpdate) {
        this.id = ++ID;
        this.isTidy = isTidy;
        this.size = size;
        this.sourcePath = sourcePath;
        this.lastUpdate = lastUpdate;
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void cleanData(){

    }

    public void filterBy(){

    }
}
