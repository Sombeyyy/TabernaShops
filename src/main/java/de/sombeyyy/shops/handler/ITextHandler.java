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

package de.sombeyyy.shops.handler;

import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.Set;

public interface ITextHandler {

    /**
     * Loads all messages for the specified language, using country codes.
     * If the country code is invalid, the default ({@code en-US}) is used.
     *
     * @param countryCode the country code
     */
    void setLanguage(final @NonNull String countryCode);

    /**
     * Returns a set of all possible country codes.
     *
     * @return the country codes
     */
    Set<String> getLanguages();

    /**
     * Checks if the country code is supported.
     *
     * @param countryCode the country code
     * @return {@code true} if the country code is supported, otherwise {@code false}
     */
    boolean languageAvailable(final @NonNull String countryCode);

    /**
     * Returns an {@link Optional} that is either empty or contains the text
     * that the key represents.
     *
     * @param key the key
     * @return the {@link Optional}
     */
    Optional<String> getText(final @NonNull String key);

    /**
     * Returns the text that the key represents. If this key does not exist,
     * the alternative text is returned.
     *
     * @param key         the key
     * @param alternative the alternative text
     * @return the text
     */
    String getTextOr(final @NonNull String key, @NonNull String alternative);

    /**
     * Sends the player the message representing the specified key.
     *
     * @param player the player
     * @param key    the key
     * @return {@code true} if the key exists and the message was sent,
     * otherwise {@code false}
     */
    boolean sendMessage(final @NonNull Player player, final @NonNull String key);

    /**
     * Sends the player the message representing the specified key. If this
     * key does not exist the alternative text is sent.
     *
     * @param player      the player
     * @param key         the key
     * @param alternative the alternative text
     * @return {@code true} if the key exists, otherwise {@code false}. A
     * message is sent in both cases
     */
    boolean sendMessage(final @NonNull Player player, final @NonNull String key, @NonNull String alternative);

}
