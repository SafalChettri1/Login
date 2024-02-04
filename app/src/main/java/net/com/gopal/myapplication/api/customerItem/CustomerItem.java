//package net.com.gopal.myapplication.api.customerItem;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//
//import net.com.gopal.myapplication.R;
//import net.com.gopal.myapplication.api.MenuItemAsync;
//import net.com.gopal.myapplication.api.MenuModel;
//import net.com.gopal.myapplication.home;
//import net.com.gopal.myapplication.myAdapter;
//
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CustomerItem extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    RecyclerView.LayoutManager layoutManager;
//    itemAdapter adapter;
//    ArrayList<itemModel> itemList;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_customer_item);
//
//        recyclerView = findViewById(R.id.recycleview2);
//        layoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(layoutManager);
//
//
//        new MenuItemAsync(CustomerItem.this, getReqForMenu(), new MenuItemAsync.GetMenuItemInterface() {
//            @Override
//            public void OnSuccess(String msg, List<MenuModel> receivedMenuList, List<itemModel> receivedItemList ) {
//                // Use the receivedMenuList instead of the local menuList
//                itemList = new ArrayList<>(receivedItemListList);
//
//                // Initialize the adapter with the context and menuList
//                adapter = new itemAdapter(CustomerItem.this, itemList);
//
//                // Set the adapter to the RecyclerView
//                recyclerView.setAdapter(adapter);
//
//                // Notify the adapter that the data has changed
//                adapter.notifyDataSetChanged();
//            }
//        };
//
//    }
//
//    private JSONObject getReqForMenu() {
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("Id", "8609");
//            jsonObject.put("BranchId", "8609");
//            jsonObject.put("AppId", "3R0000000001443");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonObject;
//    }
//
//}
package net.com.gopal.myapplication.api.customerItem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import net.com.gopal.myapplication.R;

import net.com.gopal.myapplication.api.MenuItemAsync;
import net.com.gopal.myapplication.api.MenuModel;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomerItem extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    itemAdapter adapter;
    ArrayList<itemModel> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_item);

        recyclerView = findViewById(R.id.recycleview2);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        new MenuItemAsync(CustomerItem.this, getReqForMenu(), new MenuItemAsync.GetMenuItemInterface() {
            @Override
            public void OnSuccess(String msg, List<MenuModel> receivedMenuList, List<itemModel> receivedItemList) {
                // Use the receivedItemList instead of the local itemList
                itemList = new ArrayList<>(receivedItemList);

                // Initialize the adapter with the context and itemList
                adapter = new itemAdapter(CustomerItem.this, itemList);

                // Set the adapter to the RecyclerView
                recyclerView.setAdapter(adapter);

                // Notify the adapter that the data has changed
                adapter.notifyDataSetChanged();
            }

            @Override
            public void OnFail(String msg) {
                // Handle failure if needed
            }
        }).execute(); // Don't forget to execute the AsyncTask
//        new MenuItemAsync(CustomerItem.this, getReqForMenu(), new MenuItemAsync.GetMenuItemInterface() {
//            @Override
//            public void OnSuccess(String msg, List<MenuModel> receivedMenuList, List<itemModel> receivedItemList) {
//                // Use the receivedItemList instead of the local itemList
//                itemList = new ArrayList<>(receivedItemList);
//
//                // Initialize the adapter with the context and itemList
//                adapter = new itemAdapter(CustomerItem.this, itemList);
//
//                // Set the adapter to the RecyclerView
//                recyclerView.setAdapter(adapter);
//
//                // Notify the adapter that the data has changed
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void OnFail(String msg) {
//                // Handle failure if needed
//            }
//        }).execute(); // Don't forget to execute the AsyncTask
    }

    private JSONObject getReqForMenu() {
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
