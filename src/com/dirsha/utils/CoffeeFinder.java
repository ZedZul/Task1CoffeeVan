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
import com.dirsha.model.coffee_stock.PackagedCoffeeStock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class CoffeeFinder {

    public static Set<PackagedCoffee> find(List<PackagedCoffeeStock> pPackagedCoffeeStockArrayList, Map<String, String> searchOption) {
        Set<PackagedCoffee> foundCoffeeSet = new HashSet<>();
        List<PackagedCoffee> tempCoffeePriceSearchOptionSet = new ArrayList<>();
        if (searchOption.containsKey(SearchOptionsConst.PRICE)) {
            tempCoffeePriceSearchOptionSet = pPackagedCoffeeStockArrayList.stream()
                    .map(PackagedCoffeeStock::getPackagedCoffee)
                    .filter(unit -> Double.parseDouble(searchOption.get(SearchOptionsConst.PRICE)) < unit.getPrice())
                    .collect(Collectors.toList());
        }
        List<PackagedCoffee> tempCoffeeQuantitySearchOptionSet = new ArrayList<>();
        if (searchOption.containsKey(SearchOptionsConst.COFFEE_QUANTITY)) {
            tempCoffeeQuantitySearchOptionSet = pPackagedCoffeeStockArrayList.stream()
                    .map(PackagedCoffeeStock::getPackagedCoffee)
                    .filter(unit -> searchOption.get(SearchOptionsConst.COFFEE_QUANTITY).equals(unit.getCoffee().getCoffeeInfo().getQuantity().name()))
                    .collect(Collectors.toList());
        }

        List<PackagedCoffee> tempCoffeePhysicalStateSearchOptionSet = new ArrayList<>();
        if (searchOption.containsKey(SearchOptionsConst.COFFE_PHYSICAL_STATE)) {
            tempCoffeePhysicalStateSearchOptionSet = pPackagedCoffeeStockArrayList.stream()
                    .map(PackagedCoffeeStock::getPackagedCoffee)
                    .filter(unit -> searchOption.get(SearchOptionsConst.COFFE_PHYSICAL_STATE).equals(unit.getCoffee().getCoffeeInfo().getPhysicalState().name()))
                    .collect(Collectors.toList());
        }

        foundCoffeeSet.addAll(tempCoffeePhysicalStateSearchOptionSet);
        foundCoffeeSet.addAll(tempCoffeePriceSearchOptionSet);
        foundCoffeeSet.addAll(tempCoffeeQuantitySearchOptionSet);

        if (searchOption.containsKey(SearchOptionsConst.PRICE)){
            foundCoffeeSet.retainAll(tempCoffeePriceSearchOptionSet);
        }
        if (searchOption.containsKey(SearchOptionsConst.COFFE_PHYSICAL_STATE)){
            foundCoffeeSet.retainAll(tempCoffeePhysicalStateSearchOptionSet);
        }
        if (searchOption.containsKey(SearchOptionsConst.COFFEE_QUANTITY)){
            foundCoffeeSet.retainAll(tempCoffeeQuantitySearchOptionSet);
        }

        return foundCoffeeSet;
    }
}