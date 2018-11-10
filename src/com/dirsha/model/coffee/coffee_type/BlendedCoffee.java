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
package com.dirsha.model.coffee.coffee_type;

import com.dirsha.model.coffee.CoffeeInfo;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class BlendedCoffee extends Coffee {

    CoffeeInfo mSecondaryCoffeeInfo;

    public BlendedCoffee(String pProductName, CoffeeInfo pFirstCoffeeInfo, CoffeeInfo pSecondaryCoffeeInfo) {
        super(pProductName,
                (pFirstCoffeeInfo.pricePerGr() + pSecondaryCoffeeInfo.pricePerGr()) / 2.0,
                (pFirstCoffeeInfo.weightPerVolumeUnit() + pSecondaryCoffeeInfo.weightPerVolumeUnit()) / 2.0,
                pFirstCoffeeInfo);
        this.mSecondaryCoffeeInfo = pSecondaryCoffeeInfo;
    }

    @Override
    public String toString() {
        return String.join(" ", super.toString(), mSecondaryCoffeeInfo.toString());
    }
}
