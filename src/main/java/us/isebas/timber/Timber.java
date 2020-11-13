package us.isebas.timber;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.apache.logging.log4j.Logger;
import org.loomdev.api.ApiVersion;
import org.loomdev.api.block.BlockPointer;
import org.loomdev.api.entity.player.Player;
import org.loomdev.api.event.block.entity.EntityBlockBreakEvent;
import org.loomdev.api.plugin.annotation.LoomPlugin;
import org.loomdev.api.plugin.PluginManager;
import org.loomdev.api.event.block.sign.SignWriteEvent;
import org.loomdev.api.plugin.hooks.Hook;
import org.loomdev.api.plugin.hooks.PluginEnableHook;
import org.loomdev.api.server.Server;
import org.loomdev.api.event.Subscribe;
import org.loomdev.api.world.World;
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
        authors = "isebasus",
        minimumApiVersion = ApiVersion.UNKNOWN
)

public class Timber {

    @Inject
    private Server server;

    @Inject
    private Logger logger;

    @Inject
    public Timber(Logger logger) {
        logger.info("Plugin load");
    }

    private Integer i = 0;
    private final Map<Integer, ArrayList<BlockPos>> map = new HashMap<>();

    @Hook
    public void onPluginEnable(PluginEnableHook hook) {
        logger.info("Hello, enabling the plugin.");
        server.getCommandManager().register(this, new BrokenBlockCommand(map));
        logger.info(this.server != null);
    }

    @Hook
    public void onPluginDisable() {
        logger.info("Bye, disabling the plugin.");
    }

    public void onSign(SignWriteEvent event) {
        List<String> text = event.getText();
        text.set(1, "tektoolbithc");
    }

    @Subscribe
    public void onBlockBroken(EntityBlockBreakEvent event) {
        i++;
        BlockPointer block = event.getBlock();
        int x = (int) block.getLocation().getX();
        int y = (int) block.getLocation().getY();
        int z = (int) block.getLocation().getZ();

        BlockPos pos = new BlockPos(new int[]{x, y, z}, block.getBlockType());
        ArrayList<BlockPos> blockPos = new ArrayList<>();
        blockPos.add(pos);


        map.put(i, blockPos);
        new WoodType(block, event.getEntity().getWorld(), x, y, z);

    }



}
