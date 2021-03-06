/*
 * Copyright (C) 2016-2017 David Alejandro Rubio Escares / Kodehawa
 *
 * Mantaro is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Mantaro is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mantaro.  If not, see http://www.gnu.org/licenses/
 */

package net.kodehawa.mantarobot.core.modules.commands;

import lombok.Getter;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.kodehawa.mantarobot.core.modules.commands.base.Category;
import net.kodehawa.mantarobot.core.modules.commands.base.Command;
import net.kodehawa.mantarobot.core.modules.commands.base.CommandPermission;
import net.kodehawa.mantarobot.options.Option;

@Getter
public class AliasCommand implements Command {
    private final Command command;
    private final String commandName;

    public AliasCommand(String commandName, Command command) {
        this.commandName = commandName;
        this.command = command;
    }

    @Override
    public Category category() {
        return null; //Alias Commands are hidden
    }

    @Override
    public MessageEmbed help(GuildMessageReceivedEvent event) {
        return command.help(event);
    }

    @Override
    public CommandPermission permission() {
        return command.permission();
    }

    @Override
    public void run(GuildMessageReceivedEvent event, String ignored, String content) {
        command.run(event, commandName, content);
    }

    @Override
    public Command addOption(String call, Option option) {
        Option.addOption(call, option);
        return this;
    }
}
