package com.example.examplemod.network.message;

import java.util.function.Supplier;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.enchantment.EnchantmentDoubleJump;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class MessageJump implements IMessage<MessageJump> {
    private int airJumps;
    // TODO private bool onground

    public MessageJump(){
        airJumps = 0;
    }
    public MessageJump(int jumps){
        airJumps = jumps;

    }
    @Override
    public void encode(MessageJump message, PacketBuffer buffer) {
        buffer.writeInt(message.airJumps);

    }

    @Override
    public MessageJump decode(PacketBuffer buffer) {        
        return new MessageJump(buffer.readInt());
    }

    @Override
    public void handle(MessageJump message, Supplier<Context> supplier) {
        ExampleMod.LOGGER.debug("Here");
        supplier.get().enqueueWork(() -> {
            ServerPlayerEntity player = supplier.get().getSender();
            EnchantmentDoubleJump.DoubleJumpHandle(message,player);
        });
        

    }

}