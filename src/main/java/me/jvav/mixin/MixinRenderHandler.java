package me.jvav.mixin;

import fi.dy.masa.minihud.event.RenderHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderHandler.class, remap = false)
public class MixinRenderHandler {
    @Shadow
    private int fps;

    @Inject(method = "updateFps", at = @At(value = "HEAD"), cancellable = true)
    private void onUpdateFps(CallbackInfo ci) {
        fps = 114514;
        ci.cancel();
    }
}
