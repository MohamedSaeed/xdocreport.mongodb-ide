package fr.opensagres.mongodb.ide.core.model;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class Server extends TreeContainerNode<Server, TreeSimpleNode> {

	private String name;
	private String host;
	private Integer port;

	public Server(String name, String host, Integer port) {
		setName(name);
		setHost(host);
		setPort(port);
	}

	private Mongo mongo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String getLabel() {
		return name + " [" + host + ":" + port + "]";
	}

	@Override
	public NodeType getType() {
		return NodeType.Server;
	}

	@Override
	protected void doGetChildren() throws Exception {
		Mongo mongo = getMongo();
		List<String> names = mongo.getDatabaseNames();
		for (String name : names) {
			Database database = new Database(name);
			super.addNode(database);
		}
	}

	public Mongo getMongo() throws UnknownHostException, MongoException {
		if (mongo == null) {
			if (port != null) {
				mongo = new Mongo(host, port);
			} else {
				mongo = new Mongo(host);
			}
		}
		return mongo;
	}

}
