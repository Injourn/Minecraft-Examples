package com.example.examplemod.Command;

import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.util.text.StringTextComponent;

public final class SimpleCommand{
    //private static final SuggestionProvider<CommandSource> ITEM_ID_SUGGESTIONS = (context,builder) ->
    //  ISuggestionProvider.func_2...a(ForgeRegistries.ITEMS.getKeys().stream(),builder)
    private SimpleCommand(){
        
    }

    public static void register (CommandDispatcher<CommandSource> dispatcher){
        dispatcher.register(Commands.literal("diamondplz").requires(source -> source.hasPermissionLevel(2))
            .then(Commands.argument("amount", EntityArgument.players())            
            )/*.suggests(ITEM_ID_SUGGESTIONS)*/.executes(context -> Deny(context.getSource())) //ResourceLocationArgument.getResourceLocation(context,"amount");
        );
    }
    public static int Deny(CommandSource source){
            source.sendFeedback(new StringTextComponent("no"), false);
        return 0;
    }
}