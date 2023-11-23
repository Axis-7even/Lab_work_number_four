package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private int mScore1;
	private int mScore2;
	private TextView mScoreText1;
	private TextView mScoreText2;
	static final String STATE_SCORE_1 = "Team 1 Score";

	static final String STATE_SCORE_2 = "Team 2 Score";
	private static final String TAG = "MyActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mScoreText1 = (TextView)findViewById(R.id.score_1);
		mScoreText2 = (TextView)findViewById(R.id.score_2);
		if (savedInstanceState != null) {

			mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
			mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
			mScoreText1.setText(String.valueOf(mScore1));
			mScoreText2.setText(String.valueOf(mScore2));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		int nightMode = AppCompatDelegate.getDefaultNightMode();
		if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
			menu.findItem(R.id.theme_mode).setTitle(R.string.day_mode);
		} else{
			menu.findItem(R.id.theme_mode).setTitle(R.string.night_mode);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		int nightMode = AppCompatDelegate.getDefaultNightMode();
		if(nightMode == AppCompatDelegate.MODE_NIGHT_YES)
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
		else
			AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
		return true;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putInt(STATE_SCORE_1, mScore1);
		outState.putInt(STATE_SCORE_2, mScore2);
		super.onSaveInstanceState(outState);
	}

	public void decreaseScore(View view) {
		int viewID = view.getId();
		if(viewID == R.id.decreaseTeam1){
			mScore1--;
			mScoreText1.setText(String.valueOf(mScore1));
		}
		if(viewID == R.id.decreaseTeam2) {
			mScore2--;
			mScoreText2.setText(String.valueOf(mScore2));
		}
	}

	public void increaseScore(View view) {
		int viewID = view.getId();
		if (viewID == R.id.increaseTeam1) {
			mScore1++;
			mScoreText1.setText(String.valueOf(mScore1));
		}
		if (viewID == R.id.increaseTeam2) {
			mScore2++;
			mScoreText2.setText(String.valueOf(mScore2));
		}
	}
}