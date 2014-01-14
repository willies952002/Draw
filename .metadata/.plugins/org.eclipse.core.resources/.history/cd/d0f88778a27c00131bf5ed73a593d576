package tk.willies952002.java.bukkitPlugins.Draw;

import java.awt.EventQueue;
import java.io.File;

import org.bukkit.Server;

public class WorldReloader {

	private static Server miniGameServer;
	@SuppressWarnings("unused")
	private static File[] subDirFiles;

	public WorldReloader(Server server) {
		WorldReloader.miniGameServer = server;
	}

	public static void main(String[] args) throws Exception {
		File srvrDir = new File(miniGameServer.getUpdateFolderFile().getAbsolutePath());
		File[] worldFiles = srvrDir.listFiles(new DrawWorldsFilter(srvrDir, "DrawMinigame"));
		EventQueue.invokeAndWait(new WorldDeleter(worldFiles));
		EventQueue.invokeAndWait(new WorldUnpacker("DrawMinigame"));
	}

}
