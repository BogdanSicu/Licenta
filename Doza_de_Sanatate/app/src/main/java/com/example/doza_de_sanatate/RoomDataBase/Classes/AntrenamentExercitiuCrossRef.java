package com.example.doza_de_sanatate.RoomDataBase.Classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(primaryKeys = {"denumireAntrenamentID", "denumireExercitiuID"})
public class AntrenamentExercitiuCrossRef {

    @NonNull
    @ColumnInfo(name = "denumireAntrenamentID")
    private String denumireAntrenamentID;

    @NonNull
    @ColumnInfo(name = "denumireExercitiuID")
    private String denumireExercitiuID;

    public AntrenamentExercitiuCrossRef(@NonNull String denumireAntrenamentID, @NonNull String denumireExercitiuID) {
        this.denumireAntrenamentID = denumireAntrenamentID;
        this.denumireExercitiuID = denumireExercitiuID;
    }

    @NonNull
    public String getDenumireAntrenamentID() {
        return denumireAntrenamentID;
    }

    public void setDenumireAntrenamentID(@NonNull String denumireAntrenamentID) {
        this.denumireAntrenamentID = denumireAntrenamentID;
    }

    @NonNull
    public String getDenumireExercitiuID() {
        return denumireExercitiuID;
    }

    public void setDenumireExercitiuID(@NonNull String denumireExercitiuID) {
        this.denumireExercitiuID = denumireExercitiuID;
    }
}
