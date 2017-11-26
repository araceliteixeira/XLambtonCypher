import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class XLambtonTeam {
	private static List<Agent> agents;
	private static List<Team> teams;
	private static Scanner scanner;

	public static void main(String[] args) {
		loadAgents();
		teams = new ArrayList<>();
		scanner = new Scanner(System.in);

		while (true) {
			System.out.println("XLambton - Global Agencies Cooperation");
			System.out.println("");
			System.out.println("Menu");
			System.out.println("1: Create teams");
			System.out.println("2: Generate reports");
			System.out.println("0: Exit");
			String option = readInputWithMessage(
					"Please select one option:", "0", "1", "2");
			if (option.equals("0")) {
				System.out.println("End of program.");
				System.exit(0);
			} else if (option.equals("1")) {
				createTeams();
			} else {
				generateReports();
			}	
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String readInput() {
		String line = "";
		try {
			while (line.isEmpty()) {
				line = scanner.nextLine().trim();
			}
		} catch(IllegalStateException | NoSuchElementException e) {
			System.out.println("System.in was closed; exiting");
		}
		return line;
	}
	
	private static String readInputWithMessage(String message, String... options) {
		String option = "";
		List<String> list = Arrays.asList(options);
		do {
			System.out.println(message);
			option = readInput().toLowerCase();
		} while (!list.contains(option));
		return option;
	}

	public static void createTeams() {

		while (true) {
			Team team = new Team();

			System.out.println("\nType the team's code or 0 to return to main menu:");
			String code = readInput();
			if (code.equals("0")) {
				return;
			}
			team.setCode(code);

			do {
				System.out.println("Type the team's start date (DDMMYYYY):");
				try {
					team.setStartDateAsString(readInput());
				} catch (ParseException e) {
					System.out.println("Invalid date format.");
				}
			} while (team.getStartDate() == null);

			do {
				System.out.println("Type the team's end date (DDMMYYYY):");
				try {
					team.setEndDateAsString(readInput());
				} catch (ParseException e) {
					System.out.println("Invalid date format.");
				}
			} while (team.getEndDate() == null);

			String option = readInputWithMessage(
					"Proceed to Select agents (s) or Restart the process (r)?", "s", "r");

			if (option.toLowerCase().equals("s")) {
				selectAgents(team);
			}
		}
	}

	public static void selectAgents(Team team) {
		while (true) {
			System.out.println("\nSelect the agents for team code " + team.getCode() + ":");
			System.out.println("");
			int index = 1;
			for (Agent a: agents) {
				System.out.println(index + ":\t" + a.getName() + " (" + a.getAgency() 
				+ ") from " + a.getCountry());
				index++;
			}

			List<Agent> selectedAgents = new ArrayList<>();
			while (true) {
				System.out.println("Type the numbers separated by ',':");
				String[] numbers = readInput().split(",");
				try {
					for (String number: numbers) {
						index = Integer.parseInt(number.trim()) - 1;
						selectedAgents.add(agents.get(index));
					}
					break;
				} catch (NumberFormatException | IndexOutOfBoundsException e) {
					System.out.println("Invalid selection. Try again.");
				}
			}
			System.out.println("Do you confirm the assignment of the following agent(s) to this team?");
			for (Agent a: selectedAgents) {
				System.out.println(a.getName() + " (" + a.getAgency() + ") from " + a.getCountry());
			}
			System.out.println("");
			String option = readInputWithMessage(
					"Yes, save this team (y), No, select agents again (n) or "
					+ "0 to cancel this team and return to team menu:", "y", "n", "0");
			if (option.equals("0")) {
				return;
			} else if (option.toLowerCase().equals("y")) {
				teams.add(team);
				System.out.println("The team " + team.getCode() + " was successfully saved.");
				return;
			}
		}
	}

	public static void generateReports() {
		while (true) {
			System.out.println("\nChoose the report:");
			System.out.println("1: How many agents are allocated in a specific team");
			System.out.println("2: Teams that are working in a specific date");
			System.out.println("3: Which agency has more agents");
			System.out.println("4: How many teams are assigned to a specific agency");
			System.out.println("5: How many agents per agency");
			System.out.println("0: Return to main menu");
			String option = readInputWithMessage(
					"Please select one option:", "0", "1", "2", "3", "4", "5");
			switch (option) {
				case "1":
					report1();
					break;
				case "2":
					report2();
					break;
				case "3":
					report3();
					break;
				case "4":
					report4();
					break;
				case "5":
					report5();
					break;
				case "0":
					return;
			}
		}
	}

	private static void report1() {
		
	}

	private static void report2() {
		
	}

	private static void report3() {
		
	}

	private static void report4() {
		
	}

	private static void report5() {
		
	}
}
