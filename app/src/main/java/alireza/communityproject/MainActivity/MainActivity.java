package alireza.communityproject.MainActivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import alireza.communityproject.CultureProducts.Comment;
import alireza.communityproject.CultureProducts.Like;
import alireza.communityproject.CultureProducts.Video;
import alireza.communityproject.Profile.ProfileActivity;
import alireza.communityproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToProfile(View view){
        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
    }
}
