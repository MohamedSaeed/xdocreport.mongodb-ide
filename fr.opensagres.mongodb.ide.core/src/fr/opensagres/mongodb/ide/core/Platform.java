package fr.opensagres.mongodb.ide.core;

import fr.opensagres.mongodb.ide.core.internal.ServerManager;

public class Platform {

	private final static IServerManager INSTANCE = new ServerManager();

	public static IServerManager getServerManager() {
		return INSTANCE;
	}
}
