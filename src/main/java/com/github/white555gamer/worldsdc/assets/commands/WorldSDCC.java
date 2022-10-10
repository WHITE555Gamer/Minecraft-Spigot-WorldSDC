package com.github.white555gamer.worldsdc.assets.commands;

import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.github.white555gamer.worldsdc.assets.check.IsParsableBoolean.*;
import static com.github.white555gamer.worldsdc.assets.check.ParseStr2Difficullty.ParseStr2Difficulty;
import static com.github.white555gamer.worldsdc.assets.messages.TemplateMsg.IncorrectArg;
import static com.github.white555gamer.worldsdc.assets.messages.TemplateMsg.MissingArg;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public class WorldSDCC implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0 || args.length == 1) {

            sender.sendMessage(MissingArg);
            return true;

        } else if (args.length == 2) {

            if (IsParsableWorldsBoolean(getServer().getWorlds(), args[0])) {

                World world = getWorld(args[0]);

                switch (args[1]) {

                    case "worldborder":
                        WorldBorder worldborder = world.getWorldBorder();
                        Location WorldBCLoc = worldborder.getCenter();
                        String WorldBCLocData = "(" + WorldBCLoc.getWorld().getName() + "):" + WorldBCLoc.getX() + "/" + WorldBCLoc.getY() + "/" + WorldBCLoc.getZ();
                        sender.sendMessage("World Border(" + args[0] + "):\n" +
                                "  World Border Center: " + WorldBCLocData + "\n" +
                                "  World Border Center Coordinate: " + worldborder.getMaxCenterCoordinate() + "\n" +
                                "  World Border Size: " + worldborder.getSize() + "\n" +
                                "  World Border Max Size: " + worldborder.getMaxSize() + "\n" +
                                "  World Border Damage Amount: " + worldborder.getDamageAmount() + "\n" +
                                "  World Border Damage Buffer: " + worldborder.getDamageBuffer() + "\n" +
                                "  World Border Warning Time: " + worldborder.getWarningTime() + "\n" +
                                "  World Border Warning Distance: " + worldborder.getWarningDistance());
                        break;

                    case "worlddata":
                        sender.sendMessage("World Data(" + args[0] + "):\n" +
                                "  World Name: " + world.getName() + "\n" +
                                "  World Hash Code: " +world.getName() + "\n" +
                                "  World UUID: " + world.getUID() + "\n" +
                                "  World Seed: " + world.getSeed() + "\n" +
                                "  World Difficulty: " + world.getDifficulty() + "\n" +
                                "  World is Hardcore: " + world.isHardcore() + "\n" +
                                "  World Players: " + world.getPlayers().size());
                        break;

                    case "worldlocation":
                        Location SpawnLoc = world.getSpawnLocation();
                        String SpawnLocData = "(" + SpawnLoc.getWorld().getName() + "):" + SpawnLoc.getX() + "/" + SpawnLoc.getY() + "/" + SpawnLoc.getZ();
                        sender.sendMessage("World Location(" + args[0] + "):\n" +
                                "  World Max Height: " + world.getMaxHeight() + "\n" +
                                "  World Min Height: " + world.getMinHeight() + "\n" +
                                "  World Logical Height: " + world.getLogicalHeight() + "\n" +
                                "  World Sea Level: " + world.getSeaLevel() + "\n" +
                                "  World Spawn Location: " + SpawnLocData + "\n" +
                                "  World is Bed Work: " + world.isBedWorks() + "\n" +
                                "  World is Respawn Anchor Works: " + world.isRespawnAnchorWorks() + "\n" +
                                "  World Keep Spawn In Memory: " + world.getKeepSpawnInMemory());
                        break;

                    case "worldrule":
                        sender.sendMessage("World Rule(" + args[0] + "):\n" +
                                "  World Allow Animals: " + world.getAllowAnimals() + "\n" +
                                "  World Allow Monsters: " + world.getAllowMonsters() + "\n" +
                                "  World PVP: " + world.getPVP()
                        );
                        break;

                    case "worldsave":
                        sender.sendMessage("World Save(" + args[0] + "):\n" +
                                "  World Folder: " + world.getWorldFolder().getName() + "\n" +
                                "  World is Auto Save: " + world.isAutoSave());
                        break;

                    case "worldtime":
                        sender.sendMessage("World Time(" + args[0] + "):\n" +
                                "  World Time: " + world.getTime() + "\n" +
                                "  World Full Time: " + world.getFullTime() + "\n" +
                                "  World Game Time: " + world.getGameTime());
                        break;

                    case "worldtrait":
                        sender.sendMessage("World Trait(" + args[0] + "):\n" +
                                "  World is Natural: " + world.isNatural() + "\n" +
                                "  World is Piglin Safe: " + world.isPiglinSafe() + "\n" +
                                "  World has Ceiling: " + world.hasCeiling() + "\n" +
                                "  World Environment: " + world.getEnvironment()
                        );
                        break;

                    case "worldweather":
                        sender.sendMessage("World Weather(" + args[0] + "):\n" +
                                "  World Weather Duration: " + world.getWeatherDuration() + "\n" +
                                "  World Clear Weather Duration: " + world.getClearWeatherDuration() + "\n" +
                                "  World Thunder Duration: " + world.getThunderDuration() + "\n" +
                                "  World is Clear Weather: " + world.isClearWeather() + "\n" +
                                "  World is Thundering: " + world.isThundering() + "\n" +
                                "  World has Storm: " + world.hasStorm() + "\n" +
                                "  World has Sky Light: " + world.hasSkyLight());
                        break;

                    default:
                        sender.sendMessage(IncorrectArg);
                        break;
                }
            } else {
                sender.sendMessage(IncorrectArg);
            }
            return true;

        } else if (args.length == 3) {

            if (IsParsableWorldsBoolean(getServer().getWorlds(), args[0])) {

                World world = getWorld(args[0]);

                switch (args[1]) {

                    case "setautosave":
                        if (IsParsableBooleanBoolean(args[2])) {
                            world.setAutoSave(Boolean.parseBoolean(args[2]));
                            sender.sendMessage("Auto Save has been set to " + args[2]);
                        } else {
                            sender.sendMessage(IncorrectArg);
                        }
                        break;

                    case "setdifficulty":
                        if (IsParsableDifficultyBoolean(args[2])) {
                            if (ParseStr2Difficulty(args[2]) != null) {
                                world.setDifficulty(ParseStr2Difficulty(args[2]));
                                sender.sendMessage("Difficulty has been set to " + args[2]);
                            } else {
                                sender.sendMessage(IncorrectArg);
                            }
                        } else {
                            sender.sendMessage(IncorrectArg);
                        }
                        break;

                    case "sethardcore":
                        if (IsParsableBooleanBoolean(args[2])){
                            world.setHardcore(Boolean.parseBoolean(args[2]));
                            sender.sendMessage("Hardcore mode has been set to " + args[2]);
                        } else {
                            sender.sendMessage(IncorrectArg);
                        }
                        break;

                    case "setpvp":
                        if (IsParsableBooleanBoolean(args[2])) {
                            world.setPVP(Boolean.parseBoolean(args[2]));
                            sender.sendMessage("PvP has been set to " + args[2]);
                        } else {
                            sender.sendMessage(IncorrectArg);
                        }
                        break;

                    case "setkeepspawninmemory":

                        if (IsParsableBooleanBoolean(args[2])) {
                            world.setKeepSpawnInMemory(Boolean.parseBoolean(args[2]));
                            sender.sendMessage("Keep Spawn In Memory has been set to " + args[2]);
                        } else {
                            sender.sendMessage(IncorrectArg);
                        }
                        break;

                    case "settime":
                        try {
                            Integer.parseInt(args[2]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(IncorrectArg);
                            return true;
                        }
                        world.setTime(Integer.parseInt(args[2]));
                        sender.sendMessage("Time has been set to " + args[2]);
                        break;

                    case "setfulltime":
                        try {
                            Integer.parseInt(args[2]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(IncorrectArg);
                            return true;
                        }
                        world.setFullTime(Integer.parseInt(args[2]));
                        sender.sendMessage("Full Time has been set to " + args[2]);
                        break;

                    case "setweatherduration":
                        try {
                            Integer.parseInt(args[2]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(IncorrectArg);
                            return true;
                        }
                        world.setWeatherDuration(Integer.parseInt(args[2]));
                        sender.sendMessage("Weather Duration has been set to " + args[2]);
                        break;

                    case "setclearweatherduration":
                        try {
                            Integer.parseInt(args[2]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(IncorrectArg);
                            return true;
                        }
                        world.setClearWeatherDuration(Integer.parseInt(args[2]));
                        sender.sendMessage("Clear Weather Duration has been set to " + args[2]);
                        break;

                    case "setthunderduration":
                        try {
                            Integer.parseInt(args[2]);
                        } catch (NumberFormatException e) {
                            sender.sendMessage(IncorrectArg);
                            return true;
                        }
                        world.setThunderDuration(Integer.parseInt(args[2]));
                        sender.sendMessage("Thunder Duration has been set to " + args[2]);
                        break;

                    case "setthundering":

                        if (IsParsableBooleanBoolean(args[2])) {
                            world.setThundering(Boolean.parseBoolean(args[2]));
                            sender.sendMessage("Thundering has been set to " + args[2]);
                        } else {
                            sender.sendMessage(IncorrectArg);
                        }
                        break;

                    case "setstorm":

                        if (IsParsableBooleanBoolean(args[2])) {
                            world.setStorm(Boolean.parseBoolean(args[2]));
                            sender.sendMessage("Storm has been set to " + args[2]);
                        } else {
                            sender.sendMessage(IncorrectArg);
                        }
                        break;

                    default:
                        sender.sendMessage(IncorrectArg);
                        break;

                }

            } else {
                sender.sendMessage(IncorrectArg);
            }
            return true;

        } else {

            sender.sendMessage(MissingArg);
            return true;

        }

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("worldsdc")) {

            if (args.length == 1) {
                if (args[0].length() == 0) {

                    List<String> WorldsList = new ArrayList<>();
                    for (int i = 0; i < getServer().getWorlds().size(); i++) {
                        WorldsList.add(getServer().getWorlds().get(i).getName());
                    }
                    return WorldsList;

                }

            } else if (args.length == 2) {

                if (args[1].length() == 0) {
                    return Arrays.asList("worldborder","worlddata","worldlocation","worldrule","worldsave","worldtime","worldtrait","worldweather",
                            "setautosave","setdifficulty","sethardcore","setpvp","setkeepspawninmemory","settime","setfulltime",
                            "setweatherduration","setclearweatherduration","setthunderduration","setthundering","setstorm");
                } else {

                    if ("world".startsWith(args[1])) {
                        return Arrays.asList("worldborder","worlddata","worldlocation","worldrule","worldsave","worldtime","worldtrait","worldweather");
                    } else if ("worldt".startsWith(args[1])) {
                        return Arrays.asList("worldtime","worldtrait");
                    } else if ("worldborder".startsWith(args[1])) {
                        return Collections.singletonList("worldborder");
                    } else if ("worlddata".startsWith(args[1])) {
                        return Collections.singletonList("worlddata");
                    } else if ("worldlocation".startsWith(args[1])) {
                        return Collections.singletonList("worldlocation");
                    } else if ("worldrule".startsWith(args[1])) {
                        return Collections.singletonList("worldrule");
                    } else if ("worldsave".startsWith(args[1])) {
                        return Collections.singletonList("worldsave");
                    } else if ("worldtime".startsWith(args[1])) {
                        return Collections.singletonList("worldtime");
                    } else if ("worldtrait".startsWith(args[1])) {
                        return Collections.singletonList("worldtrait");
                    } else if ("worldweather".startsWith(args[1])) {
                        return Collections.singletonList("worldweather");
                    } else if ("set".startsWith(args[1])) {
                        return Arrays.asList("setautosave","setdifficulty","sethardcore","setpvp","setkeepspawninmemory","settime","setfulltime",
                                "setweatherduration","setclearweatherduration","setthunderduration","setthundering","setstorm");
                    } else if ("sett".startsWith(args[1])) {
                        return Arrays.asList("settime","setthunderduration","setthundering");
                    } else if ("setthunder".startsWith(args[1])) {
                        return Arrays.asList("setthunderduration","setthundering");
                    } else if ("setautosave".startsWith(args[1])) {
                        return Collections.singletonList("setautosave");
                    } else if ("setdifficulty".startsWith(args[1])) {
                        return Collections.singletonList("setdifficulty");
                    } else if ("sethardcore".startsWith(args[1])) {
                        return Collections.singletonList("sethardcore");
                    } else if ("setpvp".startsWith(args[1])) {
                        return Collections.singletonList("setpvp");
                    } else if ("setkeepspawninmemory".startsWith(args[1])) {
                        return Collections.singletonList("setkeepspawninmemory");
                    } else if ("settime".startsWith(args[1])) {
                        return Collections.singletonList("settime");
                    } else if ("setfulltime".startsWith(args[1])) {
                        return Collections.singletonList("setfulltime");
                    } else if ("setweatherduration".startsWith(args[1])) {
                        return Collections.singletonList("setweatherduration");
                    } else if ("setclearweatherduration".startsWith(args[1])) {
                        return Collections.singletonList("setclearweatherduration");
                    } else if ("setthunderduration".startsWith(args[1])) {
                        return Collections.singletonList("setthunderduration");
                    } else if ("setthundering".startsWith(args[1])) {
                        return Collections.singletonList("setthundering");
                    } else if ("setstorm".startsWith(args[1])) {
                        return Collections.singletonList("setstorm");
                    }

                }

            } else if (args.length == 3) {

                if (args[2].length() == 0) {

                    switch (args[1]) {
                        case "setautosave":
                        case "sethardcore":
                        case "setpvp":
                        case "setkeepspawninmemory":
                        case "setthundering":
                        case "setstorm":
                            return Arrays.asList("true","false");
                        case "setdifficulty":
                            return Arrays.asList("peaceful","easy","normal","hard");
                    }

                } else {

                    switch (args[1]) {
                        case "setautosave":
                        case "sethardcore":
                        case "setpvp":
                        case "setkeepspawninmemory":
                        case "setthundering":
                        case "setstorm":
                            if ("true".startsWith(args[2])) {
                                return Collections.singletonList("true");
                            } else if ("false".startsWith(args[2])) {
                                return Collections.singletonList("false");
                            }
                        break;
                        case "setdifficulty":
                            if ("peaceful".startsWith(args[2])) {
                                return Collections.singletonList("peaceful");
                            } else if ("easy".startsWith(args[2])) {
                                return Collections.singletonList("easy");
                            } else if ("normal".startsWith(args[2])) {
                                return Collections.singletonList("normal");
                            } else if ("hard".startsWith(args[2])) {
                                return Collections.singletonList("hard");
                            }
                        break;
                    }

                }

            }


        }

        return null;
    }
}
