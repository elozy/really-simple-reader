/*Really Simple Reader - An RSS feed reader for Android*/
/*       Created by B. Gokulakrishnan - 080125J        */
/* 		 	 CS3200 - Programming Project			   */

package gokul.cs3200.rsr;

import gokul.cs3200.rsr.R;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * This class is used to create the displayRSSItems Activity which is triggered when an item in the
 * ListView is selected.
 */

public class RSSItemDisplayer extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rss_item_displayer);

		this.setTitle(gokul.cs3200.rsr.ReallySimpleReader.RSSTitle);
		RSSItem selectedRssItem = gokul.cs3200.rsr.ReallySimpleReader.selectedItem;

		TextView titleTv = (TextView) findViewById(R.id.titleTextView);
		TextView contentTv = (TextView) findViewById(R.id.contentTextView);

		SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM \t hh:mm aa");
		String title = "";
		title = "\n" + selectedRssItem.getTitle() + "\n\t\t"
				+ sdf.format(selectedRssItem.getPubDate()) + " \n";

		String content = "";
		content += "\n" + selectedRssItem.getDescription() + "\n"
				+ selectedRssItem.getLink();

		titleTv.setText(title);
		contentTv.setText(content);
	}
}