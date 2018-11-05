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
import javafx.beans.property.Property;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class CoffeeSorter {

    public static void sort(ArrayList<PackagedCoffeeStock> packagedCoffeeStockArrayList) {
        packagedCoffeeStockArrayList.sort((s1, s2) -> {
            Double t1 = s1.getPackagedCoffee().getPrice() / s1.getPackagedCoffee().getProductWeight();
            Double t2 = s2.getPackagedCoffee().getPrice() / s2.getPackagedCoffee().getProductWeight();
            return t1.compareTo(t2);
        });

    }
}
