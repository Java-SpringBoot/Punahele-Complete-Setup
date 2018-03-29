package com.punahele.adapters.command_prompt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServerManagement {
	static String new_dir = "C:\\Kafka";

	public static List<String> readCommands() {
		String fileName = "Commandlist";
		List<String> commandList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			commandList = stream.filter(line -> !line.startsWith("#")).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return commandList;
	}

	public static void main(String[] args) throws IOException {
		executeCommands(readCommands());

	}

	public static void executeCommands(List<String> commands) {
		for (String cmd : commands) {
			try {
				Runtime rt = Runtime.getRuntime();
				rt.exec("cmd.exe /c cd \"" + new_dir
						+ "\" & start cmd.exe /k"+cmd);
				Thread.sleep(3000);
			} catch (IOException | InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
