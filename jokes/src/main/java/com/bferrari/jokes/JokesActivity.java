package com.bferrari.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    private TextView mJokeTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokes_activity);

        String joke = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        mJokeTv = findViewById(R.id.joke);
        mJokeTv.setText(joke);
    }
}
