package net.betterspears.entity.renderer;

import net.betterspears.entity.Spear_Entity;
import net.betterspears.entity.model.Spear_Entity_Model;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class Spear_Entity_Renderer extends EntityRenderer<Spear_Entity> {
  private static final Map<EntityType<?>, Identifier> TEXTURES = new HashMap<>();
  private final Spear_Entity_Model model = new Spear_Entity_Model();

  public Spear_Entity_Renderer(EntityRenderDispatcher entityRenderDispatcher) {
    super(entityRenderDispatcher);
  }

  @Override
  public void render(Spear_Entity spear_Entity, float f, float g, MatrixStack matrixStack,
      VertexConsumerProvider vertexConsumerProvider, int i) {
    matrixStack.push();
    VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(vertexConsumerProvider,
        model.getLayer(this.getTexture(spear_Entity)), false, spear_Entity.enchantingGlint());

    matrixStack.multiply(Vector3f.POSITIVE_Y
        .getDegreesQuaternion(MathHelper.lerp(g, spear_Entity.prevYaw, spear_Entity.yaw) - 90.0F));
    matrixStack.multiply(Vector3f.POSITIVE_Z
        .getDegreesQuaternion(MathHelper.lerp(g, spear_Entity.prevPitch, spear_Entity.pitch) + 90.0F));

    model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
    matrixStack.scale(1.0F, -1.0F, 1.0F);
    matrixStack.translate(0.0D, -4.0D, 0.0D);
    matrixStack.pop();
    super.render(spear_Entity, f, g, matrixStack, vertexConsumerProvider, i);
  }

  @Override
  public Identifier getTexture(Spear_Entity spear_Entity) {
    return getTexture(spear_Entity.getType());
  }

  public static Identifier getTexture(EntityType<?> type) {
    if (!TEXTURES.containsKey(type)) {
      TEXTURES.put(type,
          new Identifier("betterspears", "textures/entity/" + Registry.ENTITY_TYPE.getId(type).getPath() + ".png"));
    }
    return TEXTURES.get(type);
  }
}