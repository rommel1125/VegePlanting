package com.example.vegeplanting;

public class Model {
    private int id;
    private String vegeName;
    private  String datePlanted;
    private byte[] image;

    public Model(int id, String vegeName, String datePlanted, byte[] image) {
        this.id = id;
        this.vegeName = vegeName;
        this.datePlanted = datePlanted;
        this.image = image;
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
}
