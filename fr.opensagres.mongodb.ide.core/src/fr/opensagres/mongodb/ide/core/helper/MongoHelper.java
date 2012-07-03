package fr.opensagres.mongodb.ide.core.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MongoHelper {

	// see http://eric.lemerdy.free.fr/dotclear/index.php?post/2012/03/11/Start-and-stop-mongodb-with-Junit-in-java
	private static List startMongoDBAsADaemon() throws IOException,
			InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder(
				"../../mongodb-osx-x86_64-2.0.3/bin/mongod", "--dbpath",
				"dbpath", "--fork", "--logpath", "logpath");
		processBuilder.directory(new File("target"));
		processBuilder.redirectErrorStream(true);
		Process pwd = processBuilder.start();
		BufferedReader outputReader = new BufferedReader(new InputStreamReader(
				pwd.getInputStream()));
		String output;
		List lines = new ArrayList();
		while ((output = outputReader.readLine()) != null) {
			lines.add(output.toString());
		}
		pwd.waitFor();
	//	assertThat(pwd.exitValue()).isEqualTo(0);
		return lines;
	}
}
