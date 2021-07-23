package com.example.springboot.dY1_APP;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class carService {
    //get car details by id
    public static carList getByid(String queryId,ArrayList<carList> carBmwAudi){
        for (carList x:carBmwAudi) {
            if (x.id.equals(queryId)) {
                return (x); }
        }
        return  null;
    }
    //get Bmw car of petrol type and transmission auto and maxm milege
    public  static  carList autopetrol(ArrayList<carList> carBmwAudi){
        int maxMilege=0;
        carList result=null;
        for (carList x:carBmwAudi) {
            if( x.id.startsWith("b")  && (x.transmission.equals("Automatic")) && (x.fuelType.equals("Petrol")) && x.mileage > maxMilege) {
                maxMilege = x.mileage;
                result = x; }
        }return result;
    }
     //newest model with lowest price
     public  static  carList newestandLowest(ArrayList<carList> carBmwAudi){
        int price=99999;
        String yr="1800";
        carList result=null;
        for (carList x:carBmwAudi) {
            if((x.year.compareTo(yr))==1 || (x.year.compareTo(yr))==0) {
                if(x.price<price && x.year.compareTo(yr)==0) {
                    price = x.price;
                    result = x;
                }else{
                    price = x.price;
                    yr = x.year;
                    result = x; }
            }
        }
        return result;
    }
    //top 10 cheapest car with engine size 2
    public static List Tencheapestcarwithenginesize2(ArrayList<carList> carBmwAudi){
        List listofenginesize2= (carBmwAudi.stream().filter(p -> p.getEnginesize()==2).collect(Collectors.toList()));
        listofenginesize2.sort(Comparator.comparing(carList::getPrice));
        List x=listofenginesize2.subList(0,10);
        return x;
    }
    //Audi car with manual transmission and diesel type
    public  static carList Audimanualdiesel(ArrayList<carList> carBmwAudi) {
        int maxMilege = 0;
        carList result = null;
        for (carList x : carBmwAudi) {
            if (x.id.startsWith("a") && (x.transmission.equals("Manual")) && (x.fuelType.equals("Diesel")) && x.mileage > maxMilege) {
                maxMilege = x.mileage;
                result = x;
            }
        }
        return result;
    }
    //top models with milege greater than 70000
    public static List Fivemodelmilege7000(ArrayList<carList> carBmwAudi){
        List topmodel= (carBmwAudi.stream().filter(p -> p.getMileage()>70000).collect(Collectors.toList()));
        topmodel.sort(Comparator.comparing(carList::getPrice));
        Collections.reverse(topmodel);
        List xyz=topmodel.subList(0,5);
        return xyz;
    }
    //top 10 petrol car with tax above 200
    public static List TenPetrolwithtax(ArrayList<carList> carBmwAudi){
        List topmodel= (carBmwAudi.stream().filter(p -> p.getTax()>200 && p.fuelType.equals("Petrol")).collect(Collectors.toList()));
        topmodel.sort(Comparator.comparing(carList::getPrice));
        Collections.reverse(topmodel);
        List xyz=topmodel.subList(0,10);
        return xyz;
    }
    //top 5 semi-auto model by price
    public static List Fivesemiauto(ArrayList<carList> carBmwAudi){
        List topmodel= (carBmwAudi.stream().filter(p -> p.getMpg()>60.0 && p.transmission.equals("Semi-Auto")).collect(Collectors.toList()));
        topmodel.sort(Comparator.comparing(carList::getPrice));
        Collections.reverse(topmodel);
        List xyz=topmodel.subList(0,5);
        return xyz;
    }
    //top 3 models price between 80k-100k
    public static List top3_80k_100k(ArrayList<carList> carBmwAudi){
        List topmodel= (carBmwAudi.stream().filter(p -> p.getPrice()<100000 && p.price>80000).collect(Collectors.toList()));
        topmodel.sort(Comparator.comparing(carList::getPrice));
        Collections.reverse(topmodel);
        List xyz=topmodel.subList(0,3);
        return xyz;
    }

}
