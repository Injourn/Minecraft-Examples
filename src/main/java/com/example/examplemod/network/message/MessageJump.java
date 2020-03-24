package com.example.examplemod.network.message;

import java.util.function.Supplier;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.enchantment.EnchantmentDoubleJump;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class MessageJump implements IMessage<MessageJump> {
    private boolean onGround;

    public MessageJump(){
        onGround = true;
    }
    public MessageJump(boolean jumps){
        onGround = jumps;

    }
    @Override
    public void encode(MessageJump message, PacketBuffer buffer) {
        buffer.writeBoolean(message.onGround);

    }

    @Override
    public MessageJump decode(PacketBuffer buffer) {        
        return new MessageJump(buffer.readBoolean());
    }

    @Override
    public void handle(MessageJump message, Supplier<Context> supplier) {        
        supplier.get().enqueueWork(() -> {
            ServerPlayerEntity player = supplier.get().getSender();
            EnchantmentDoubleJump.DoubleJumpHandle(message.onGround,player);
        });
        

    }

}