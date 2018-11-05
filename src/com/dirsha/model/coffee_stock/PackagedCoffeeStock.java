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
package com.dirsha.model.coffee_stock;

import com.dirsha.model.coffee.IPackagedCoffee;
import com.dirsha.model.coffee.PackagedCoffee;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class PackagedCoffeeStock implements ICoffeeStock {

    private PackagedCoffee mPackagedCoffee;
    int mNumber;

    public PackagedCoffee getPackagedCoffee() {
        return mPackagedCoffee;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    public PackagedCoffeeStock(PackagedCoffee pPackagedCoffee, int pNumber) {
        mPackagedCoffee = pPackagedCoffee;
        mNumber = pNumber;
    }
}
