package com.example.meoqi.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static ApiProvider instance;
    public static final String BASE_URL = "https://meoqi-backend1.herokuapp.com/";
    //prod : https://meoqi-backend1.herokuapp.com
    //dev : https://meoqi-backend-dev.herokuapp.com/

    public static ApiProvider getInstance() {
        if (instance == null) {
            instance = new ApiProvider();
        }
        return instance;
    }
    public MeoqiBackendApi provide(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://meoqi-backend1.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MeoqiBackendApi.class);
    }
}
