package com.dirsha.tests;

import com.dirsha.model.coffee.CoffeeInfo;
import com.dirsha.model.coffee.CoffeePhysicalState;
import com.dirsha.model.coffee.CoffeeQuantity;
import com.dirsha.model.coffee.PackagedCoffee;
import com.dirsha.model.coffee.coffee_stock.PackagedCoffeeStock;
import com.dirsha.model.coffee.coffee_type.Coffee;
import com.dirsha.utils.CoffeeFinder;
import com.dirsha.utils.SearchOptionsConst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author = Vadim Dirsha
 * @date = 05.11.2018
 */

public class CoffeeFinderTest {

    static ArrayList<PackagedCoffeeStock> mPackagedCoffeeStockArrayList;
    static PackagedCoffeeStock mMockPackagedCoffeeStock;
    static PackagedCoffee mMockPackagedCoffee;
    static Coffee mMockCoffee;
    static CoffeeInfo mMockCoffeeInfo;
    //   static PackagedCoffeeStock mSpyPackagedCoffeeStock;

    @Before
    public void initializeTestClassFields() {
        mPackagedCoffeeStockArrayList = new ArrayList<>();

        mMockPackagedCoffeeStock = mock(PackagedCoffeeStock.class);
        mMockPackagedCoffee = mock(PackagedCoffee.class);
        mMockCoffee = mock(Coffee.class);
        mMockCoffeeInfo = mock(CoffeeInfo.class);

        when(mMockPackagedCoffeeStock.getPackagedCoffee()).thenReturn(mMockPackagedCoffee);
        when(mMockPackagedCoffeeStock.getPackagedCoffee().getCoffee()).thenReturn(mMockCoffee);
        when(mMockPackagedCoffeeStock.getPackagedCoffee().getCoffee().getCoffeeInfo()).thenReturn(mMockCoffeeInfo);

//        mSpyPackagedCoffeeStock = spy(PackagedCoffeeStock.class);

        for (int i = 0; i < 10; i++) {
            mPackagedCoffeeStockArrayList.add(new PackagedCoffeeStock(mock(PackagedCoffee.class), i));

        }

        for (PackagedCoffeeStock unit : mPackagedCoffeeStockArrayList) {
            when(unit.getPackagedCoffee().getCoffee()).thenReturn(mock(Coffee.class));
            when(unit.getPackagedCoffee().getCoffee().getCoffeeInfo()).thenReturn(mock(CoffeeInfo.class));
        }
    }

    @Test
    public void findFunctionTestWitOneOptionArgument_PRICE() {

        HashMap<String, String> searchOption = new HashMap<>();

        searchOption.put(SearchOptionsConst.PRICE, Double.toString(2000.0));

        when(mPackagedCoffeeStockArrayList.get(mPackagedCoffeeStockArrayList.size() - 1).getPackagedCoffee().getPrice())
                .thenReturn(1000.0);

        for (int i = 0; i < mPackagedCoffeeStockArrayList.size() - 1; i++) {
            when(mPackagedCoffeeStockArrayList.get(i).getPackagedCoffee().getPrice()).thenReturn(3000.0);
            ;
        }

        Assert.assertEquals(CoffeeFinder.find(mPackagedCoffeeStockArrayList, searchOption).size(), mPackagedCoffeeStockArrayList.size() - 1);
        assertEquals((int) mPackagedCoffeeStockArrayList.get(mPackagedCoffeeStockArrayList.size() - 1).getPackagedCoffee().getPrice(), 1000);
    }

    @Test
    public void findFunctionTestWitOneOptionArgument_PHYSICAL_STATE() {

        HashMap<String, String> searchOption = new HashMap<>();

        searchOption.put(SearchOptionsConst.COFFE_PHYSICAL_STATE, CoffeePhysicalState.COFFEE_BEANS.name());



        for (int i = 1; i < mPackagedCoffeeStockArrayList.size(); i++) {
            when(mPackagedCoffeeStockArrayList.get(i).getPackagedCoffee().getCoffee().getCoffeeInfo().getPhysicalState())
                    .thenReturn(CoffeePhysicalState.INSTANT_COFFEE);
        }
        when(mPackagedCoffeeStockArrayList.get(0).getPackagedCoffee().getCoffee().getCoffeeInfo().getPhysicalState())
                .thenReturn(CoffeePhysicalState.COFFEE_BEANS);

        assertEquals(CoffeeFinder.find(mPackagedCoffeeStockArrayList, searchOption).size(), 1);
    }

    @Test
    public void findFunctionTestWitOneOptionArgument_QUANTITY() {

        HashMap<String, String> searchOption = new HashMap<>();

        searchOption.put(SearchOptionsConst.COFFEE_QUANTITY, CoffeeQuantity.BA.name());

        when(mPackagedCoffeeStockArrayList.get(0).getPackagedCoffee().getCoffee().getCoffeeInfo().getQuantity())
                .thenReturn(CoffeeQuantity.AA);
        for (int i = 1; i < mPackagedCoffeeStockArrayList.size(); i++) {
            when(mPackagedCoffeeStockArrayList.get(i).getPackagedCoffee().getCoffee().getCoffeeInfo().getQuantity())
                    .thenReturn(CoffeeQuantity.BA);
        }

        assertEquals(CoffeeFinder.find(mPackagedCoffeeStockArrayList, searchOption).size(), 9);
    }

    @Test
    public void findFunctionTestWitTцщOptionArgument_QUANTITY_AND_PHYSICAL_STATE() {

        HashMap<String, String> searchOption = new HashMap<>();

        searchOption.put(SearchOptionsConst.COFFEE_QUANTITY, CoffeeQuantity.BA.name());
        searchOption.put(SearchOptionsConst.COFFE_PHYSICAL_STATE, CoffeePhysicalState.COFFEE_BEANS.name());


        for (int i = 0; i < mPackagedCoffeeStockArrayList.size(); i++) {
            when(mPackagedCoffeeStockArrayList.get(i).getPackagedCoffee().getCoffee().getCoffeeInfo().getQuantity())
                    .thenReturn(CoffeeQuantity.AA);
        }
        when(mPackagedCoffeeStockArrayList.get(5).getPackagedCoffee().getCoffee().getCoffeeInfo().getQuantity())
                .thenReturn(CoffeeQuantity.BA);

        for (int i = 0; i < mPackagedCoffeeStockArrayList.size(); i++) {
            when(mPackagedCoffeeStockArrayList.get(i).getPackagedCoffee().getCoffee().getCoffeeInfo().getPhysicalState())
                    .thenReturn(CoffeePhysicalState.INSTANT_COFFEE);
        }
        when(mPackagedCoffeeStockArrayList.get(5).getPackagedCoffee().getCoffee().getCoffeeInfo().getPhysicalState())
                .thenReturn(CoffeePhysicalState.COFFEE_BEANS);

        assertEquals(CoffeeFinder.find(mPackagedCoffeeStockArrayList, searchOption).size(), 1);
    }
}