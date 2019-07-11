package com.example.electircalchargestations.local;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.electircalchargestations.Model.Country;
import java.util.List;

@Dao
public interface CountryDao {

    @Insert
    void insertCountryList(List<Country> countryList);

    @Query("SELECT * FROM country ORDER BY country_code ASC")
    LiveData<List<Country>> getCountryList();
}
