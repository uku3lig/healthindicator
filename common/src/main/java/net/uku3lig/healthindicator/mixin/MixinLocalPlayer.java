package net.uku3lig.healthindicator.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.HealthIndicatorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class MixinLocalPlayer extends AbstractClientPlayer {
    public MixinLocalPlayer(ClientLevel world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(method = "hurtTo", at = @At("HEAD"))
    private void soundOnDamage(float newHealth, CallbackInfo ci) {
        HealthIndicatorConfig config = HealthIndicator.getManager().getConfig();
        long now = System.currentTimeMillis();

        if (this.getHealth() <= config.getMinHealth() && config.isPlaySound()
                && now >= HealthIndicator.getLastPlayedSound() + config.getSoundCooldownMs()) {
            this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(Identifier.tryParse(config.getSound())), 1, 1);
            HealthIndicator.setLastPlayedSound(now);
        }
    }
}
