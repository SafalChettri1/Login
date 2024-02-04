package net.com.gopal.myapplication.api;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import net.com.gopal.myapplication.api.customerItem.itemModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MenuItemAsync extends AsyncTask<String, String, String> {

    private Context context;
    private GetMenuItemInterface getMenuItemInterface;
    private JSONObject jsonObject;
    private List<itemModel> itemModelList;

//    public MenuItemAsync(Context context, JSONObject jsonObject, GetMenuItemInterface getMenuItemInterface) {
//        this.context = context;
//        this.getMenuItemInterface = getMenuItemInterface;
//        this.jsonObject = jsonObject;
//    }

    public MenuItemAsync(Context context, JSONObject jsonObject, GetMenuItemInterface getMenuItemInterface) {
        this.context = context;
        this.getMenuItemInterface = getMenuItemInterface;
        this.jsonObject = jsonObject;
        this.itemModelList = new ArrayList<>();  // Initialize itemModelList
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... strings) {
        String response = null;
        try {
            response = httpClass.sendHTTPData(Utills.MENU, jsonObject);
            Log.d("Gopal", "response : " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            if (s != null) {
                JSONObject jsonObject = new JSONObject(s);
                String status = jsonObject.getString("status");
                String message = jsonObject.getString("message");
                if (status.equals("200")) {


                    JSONArray menuCategories = jsonObject.getJSONObject("data").getJSONArray("MenuCategories");

//                    List<itemModel> originalItemModelList = new ArrayList<>(itemModelList);

                    List<MenuModel> MenuModel = new ArrayList<>();
                    itemModelList = new ArrayList<>();
                    for (int i = 0; i < menuCategories.length(); i++) {
                        JSONObject category = menuCategories.getJSONObject(i);
                        String categoryName = category.getString("Category");
                        String iconURL = category.getString("IconUrl");
                        String categoryId = category.getString("CategoryId");

//                     Create a MenuModel object and add it to the list
                        MenuModel menuModel = new MenuModel(categoryName, iconURL, categoryId);
                        MenuModel.add(menuModel);


                        String categoryIdForItems = category.getString("CategoryId");
                        JSONArray menuItems = jsonObject.getJSONObject("data").getJSONArray("MenuItems");


                        for (int j = 0; j < menuItems.length(); j++) {
                            JSONObject menuItemObject = menuItems.getJSONObject(j);
                            if (menuItemObject.getString("CategoryId").equals(categoryIdForItems)) {
                                String ItemsName = menuItemObject.getString("ItemName");
                                String ImageUrl = menuItemObject.getString("ImageUrl");
                                String Rate = menuItemObject.getString("Rate");
                                String CategoryID = menuItemObject.getString("CategoryId");

                                itemModel itemModel = new itemModel(ItemsName, ImageUrl, Rate,CategoryID);
                                itemModelList.add(itemModel);


                            }

                        }
//                        JSONArray menuItems = jsonObject.getJSONObject("data").getJSONArray("MenuItems");
//
//                        for (int j = 0; j < menuItems.length(); j++) {
//                            JSONObject menuItemObject = menuItems.getJSONObject(j);
//                            if (menuItemObject.getString("CategoryId").equals(categoryIdForItems)) {
//                                String ItemsName = menuItemObject.getString("ItemName");
//                                String ImageUrl = menuItemObject.getString("ImageUrl");
//                                String Rate = menuItemObject.getString("Rate");
//                                String CategoryID = menuItemObject.getString("CategoryId"); // Use "CategoryId" instead of "CategoryID"
//
//                                itemModel itemModel = new itemModel(ItemsName, ImageUrl, Rate, CategoryID);
//                                itemModelList.add(itemModel);
//                            }
//                        }


                    }
                    getMenuItemInterface.OnSuccess(message, MenuModel, itemModelList);

                } else {
                    getMenuItemInterface.OnFail(message);
                }
            }
            else{
                getMenuItemInterface.OnFail("Empty or null JSON response");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public interface GetMenuItemInterface {
        void OnSuccess(String msg, List<MenuModel> Order, List<itemModel> item);

        void OnFail(String msg);
    }




}