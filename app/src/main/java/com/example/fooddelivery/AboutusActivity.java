package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.CalendarContract;



import android.view.Gravity;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Calendar;
import mehdi.sakout.aboutpage.Element;
import mehdi.sakout.aboutpage.AboutPage;

public class AboutusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(" The Easy Eat app helps customers to taste their favourite dishes from favourite restaurants staying at home")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("CONNECT WITH US!")
                .addEmail("najwa.elazhari@gmail.com")
                .addWebsite("www.easyeat.com")
                .addYoutube("easyeat")
                .addPlayStore("com.example.fooddelivery")
                .addInstagram("easy__eat21")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by EasyEat", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutusActivity.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }

}