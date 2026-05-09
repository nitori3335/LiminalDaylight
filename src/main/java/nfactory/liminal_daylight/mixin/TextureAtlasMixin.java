package nfactory.liminal_daylight.mixin;

import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(TextureAtlas.class)
public class TextureAtlasMixin {
    @Shadow
    private Map<ResourceLocation, TextureAtlasSprite> texturesByName;

    @Unique
    private TextureAtlasSprite liminal_daylight$cachedMissing;

    @Inject(method = "getSprite", at = @At("HEAD"), cancellable = true)
    private void forceMissing(ResourceLocation location, CallbackInfoReturnable<TextureAtlasSprite> cir) {

        if (liminal_daylight$cachedMissing == null && !texturesByName.isEmpty()) {
            liminal_daylight$cachedMissing = texturesByName.get(MissingTextureAtlasSprite.getLocation());
        }

        if (liminal_daylight$cachedMissing != null) {
            cir.setReturnValue(liminal_daylight$cachedMissing);
        }
    }
}
