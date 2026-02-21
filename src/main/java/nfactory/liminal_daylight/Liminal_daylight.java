package nfactory.liminal_daylight;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Liminal_daylight.MODID)
public class Liminal_daylight {

    public static final String MODID = "liminal_daylight";

    public Liminal_daylight() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
