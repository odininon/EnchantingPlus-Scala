package com.aesireanempire.eplus.network

import com.aesireanempire.eplus.blocks.BlockAdvEnchantmentTable
import com.aesireanempire.eplus.blocks.entities.TileEntityAdvEnchantmentTable
import com.aesireanempire.eplus.items.ItemAdvTableUpgrade
import com.aesireanempire.eplus.render.{RenderAdvTable, FixedTechneModelLoader}
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.entity.RenderItem
import net.minecraft.client.resources.model.ModelResourceLocation
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.client.model.AdvancedModelLoader
import net.minecraft.item.Item;

class ClientProxy extends CommonProxy {
    override def init() {
        super.init()
        AdvancedModelLoader.registerModelHandler(new FixedTechneModelLoader())

        val modelMesher = Minecraft.getMinecraft.getRenderItem.getItemModelMesher

        //blocks
        modelMesher.register(Item.getItemFromBlock(BlockAdvEnchantmentTable), 0, new ModelResourceLocation("eplus:advEnchantmentTable", "inventory"))

        //items
        modelMesher.register(ItemAdvTableUpgrade, 0, new ModelResourceLocation("eplus:advTableUpgrade", "inventory"))

        ClientRegistry.bindTileEntitySpecialRenderer(classOf[TileEntityAdvEnchantmentTable], RenderAdvTable)
    }
}
