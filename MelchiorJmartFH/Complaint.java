package MelchiorJmartFH;

import java.util.Date;
import java.text.*;

public class Complaint extends Recognizable {
	public Date date;
	public String desc;

	public Complaint(String desc) {
		this.desc = desc;
	}

	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String dateForm = dateFormat.format(this.date);
		return "{date = " + dateForm + "desc = '" + this.desc + "'}";
	}

}
