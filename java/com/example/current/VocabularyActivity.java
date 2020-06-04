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

public class VocabularyActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListner;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListner);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView imageView = (ImageView) findViewById(R.id.signout);
        mAuth = FirebaseAuth.getInstance();

        mAuthListner = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser()==null)
                {
                    startActivity(new Intent(VocabularyActivity.this, SignInActivity.class));
                }
            }
        };

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });

        TextView aMeaning = (TextView) findViewById(R.id.a_meaning);
        TextView bb = (TextView) findViewById(R.id.b);
        TextView cc = (TextView) findViewById(R.id.c);
        TextView dd = (TextView) findViewById(R.id.d);
        TextView ee = (TextView) findViewById(R.id.e);
        TextView ff= (TextView) findViewById(R.id.f);
        TextView gg = (TextView) findViewById(R.id.g);
        TextView hh= (TextView) findViewById(R.id.h);
        TextView ii= (TextView) findViewById(R.id.i);
        TextView jj = (TextView) findViewById(R.id.j);
        TextView kk = (TextView) findViewById(R.id.k);
        TextView ll = (TextView) findViewById(R.id.l);
        TextView mm = (TextView) findViewById(R.id.m);
        TextView nn = (TextView) findViewById(R.id.n);
        TextView oo = (TextView) findViewById(R.id.o);
        TextView pp = (TextView) findViewById(R.id.p);
        TextView qq = (TextView) findViewById(R.id.q);
        TextView rr = (TextView) findViewById(R.id.r);
        TextView ss = (TextView) findViewById(R.id.s);
        TextView tt = (TextView) findViewById(R.id.t);
        TextView uu = (TextView) findViewById(R.id.u);
        TextView vv = (TextView) findViewById(R.id.v);
        TextView ww = (TextView) findViewById(R.id.w);
        TextView xx = (TextView) findViewById(R.id.x);
        TextView yy = (TextView) findViewById(R.id.y);
        TextView zz = (TextView) findViewById(R.id.z);
        aMeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, AActivity.class);
                startActivity(i);
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, BActivity.class);
                startActivity(i);
            }
        });
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, CActivity.class);
                startActivity(i);
            }
        });
        dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, DActivity.class);
                startActivity(i);
            }
        });
        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, EActivity.class);
                startActivity(i);
            }
        });
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, FActivity.class);
                startActivity(i);
            }
        });
        gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, GActivity.class);
                startActivity(i);
            }
        });
        hh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, HActivity.class);
                startActivity(i);
            }
        });
        ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, IActivity.class);
                startActivity(i);
            }
        });
        jj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, JActivity.class);
                startActivity(i);
            }
        });
        kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, KActivity.class);
                startActivity(i);
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, LActivity.class);
                startActivity(i);
            }
        });
        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, MActivity.class);
                startActivity(i);
            }
        });
        nn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, NActivity.class);
                startActivity(i);
            }
        });
        oo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, OActivity.class);
                startActivity(i);
            }
        });
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, PActivity.class);
                startActivity(i);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, QActivity.class);
                startActivity(i);
            }
        });
        rr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, RActivity.class);
                startActivity(i);
            }
        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, SActivity.class);
                startActivity(i);
            }
        });
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, TActivity.class);
                startActivity(i);
            }
        });
        uu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, UActivity.class);
                startActivity(i);
            }
        });
        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, VActivity.class);
                startActivity(i);
            }
        });
        ww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, WActivity.class);
                startActivity(i);
            }
        });
        xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, XActivity.class);
                startActivity(i);
            }
        });
        yy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, YActivity.class);
                startActivity(i);
            }
        });
        zz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VocabularyActivity.this, ZActivity.class);
                startActivity(i);
            }
        });


    }
}