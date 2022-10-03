package com.github.white555gamer.worldsdc.assets.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

import static com.github.white555gamer.worldsdc.assets.check.IsParsableBoolean.IsParsableWorldsBoolean;
import static com.github.white555gamer.worldsdc.assets.messages.TemplateMsg.IncorrectArg;
import static com.github.white555gamer.worldsdc.assets.messages.TemplateMsg.MissingArg;
import static org.bukkit.Bukkit.getServer;
import static org.bukkit.Bukkit.getWorld;

public class WorldSDCC implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {

            sender.sendMessage(MissingArg);
            return true;

        } else if (args.length == 1) {

            sender.sendMessage(MissingArg);
            return true;

        } else if (args.length == 2) {

            if (IsParsableWorldsBoolean(getServer().getWorlds(), args[0])) {

                switch (args[1]) {

                    case "worlddata":
                        sender.sendMessage("World Data(" + args[0] + "):\n" +
                                "  World Name: " + getWorld(args[0]).getName() + "\n" +
                                "  World Hash Code: " +getWorld(args[0]).getName() + "\n" +
                                "  World UUID: " + getWorld(args[0]).getUID() + "\n" +
                                "  World Seed: " + getWorld(args[0]).getSeed() + "\n" +
                                "  World Difficulty: " + getWorld(args[0]).getDifficulty() + "\n" +
                                "  World is Hardcore: " + getWorld(args[0]).isHardcore() + "\n" +
                                "  World Players: " + getWorld(args[0]).getPlayers().size());
                        break;

                    case "worldlocation":
                        Location SpawnLoc =getWorld(args[0]).getSpawnLocation();
                        String SpawnLocData = "(" + SpawnLoc.getWorld().getName() + "):" + SpawnLoc.getX() + "/" + SpawnLoc.getY() + "/" + SpawnLoc.getZ();
                        sender.sendMessage("World Location(" + args[0] + ":\n" +
                                "  World Max Height: " + getWorld(args[0]).getMaxHeight() + "\n" +
                                "  World Min Height: " + getWorld(args[0]).getMinHeight() + "\n" +
                                "  World Logical Height: " + getWorld(args[0]).getLogicalHeight() + "\n" +
                                "  World Sea Level: " + getWorld(args[0]).getSeaLevel() + "\n" +
                                "  World Spawn Location: " + SpawnLocData + "\n" +
                                "  World is Bed Work: " + getWorld(args[0]).isBedWorks() + "\n" +
                                "  World is Respawn Anchor Works: " + getWorld(args[0]).isRespawnAnchorWorks() + "\n" +
                                "  World Keep Spawn In Memory: " + getWorld(args[0]).getKeepSpawnInMemory());
                        break;

                    case "worldrule":
                        sender.sendMessage("World Rule(" + args[0] + "):\n" +
                                "  World Allow Animals: " + getWorld(args[0]).getAllowAnimals() + "\n" +
                                "  World Allow Monsters: " + getWorld(args[0]).getAllowMonsters() + "\n" +
                                "  World PVP: " + getWorld(args[0]).getPVP()
                        );
                        break;

                    case "worldsave":
                        sender.sendMessage("World Save(" + args[0] + "):\n" +
                                "  World Folder: " + getWorld(args[0]).getWorldFolder().getName() + "\n" +
                                "  World is Auto Save: " + getWorld(args[0]).isAutoSave());
                        break;

                    case "worldtime":
                        sender.sendMessage("World Time(" + args[0] + "):\n" +
                                "  World Time: " + getWorld(args[0]).getTime() + "\n" +
                                "  World Full Time: " + getWorld(args[0]).getFullTime() + "\n" +
                                "  World Game Time: " + getWorld(args[0]).getGameTime());
                        break;

                    case "worldtrait":
                        sender.sendMessage("World Trait(" + args[0] + "):\n" +
                                "  World is Natural: " + getWorld(args[0]).isNatural() + "\n" +
                                "  World is Piglin Safe: " + getWorld(args[0]).isPiglinSafe() + "\n" +
                                "  World has Ceiling: " + getWorld(args[0]).hasCeiling() + "\n" +
                                "  World Environment: " + getWorld(args[0]).getEnvironment()
                        );
                        break;

                    case "worldweather":
                        sender.sendMessage("World Weather(" + args[0] + "):\n" +
                                "  World Weather Duration: " + getWorld(args[0]).getWeatherDuration() + "\n" +
                                "  World Clear Weather Duration: " + getWorld(args[0]).getClearWeatherDuration() + "\n" +
                                "  World Thunder Duration: " + getWorld(args[0]).getThunderDuration() + "\n" +
                                "  World is Clear Weather: " + getWorld(args[0]).isClearWeather() + "\n" +
                                "  World is Thundering: " + getWorld(args[0]).isThundering() + "\n" +
                                "  World has Storm: " + getWorld(args[0]).hasStorm() + "\n" +
                                "  World has Sky Light: " + getWorld(args[0]).hasSkyLight());
                        break;

                    case "worldborder":
                        Location WorldBCLoc = getWorld(args[0]).getWorldBorder().getCenter();
                        String WorldBCLocData = "(" + WorldBCLoc.getWorld().getName() + "):" + WorldBCLoc.getX() + "/" + WorldBCLoc.getY() + "/" + WorldBCLoc.getZ();
                        sender.sendMessage("World Border(" + args[0] + "):\n" +
                                "  World Border Center: " + WorldBCLocData + "\n" +
                                "  World Border Center Coordinate: " + getWorld(args[0]).getWorldBorder().getMaxCenterCoordinate() + "\n" +
                                "  World Border Size: " + getWorld(args[0]).getWorldBorder().getSize() + "\n" +
                                "  World Border Max Size: " + getWorld(args[0]).getWorldBorder().getMaxSize() + "\n" +
                                "  World Border Damage Amount: " + getWorld(args[0]).getWorldBorder().getDamageAmount() + "\n" +
                                "  World Border Damage Buffer: " + getWorld(args[0]).getWorldBorder().getDamageBuffer() + "\n" +
                                "  World Border Warning Time: " + getWorld(args[0]).getWorldBorder().getWarningTime() + "\n" +
                                "  World Border Warning Distance: " + getWorld(args[0]).getWorldBorder().getWarningDistance());
                        break;

                    default:
                        sender.sendMessage(IncorrectArg);
                        break;
                }
                return true;

            } else {

                sender.sendMessage(IncorrectArg);
                return true;

            }

        } else {

            sender.sendMessage(MissingArg);
            return true;

        }

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
