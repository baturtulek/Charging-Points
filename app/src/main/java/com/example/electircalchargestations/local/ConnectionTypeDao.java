package com.example.electircalchargestations.local;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.electircalchargestations.Model.ConnectionType;
import java.util.List;

@Dao
public interface ConnectionTypeDao {

    @Insert
    void insertConnectionTypeList(List<ConnectionType> connectionTypeList);

    @Query("SELECT * FROM connection_type ORDER BY connection_id ASC")
    LiveData<List<ConnectionType>> getConnectionTypeList();
}
