package com.alonemusk.medicalapp.ui.Search;



import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class SearchMedicine {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int medicine_id;
    public String medicine_name;

    @Override
    public String toString() {
        return "MedicineNameId{" +
                "medicine_id=" + medicine_id +
                ", medicine_name='" + medicine_name + '\'' +
                '}';
    }

    public SearchMedicine(int medicine_id, String medicine_name) {
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
    }

    public int getMedicine_id() {
        return medicine_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
         this.id=id;
    }


    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }
}
