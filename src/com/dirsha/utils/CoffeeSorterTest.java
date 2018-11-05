package com.dirsha.utils;

import com.dirsha.model.coffee.PackagedCoffee;
import com.dirsha.model.coffee_stock.PackagedCoffeeStock;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author = Vadim Dirsha
 * @date = 05.11.2018
 */
public class CoffeeSorterTest {

    static ArrayList<PackagedCoffeeStock> mPackagedCoffeeStockArrayList = new ArrayList<>();

    @BeforeClass
    public static void initializeTestClassFields() {

        //create data in reverse sort order
        for (int i = 0; i < 10; i++) {
            mPackagedCoffeeStockArrayList.add(new PackagedCoffeeStock(mock(PackagedCoffee.class), i));
            when(mPackagedCoffeeStockArrayList.get(i).getPackagedCoffee().getPrice()).thenReturn(1000.0);
            when(mPackagedCoffeeStockArrayList.get(i).getPackagedCoffee().getProductWeight()).thenReturn(i * 100.0);
        }
    }

    @Test
    public void testSortPackagedCoffeeStock_PRICE_TO_WEIGHT_CHEAP_AT_THE_TOP() {
        ArrayList<PackagedCoffeeStock> resultPackagedCoffeeStockArrayList = new ArrayList<>();
        for (int i = 0; i < mPackagedCoffeeStockArrayList.size(); i++) {
            resultPackagedCoffeeStockArrayList.add(mPackagedCoffeeStockArrayList.get(i));
        }

        CoffeeSorter.sort(mPackagedCoffeeStockArrayList);
        Collections.reverse(resultPackagedCoffeeStockArrayList);

        assertEquals(mPackagedCoffeeStockArrayList, resultPackagedCoffeeStockArrayList);
    }
}