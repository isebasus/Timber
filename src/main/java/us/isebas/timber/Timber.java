package us.isebas.timber;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.apache.logging.log4j.Logger;
import org.loomdev.api.plugin.LoomPlugin;

import org.loomdev.api.plugin.Plugin;
import org.loomdev.api.server.Server;
import org.loomdev.api.config.Configuration;
import org.loomdev.api.entity.decoration.ArmorStand;
import org.loomdev.api.event.Subscribe;
import org.loomdev.api.event.entity.decoration.ArmorStandPlacedEvent;
import org.loomdev.api.event.player.PlayerMessagedEvent;
import org.loomdev.api.event.player.connection.PlayerJoinedEvent;
import org.loomdev.api.event.server.ServerPingedEvent;
import org.loomdev.api.plugin.Plugin;
import org.loomdev.api.plugin.annotation.Config;
import org.loomdev.api.server.Server;
import org.loomdev.api.util.ChatColor;

import javax.inject.Inject;

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

    @Override
    public void onPluginEnable() {
        logger.info("Hello, enabling the plugin.");
        logger.info(this.server != null);
    }

    @Override
    public void onPluginDisable() {
        logger.info("Bye, disabling the plugin.");
    }

    @Subscribe
    public void onChat(PlayerMessagedEvent event) {
        event.setPrefix(TextComponent.builder()
                .append(event.getPlayer().getDisplayName())
                .append(TextComponent.of(": ").color(TextColor.fromHexString("#AAAAAA")))
                .build()
        );
        event.setMessage(event.getMessage().orElse(TextComponent.empty()).color(TextColor.fromHexString("#94d1ff")));
    }

}
