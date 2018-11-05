package com.dirsha.utils;

import com.dirsha.PrepareData;
import com.dirsha.model.coffee_stock.PackagedCoffeeStock;
import com.dirsha.model.van.Van;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author = Vadim Dirsha
 * @date = 05.11.2018
 */
public class CoffeeLoaderTest {

    @Test
    public void testComplianceLoadParameters() {
        int volume = 500;
        double cost = 100000.0;
        Van van = new Van(volume);
        CoffeeLoader.load(van, cost, van.getUsefulVolume(), PrepareData.createPackagedCoffees());

        int tempVolume = 0;
        double tempCost = 0.0;
        for (PackagedCoffeeStock packagedCoffeeStock : van.getCargo()) {
            tempVolume += packagedCoffeeStock.getNumber() * packagedCoffeeStock.getPackagedCoffee().getPackaging().getVolume();
            tempCost += packagedCoffeeStock.getNumber() * packagedCoffeeStock.getPackagedCoffee().getPrice();
        }

        assertEquals(tempCost < cost, true);
        assertEquals(tempVolume < volume, true);
    }
}