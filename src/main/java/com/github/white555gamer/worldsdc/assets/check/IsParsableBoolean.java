package com.github.white555gamer.worldsdc.assets.check;

import org.bukkit.World;

import java.util.List;
import java.util.Locale;

public class IsParsableBoolean {

    public static boolean IsParsableBooleanBoolean(String string) {

        switch (string.toLowerCase(Locale.ROOT)) {
            case "true":
            case "false":
                return true;
            default:
                return false;

        }
    }

    public static boolean IsParsableDifficultyBoolean(String string) {

        switch (string.toLowerCase(Locale.ROOT)) {
            case "peaceful":
            case "easy":
            case "normal":
            case "hard":
                return true;
            default:
                return false;

        }
    }

    public static boolean IsParsableWorldsBoolean(List<World> worlds, String string) {

        String[] worldslist = new String[worlds.size()];
        boolean IsMatched = false;

        for (int i = 0; i < worlds.size(); i++) {
            worldslist[i] = worlds.get(i).getName();
            if (worlds.get(i).getName().equalsIgnoreCase(string)) {IsMatched = true;}
        }

        if (IsMatched) {return true;} else {return false;}

    }

}
