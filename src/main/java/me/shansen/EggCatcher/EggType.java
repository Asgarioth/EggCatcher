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

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public enum EggType {
    PIG_ZOMBIE(EntityType.PIG_ZOMBIE, 57, "PigZombie"),
    MAGMA_CUBE(EntityType.MAGMA_CUBE, 62, "MagmaCube"),
    CAVE_SPIDER(EntityType.CAVE_SPIDER, 59, "CaveSpider"),
    MUSHROOM_COW(EntityType.MUSHROOM_COW, 96, "MushroomCow"),
    CREEPER(EntityType.CREEPER, 50, "Creeper"),
    SKELETON(EntityType.SKELETON, 51, "Skeleton"),
    SPIDER(EntityType.SPIDER, 52, "Spider"),
    ZOMBIE(EntityType.ZOMBIE, 54, "Zombie"),
    SLIME(EntityType.SLIME, 55, "Slime"),
    GHAST(EntityType.GHAST, 56, "Ghast"),
    ENDERMAN(EntityType.ENDERMAN, 58, "Enderman"),
    SILVERFISH(EntityType.SILVERFISH, 60, "Silverfish"),
    BLAZE(EntityType.BLAZE, 61, "Blaze"),
    PIG(EntityType.PIG, 90, "Pig"),
    SHEEP(EntityType.SHEEP, 91, "Sheep"),
    COW(EntityType.COW, 92, "Cow"),
    CHICKEN(EntityType.CHICKEN, 93, "Chicken"),
    SQUID(EntityType.SQUID, 94, "Squid"),
    WOLF(EntityType.WOLF, 95, "Wolf"),
    VILLAGER(EntityType.VILLAGER, 120, "Villager"),
    OCELOT(EntityType.OCELOT, 98, "Ocelot"),
    BAT(EntityType.BAT, 65, "Bat"),
    WITCH(EntityType.WITCH, 66, "Witch"),
    HORSE(EntityType.HORSE, 100, "Horse"),
    ENDERMITE(EntityType.ENDERMITE, 67, "Endermite"),
    GUARDIAN(EntityType.GUARDIAN, 68, "Guardian"),
    RABBIT(EntityType.RABBIT, 101, "Rabbit"),
    POLA_BEAR(EntityType.POLAR_BEAR, 102, "PolarBear"),
    IRON_GOLEM(EntityType.IRON_GOLEM, 99, "IronGolem"),
    SKELETON_HORSE(EntityType.SKELETON_HORSE,28,"SkeletonHorse"),
    DONKEY(EntityType.DONKEY,31,"Donkey"),
    MULE(EntityType.MULE,32,"Mule"),
    ZOMBIE_HORSE(EntityType.ZOMBIE_HORSE,29,"ZombieHorse"),
    VEX(EntityType.VEX,35,"Vex"),
    EVOKER(EntityType.EVOKER,34,"Evoker"),
    VINDICATOR(EntityType.VINDICATOR,36,"Vindicator"),
    LLAMA(EntityType.LLAMA,103,"Llama"),
    HUSK(EntityType.HUSK,23,"Husk"),
    STRAY(EntityType.STRAY,6,"Stray"),
    ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN,4,"ElderGuardian"),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER,27,"ZombieVillager"),
    PARROT(EntityType.PARROT,105,"Parrot")
    ;

    

    private final EntityType entityType;
    private final Integer creatureId;
    private final String friendlyName;

    EggType(EntityType entityType, Integer creatureId, String friendlyName) {
        this.entityType = entityType;
        this.creatureId = creatureId;
        this.friendlyName = friendlyName;
    }

    public short getCreatureId() {
        return this.creatureId.shortValue();
    }

    public EntityType getCreatureType() {
        return this.entityType;
    }

    public String getFriendlyName() {
        return this.friendlyName;
    }

    public static EggType getEggType(Entity entity) {
    	
        for (EggType eggType : EggType.values()) {
            if (!eggType.getCreatureType().getEntityClass().isInstance(entity)) {
                continue;
            }
            // Skip, if eggType is skeleton but mob is a stray
            if(entity.getType() == EntityType.ELDER_GUARDIAN && !(eggType.getCreatureType() == EntityType.ELDER_GUARDIAN)) {
            	continue;
            }            
            // Skip, if eggType is skeleton but mob is a stray
            if(entity.getType() == EntityType.STRAY && !(eggType.getCreatureType() == EntityType.STRAY)) {
            	continue;
            }
            // Skip, if eggType is zombie but mob is a husk
            if(entity.getType() == EntityType.HUSK && !(eggType.getCreatureType() == EntityType.HUSK)) {
            	continue;
            }
            // Skip, if eggType is zombie but mob is a husk
            if(entity.getType() == EntityType.ZOMBIE_VILLAGER && !(eggType.getCreatureType() == EntityType.ZOMBIE_VILLAGER)) {
            	continue;
            }            
            return eggType;
        }
        return null;
    }
}
