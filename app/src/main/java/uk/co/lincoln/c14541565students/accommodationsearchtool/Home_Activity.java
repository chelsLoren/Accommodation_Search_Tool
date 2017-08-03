package uk.co.lincoln.c14541565students.accommodationsearchtool;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Home_Activity extends Activity {

    Button Home_button;
    Button contacts_button;
    Button search_button;
    ViewPager slideshow_viewPager;
    CustomSwipeAdapter slideshow_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        TextView accommodation_guide = (TextView) findViewById(R.id.accommodation_guide);
        String linkText = "Visit the <a href='https://www.lincoln.ac.uk/home/media/universityoflincoln/adminimages/UoL-Accom.pdf'>Accommodation Guide</a> web page.";
        accommodation_guide.setText(Html.fromHtml(linkText));
        accommodation_guide.setMovementMethod(LinkMovementMethod.getInstance());

        ActionBar actionBar = getActionBar();
        actionBar.setLogo(R.drawable.logo);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        slideshow_viewPager = (ViewPager) findViewById(R.id.slideshow_viewpager);
        slideshow_adapter = new CustomSwipeAdapter(this);
        slideshow_viewPager.setAdapter(slideshow_adapter);

        Home_button = (Button) findViewById(R.id.Home_button);
        contacts_button = (Button) findViewById(R.id.contacts_button);
        search_button = (Button) findViewById(R.id.search_button);

    }

    public void onClick(View v){
        Intent intent = new Intent(this, Accommodation_View.class);
        startActivity(intent);
    }

    public void buttonOnClick(View v){
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);
    }

    public void buttononHomeClick(View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


}