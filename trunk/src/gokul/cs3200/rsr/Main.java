package gokul.cs3200.rsr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/*
 This class provides the main activity which acts as the primary user interface which interacts with
 the user as well as acting as a central command point which calls other activities.
 */

public class Main extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.facade);

		final TextView rssURLTV = (TextView) findViewById(R.id.enteredFeedUrl);

		Button getFile = (Button) findViewById(R.id.getFile);
		getFile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ReallySimpleReader.feedUrl = rssURLTV.getText().toString();
				Intent intent2 = new Intent("gokul.cs3200.rsr.fileview");
				startActivity(intent2);

			}
		});

		Button getFeed = (Button) findViewById(R.id.getFeed);
		getFeed.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ReallySimpleReader.feedUrl = rssURLTV.getText().toString();
				ReallySimpleReader.isLive = true;

				Intent intent1 = new Intent("gokul.cs3200.rsr.reader");
				startActivity(intent1);

			}
		});

	}

}
