package galosoft.com.androiddrinkshop2.Utils;

import galosoft.com.androiddrinkshop2.Model.User;
import galosoft.com.androiddrinkshop2.Retrofit.IDrinkShopAPI;
import galosoft.com.androiddrinkshop2.Retrofit.RetrofitClient;

public class Common {

    //In emulator local hos is 10.0.2.2
    public static final String BASE_URL = "http://10.0.2.2:8080/drinkshop/";
    public static final String TOPPING_MENU_ID = "7";

    public static User currentUser = null;

    public static IDrinkShopAPI getAPI() {
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
}
