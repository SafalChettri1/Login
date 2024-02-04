package net.com.gopal.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import net.com.gopal.myapplication.api.MenuItemAsync;
import net.com.gopal.myapplication.api.MenuModel;
import net.com.gopal.myapplication.api.customerItem.CustomerItem;
import net.com.gopal.myapplication.api.customerItem.itemAdapter;
import net.com.gopal.myapplication.api.customerItem.itemModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class home extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    myAdapter adapter;
    ArrayList<MenuModel> menuList;
    ArrayList<itemModel> itemList;
//    net.com.gopal.myapplication.api.customerItem.itemAdapter itemAdapter;
    List<itemModel> originalItemModelList;// Add this variable



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recycleview);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);


        new MenuItemAsync(home.this, getReqForMenu(), new MenuItemAsync.GetMenuItemInterface() {
            @Override
            public void OnSuccess(String msg, List<MenuModel> receivedMenuList, List<itemModel> receivedItemList) {
                // Use the receivedMenuList instead of the local menuList
                menuList= new ArrayList<>(receivedMenuList);

                // Initialize the adapter with the context and menuList
                adapter = new myAdapter(home.this, menuList, new myAdapter.MyOnItemClickListener() {
                    @Override
                    public void onItemClick(MenuModel menuModel) {
                        // Handle item click, navigate to CustomerItem activity
                        Intent intent = new Intent(home.this, CustomerItem.class);
                        intent.putExtra("categoryId", menuModel.getCategoryId());
                        startActivity(intent);
                    }
                });

                recyclerView.setAdapter(adapter);


                // Notify the adapter that the data has changed
                adapter.notifyDataSetChanged();
            }





            @Override
            public void OnFail(String msg) {
                Toast.makeText(home.this, "Failed to fetch menu data: " + msg, Toast.LENGTH_SHORT).show();

            }
        }).execute();
    }

    public JSONObject getReqForMenu() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Id", "8609");
            jsonObject.put("BranchId", "8609");
            jsonObject.put("AppId", "3R0000000001443");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}


//        List<item> items = new ArrayList<item>();
//        items.add(new item("Gladiator", R.drawable.g,  2000));
//        items.add(new item("The GodFather", R.drawable.godfather,  1969));
//        items.add(new item("Fight Club", R.drawable.image1,  1999));
//        items.add(new item("American Psycho", R.drawable.g,  2001));
//        items.add(new item("Drive", R.drawable.g,  2007));
//        items.add(new item("Taxi Driver", R.drawable.taxi,  1975));
//        items.add(new item("Scarface", R.drawable.g,  1984));
//        items.add(new item("Pulp Fiction", R.drawable.g,  1996));
//        items.add(new item("MoneyBall", R.drawable.g,  1994));
//        items.add(new item("The Curious Case of Bengimum Buttom", R.drawable.g,  2001));
//        items.add(new item("Batman", R.drawable.g,  2003));
//        items.add(new item("Scent of Woman", R.drawable.g,  1992));
//
//
//
//        recyclerView.setAdapter(new myAdapter(getApplicationContext(),items));