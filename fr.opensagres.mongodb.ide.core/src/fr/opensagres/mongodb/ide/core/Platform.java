package fr.opensagres.mongodb.ide.core;

import fr.opensagres.mongodb.ide.core.internal.MongoInstanceManager;
import fr.opensagres.mongodb.ide.core.internal.ServerManager;

public class Platform {

	private final static IServerManager SERVER_MANAGER_INSTANCE = new ServerManager();
	private final static IMongoInstanceManager MONGO_INSTANCE_MANAGER_INSTANCE = new MongoInstanceManager();
	private static IServerLauncherManager serverLauncherManager;

	public static IServerManager getServerManager() {
		return SERVER_MANAGER_INSTANCE;
	}

	public static IMongoInstanceManager getMongoInstanceManager() {
		return MONGO_INSTANCE_MANAGER_INSTANCE;
	}

	public static void setServerLauncherManager(
			IServerLauncherManager serverLauncherManager) {
		Platform.serverLauncherManager = serverLauncherManager;
	}

	public static IServerLauncherManager getServerLauncherManager() {
		return serverLauncherManager;
	}
}
