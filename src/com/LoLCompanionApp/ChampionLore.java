package com.LoLCompanionApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChampionLore extends Activity {

	private String champion;
	private DatabaseMain database;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.champlore);

		database = new DatabaseMain(this);
		champion = getIntent().getStringExtra("name");

		createHeader();

		// set lore text to text view
		TextView lore = (TextView) findViewById(R.id.loreText);
		lore.setText(database.getChampionLore(champion));
	}

	private void createHeader() {
		// Creates header
		TextView champName = (TextView) findViewById(R.id.champName);
		TextView champTitle = (TextView) findViewById(R.id.champTitle);
		ImageView champImage = (ImageView) findViewById(R.id.champPicture);
		champName.setText(champion);
		String champPic = database.removeSpecialChars(champion);
		int path = getResources().getIdentifier(
				champPic.toLowerCase() + "_square_0", "drawable",
				"com.LoLCompanionApp");

		champTitle.setText(database.getChampionTitle(champion));
		champImage.setImageResource(path);
	}


	public void back(View view) {
		finish();
	}
}
