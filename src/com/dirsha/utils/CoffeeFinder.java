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

import com.dirsha.model.coffee.CoffeePhysicalState;
import com.dirsha.model.coffee.CoffeeQuantity;
import com.dirsha.model.coffee.PackagedCoffee;
import com.dirsha.model.coffee_stock.PackagedCoffeeStock;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class CoffeeFinder {

    public static List<PackagedCoffee> find(List<PackagedCoffeeStock> pPackagedCoffeeStockArrayList, Map<String, String> searchOption) {
        ArrayList<PackagedCoffee> foundCoffeeSet = new ArrayList<>();
        List<PackagedCoffee> tempCoffeePriceSearchOptionSet = new ArrayList<>();
        if (searchOption.containsKey(SearchOptionsConst.PRICE)) {
            tempCoffeePriceSearchOptionSet = pPackagedCoffeeStockArrayList.stream()
                    .map(PackagedCoffeeStock::getPackagedCoffee)
                    .filter(unit -> Double.parseDouble(searchOption.get(SearchOptionsConst.PRICE)) < unit.getPrice())
                    .collect(Collectors.toList());
        }
        Set<PackagedCoffee> tempCoffeeQuantitySearchOptionSet = new HashSet<>();
        if (searchOption.containsKey(SearchOptionsConst.COFFEE_QUANTITY)) {
            tempCoffeePriceSearchOptionSet = pPackagedCoffeeStockArrayList.stream()
                    .map(PackagedCoffeeStock::getPackagedCoffee)
                    .filter(unit -> CoffeeQuantity.valueOf(searchOption.get(SearchOptionsConst.COFFEE_QUANTITY)) == unit.getCoffee().getCoffeeInfo().getQuantity())
                    .collect(Collectors.toList());
        }

        Set<PackagedCoffee> tempCoffeePhysicalStateSearchOptionSet = new HashSet<>();
        if (searchOption.containsKey(SearchOptionsConst.COFFE_PHYSICAL_STATE)) {
            tempCoffeePriceSearchOptionSet = pPackagedCoffeeStockArrayList.stream()
                    .map(PackagedCoffeeStock::getPackagedCoffee)
                    .filter(unit -> CoffeePhysicalState.valueOf(searchOption.get(SearchOptionsConst.COFFE_PHYSICAL_STATE)) == unit.getCoffee().getCoffeeInfo().getPhysicalState())
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