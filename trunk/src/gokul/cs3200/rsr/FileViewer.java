package gokul.cs3200.rsr;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/*
 * This class generates FileViewer activity which is used to select a file from the device's SD
 * card storage. Once a file has been selected, it is also responsible for transferring the file
 * to the reader activity.
 */

public class FileViewer extends Activity {

	private ListView fileView;
	private File[] files;
	File fi, f;
	AlertDialog.Builder builder1;

	ArrayAdapter<String> ad;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_list);

		fileView = (ListView) findViewById(R.id.file_list);

		fi = new File("/sdcard/Saved RSS Feeds/");
		files = fi.listFiles();

		process(fi);

		fileView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> av, View view, int index,
					long arg3) {

				f = files[index];
				process(f);
			}
		});

	}

	/*
	 * This method listens for user clicks on the FileViewer interface and processes the selected
	 * file accordingly: If a folder is selected, it opens the folder and if a valid .rss file is
	 * selected, it is sent for processing by the DOM engine.
	 */
	
	void process(File fl) {
		if (fl.isFile()) {

			ReallySimpleReader.openedFileName = fl;
			ReallySimpleReader.isLive = false;

			Intent intent = new Intent("gokul.cs3200.rsr.reader");
			startActivity(intent);

		} else {
			File[] newfiles = fl.listFiles();
			if (newfiles.length > 0) {
				String[] filesByName = new String[newfiles.length];
				for (int i = 0; i < newfiles.length; i++) {
					filesByName[i] = newfiles[i].getName();
				}
				ad = new ArrayAdapter<String>(this, R.layout.list_item,
						filesByName);
				fileView.setAdapter(ad);

				ad.notifyDataSetChanged();
			} else {
				builder1 = new AlertDialog.Builder(this);
				builder1.setMessage("There are no locally stored files.")
						.setCancelable(false).setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										FileViewer.this.finish();
									}
								});
				AlertDialog alert1 = builder1.create();
				alert1.show();
			}
		}

	}

}
