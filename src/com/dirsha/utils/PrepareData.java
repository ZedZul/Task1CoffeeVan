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

import com.dirsha.NameConst;
import com.dirsha.model.coffee.CoffeeInfo;
import com.dirsha.model.coffee.CoffeePhysicalState;
import com.dirsha.model.coffee.CoffeeQuantity;
import com.dirsha.model.coffee.PackagedCoffee;
import com.dirsha.model.coffee.coffee_type.BlendedCoffee;
import com.dirsha.model.coffee.coffee_type.Coffee;
import com.dirsha.model.coffee.coffee_type.CoffeeWithTopic;
import com.dirsha.model.packaging.Packaging;
import com.dirsha.model.packaging.PackagingSize;
import com.dirsha.model.packaging.PackagingType;

import java.util.ArrayList;

/**
 * @author = Vadim Dirsha
 * @date = 05.11.2018
 */
public class PrepareData {

    public static ArrayList<PackagedCoffee> createPackagedCoffees() {
        ArrayList<PackagedCoffee> packagedCoffees = new ArrayList<>();

        CoffeeInfo coffee1 = new CoffeeInfo(NameConst.ARABICA, CoffeePhysicalState.COFFEE_BEANS, CoffeeQuantity.AA);
        CoffeeInfo coffee2 = new CoffeeInfo(NameConst.LIBERICA, CoffeePhysicalState.GROUND_COFFEE, CoffeeQuantity.AB);
        CoffeeInfo coffee3 = new CoffeeInfo(NameConst.ROBUSTA, CoffeePhysicalState.INSTANT_COFFEE, CoffeeQuantity.BB);

        CoffeeInfo coffee4 = new CoffeeInfo(NameConst.ARABICA, CoffeePhysicalState.GROUND_COFFEE, CoffeeQuantity.AA);
        CoffeeInfo coffee5 = new CoffeeInfo(NameConst.LIBERICA, CoffeePhysicalState.INSTANT_COFFEE, CoffeeQuantity.BA);
        CoffeeInfo coffee6 = new CoffeeInfo(NameConst.ROBUSTA, CoffeePhysicalState.COFFEE_BEANS, CoffeeQuantity.AB);

        CoffeeInfo coffee7 = new CoffeeInfo(NameConst.ARABICA, CoffeePhysicalState.INSTANT_COFFEE, CoffeeQuantity.AA);
        CoffeeInfo coffee8 = new CoffeeInfo(NameConst.LIBERICA, CoffeePhysicalState.COFFEE_BEANS, CoffeeQuantity.BA);
        CoffeeInfo coffee9 = new CoffeeInfo(NameConst.ROBUSTA, CoffeePhysicalState.GROUND_COFFEE, CoffeeQuantity.AB);

        BlendedCoffee product1 = new BlendedCoffee(NameConst.NESCAFE_BARISTA, coffee2, coffee3);
        BlendedCoffee product2 = new BlendedCoffee(NameConst.JACOBS_BARISTA, coffee4, coffee5);
        BlendedCoffee product3 = new BlendedCoffee(NameConst.TCHIBO_BARISTA, coffee7, coffee9);

        Coffee product4 = new Coffee(NameConst.NESCAFE, coffee1);
        Coffee product5 = new Coffee(NameConst.JACOBS, coffee6);
        Coffee product6 = new Coffee(NameConst.TCHIBO, coffee8);

        CoffeeWithTopic product7 = new CoffeeWithTopic(NameConst.NESCAFE_GOLD, coffee3, NameConst.MILK, 3, 150.0);
        CoffeeWithTopic product8 = new CoffeeWithTopic(NameConst.JACOBS_GOLD, coffee5, NameConst.SUGAR, 2, 200.0);
        CoffeeWithTopic product9 = new CoffeeWithTopic(NameConst.TCHIBO_GOLD, coffee7, NameConst.MILK_AND_SUGAR, 2.5, 175.0);

        ArrayList<Coffee> coffees = new ArrayList<>();
        coffees.add(product1);
        coffees.add(product2);
        coffees.add(product3);
        coffees.add(product4);
        coffees.add(product5);
        coffees.add(product6);
        coffees.add(product7);
        coffees.add(product8);
        coffees.add(product9);

        ArrayList<Packaging> packagings = new ArrayList<>();
        for (PackagingSize size : PackagingSize.values()) {
            for (PackagingType type : PackagingType.values()) {
                packagings.add(new Packaging(type, size));
            }
        }

        for (Coffee coffee : coffees) {
            for (Packaging packaging : packagings) {
                packagedCoffees.add(new PackagedCoffee(coffee, packaging));
            }
        }
        return packagedCoffees;
    }
}
