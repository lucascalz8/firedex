package edu.uci.ics.configuration;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.Files;

import edu.uci.ics.exception.FiredexException;
import edu.uci.ics.utility.JsonUtility;

public class Configuration {
	private Server server;
	private Publisher publisher;
	private Output output;
	
	public Configuration(Server server, Publisher publisher, Output output) {
		this.server = server;
		this.publisher = publisher;
		this.output = output;
	}
	
	public Server getServer() {
		return (server);
	}
	
	public Publisher getPublisher() {
		return (publisher);
	}
	
	public Output getOutput() {
		return (output);
	}
	
	public static Configuration initialize(String file) throws FiredexException {
		try {
			List<String> lines = Files.readLines( new File(file), Charset.defaultCharset() );
			StringBuilder json = new StringBuilder();
			lines.forEach( (line) -> json.append(line + System.lineSeparator()) );
			Configuration configuration = JsonUtility.fromJson(json.toString(), Configuration.class);
			return (configuration);
		} catch (Exception exception) {
			throw ( new FiredexException() );
		}
	}
	
}
