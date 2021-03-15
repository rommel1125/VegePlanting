package com.example.vegeplanting;

public class EventModel {
    private int id;
    private String datePlanted;
    private String harvestDate;
    private int vegeID;
    private String description;

    public EventModel(int id, String datePlanted, String harvestDate, int vegeID, String description) {
        this.id = id;
        this.datePlanted = datePlanted;
        this.harvestDate = harvestDate;
        this.vegeID = vegeID;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(String datePlanted) {
        this.datePlanted = datePlanted;
    }

    public String getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(String harvestDate) {
        this.harvestDate = harvestDate;
    }

    public int getVegeID() {
        return vegeID;
    }

    public void setVegeID(int vegeID) {
        this.vegeID = vegeID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
