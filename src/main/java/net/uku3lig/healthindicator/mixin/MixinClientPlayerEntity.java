package net.uku3lig.healthindicator.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.network.encryption.PlayerPublicKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.uku3lig.healthindicator.HealthIndicator;
import net.uku3lig.healthindicator.config.Config;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public abstract class MixinClientPlayerEntity extends AbstractClientPlayerEntity {
    @Shadow public abstract void playSound(SoundEvent sound, float volume, float pitch);

    private final Config config = HealthIndicator.getConfig();

    protected MixinClientPlayerEntity(ClientWorld world, GameProfile profile, @Nullable PlayerPublicKey publicKey) {
        super(world, profile, publicKey);
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void soundOnDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (this.getHealth() <= config.getMinHealth() && config.isPlaySound()) {
            this.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BANJO, SoundCategory.PLAYERS, 1, 1);
        }
    }
}