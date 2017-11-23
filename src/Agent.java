import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agent {

	private String name;
	private String operation;
	private String country;
	private Date date;
	private String agency;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getDateAsString() {
		Format formatter = new SimpleDateFormat("ddMMyyyy");
		return formatter.format(date);
	}
	public void setDateAsString(String date) {
		DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		try {
			this.date = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
