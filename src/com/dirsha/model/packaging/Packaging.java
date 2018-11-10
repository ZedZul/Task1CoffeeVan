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
package com.dirsha.model.packaging;

/**
 * @author = Vadim Dirsha
 * @date = 22.10.2018
 */
public class Packaging implements IPackaging {

    private PackagingType mType;
    private PackagingSize mSize;
    private int mVolume;

    public Packaging(PackagingType pType, PackagingSize pSize) {
        mType = pType;
        mSize = pSize;
        mVolume = mType.getVolumeModifier() + mSize.getSizeValue();
    }

    public PackagingType getType() {
        return mType;
    }

    public PackagingSize getSize() {
        return mSize;
    }

    public int getVolume() {
        return mVolume;
    }

    public int getPrice() {
        return this.getVolume() + mType.getPriceModifier() * 2;
    }

    @Override
    public String toString() {
        return String.join(" ", mType.name(), mSize.name());
    }
}
