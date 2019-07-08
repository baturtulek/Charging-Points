package com.example.electircalchargestations.local;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.example.electircalchargestations.Model.ConnectionType;
import com.example.electircalchargestations.Model.Country;
import com.example.electircalchargestations.Model.Level;

@Database(entities = {Country.class, Level.class, ConnectionType.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static  AppDatabase         dbInstance;
    public abstract CountryDao          countryDao();
    public abstract ChargerTypeDao      chargerTypeDao();
    public abstract ConnectionTypeDao   connectionTypeDao();

    protected AppDatabase() { }

    public static synchronized AppDatabase getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "electric-charging-stations")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dbInstance;
    }

    public static synchronized void destroyInstance(){
        dbInstance = null;
    }
}
