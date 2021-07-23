package com.example.springboot.dY1_APP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class mainapp {
    public static ArrayList<carList> carBmwAudi = new ArrayList();
    public static void main(String[] args) throws IOException {

        System.out.println("hello");
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
        String queryId = "";
        for (int i = 0; i < 5; i++) {
            //System.out.println(carBmwAudi.get(i).toString());
            queryId = carBmwAudi.get(i).id;
        }
        //get cardetails by Id
        queryId="a8631";
        System.out.println(carService.getByid(queryId,carBmwAudi));
        //Bmw car of automatic type and fuel type petrol
        System.out.println(carService.autopetrol(carBmwAudi) );
        //newest car with lowest price
        System.out.println( carService.newestandLowest(carBmwAudi) );
        //Audi car wth manual transmission and diesel type fuel
        System.out.println(carService.Audimanualdiesel(carBmwAudi));
        //TEncheapest car of engine size 2
        System.out.println("Tencheapest car with eg -2");
        List cheapcar=(carService.Tencheapestcarwithenginesize2(carBmwAudi));
        for (int i=0;i<10;i++){
            System.out.println(cheapcar.get(i));
        }
        //Top 5 model with milege greater than 70000
        System.out.println("top Model 70000");
        List topmodel=(carService.Fivemodelmilege7000(carBmwAudi));
        for (int i=0;i<5;i++){
            System.out.println(topmodel.get(i));
        }
        //top 10 model with tax >200 and type petrol
        List<carList> topmode= new ArrayList<>();
        topmode=(carService.TenPetrolwithtax(carBmwAudi));
        System.out.println("tax<200 and petrol");
        for(int i=0;i<topmode.size();i++){
            System.out.println(topmode.get(i).series + " " + topmode.get(i).transmission + " "+ topmode.get(i).id);
        }
        //top 5 semi-auto model
        topmodel=(carService.Fivesemiauto(carBmwAudi));
        System.out.println("semi-auto");
        for(int i=0;i<topmodel.size();i++){
            System.out.println(topmodel.get(i));
        }
        //top 3 model between price 80-100
        topmodel=(carService.top3_80k_100k(carBmwAudi));
        System.out.println("top 3 between 80k-100k");
        for(int i=0;i<topmodel.size();i++){
            System.out.println(topmodel.get(i));
        }
    }
    
}
