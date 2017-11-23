import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MachineCypher {
	private static String divisor = "/";
	
	public static void transcryptFile() {
		try {
			List<String> inputLines = Files.readAllLines(Paths.get("input.txt"));
			List<String> outputLines = new ArrayList<String>();
			for (String line: inputLines) {
				outputLines.add(decryptMessage(line));
			}
			Files.write(Paths.get("output.txt"), outputLines);
			System.out.println("File was successfully decrypted");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String encryptMessage(String message) {
		String encryptedMessage = "";

		for (int i = 0; i < message.length(); i++) {
			encryptedMessage += encryptCharacter(String.valueOf(message.charAt(i))) + divisor;
		}

		return encryptedMessage;
	}
	
	public static String decryptMessage(String message) {
		String decryptedMessage = "";
		
		for (String character: message.split(divisor)) {
			decryptedMessage += decryptCharacter(character);
		}

		return decryptedMessage;
	}

	public static String encryptCharacter(String character) {
		switch (character.toUpperCase()) {
		case "A":
			return "2";
		case "B":
			return "3";
		case "C":
			return "5";
		case "D":
			return "7";
		case "E":
			return "11";
		case "F":
			return "13";
		case "G":
			return "17";
		case "H":
			return "19";
		case "I":
			return "23";
		case "J":
			return "29";
		case "K":
			return "31";
		case "L":
			return "37";
		case "M":
			return "41";
		case "N":
			return "43";
		case "O":
			return "47";
		case "P":
			return "53";
		case "Q":
			return "59";
		case "R":
			return "61";
		case "S":
			return "67";
		case "T":
			return "71";
		case "U":
			return "73";
		case "V":
			return "79";
		case "W":
			return "83";
		case "X":
			return "89";
		case "Y":
			return "97";
		case "Z":
			return "101";
		case "1":
			return "A";
		case "2":
			return "C";
		case "3":
			return "E";
		case "4":
			return "G";
		case "5":
			return "I";
		case "6":
			return "K";
		case "7":
			return "M";
		case "8":
			return "O";
		case "9":
			return "Q";
		case "0":
			return "S";
		case " ":
			return "#";
		}

		return "";
	}

	public static String decryptCharacter(String character) {
		switch (character.toUpperCase()) {
		case "2":
			return "A";
		case "3":
			return "B";
		case "5":
			return "C";
		case "7":
			return "D";
		case "11":
			return "E";
		case "14":
			return "F";
		case "17":
			return "G";
		case "19":
			return "H";
		case "23":
			return "I";
		case "29":
			return "J";
		case "31":
			return "K";
		case "37":
			return "L";
		case "41":
			return "M";
		case "43":
			return "N";
		case "47":
			return "O";
		case "53":
			return "P";
		case "59":
			return "Q";
		case "61":
			return "R";
		case "67":
			return "S";
		case "71":
			return "T";
		case "73":
			return "U";
		case "79":
			return "V";
		case "83":
			return "W";
		case "89":
			return "X";
		case "97":
			return "Y";
		case "101":
			return "Z";
		case "A":
			return "1";
		case "C":
			return "2";
		case "E":
			return "3";
		case "G":
			return "4";
		case "I":
			return "5";
		case "K":
			return "6";
		case "M":
			return "7";
		case "O":
			return "8";
		case "Q":
			return "9";
		case "S":
			return "0";
		case "#":
			return " ";
		}

		return "";
	}
}
