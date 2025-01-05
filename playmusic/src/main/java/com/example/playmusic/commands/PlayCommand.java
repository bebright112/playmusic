package com.example.playmusic.commands;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class PlayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage("사용법: /play <URL>");
            return true;
        }
        String url = args[0];
        Player player = (Player) sender;
        String streamUrl = "http://localhost:3000/stream?url=" + url;
        player.sendMessage("음악을 재생하려면 다음 링크를 열어주세요: " + streamUrl);
        //Bukkit.broadcastMessage(player.getName() + "님이 음악을 재생하고 있습니다!");

        return true;
    }
}
