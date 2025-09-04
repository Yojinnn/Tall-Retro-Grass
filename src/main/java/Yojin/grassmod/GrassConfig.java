package Yojin.grassmod;

import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;


public class GrassConfig {
	private static final Toml TOML = new Toml("TestMod's TOML Config");
	public static final TomlConfigHandler CFG;

	static {
		TOML.addCategory("IDs")
			.addEntry("startingItemID", "Default: 22000", 22000) // id that your items id start with (please change id to something else)
			.addEntry("startingBlockID", "Default: 7005", 7005); // id that your blocks id start with (please change id to something else)

		CFG = new TomlConfigHandler(Grassmod.MOD_ID, TOML);
	}
}
