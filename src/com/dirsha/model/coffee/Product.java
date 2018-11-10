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

import com.dirsha.utils.LogMessageConst;

import java.util.logging.Logger;

/**
 * @author = Vadim Dirsha
 * @date = 03.11.2018
 */
public class Product implements IProduct {

    private static Logger log = Logger.getLogger(PackagedCoffee.class.getName());
    private String mProductName;
    private double mPricePerGr;
    private double mWeightPerVolumeUnit;
    public Product(String pProductName, double pPricePerGr, double pWeightPerVolumeUnit) {
        mProductName = pProductName;
        mPricePerGr = pPricePerGr;
        mWeightPerVolumeUnit = pWeightPerVolumeUnit;
        log.fine(LogMessageConst.OBJ_CREATE);
    }

    public static Logger getLog() {
        return log;
    }

    public String getProductName() {
        return mProductName;
    }

    public double getPricePerGr() {
        return mPricePerGr;
    }

    public double getWeightPerVolumeUnit() {
        return mWeightPerVolumeUnit;
    }
}
