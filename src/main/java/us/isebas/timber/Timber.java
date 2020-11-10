package us.isebas.timber;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.apache.logging.log4j.Logger;
import org.loomdev.api.block.Block;
import org.loomdev.api.plugin.annotation.LoomPlugin;
import org.loomdev.api.plugin.Plugin;
import org.loomdev.api.server.Server;
import org.loomdev.api.event.Subscribe;
import us.isebas.timber.util.BlockPos;
import us.isebas.timber.util.BrokenBlockCommand;
import org.loomdev.api.block.BlockType;
import org.loomdev.api.event.player.PlayerChatEvent;
import org.loomdev.api.event.block.BlockBreakEvent;
import us.isebas.timber.util.WoodType;

import javax.inject.Inject;
import java.util.*;

@LoomPlugin(
        id = "timber",
        name = "Timber Plugin",
        description = "A plugin that cuts down trees",
        version = "V0.1",
        authors = { "isebasus" }
)

public class Timber implements Plugin{

    @Inject
    private Server server;

    @Inject
    private Logger logger;

    @Inject
    public Timber(Logger logger) {
        logger.info("Plugin load");
    }

    private Integer i = 0;
    private Map<Integer, ArrayList<BlockPos>> map = new HashMap<>();

    @Override
    public void onPluginEnable() {
        logger.info("Hello, enabling the plugin.");
        server.getCommandManager().register(this, new BrokenBlockCommand(map));
        logger.info(this.server != null);
    }

    @Override
    public void onPluginDisable() {
        logger.info("Bye, disabling the plugin.");
    }


    @Subscribe
    public void onBlockBroken(BlockBreakEvent event) {
        i++;
        Block block = event.getBlock();
        BlockType blockType = block.getType();
        //WoodType woodtype = new WoodType(blockType);

        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();

        BlockPos pos = new BlockPos(new int[]{x, y, z}, block);
        ArrayList<BlockPos> blockPos = new ArrayList<>();
        blockPos.add(pos);

        if (map.size() > 5) {
            map = Collections.emptyMap();
        }

        map.put(i, blockPos);

    }



}
