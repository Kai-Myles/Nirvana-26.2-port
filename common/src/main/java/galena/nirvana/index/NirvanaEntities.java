package galena.nirvana.index;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.entry.EntityEntry;
import galena.nirvana.platform.Services;
import galena.nirvana.world.entity.MinecartThc;
import galena.nirvana.world.entity.PrimedThc;
import galena.nirvana.world.entity.Reefer;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.vehicle.minecart.MinecartTNT;

public class NirvanaEntities {

    private static final AbstractRegistrate REGISTRATE = Services.PLATFORM.getRegistrate();

    public static final EntityEntry<? extends Mob> REEFER = REGISTRATE
            .entity("reefer", Reefer::new, MobCategory.MONSTER)
            .attributes(Reefer::createAttributes)
            .transform(Services.PLATFORM.entityProperties(builder -> builder
                    .sized(0.6F, 1.7F)
                    .clientTrackingRange(8)
            ))
            .loot(Services.DATAGEN::reefer)
            .register();

    public static final EntityEntry<? extends PrimedTnt> THC = REGISTRATE
            .<PrimedThc>entity("thc", PrimedThc::new, MobCategory.MISC)
            .lang("THC")
            .transform(Services.PLATFORM.entityProperties(builder -> builder
                    .fireImmune()
                    .sized(0.98F, 0.98F)
                    .clientTrackingRange(10)
                    .updateInterval(10)
            ))
            .register();

    public static final EntityEntry<? extends MinecartTNT> THC_MINECART = REGISTRATE
            .<MinecartThc>entity("thc_minecart", MinecartThc::new, MobCategory.MISC)
            .lang("Minecart with THC")
            .transform(Services.PLATFORM.entityProperties(builder -> builder
                    .sized(0.98F, 0.7F)
                    .clientTrackingRange(8)
            ))
            .register();

    public static void register() {
        // loads this class
    }

}
