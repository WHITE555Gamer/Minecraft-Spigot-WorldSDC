package com.github.white555gamer.worldsdc.assets.check;

import org.bukkit.World;

import java.util.List;

public class IsParsableBoolean {

    public static boolean IsParsableWorldsBoolean(List<World> worlds, String string) {

        String[] worldslist = new String[worlds.size() - 1];
        boolean IsMatched = false;

        for (int i = 0; i < worlds.size(); i++) {
            worldslist[i] = worlds.get(i).getName();
            if (worlds.get(i).getName().equalsIgnoreCase(string)) {IsMatched = true;}
        }

        if (IsMatched) {return true;} else {return false;}

    }

}
