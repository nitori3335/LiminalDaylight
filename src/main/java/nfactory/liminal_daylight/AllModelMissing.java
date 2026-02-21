package nfactory.liminal_daylight;

import net.minecraft.client.resources.model.ModelBakery;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "liminal_daylight",
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class AllModelMissing {

    @SubscribeEvent
    public static void onModelBake(ModelEvent.ModifyBakingResult event) {
        var models = event.getModels();

        models.replaceAll((id, model) -> {
            // missing model 自体は除外（無限ループ防止）
            if (id.equals(ModelBakery.MISSING_MODEL_LOCATION)) {
                return model;
            }
            return new MissingModelWrapper(model);
        });
    }
}

