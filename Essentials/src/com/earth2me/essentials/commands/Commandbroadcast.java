package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import static com.earth2me.essentials.I18n.tl;
import com.earth2me.essentials.User;
import com.earth2me.essentials.utils.FormatUtil;
import org.bukkit.Server;

public class Commandbroadcast extends EssentialsCommand {

    public Commandbroadcast() {
        super("broadcast");
    }

    @Override
    public void run(final Server server, final User user, final String commandLabel, final String[] args) throws Exception {
        sendBroadcast(user.getDisplayName(), args);
    }

    @Override
    public void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
        sendBroadcast(sender.getSender().getName(), args);
    }

    private void sendBroadcast(final String name, final String[] args) throws NotEnoughArgumentsException {
        if (args.length < 1) {
            throw new NotEnoughArgumentsException();
        }

        ess.broadcastMessage(tl("broadcast", FormatUtil.replaceFormat(getFinalArg(args, 0)).replace("\\n", "\n"), name));
    }
}
