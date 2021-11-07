package fr.exelo.radiation;

import org.bukkit.entity.Player;

public class Help
{
    public Main plugin;
    
    public Help(final Main instance) {
        this.plugin = instance;
    }
    
    public void getHelp(final Player player, final String cmd) {
        final String[] helps = new String[12];
        if (cmd != null) {
            if (cmd.contains("stop") || cmd.contains("start")) {
                helps[1] = "§6[§eF.Rad§6] §9commande: stop/start";
                helps[2] = "§d/rad <stop/start>";
                helps[3] = "§7Arrêter ou redémarrer les radiations";
            }
            else if (cmd.contains("safezone") || cmd.contains("sz")) {
                helps[1] = "§6[§eF.Rad§6] §9commande: safezone";
                helps[2] = "§d/rad <safezone> <add/remove> <name>";
                helps[3] = "§7Ajouter une région ou la retirer des safezone avec le nom de la région <name>";
            }
            else if (cmd.contains("give")) {
                helps[1] = "§6[§eF.Rad§6] §9commande: give";
                helps[2] = "§d/rad give [Player] <armor/potion> [lvl]";
                helps[3] = "§7Permet de se give un item du plugin";
            }
            else if (cmd.contains("reload") || cmd.contains("rl")) {
                helps[1] = "§6[§eF.Rad§6] §9commande: reload";
                helps[2] = "§d/rad reload";
                helps[3] = "§7Permet de reload le plugin via plugman";
            }
        }
        else {
            helps[1] = "§6[§eF.Rad§6] §9commandes:";
            helps[2] = "§d/rad give §8- §7Permet de se give un item du plugin";
            helps[3] = "§d/rad <stop/start> §8- §7Arrêter ou redémarrer les radiations";
            helps[5] = "§d/rad safezone §8- §7Paramétrer les régions";
            helps[6] = "§d/rad reload §8- §7Permet de reload le Plugin";
        }
        for (int i = 1; i < helps.length; ++i) {
            if (helps[i] != null) {
                player.sendMessage(helps[i]);
            }
        }
    }
}