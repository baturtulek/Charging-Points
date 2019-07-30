package com.example.electircalchargestations.remote;
import com.example.electircalchargestations.Constants;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout (1,     TimeUnit.MINUTES)
                    .readTimeout    (30,    TimeUnit.SECONDS)
                    .writeTimeout   (15,    TimeUnit.SECONDS)
                    .build();

    protected RetrofitService(){ }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
