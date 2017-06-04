package com.example.android.jokes_display_library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.ButterKnife;


/**
 * Created by Dawid on 2017-06-04.
 */

public class JokesDisplayActivity extends AppCompatActivity {

        public static final String JOKE = "JOKE";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_jokes_display);

            if (getIntent() != null && getIntent().hasExtra(JOKE)) {
                TextView jokeTextView = ButterKnife.findById(this, R.id.text_view_joke);
                jokeTextView.setText(getIntent().getStringExtra(JOKE));
            }

            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId())
            {
                case (android.R.id.home):
                default:
                    onBackPressed();
            }
            return super.onOptionsItemSelected(item);
        }
}