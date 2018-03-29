package com.punahele.adapters.kafka;

import java.io.IOException;

public class CommandKafka {
public static void main(String[] args) throws IOException {
	String new_dir = "C:\\Kafka";
	Runtime rt = Runtime.getRuntime();
	rt.exec("cmd.exe /c cd \""+new_dir+"\" & start cmd.exe /k \" bin\\windows\\zookeeper-server-start.bat config\\zookeeper.properties\"");
}
}
