package Testing;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockPlaceHandler {

  @SubscribeEvent
  public void onPlaceEvent(PlaceEvent event) {
    event.getPlayer().sendMessage(
        new TextComponentString("You placed a block : " + event.getPlacedBlock().getBlock().getLocalizedName()));
  }
}