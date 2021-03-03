package com.example.vegeplanting;

public class NoteModel {
    private int id;
    private String vegeName;
    private String dateOfNote;
    private String Note;
    private int vegeID;

    public NoteModel(int id, String vegeName, String dateOfNote, String note, int vegeID) {
        this.id = id;
        this.vegeName = vegeName;
        this.dateOfNote = dateOfNote;
        Note = note;
        this.vegeID = vegeID;
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

    public String getDateOfNote() {
        return dateOfNote;
    }

    public void setDateOfNote(String dateOfNote) {
        this.dateOfNote = dateOfNote;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public int getVegeID() {
        return vegeID;
    }

    public void setVegeID(int vegeID) {
        this.vegeID = vegeID;
    }
}
