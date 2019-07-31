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

    private static  AppDatabase         INSTANCE;
    public abstract CountryDao          countryDao();
    public abstract ChargerTypeDao      chargerTypeDao();
    public abstract ConnectionTypeDao   connectionTypeDao();
    private static final Object sLock   = new Object();

    protected AppDatabase() { }

    public static synchronized AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,
                        "charging-stations.db")
                        .build();
            }
            return INSTANCE;
        }
    }

    public static synchronized void destroyInstance(){
        INSTANCE = null;
    }
}
