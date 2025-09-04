package Yojin.grassmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class Grassmod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "grassmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {

		GrassBlock.initBlocks();


		LOGGER.info("Grass Mod initialized.");
	}




	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}
}
