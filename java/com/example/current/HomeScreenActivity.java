package com.example.current;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class HomeScreenActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    ImageView notification, currentaffairs, gk, vocab;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView = (ImageView) findViewById(R.id.signout);
         notification = (ImageView) findViewById(R.id.notifications);
         currentaffairs = (ImageView) findViewById(R.id.current_affairs);
         gk  = (ImageView) findViewById(R.id.static_gk);
         vocab = (ImageView) findViewById(R.id.vocabulary);
        mAuth = FirebaseAuth.getInstance();

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(HomeScreenActivity.this, SignInActivity.class));
                }
            }
        };

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(HomeScreenActivity.this, NotificationsActivity.class);
                startActivity(i1);
            }
        });

        currentaffairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(HomeScreenActivity.this, CurrentAffairsActivity.class);
                startActivity(i2);
            }
        });

        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(HomeScreenActivity.this, StaticGkActivity.class);
                startActivity(i3);
            }
        });

        vocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(HomeScreenActivity.this, VocabularyActivity.class);
                startActivity(i4);
            }
        });
    }
}
