import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Team {

	private String code;
	private Date startDate;
	private Date endDate;
	private List<Agent> agents;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	public String getStartDateAsString() {
		Format formatter = new SimpleDateFormat("ddMMyyyy");
		return formatter.format(startDate);
	}
	public void setStartDateAsString(String startDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		this.startDate = formatter.parse(startDate);
	}
	public String getEndDateAsString() {
		Format formatter = new SimpleDateFormat("ddMMyyyy");
		return formatter.format(endDate);
	}
	public void setEndDateAsString(String endDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		this.endDate = formatter.parse(endDate);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}
