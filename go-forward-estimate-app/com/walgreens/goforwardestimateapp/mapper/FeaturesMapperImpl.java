package com.walgreens.goforwardestimateapp.mapper;

import com.walgreens.goforwardestimateapp.models.FeaturesComponent;
import com.walgreens.goforwardestimateapp.models.Items;
import com.walgreens.goforwardestimateapp.vo.Features;
import com.walgreens.goforwardestimateapp.vo.ItemsVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-18T11:53:24+0530",
    comments = "version: 1.3.0.Final, compiler: Eclipse JDT (IDE) 3.13.0.v20170516-1929, environment: Java 1.8.0_92 (Oracle Corporation)"
)
@Component
public class FeaturesMapperImpl implements FeaturesMapper {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Features featuresComponentToFeatures(FeaturesComponent featuresComponent) {
        if ( featuresComponent == null ) {
            return null;
        }

        Features features = new Features();

        features.setFeatureName( featuresComponent.getFeatureName() );
        features.setDevComponents( itemsListToItemsVOList( featuresComponent.getDevComponents() ) );

        return features;
    }

    @Override
    public FeaturesComponent featuresToFeaturesComponent(Features features) {
        if ( features == null ) {
            return null;
        }

        FeaturesComponent featuresComponent = new FeaturesComponent();

        featuresComponent.setFeatureName( features.getFeatureName() );
        featuresComponent.setDevComponents( itemsVOListToItemsList( features.getDevComponents() ) );

        return featuresComponent;
    }

    protected List<ItemsVO> itemsListToItemsVOList(List<Items> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemsVO> list1 = new ArrayList<ItemsVO>( list.size() );
        for ( Items items : list ) {
            list1.add( itemMapper.ItemsToItemsVO( items ) );
        }

        return list1;
    }

    protected List<Items> itemsVOListToItemsList(List<ItemsVO> list) {
        if ( list == null ) {
            return null;
        }

        List<Items> list1 = new ArrayList<Items>( list.size() );
        for ( ItemsVO itemsVO : list ) {
            list1.add( itemMapper.ItemsVOToItems( itemsVO ) );
        }

        return list1;
    }
}
