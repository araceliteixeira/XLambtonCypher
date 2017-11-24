import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class XLambtonTeam {
	private static List<Agent> agents;
	private static List<Team> teams;
	private static Scanner scanner;
	
	public static void main(String[] args) {
		loadAgents();
		scanner = new Scanner(System.in);
		
        try {
            while (true) {
            		System.out.println("XLambton - Global Agencies Cooperation");
            		System.out.println("");
            		System.out.println("Menu");
            		System.out.println("1: Create teams");
            		System.out.println("2: Generate reports");
            		System.out.println("0: Exit");
            		System.out.println("");
            		String option = "";
            		do {
	            		System.out.println("Please select one option:");
	            		option = readInput();
            		} while (!option.equals("1") && !option.equals("2"));
            		if (option.equals("1")) {
            			createTeams();
            		} else {
            			generateReports();
            		}
            }
        } catch(IllegalStateException | NoSuchElementException e) {
            // System.in has been closed
            System.out.println("System.in was closed; exiting");
        }
	}
	
	public static void loadAgents() {
		agents = new ArrayList<Agent>();
		
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
	}
	
	public static void createTeams() {
		try {
            while (true) {
            		Team team = new Team();
            		
                System.out.println("Type the team's code or 0 to return to main menu:");
                String code = scanner.nextLine();
                if (code.equals("0")) {
                		return;
                }
                team.setCode(code);
                
                do {
	                System.out.println("Type the team's start date (DDMMYYYY):");
	                try {
						team.setStartDateAsString(scanner.nextLine());
					} catch (ParseException e) {
						System.out.println("Invalid date format.");
					}
                } while (team.getStartDate() == null);
                
                do {
	                System.out.println("Type the team's end date (DDMMYYYY):");
	                try {
	                		team.setEndDateAsString(scanner.nextLine());
					} catch (ParseException e) {
						System.out.println("Invalid date format.");
					}
                } while (team.getEndDate() == null);
                
                String option = "";
                do {
                		System.out.println("Proceed to Select agents (s) or Restart the process (r)?");
                		option = scanner.nextLine();
                } while (!option.toLowerCase().equals("s") && !option.toLowerCase().equals("r"));
                if (option.toLowerCase().equals("s")) {
                		selectAgents(team);
                }
            }
        } catch(IllegalStateException | NoSuchElementException e) {
            // System.in has been closed
            System.out.println("System.in was closed; exiting");
        }
	}
	
	public static void selectAgents(Team team) {
		while(true) {
			System.out.println("Select the agents for team code " + team.getCode() + ":");
			System.out.println("");
			int index = 1;
			for (Agent a: agents) {
				System.out.println(index + ":\t" + a.getName() + " (" + a.getAgency() 
					+ ") from " + a.getCountry());
				index++;
			}
			System.out.println("Type the agents numbers separated by a ';':");
			String[] numbers = scanner.nextLine().split(";");
			List<Agent> selectedAgents = new ArrayList<>();
			try {
				for (String number: numbers) {
					int n = Integer.parseInt(number);
					selectedAgents.add(agents.get(n));
				}
				System.out.println("Do you confirm the assignment of the following agents to this team?");
				for (Agent a: selectedAgents) {
					System.out.println(a.getName() + " (" + a.getAgency() + ") from " + a.getCountry());
				}
				System.out.println("Yes (y), No (n) or 0 to return to main menu:");
				scanner.nextLine();
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection. Try again.");
			}
		}
	}
	
	public static void generateReports() {
		
	}
	
	private static String readInput() {
		try {
            String line = scanner.nextLine();
            if (line.equals("0")) {
            		System.out.println("End of program.");
            		System.exit(0);
            } else {
            		return line;
            }
        } catch(IllegalStateException | NoSuchElementException e) {
            // System.in has been closed
            System.out.println("System.in was closed; exiting");
        }
		return null;
	}
}
