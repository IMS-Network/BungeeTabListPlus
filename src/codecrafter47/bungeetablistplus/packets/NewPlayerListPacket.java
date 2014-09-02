/*
 * BungeeTabListPlus - a bungeecord plugin to customize the tablist
 *
 * Copyright (C) 2014 Florian Stober
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package codecrafter47.bungeetablistplus.packets;

import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.protocol.packet.PlayerListItem;
import net.md_5.bungee.protocol.packet.PlayerListItem.Item;

/**
 *
 * @author Florian Stober
 */
public class NewPlayerListPacket implements IPlayerListPacket {

    @Override
    public void createOrUpdatePlayer(Connection.Unsafe connection, String player,
            int ping) {
        PlayerListItem t = new PlayerListItem();
        t.setAction(PlayerListItem.Action.ADD_PLAYER);
        Item i = new Item();
        i.setDisplayName(" ");
        i.setGamemode(1);
        i.setPing(ping);
        i.setUsername(player);
        connection.sendPacket(t);
    }

    @Override
    public void removePlayer(Connection.Unsafe connection, String player) {
        //connection.sendPacket(new PlayerListItem(player, false, 9999));
    }

    @Override
    public void updatePlayer(Connection.Unsafe connection, String player,
            String name,
            int ping) {
        PlayerListItem t = new PlayerListItem();
        t.setAction(PlayerListItem.Action.UPDATE_DISPLAY_NAME);
        Item i = new Item();
        i.setDisplayName(name);
        i.setGamemode(0);
        i.setPing(ping);
        i.setUsername(player);
        connection.sendPacket(t);
    }
}
