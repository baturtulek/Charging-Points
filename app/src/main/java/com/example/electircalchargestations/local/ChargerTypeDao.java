package com.example.electircalchargestations.local;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.electircalchargestations.Model.Level;
import java.util.List;

@Dao
public interface ChargerTypeDao {

    @Insert
    void insertChargerTypeList(List<Level> chargerTypeList);

    @Query("SELECT * FROM charger_type ORDER BY charger_id ASC")
    LiveData<List<Level>> getChargerTypeList();

}
