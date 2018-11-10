package com.dirsha;

import com.dirsha.model.coffee.CoffeeQuantity;
import com.dirsha.model.coffee.PackagedCoffee;
import com.dirsha.model.coffee.coffee_stock.PackagedCoffeeStock;
import com.dirsha.model.van.Van;
import com.dirsha.utils.CoffeeFinder;
import com.dirsha.utils.CoffeeLoader;
import com.dirsha.utils.CoffeeSorter;
import com.dirsha.utils.SearchOptionsConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.dirsha.utils.PrepareData.createPackagedCoffees;

public class Main {

    private static ArrayList<PackagedCoffee> mPackagedCoffeeArrayList = new ArrayList<>();
    private static int mVanVolume = 500;
    private static double mOrderCost = 1000000;
    public static void main(String[] args) {
        System.out.println("================ All possible coffee ================");
        mPackagedCoffeeArrayList = createPackagedCoffees();
        for(PackagedCoffee packagedCoffee: mPackagedCoffeeArrayList) {
            System.out.println(packagedCoffee.toString());
        }
        System.out.println();

        System.out.println("================ load van ================");
        Van van = new Van(500);
        CoffeeLoader.load(van, mOrderCost, mVanVolume, mPackagedCoffeeArrayList);

        for (PackagedCoffeeStock packagedCoffeeStock : van.getCargo()) {
            System.out.println(packagedCoffeeStock.getPackagedCoffee().toString() + " : " + packagedCoffeeStock.getNumber());
        }
        System.out.println();
        CoffeeSorter.sort(van.getCargo());

        System.out.println("================ sort cargo ================");
        for(PackagedCoffeeStock packagedCoffeeStock: van.getCargo()) {
            System.out.println(packagedCoffeeStock.getPackagedCoffee().toString() + " : " +packagedCoffeeStock.getNumber());
        }
        System.out.println();

        Map map = new HashMap<String, String>();
        map.put(SearchOptionsConst.PRICE, Double.toString(2500.0));
        map.put(SearchOptionsConst.COFFEE_QUANTITY, CoffeeQuantity.AB.name());

        System.out.println("================ find coffee: cost > 2500, Quantity only AB ================");
        Set<PackagedCoffee> list = CoffeeFinder.find(van.getCargo(), map);
        for(PackagedCoffee packagedCoffee: list) {
            System.out.println(packagedCoffee.toString());
        }
    }




}
