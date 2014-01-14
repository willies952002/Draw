package tk.willies952002.java.bukkitPlugins.Draw;

import java.io.File;
import java.io.FilenameFilter;

public class DrawWorldsFilter implements FilenameFilter {

	String filterName ;
	File filterDir;

	public DrawWorldsFilter(String fileNameFormat) {
		this(new File(System.getProperty("user.dir")), fileNameFormat);
	}
	
	public DrawWorldsFilter(File dir, String fileNameFormat) {
		this.filterDir = dir;
		this.filterName = fileNameFormat;
	}

	@Override
	public boolean accept(File dir, String name) {
		if ( dir.equals(filterDir) && name.contains(filterName) ) {
			return true;
		}
		return false;
	}

}
