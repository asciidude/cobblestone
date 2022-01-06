package net.cobblestone.mixins;
import net.cobblestone.Cobblestone;

import net.minecraft.client.util.Window;
import net.minecraft.client.MinecraftClient;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Shadow @Final
    private Window window;

    @Inject(at = @At("RETURN"), method = "updateWindowTitle")
    private void updateWindowTitle(CallbackInfo info) {
        this.window.setTitle(Cobblestone.instance.name + " v" + Cobblestone.instance.version);
    }

    @Inject(at = @At("HEAD"), method = "run")
    private void run(CallbackInfo info) {
        System.out.println("----> COBBLESTONE CLIENT <----");
        System.out.println("- Loading Cobblestone Client");
        Cobblestone.instance.run();
        System.out.println("- Cobblestone Client finished loading");
        System.out.println("----> COBBLESTONE CLIENT <----");
    }

    @Inject(at = @At("HEAD"), method = "stop")
    private void stop(CallbackInfo info) {
        System.out.println("----> COBBLESTONE CLIENT <----");
        System.out.println("- Stopping Cobblestone Client");
        Cobblestone.instance.stop();
        System.out.println("- Cobblestone Client finished stopping");
        System.out.println("----> COBBLESTONE CLIENT <----");
    }
}
