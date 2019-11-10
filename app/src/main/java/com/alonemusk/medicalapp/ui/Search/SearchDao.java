package com.alonemusk.medicalapp.ui.Search;



import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface SearchDao {
    @Insert
    void insert(SearchMedicine searchMedicine);
    @Update
    void update(SearchMedicine searchMedicine);
    @Delete
    void delete(SearchMedicine searchMedicine);
    @Query("DELETE FROM note_table")
    void deleteAll();


    @Query("SELECT * FROM note_table ORDER BY medicine_id DESC")
    LiveData<List<SearchMedicine>> getAllnodes();

}
