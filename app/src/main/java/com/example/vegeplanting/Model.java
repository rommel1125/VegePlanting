package com.example.vegeplanting;

public class Model {
    private int id;
    private String vegeName;
    private  String datePlanted;
    private byte[] image;
    private String vegeCount;
    private String harvestDate;

    public Model(int id, String vegeName, String datePlanted, byte[] image, String vegeCount, String harvestDate) {
        this.id = id;
        this.vegeName = vegeName;
        this.datePlanted = datePlanted;
        this.image = image;
        this.vegeCount = vegeCount;
        this.harvestDate = harvestDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVegeName() {
        return vegeName;
    }

    public void setVegeName(String vegeName) {
        this.vegeName = vegeName;
    }

    public String getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(String datePlanted) {
        this.datePlanted = datePlanted;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getVegeCount(){ return vegeCount; }

    public void setVegeCount(String vegeCount){ this.vegeCount = vegeCount; }

    public String getHarvestDate() { return harvestDate; }

    public void setHarvestDate(String harvestDate) { this.harvestDate = harvestDate; }
}
