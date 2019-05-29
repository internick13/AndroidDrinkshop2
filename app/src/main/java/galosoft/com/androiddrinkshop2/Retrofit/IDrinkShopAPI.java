package galosoft.com.androiddrinkshop2.Retrofit;

import java.util.List;

import galosoft.com.androiddrinkshop2.Model.Banner;
import galosoft.com.androiddrinkshop2.Model.Category;
import galosoft.com.androiddrinkshop2.Model.CheckUserResponse;
import galosoft.com.androiddrinkshop2.Model.Drink;
import galosoft.com.androiddrinkshop2.Model.User;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IDrinkShopAPI {

    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExists(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone") String phone,
                               @Field("name") String name,
                               @Field("address") String address,
                               @Field("birthdate") String birthdate);



    @FormUrlEncoded
    @POST("getuser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @GET("getbanner.php")
    Observable<List<Banner>> getBanners();

    @GET("getmenu.php")
    Observable<List<Category>> getMenu();


    @FormUrlEncoded
    @POST("getdrink.php")
    Observable<List<Drink>> getDrink(@Field("menuId") String menuID);


   /*
    @Multipart
    @POST("upload.php")
    Call<String> uploadFile(@Part MultipartBody.Part phone, @Part MultipartBody.Part file);

    @GET("getAllDrinks.php")
    Observable<List<Drink>> getAllDrinks();

    @FormUrlEncoded
    @POST("submitorder.php")
    Call<String> submitOrder(@Field("price") float oderPrice,
                             @Field("orderDetail") String orderEetail,
                             @Field("comment") String comment,
                             @Field("address") String address,
                             @Field("phone") String phone); */
}
