package us.isebas.timber.util;

import us.isebas.timber.Timber;
import net.kyori.adventure.text.TextComponent;
import org.loomdev.api.block.Block;
import org.loomdev.api.command.Command;
import org.loomdev.api.command.CommandSource;
import org.loomdev.api.entity.player.Player;
import org.loomdev.api.event.block.BlockBreakEvent;
import org.loomdev.api.plugin.Plugin;
import org.loomdev.api.util.ChatColor;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.List;
import java.util.Map;

public class BrokenBlockCommand extends Command {

    private Block block;
    private final Map<Integer, ArrayList<BlockPos>> map;
    private int[] posistions = new int[]{};

    public BrokenBlockCommand(Map<Integer, ArrayList<BlockPos>> map) {
        super("getBlocks");
        this.map = map;
        setDescription("Get locations of last block broken.");
    }

    @Override
    public void execute(CommandSource commandSource, String[] strings) {
        Player player = (Player) commandSource;
        String mapString = "";

        for (Integer key : map.keySet()) {
            ArrayList<BlockPos> arList = map.get(key);
            for (BlockPos bp : arList) {
                posistions = bp.pos;
                block = bp.block;
            }
            mapString += " " + key.toString() + ": " + Arrays.toString(posistions);
        }

        commandSource.sendMessage(TextComponent.of("Heres yo mf block").color(ChatColor.RED));
        commandSource.sendMessage(TextComponent.of(mapString).color(ChatColor.GOLD));


    }
}