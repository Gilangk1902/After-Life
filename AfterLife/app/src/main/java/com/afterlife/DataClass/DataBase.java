package com.afterlife.DataClass;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataBase {
    public static ArrayList<Funeral> funeralsData = new ArrayList<Funeral>();
    public static ArrayList<Deceased> deceasedData = new ArrayList<>();
    public static ArrayList<Promo> promosData = new ArrayList<>();
    public static ArrayList<String> countries = new ArrayList<>();


    public static void DataInit() {
        funeralsData.add(new Funeral("Funeral Home Osis Lestari", 4.5f, "Tangerang, Banten", "Chatolic Christian", "Mortuarium",
                "Crematorium", "Columbarium", "Memorial Wall", "https://placekitten.com/300/300"));
        funeralsData.add(new Funeral("Selapajang Jaya Public Cemetery", 4.3f, "Tangerang, Banten", "All Religion", "Public burial complex",
                "", "", "", "https://res.cloudinary.com/demo/image/upload/s--1tQspuaM--/c_imagga_crop/kitten.jpg"));

        countries.add("Jakarta Selatan");
        countries.add("Tangerang Selatan");

        ArrayList<String> features1 = new ArrayList<>();
        features1.add("Funeral procession according to religion");
        features1.add("Custom tombstone");
        features1.add("Consumption for 100 pax");
        features1.add("Standard wreath of condolences");
        features1.add("Standard transportation to funeral homes or cemetery");
        promosData.add(new Promo("Standard", 15000000, features1, true));

        ArrayList<String> features2 = new ArrayList<>();
        features2.add("Funeral procession according to religion");
        features2.add("Custom tombstone and decoration");
        features2.add("Consumption for 250 pax");
        features2.add("Large wreath of condolences");
        features2.add("VIP transportation to funeral homes or cemetery");
        features2.add("Include tents and chair for guest");
        promosData.add(new Promo("VIP", 25000000, features2, true));

        deceasedData.add(new Deceased("Christian Aiden Wijaya", 123,
                new GregorianCalendar(1995, Calendar.DECEMBER, 20).getTime(),
                new GregorianCalendar(2023, Calendar.MARCH, 31).getTime(), "Male", "Chatolic Christian"));

        deceasedData.add(new Deceased("Gilang Kurniawan", 124,
                new GregorianCalendar(2003, Calendar.FEBRUARY, 19).getTime(),
                new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), "Male", "Islam"));
    }
}
