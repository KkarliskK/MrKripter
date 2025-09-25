import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main extends ListenerAdapter {

    private static final String BOT_TOKEN = "ec556610c94acd2ac07ff0035206e45f70aa0d35eebcc761eb0ae98535ff18a1";

    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault(BOT_TOKEN)
                .addEventListeners(new Main())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.awaitReady();
        System.out.println("Bot is ready!");
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // Ignore messages from other bots
        if (event.getAuthor().isBot()) {
            return;
        }

        // Get the message content
        String message = event.getMessage().getContentRaw();

        // !hellp command
        if (message.startsWith("!hello")) {
            event.getChannel().sendMessage("Hello! 👋").queue();
        }

        // Respond to !crypto command (basic example)
        if (message.startsWith("!crypto")) {
            event.getChannel().sendMessage("Bitcoin is probably going to the moon! 🚀 (This is just a placeholder - add real crypto API here)").queue();
        }
    }
}