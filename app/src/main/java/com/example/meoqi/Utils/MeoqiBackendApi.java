package com.example.meoqi.Utils;

import com.example.meoqi.Models.EventData;
import com.example.meoqi.Models.LoginRes;
import com.example.meoqi.Models.SignUpData;
import com.example.meoqi.Models.TicketRes;
import com.example.meoqi.Models.User;
import com.example.meoqi.Models.UserRes;
import com.example.meoqi.Models.UsernameCheck;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MeoqiBackendApi {

    @GET("event/list")
    Call<List<EventData>> getEvent();

    @POST("signup")
    @FormUrlEncoded
    Call<JSONObject> createProfile(@Field("username")String username,@Field("first_name")String first_name,
                                   @Field("last_name")String last_name,@Field("password")String password,@Field("retype_password")String retype_password);

    @POST("login")
    @FormUrlEncoded
    Call<LoginRes> login(@Field("username")String username, @Field("password") String password);

    @GET("signup/username-check")
    Call<UsernameCheck> checkUsername(@Query("username") String username);

    @POST("tickets/book")
    @FormUrlEncoded
    Call<TicketRes> bookTicket(@Field("userID")String userID, @Field("price")String price,
                               @Field("currency")String currency, @Field("typeID") Map<String,Integer> typeID, @Field("eventID")String eventID,
                               @Field("transactionID")String transactionID);

    @GET("profile/{id}")
    Call<UserRes> getProfile(@Path("id") String id);


    @GET("event/{id}")
    Call<EventData> getEventbyId(@Path("id")String id);
}
