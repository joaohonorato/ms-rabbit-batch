package br.com.portobello.digital.partnerspurchaseorderbatch.domain.factory;

import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.leroy.order.ItemLeroyDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.pba.ProductPbaDTO;
import br.com.portobello.digital.partnerspurchaseorderbatch.domain.dtos.portobello.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemFactory {
    public ItemDTO createItemDTO(ProductPbaDTO productPbaDTO) {
        var itemDTO = new ItemDTO();
        itemDTO.setInventoryItemCode(productPbaDTO.getItemSKU());
        itemDTO.setUnitPrice(productPbaDTO.getUnitPrice());
        itemDTO.setOrderedQuantity(productPbaDTO.getQuantity());
        itemDTO.setUnitOfMeasure(productPbaDTO.getUom());
        return itemDTO;
    }

    public ItemDTO createItemDTO(ItemLeroyDTO itemLeroyDTO) {
        var itemDTO = new ItemDTO();
        itemDTO.setInventoryItemCode(itemLeroyDTO.getProductSupplierCode());
        itemDTO.setUnitPrice(itemLeroyDTO.getNetPriceUnit());
        itemDTO.setOrderedQuantity(itemLeroyDTO.getProductQuantity());
        itemDTO.setUnitOfMeasure(itemLeroyDTO.getProductUnitMeasure());
        return itemDTO;
    }
}
