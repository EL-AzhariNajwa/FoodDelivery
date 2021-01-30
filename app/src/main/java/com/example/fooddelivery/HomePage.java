package com.example.fooddelivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    RecyclerView recyclerCategories;
    RecyclerView recyclerItems;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
        recyclerCategories = findViewById(R.id.recycler_categories);
        recyclerItems = findViewById(R.id.recycler_food);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        logout=findViewById(R.id.logout);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        setCategories();
        setFoodItem(0);
    }
    private void setCategories() {
        List<FoodCategory> data = new ArrayList<>();

        FoodCategory foodCategory = new FoodCategory("Burger",R.drawable.ic_burger);
        FoodCategory foodCategory2 = new FoodCategory("Chicken",R.drawable.ic_chicken);
        FoodCategory foodCategory3 = new FoodCategory("Pizza",R.drawable.ic_pizza);
        FoodCategory foodCategory4 = new FoodCategory("Pasta",R.drawable.pastaicon);
        FoodCategory foodCategory5 = new FoodCategory("Salad",R.drawable.saladicon);
        FoodCategory foodCategory6 = new FoodCategory("Dessert",R.drawable.desserticon);
        FoodCategory foodCategory7 = new FoodCategory("Juice",R.drawable.juiceicon);

        data.add(foodCategory);
        data.add(foodCategory2);
        data.add(foodCategory3);
        data.add(foodCategory4);
        data.add(foodCategory5);
        data.add(foodCategory6);
        data.add(foodCategory7);

        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(data, HomePage.this, new FoodCategoryAdapter.OnCategoryClick() {
            @Override
            public void onClick(int pos) {
                setFoodItem(pos);
            }
        });

        recyclerCategories.setLayoutManager(new LinearLayoutManager(HomePage.this, RecyclerView.HORIZONTAL,false));
        recyclerCategories.setAdapter(foodCategoryAdapter);
        foodCategoryAdapter.notifyDataSetChanged();
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else{
            super.onBackPressed();}
    }

    private void setFoodItem(int pos){
        List<FoodItem> foodItems = new ArrayList<>();
        switch (pos) {
            case 6 :
                FoodItem foodItem61 = new FoodItem("Lemon Juice ",4.5f,20,R.drawable.juice3);
                FoodItem foodItem62 = new FoodItem(" Orange Juice",5f,18,R.drawable.orangejus);
                FoodItem foodItem63 = new FoodItem(" Strawberry Juice",4.5f,20,R.drawable.juice4);
                FoodItem foodItem64 = new FoodItem(" Mojito",5f,30,R.drawable.mojitojuice);


                foodItems.add(foodItem61);
                foodItems.add(foodItem62);
                foodItems.add(foodItem63);
                foodItems.add(foodItem64);

                break;

            case 5 :
                FoodItem foodItem51 = new FoodItem("Cupcake Candy ",5f,22,R.drawable.sweet_icon);
                FoodItem foodItem52 = new FoodItem(" Pineapple Softy Cake",5f,28,R.drawable.sweet1);
                FoodItem foodItem53 = new FoodItem(" Chocolate Pastry Cake",5f,25,R.drawable.choco);

                foodItems.add(foodItem51);
                foodItems.add(foodItem52);
                foodItems.add(foodItem53);

                break;
            case 4 :
                FoodItem foodItem41 = new FoodItem("Chicken Salad ",5f,40,R.drawable.chickiiburg);

                FoodItem foodItem42 = new FoodItem(" Vegetable Salad",4.5f,30,R.drawable.vegetablesalad);
                FoodItem foodItem43 = new FoodItem(" Rainbow Fruit Salad",5f,35,R.drawable.saladd);
                FoodItem foodItem44 = new FoodItem(" Fruit Salad",5f,35,R.drawable.saladfruitt);


                foodItems.add(foodItem41);
                foodItems.add(foodItem42);
                foodItems.add(foodItem43);
                foodItems.add(foodItem44);


                break;


            case 3 :
                FoodItem foodItem21 = new FoodItem("Diet Pasta",4f,40,R.drawable.pastadiet);
                FoodItem foodItem22 = new FoodItem(" Italien Chicken Pasta ",5f,60,R.drawable.pasta);


                foodItems.add(foodItem21);
                foodItems.add(foodItem22);

                break;

            case 2:
                FoodItem foodItem = new FoodItem("Super Pizza",5f,100,R.drawable.pizza_sup);
                FoodItem foodItem2 = new FoodItem(" Mushroom Pizza ",5f,65,R.drawable.pizza_2);
                FoodItem foodItem3 = new FoodItem("Pizza Vegetarien",4f,45,R.drawable.pizza_3);
                FoodItem foodItem4 = new FoodItem("Pizza Pepperoni",4.5f,65,R.drawable.pizza_4);

                foodItems.add(foodItem);
                foodItems.add(foodItem2);
                foodItems.add(foodItem3);
                foodItems.add(foodItem4);
                break;
            case 1:
                FoodItem foodItem5 = new FoodItem("Chicken",5f,110,R.drawable.grill_chicken_1);
                FoodItem foodItem6 = new FoodItem(" Plat Chicken  ",4.5f,90,R.drawable.grill_chicken_2);
                FoodItem foodItem7 = new FoodItem("Chicken two",3.5f,50,R.drawable.grill_chicken_3);
               /* FoodItem foodItem8 = new FoodItem("Chicken",3.5f,14,R.drawable.grill_chicken_2);*/

                foodItems.add(foodItem5);
                foodItems.add(foodItem6);
                foodItems.add(foodItem7);
                /*foodItems.add(foodItem8);*/
                break;
            case 0:
                FoodItem foodItem9 = new FoodItem(" Menu Burger",5f,56,R.drawable.burger_two);
                FoodItem foodItem10 = new FoodItem("Beef Burger  ",4f,40,R.drawable.cheesburg);
                FoodItem foodItem11 = new FoodItem("Chicken Burger",4.5f,48,R.drawable.veg_burger);
                FoodItem foodItem12 = new FoodItem("Burger Sauce ",4f,30,R.drawable.burgersauce);
                foodItems.add(foodItem9);
                foodItems.add(foodItem10);
                foodItems.add(foodItem11);
                foodItems.add(foodItem12);
                break;
        }

        FoodAdapter foodAdapter = new FoodAdapter(foodItems);
        recyclerItems.setLayoutManager(new LinearLayoutManager(HomePage.this,RecyclerView.HORIZONTAL,false));

        recyclerItems.setAdapter(foodAdapter);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_home:

                break;
            case R.id.profile:
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                break;
            case R.id.nearby:
                startActivity(new Intent(getApplicationContext(),nearbyActivity.class));
                break;
            case R.id.aboutus:
                Intent intent=new Intent(HomePage.this,AboutusActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getApplicationContext(),Login.class));
                finish();
                break;

        }

        return true;
    }

}