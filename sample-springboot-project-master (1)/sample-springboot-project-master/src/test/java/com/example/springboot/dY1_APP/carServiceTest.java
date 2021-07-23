package com.example.springboot.dY1_APP;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class carServiceTest {
    public  ArrayList<carList> carBmwAudi = new ArrayList();


    @BeforeEach
    void setUp() throws IOException {
        String file = "src\\bmw.csv";
        BufferedReader reader = null;
        String Line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            int i = 0;

            while ((Line = reader.readLine()) != null) {
                String[] row = Line.split(",");

                //System.out.println(Arrays.toString(row));
                if (i != 0) {
                    String a="b";
                    a=a+ i;
                    carBmwAudi.add(new carList(a,row[0], row[1], Integer.parseInt(row[2]), row[3], Integer.parseInt(row[4]), row[5],
                            Integer.parseInt(row[6]), Double.parseDouble(row[7]), Double.parseDouble(row[8])));
                }
                /*carBmwAudi.add(row);
                for(String index:row)System.out.printf("%-10s ", index);*/
                i += 1;

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        file = "src\\audi.csv";
        reader = null;
        Line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            int i = 0;

            while ((Line = reader.readLine()) != null) {
                String[] row = Line.split(",");

                //System.out.println(Arrays.toString(row));
                if (i != 0) {
                    String z="a";
                    z=z+ i;
                    carBmwAudi.add(new carList(z,row[0], row[1], Integer.parseInt(row[2]), row[3], Integer.parseInt(row[4]), row[5],
                            Integer.parseInt(row[6]), Double.parseDouble(row[7]), Double.parseDouble(row[8])));
                }
                /*carBmwAudi.add(row);
                for(String index:row)System.out.printf("%-10s ", index);*/
                i += 1;

            }

        } finally {
            reader.close();
        }
    }

    @Test
    void getByid() {
        carList result= new carList("a8631", " R8","2018", 95950, "Automatic", 5044, "Petrol", 150, 23.0, 5.2);
        carList testresult=carService.getByid("a8631",carBmwAudi);
        assertEquals(true,result.equals(testresult));
    }
    @Test
    void  getByidNotfound(){
        carList result=null;
        carList testresult=carService.getByid("a89631",carBmwAudi);
        if(result==testresult && testresult==null)assertEquals(0,0);

    }
    @Test
    void autopetrol() {
        carList result=new carList("b9696", " 3 Series","2008",4250,"Automatic", 141000,"Petrol", 235, 39.8,3.0);
        carList Testresul=null;
        Testresul=carService.autopetrol(carBmwAudi);
        assertEquals(true,result.equals(Testresul));

    }

    @Test
    void newestandLowest() {
        carList result=new carList("a10666", " A3","2020",17199,"Manual", 609,"Petrol", 150, 49.6,1.0);
        carList Testresul=null;
        Testresul=carService.newestandLowest(carBmwAudi);
        assertEquals(true,result.equals(Testresul));
    }

    @Test
    void tencheapestcarwithenginesize2() {
        String[] resid= {"b9697" , "b9555" , "b9407","a7796","b9221","b9919","a9823","b7359","b7429","b10022"};
        ArrayList<carList> resultar = new ArrayList();
        for(String x:resid){
            resultar.add(carService.getByid(x,carBmwAudi));
        }
        List testres=carService.Tencheapestcarwithenginesize2(carBmwAudi);

        for(int i=0; i<10;i++){
            assertEquals(true,resultar.get(i).equals(testres.get(i)));

        }
    }

    @Test
    void Audimanualdiesel() {
        carList result= null;
        result=carService.getByid("a9823",carBmwAudi);
        carList testresult=null;
        testresult=carService.Audimanualdiesel(carBmwAudi);
        assertEquals(true,result.equals(testresult));
    }

    @Test
    void Fivemodelmilege7000() {
        String[] resid= {"b2324" , "b9651" , "b7351","a9169","a4411"};
        ArrayList<carList> resultar = new ArrayList();
        for(String x:resid){
            resultar.add(carService.getByid(x,carBmwAudi));
        }
        List testres=carService.Fivemodelmilege7000(carBmwAudi);

        for(int i=0; i<testres.size();i++){
            assertEquals(true,resultar.get(i).equals(testres.get(i)));

        }

    }
    @Test
    void TenPetrolwithtax(){
        String[] resid= {"b5363" , "a5981" , "b7395","a10073","a7476","a7690","a452","a7289","a2278","a9869"};
        ArrayList<carList> resultar = new ArrayList();
        for(String x:resid){
            resultar.add(carService.getByid(x,carBmwAudi));
        }
        List testres=carService.TenPetrolwithtax(carBmwAudi);

        for(int i=0; i<testres.size();i++){
            assertEquals(true,resultar.get(i).equals(testres.get(i)));

        }
    }
    @Test
    void Fivesemiauto(){
        String[] resid= {"b3639" , "b3498" , "b6986","b4321","a4375"};
        ArrayList<carList> resultar = new ArrayList();
        for(String x:resid){
            resultar.add(carService.getByid(x,carBmwAudi));
        }
        List testres=carService.Fivesemiauto(carBmwAudi);

        for(int i=0; i<testres.size();i++){
            assertEquals(true,resultar.get(i).equals(testres.get(i)));

        }
    }
    @Test
    void  top3_80k_100k(){
        String[] resid= {"b5363" , "a3712" , "a8631"};
        ArrayList<carList> resultar = new ArrayList();
        for(String x:resid){
            resultar.add(carService.getByid(x,carBmwAudi));
        }
        List testres=carService.top3_80k_100k(carBmwAudi);

        for(int i=0; i<testres.size();i++){
            assertEquals(true,resultar.get(i).equals(testres.get(i)));

        }
    }
}