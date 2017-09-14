/*
EggCatcher
Copyright (C) 2012, 2013  me@shansen.me

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.shansen.EggCatcher;

import me.shansen.EggCatcher.listeners.EggCatcherEntityListener;
import me.shansen.EggCatcher.listeners.EggCatcherPlayerListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Egg;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public class EggCatcher extends JavaPlugin {
    public static List<Egg> eggs = new ArrayList<Egg>();
    public static Economy economy = null;

    public void onDisable() {
    }

    public void onEnable() {
        this.CheckConfigurationFile();

        PluginManager pm = this.getServer().getPluginManager();

        final EggCatcherPlayerListener playerListener = new EggCatcherPlayerListener();
        final EggCatcherEntityListener entityListener = new EggCatcherEntityListener(this);

        pm.registerEvents(playerListener, this);
        pm.registerEvents(entityListener, this);

        if (getServer().getPluginManager().getPlugin("Vault") != null) {
            RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration
                    (Economy.class);
            if (economyProvider != null) {
                economy = economyProvider.getProvider();
            }
        }
    }

    public void CheckConfigurationFile() {
        double configVersion = this.getConfig().getDouble("ConfigVersion", 0.0);
        System.out.println("Config Version is: " + configVersion);
        if (configVersion == 2.8) {
            this.saveConfig();
        }
        else if (configVersion == 2.7){
            this.getConfig().set("CatchChance.Parrot", 100.0);
            this.getConfig().set("VaultCost.Parrot", 0);
            this.getConfig().set("ItemCost.Amount.Parrot", 0);
            this.getConfig().set("HealthPercentage.Parrot", 100.0);
            this.getConfig().set("ConfigVersion", 2.8);
            this.saveConfig();
        }
        	else if (configVersion == 2.6) {
        
        	this.getConfig().set("ItemCost.ItemMaterial", "gold_nugget");
            this.getConfig().set("CatchChance.IronGolem", 100.0);
            this.getConfig().set("VaultCost.IronGolem", 0);
            this.getConfig().set("ItemCost.Amount.IronGolem", 0);
            this.getConfig().set("HealthPercentage.IronGolem", 100.0);
            this.getConfig().set("CatchChance.SkeletonHorse", 100.0);
            this.getConfig().set("VaultCost.SkeletonHorse", 0);
            this.getConfig().set("ItemCost.Amount.SkeletonHorse", 0);
            this.getConfig().set("HealthPercentage.SkeletonHorse", 100.0);
            this.getConfig().set("CatchChance.Donkey", 100.0);
            this.getConfig().set("VaultCost.Donkey", 0);
            this.getConfig().set("ItemCost.Amount.Donkey", 0);
            this.getConfig().set("HealthPercentage.Donkey", 100.0); 
            this.getConfig().set("CatchChance.Mule", 100.0);
            this.getConfig().set("VaultCost.Mule", 0);
            this.getConfig().set("ItemCost.Amount.Mule", 0);
            this.getConfig().set("HealthPercentage.Mule", 100.0);
            this.getConfig().set("CatchChance.ZombieHorse", 100.0);
            this.getConfig().set("VaultCost.ZombieHorse", 0);
            this.getConfig().set("ItemCost.Amount.ZombieHorse", 0);
            this.getConfig().set("HealthPercentage.ZombieHorse", 100.0);
            this.getConfig().set("CatchChance.Vex", 100.0);
            this.getConfig().set("VaultCost.Vex", 0);
            this.getConfig().set("ItemCost.Amount.Vex", 0);
            this.getConfig().set("HealthPercentage.Vex", 100.0);
            this.getConfig().set("CatchChance.Evoker", 100.0);
            this.getConfig().set("VaultCost.Evoker", 0);
            this.getConfig().set("ItemCost.Amount.Evoker", 0);
            this.getConfig().set("HealthPercentage.Evoker", 100.0);
            this.getConfig().set("CatchChance.Vindicator", 100.0);
            this.getConfig().set("VaultCost.Vindicator", 0);
            this.getConfig().set("ItemCost.Amount.Vindicator", 0);
            this.getConfig().set("HealthPercentage.Vindicator", 100.0);
            this.getConfig().set("CatchChance.Llama", 100.0);
            this.getConfig().set("VaultCost.Llama", 0);
            this.getConfig().set("ItemCost.Amount.Llama", 0);
            this.getConfig().set("HealthPercentage.Llama", 100.0);   
            this.getConfig().set("CatchChance.Husk", 100.0);
            this.getConfig().set("VaultCost.Husk", 0);
            this.getConfig().set("ItemCost.Amount.Husk", 0);
            this.getConfig().set("HealthPercentage.Husk", 100.0); 
            this.getConfig().set("CatchChance.Stray", 100.0);
            this.getConfig().set("VaultCost.Stray", 0);
            this.getConfig().set("ItemCost.Amount.Stray", 0);
            this.getConfig().set("HealthPercentage.Stray", 100.0);   
            this.getConfig().set("CatchChance.ElderGuardian", 100.0);
            this.getConfig().set("VaultCost.ElderGuardian", 0);
            this.getConfig().set("ItemCost.Amount.ElderGuardian", 0);
            this.getConfig().set("HealthPercentage.ElderGuardian", 100.0);              
            this.getConfig().set("ConfigVersion", 2.7);
            this.saveConfig();
        } else if (configVersion == 2.5) {
            this.getConfig().set("CatchChance.PolarBear", 100.0);
            this.getConfig().set("VaultCost.PolarBear", 0);
            this.getConfig().set("ItemCost.Amount.PolarBear", 0);
            this.getConfig().set("HealthPercentage.PolarBear", 100.0);
            this.getConfig().set("ConfigVersion", 2.6);
            this.saveConfig();
        } else if (configVersion == 2.2) {
            this.getConfig().set("DeleteVillagerInventoryOnCatch", false);

            this.getConfig().set("ConfigVersion", 2.5);
            this.saveConfig();
        } else if (configVersion == 2.0) {
            this.getConfig().set("CatchChance.Endermite", 100.0);
            this.getConfig().set("VaultCost.Endermite", 0);
            this.getConfig().set("ItemCost.Amount.Endermite", 0);
            this.getConfig().set("HealthPercentage.Endermite", 100.0);

            this.getConfig().set("CatchChance.Guardian", 100.0);
            this.getConfig().set("VaultCost.Guardian", 0);
            this.getConfig().set("ItemCost.Amount.Guardian", 0);
            this.getConfig().set("HealthPercentage.Guardian", 100.0);

            this.getConfig().set("CatchChance.Rabbit", 100.0);
            this.getConfig().set("VaultCost.Rabbit", 0);
            this.getConfig().set("ItemCost.Amount.Rabbit", 0);
            this.getConfig().set("HealthPercentage.Rabbit", 100.0);

            this.getConfig().set("ConfigVersion", 2.2);
            this.saveConfig();
        } else {
            this.saveResource("config.yml", true);
            this.reloadConfig();
        }
    }
}
