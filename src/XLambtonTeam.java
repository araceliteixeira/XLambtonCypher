import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XLambtonTeam {
	public static void main(String[] args) {
		List<Agent> agents = new ArrayList<Agent>();
		
		try {
			List<String> lines = Files.readAllLines(Paths.get("file.txt"));
			int index = 0;
			Agent agent = new Agent();
			for (String line: lines) {
				if (!line.isEmpty()) {
					switch(index) {
						case 0:
							agent = new Agent();
							agent.setName(line);
							index++;
							break;
						case 1:
							agent.setOperation(line);
							index++;
							break;
						case 2:
							agent.setCountry(line);
							index++;
							break;
						case 3:
							agent.setDateAsString(line);
							index++;
							break;
						case 4:
							agent.setAgency(line);
							agents.add(agent);
							index = 0;
							break;
					}
				}
			}
			System.out.println("File was successfully loaded");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Agent a: agents) {
			System.out.println("Agent:");
			System.out.println(a.getName());
			System.out.println(a.getOperation());
			System.out.println(a.getCountry());
			System.out.println(a.getDateAsString());
			System.out.println(a.getAgency());
			System.out.println();
		}
	}
}
