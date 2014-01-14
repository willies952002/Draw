package tk.willies952002.java.bukkitPlugins.Draw;

import java.io.File;

public class WorldDeleter implements Runnable {

	private File[] worldFiles;

	public WorldDeleter(File[] files) {
		this.worldFiles = files;
	}

	@Override
	public void run() {
		try { deleteFiles(worldFiles); }
		catch (Exception e) { e.printStackTrace(); }
	}
	
	public static void deleteFiles(File[] files) throws Exception {
		for ( File file : files ) {
			if ( file.isDirectory() ) {
				deleteFiles(file.listFiles());
			}
			else if ( file.isFile() ) {
				file.delete();
			}
		}
	}

}
