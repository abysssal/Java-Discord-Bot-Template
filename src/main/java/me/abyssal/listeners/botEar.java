package me.abyssal.listeners;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class botEar extends ListenerAdapter {

    private final Dotenv config = Dotenv.configure().load();
    private final String guildID = config.get("GUILD_ID");
    private final String mainChannelID = config.get("MAIN_CHANNEL_ID");

    @Override
    @NotNull
    public void onReady(@NotNull ReadyEvent event) {
        TextChannel mainChan = Objects.requireNonNull(event.getJDA().getGuildById(guildID).getTextChannelById(mainChannelID));
        mainChan.sendMessage("ready").queue();
    }
}
