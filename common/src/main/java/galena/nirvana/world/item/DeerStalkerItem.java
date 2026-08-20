package galena.nirvana.world.item;

import galena.nirvana.index.NirvanaItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DeerStalkerItem extends Item {

    public DeerStalkerItem(Properties properties) {
        super(properties
                .durability(65)
                .enchantable(15)
                .equippable(EquipmentSlot.HEAD)
                .repairable(NirvanaItems.HEMP_CLOTH));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        var stack = player.getItemInHand(hand);
        var equippable = stack.get(net.minecraft.core.component.DataComponents.EQUIPPABLE);
        if (equippable != null) {
            return equippable.swapWithEquipmentSlot(stack, player);
        }
        return InteractionResult.PASS;
    }
}
