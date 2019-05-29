package galosoft.com.androiddrinkshop2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import galosoft.com.androiddrinkshop2.Adapter.DrinkAdapter;
import galosoft.com.androiddrinkshop2.Model.Drink;
import galosoft.com.androiddrinkshop2.Retrofit.IDrinkShopAPI;
import galosoft.com.androiddrinkshop2.Utils.Common;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DrinkActivity extends AppCompatActivity {

    IDrinkShopAPI mService;
    RecyclerView lst_drink;
    //RX java
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    TextView txt_banner_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        mService = Common.getAPI();

        lst_drink = findViewById(R.id.recycler_drinks);
        lst_drink.setLayoutManager(new GridLayoutManager(this,2));
        lst_drink.setHasFixedSize(true);
        txt_banner_name = findViewById(R.id.txt_menu_name);
        txt_banner_name.setText(Common.currentCategory.Name);

        loadListDrink(Common.currentCategory.ID);
    }

    private void loadListDrink(String menuId) {
        compositeDisposable.add(mService.getDrink(menuId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Drink>>() {
                    @Override
                    public void accept(List<Drink> drinks) throws Exception {
                        displayDrinkList(drinks);
                    }
                }));
    }

    private void displayDrinkList(List<Drink> drinks) {
        DrinkAdapter adapter = new DrinkAdapter(this, drinks);
        lst_drink.setAdapter(adapter);
    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
        //isBackButtonClicked = true;
    }
}



