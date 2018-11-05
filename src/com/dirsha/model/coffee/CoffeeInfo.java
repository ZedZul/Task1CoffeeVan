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
package com.dirsha.model.coffee;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class CoffeeInfo implements ICoffeeInfo {

    private String mName;
    private CoffeePhysicalState mPhysicalState;
    private CoffeeQuantity mQuantity;

    public CoffeeInfo(String pName, CoffeePhysicalState pPhysicalState, CoffeeQuantity pQuantity) {
        mName = pName;
        mPhysicalState = pPhysicalState;
        mQuantity = pQuantity;
    }

    public String getName() {
        return mName;
    }

    public CoffeePhysicalState getPhysicalState() {
        return mPhysicalState;
    }

    public CoffeeQuantity getQuantity() {
        return mQuantity;
    }

    public double pricePerGr() {
        return (double) (mPhysicalState.getMarkupPerGr() + mQuantity.getPricePerGr());
    }

    public double weightPerVolumeUnit() {
        if (mPhysicalState == CoffeePhysicalState.COFFEE_BEANS) {
            return 100;
        } else {
            return mPhysicalState == CoffeePhysicalState.INSTANT_COFFEE ? 200 : 150;
        }
    }

    @Override
    public String toString() {
        return String.join(" ", mName, mPhysicalState.name(), mQuantity.name());
    }
}
