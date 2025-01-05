package com.example.playmusic;
import com.example.playmusic.commands.PlayCommand;
import com.example.playmusic.commands.StopCommand;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("playmusic 플러그인이 활성화되었습니다!");
        getCommand("play").setExecutor(new PlayCommand());
        getCommand("stop").setExecutor(new StopCommand());
    }
    @Override
    public void onDisable() {
        getLogger().info("playmusic 플러그인이 비활성화되었습니다!");
    }
}
