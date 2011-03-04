/*Really Simple Reader - An RSS feed reader for Android*/
/*       Created by B. Gokulakrishnan - 080125J        */
/* 		 	 CS3200 - Programming Project			   */

package gokul.cs3200.rsr;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * This class defines an RSSItem object which is created for reading purposes as well as
 * persistent storage if needed.
 */

public class RSSItem {

	private String title;
	private String description;
	private Date pubDate;
	private String link;

	public RSSItem(String title, String description, Date pubDate, String link) {
		this.title = title;
		this.description = description;
		this.pubDate = pubDate;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	/*This overridden method is used to extract title and publication date information for
	 * publishing in the ListView.
	 */
	@Override
	public String toString() {

		SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM \t hh:mm aa");

		String result = this.getTitle() + "\n" + sdf.format(this.getPubDate());
		return result;
	}

}
