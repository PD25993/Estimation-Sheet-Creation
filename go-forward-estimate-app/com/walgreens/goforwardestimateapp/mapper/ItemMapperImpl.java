package com.walgreens.goforwardestimateapp.mapper;

import com.walgreens.goforwardestimateapp.models.Items;
import com.walgreens.goforwardestimateapp.vo.ItemsVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-18T11:53:22+0530",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.13.0.v20170516-1929, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemsVO ItemsToItemsVO(Items items) {
        if ( items == null ) {
            return null;
        }

        ItemsVO itemsVO = new ItemsVO();

        itemsVO.setItemName( items.getItemName() );
        itemsVO.setItemType( items.getItemType() );
        itemsVO.setNewOrModify( items.getNewOrModify() );
        itemsVO.setComponentComplexityForItem( items.getComponentComplexityForItem() );
        itemsVO.setDegreeOfChangesForItem( items.getDegreeOfChangesForItem() );
        itemsVO.setTechnologyForItem( items.getTechnologyForItem() );

        return itemsVO;
    }

    @Override
    public Items ItemsVOToItems(ItemsVO itemvVO) {
        if ( itemvVO == null ) {
            return null;
        }

        Items items = new Items();

        items.setItemName( itemvVO.getItemName() );
        items.setItemType( itemvVO.getItemType() );
        items.setNewOrModify( itemvVO.getNewOrModify() );
        items.setComponentComplexityForItem( itemvVO.getComponentComplexityForItem() );
        items.setDegreeOfChangesForItem( itemvVO.getDegreeOfChangesForItem() );
        items.setTechnologyForItem( itemvVO.getTechnologyForItem() );

        return items;
    }
}
