/*
 * Copyright (C) 2023  Sombeyyy
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.sombeyyy.shops.handler.impl;

import de.sombeyyy.shops.ShopPlugin;
import de.sombeyyy.shops.handler.Handler;
import de.sombeyyy.shops.handler.ITextHandler;
import lombok.NonNull;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TextHandler extends Handler implements ITextHandler {

    private final ShopPlugin plugin;

    private final Map<String, String> messageMap;

    public TextHandler(final @NonNull ShopPlugin plugin) {
        this.plugin = plugin;
        this.messageMap = new HashMap<>();
    }

    @Override
    public void reload() {
        messageMap.clear();
        //TODO: Implement
    }

    @Override
    public void setLanguage(@NonNull String countryCode) {

    }

    @Override
    public Set<String> getLanguages() {
        return null;
    }

    @Override
    public boolean languageAvailable(@NonNull String countryCode) {
        return false;
    }

    @Override
    public Optional<String> getText(@NonNull String key) {
        return Optional.ofNullable(this.messageMap.get(key));
    }

    @Override
    public String getTextOr(@NonNull String key, @NonNull String alternative) {
        return this.messageMap.getOrDefault(key, alternative);
    }

    @Override
    public boolean sendMessage(@NonNull Player player, @NonNull String key) {
        Optional<String> message = getText(key);
        if (!message.isPresent())
            return false;
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.get()));
        return true;
    }

    @Override
    public boolean sendMessage(@NonNull Player player, @NonNull String key, @NonNull String alternative) {
        Optional<String> message = getText(key);
        if (!message.isPresent()) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', alternative));
            return false;
        }
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.get()));
        return true;
    }

}
