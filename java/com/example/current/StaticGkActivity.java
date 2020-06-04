package com.example.current;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class StaticGkActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;
    TextView danceForms,nationalParks,countryCapitalCurrency,Awards,importantDays,firstInIndia,bankingAbbreviations,govtSchemes,damsInIndia,stateCapitals;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_gk);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView = (ImageView) findViewById(R.id.signout);
        mAuth = FirebaseAuth.getInstance();

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(StaticGkActivity.this, SignInActivity.class));
                }
            }
        };

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        danceForms = (TextView) findViewById(R.id.dance_forms);
        danceForms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, DanceFormsActivity.class);
                startActivity(i);
            }
        });

        nationalParks = (TextView) findViewById(R.id.national_parks);
        nationalParks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, NationalParksActivity.class);
                startActivity(i);
            }
        });

        countryCapitalCurrency = (TextView) findViewById(R.id.country_capital_currency);
        countryCapitalCurrency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, CountryCapitalCurrencyActivity.class);
                startActivity(i);
            }
        });

        Awards = (TextView) findViewById(R.id.awards);
        Awards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, AwardsActivity.class);
                startActivity(i);
            }
        });

        importantDays = (TextView) findViewById(R.id.important_days);
        importantDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, ImportantDaysActivity.class);
                startActivity(i);
            }
        });

        firstInIndia = (TextView) findViewById(R.id.first_in_india);
        firstInIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, FirstInIndiaActivity.class);
                startActivity(i);
            }
        });

        bankingAbbreviations = (TextView) findViewById(R.id.banking_abbreviations);
        bankingAbbreviations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, BankingAbbreviationsActivity.class);
                startActivity(i);
            }
        });

        govtSchemes = (TextView) findViewById(R.id.govt_schemes);
        govtSchemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, GovtSchemesActivity.class);
                startActivity(i);
            }
        });

        damsInIndia = (TextView) findViewById(R.id.dams_in_india);
        damsInIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, DamsInIndiaActivity.class);
                startActivity(i);
            }
        });

        stateCapitals = (TextView) findViewById(R.id.state_capitals);
        stateCapitals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StaticGkActivity.this, StateCapitalsActivity.class);
                startActivity(i);
            }
        });
    }
}
