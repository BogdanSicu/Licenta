package com.example.doza_de_sanatate.RoomDataBase.Classes;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class AntrenamentExercitiuCrossRef {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @NonNull
    @ColumnInfo(name = "denumireAntrenamentID")
    private String denumireAntrenamentID;

    @NonNull
    @ColumnInfo(name = "denumireExercitiuID")
    private String denumireExercitiuID;

    public AntrenamentExercitiuCrossRef(long id, @NonNull String denumireAntrenamentID, @NonNull String denumireExercitiuID) {
        this.id = id;
        this.denumireAntrenamentID = denumireAntrenamentID;
        this.denumireExercitiuID = denumireExercitiuID;
    }

    @Ignore
    public AntrenamentExercitiuCrossRef(@NonNull String denumireAntrenamentID, @NonNull String denumireExercitiuID) {
        this.denumireAntrenamentID = denumireAntrenamentID;
        this.denumireExercitiuID = denumireExercitiuID;
    }

    @NonNull
    public long getId() {
        return id;
    }

    @NonNull
    public String getDenumireAntrenamentID() {
        return denumireAntrenamentID;
    }

    @NonNull
    public String getDenumireExercitiuID() {
        return denumireExercitiuID;
    }

}
