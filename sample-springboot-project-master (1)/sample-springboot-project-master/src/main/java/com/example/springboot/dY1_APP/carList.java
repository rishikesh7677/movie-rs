package com.example.springboot.dY1_APP;

import org.springframework.context.annotation.Bean;

import java.util.Objects;

public class carList {
    String id;
    String series;
    String year;
    int price;
    String transmission;
    int mileage;
    String fuelType;
    int tax;
    double mpg;
    double enginesize;

    public carList(String id,String series , String year , int price, String transmission, int mileage ,
                   String fuelType, int tax , double mpg, double enginesize) {
        this.id = id;
        this.series = series;
        this.year = year;
        this.price = price;
        this.transmission = transmission;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.tax = tax;
        this.mpg = mpg;
        this.enginesize = enginesize;

    }

    @Override
    public String toString() {
        return "carList{" +
                "id='" + id + '\'' +
                ", series='" + series + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                ", transmission='" + transmission + '\'' +
                ", mileage=" + mileage +
                ", fuelType='" + fuelType + '\'' +
                ", tax=" + tax +
                ", mpg=" + mpg +
                ", enginesize=" + enginesize +
                '}';
    }

    public  double getEnginesize() {
        return enginesize;
    }
    public int getPrice(){
        return  price;
    }

    public int getMileage() {
        return mileage;
    }

    public int getTax() {
        return tax;
    }

    public double getMpg() {
        return mpg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        carList carList = (carList) o;
        return price == carList.price && mileage == carList.mileage && tax == carList.tax && Double.compare(carList.mpg, mpg) == 0 && Double.compare(carList.enginesize, enginesize) == 0 && id.equals(carList.id) && series.equals(carList.series) && year.equals(carList.year) && transmission.equals(carList.transmission) && fuelType.equals(carList.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, series, year, price, transmission, mileage, fuelType, tax, mpg, enginesize);
    }
}

