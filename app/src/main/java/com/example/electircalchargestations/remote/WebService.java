package com.example.electircalchargestations.remote;
import com.example.electircalchargestations.Constants;
import com.example.electircalchargestations.Model.ChargeStation;
import com.example.electircalchargestations.ReferenceDataRequestBeans;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {

    @GET(Constants.END_POINT_REFERENCE_DATA)
    Call<ReferenceDataRequestBeans> getReferenceData();

    @GET(Constants.END_POINT)
    Call<List<ChargeStation>> getChargeStationListByCountry(@Query("countrycode")   String countryCode,
                                                            @Query("output")        String outputFormat,
                                                            @Query("maxresults")    String returnResult);
}
