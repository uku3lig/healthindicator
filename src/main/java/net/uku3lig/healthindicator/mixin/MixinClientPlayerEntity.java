package net.uku3lig.healthindicator.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.HealthIndicatorConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayerEntity extends AbstractClientPlayerEntity {
    public MixinClientPlayerEntity(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(method = "updateHealth", at = @At("HEAD"))
    private void soundOnDamage(float health, CallbackInfo ci) {
        HealthIndicatorConfig config = HealthIndicator.getManager().getConfig();
        long now = System.currentTimeMillis();

        if (this.getHealth() <= config.getMinHealth() && config.isPlaySound()
                && now >= HealthIndicator.getLastPlayedSound() + config.getSoundCooldownMs()) {
            this.playSound(Registries.SOUND_EVENT.get(Identifier.tryParse(config.getSound())), 1, 1);
            HealthIndicator.setLastPlayedSound(now);
        }
    }
}
