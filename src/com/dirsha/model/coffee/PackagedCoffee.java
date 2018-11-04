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

import com.dirsha.model.packaging.Packaging;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class PackagedCoffee implements IPackagedCoffee {

    private Product mCoffee;
    private Packaging mPackaging;
    private double mProductWeight;
    private double mPrice;

    public Product getCoffee() {
        return mCoffee;
    }

    public Packaging getPackaging() {
        return mPackaging;
    }

    public double getProductWeight() {
        return mProductWeight;
    }

    public double getPrice() {
        return mPrice;
    }

    public PackagedCoffee(Product pCoffee, Packaging pPackaging) {
        mCoffee = pCoffee;
        mPackaging = pPackaging;
        mProductWeight = pPackaging.getSize().getSizeValue() * pCoffee.getWeightPerVolumeUnit();
        mPrice = pCoffee.getPricePerGr() * mProductWeight + pPackaging.getType().getPriceModifier() * 100;
    }

    @Override
    public String toString() {
        return String.join(" ", mCoffee.toString(), mPackaging.toString());
    }
}
