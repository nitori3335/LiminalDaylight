package nfactory.liminal_daylight;

import net.minecraft.client.resources.model.ModelBakery;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;

@EventBusSubscriber(modid = Liminal_daylight.MODID, value = Dist.CLIENT)
public class AllModelMissing {

    @SubscribeEvent
    public static void onModelBake(ModelEvent.ModifyBakingResult event) {
        var models = event.getModels();

        models.replaceAll((id, model) -> {
            if (id.id().equals(ModelBakery.MISSING_MODEL_LOCATION)) {
                return model;
            }
            return new MissingModelWrapper(model);
        });
    }
}
