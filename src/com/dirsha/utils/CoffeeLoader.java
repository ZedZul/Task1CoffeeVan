/**
 * Vadim Dirsha
 * Copyright (c) 2018 Java Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.dirsha.utils;

import com.dirsha.model.coffee.PackagedCoffee;
import com.dirsha.model.coffee.coffee_stock.PackagedCoffeeStock;
import com.dirsha.model.van.Van;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class CoffeeLoader {

    public static void load(Van pVan, double pOrderCoast, int pVanVolume, List<PackagedCoffee> pPackagedCoffeeArrayList) {
        ArrayList<PackagedCoffeeStock> packagedCoffeeStockArrayList = new ArrayList<>();
        int sizePackagedCoffee = pPackagedCoffeeArrayList.size();
        int tempVolume = 0;
        double tempCoast = 0.0;
        Random random = new Random(new Date().getTime());
        while (tempVolume < pVanVolume && tempCoast < pOrderCoast) {
            packagedCoffeeStockArrayList.add(new PackagedCoffeeStock(pPackagedCoffeeArrayList.get(random.nextInt(sizePackagedCoffee)),
                    1));
            tempVolume += packagedCoffeeStockArrayList.get(packagedCoffeeStockArrayList.size() - 1).getPackagedCoffee().getPackaging().getVolume();
            tempCoast += packagedCoffeeStockArrayList.get(packagedCoffeeStockArrayList.size() - 1).getPackagedCoffee().getPrice();
        }
        if (!packagedCoffeeStockArrayList.isEmpty()) {
            packagedCoffeeStockArrayList.remove(packagedCoffeeStockArrayList.size() - 1);

            packagedCoffeeStockArrayList.stream().collect(Collectors.groupingBy(p -> p.getPackagedCoffee(), Collectors.counting()))
                    .entrySet().stream()
                    .forEach(key -> pVan.getCargo().add(new PackagedCoffeeStock(key.getKey(), key.getValue().intValue())));

        }
    }
}
