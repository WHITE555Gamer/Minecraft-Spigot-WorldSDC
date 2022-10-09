package com.github.white555gamer.worldsdc.assets.check;

import org.bukkit.Difficulty;

import java.util.Locale;

public class ParseStr2Difficullty {

    public static Difficulty ParseStr2Difficulty(String string) {

        switch (string.toLowerCase(Locale.ROOT)) {
            case "peaceful":
                return Difficulty.PEACEFUL;
            case "easy":
                return Difficulty.EASY;
            case "normal":
                return Difficulty.NORMAL;
            case "hard":
                return Difficulty.HARD;
            default:
                return null;

        }
    }

}
