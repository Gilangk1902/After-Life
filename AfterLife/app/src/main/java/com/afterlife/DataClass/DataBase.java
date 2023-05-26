package com.afterlife.DataClass;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataBase {
    public static ArrayList<Funeral> funeralsData = new ArrayList<Funeral>();
    public static ArrayList<Deceased> deceasedData = new ArrayList<>();
    public static ArrayList<Promo> promosData = new ArrayList<>();
    public static ArrayList<String> cities = new ArrayList<>();
    public static ArrayList<User> userData = new ArrayList<>();
    public static ArrayList<Coffin> coffinsData = new ArrayList<>();
    public static ArrayList<Accessory> otherAppliancesData = new ArrayList<>();

    public static ArrayList<Integer> dayList = new ArrayList<>();
    public static ArrayList<Integer> hourList = new ArrayList<>();
    public static ArrayList<Integer> minuteList = new ArrayList<>();
    public static ArrayList<Integer> yearList = new ArrayList<>();
    public static ArrayList<String> monthList = new ArrayList<>();

    public static boolean User_is_email_n_password_match(int position, EditText email, EditText password){
        if(userData.get(position).getEmail().equals(email.getText().toString())
                && userData.get(position).getPassword().equals(password.getText().toString())){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean User_email_is_found_but_password_dont_match(int position, EditText email, EditText password){
        if(userData.get(position).getEmail().equals(email.getText().toString())
                && !userData.get(position).getPassword().equals(password.getText().toString())){
            return true;
        }
        else{
            return false;
        }
    }

    public static void DataInit() {
        funeralsData.add(new Funeral("Funeral Home Oasis Lestarti",
                4.5f, "", "Christian", 34,
                "https://placekitten.com/300/300",
                new ArrayList<String>(){
                    {
                        add("Mortuarium");
                        add("Columbarium");
                        add("Crematorium");
                    }
                }));
        funeralsData.add(new Funeral("Funeral Home Oasis Lestarti",
                4.5f, "", "Christian", 34,
                "https://placekitten.com/300/300",
                new ArrayList<String>(){
                    {
                        add("Mortuarium");
                        add("Columbarium");
                        add("Crematorium");
                    }
                }));
        cities.add("Jakarta Selatan");
        cities.add("Tangerang Selatan");

        userData.add(new User("Gilang",
                "1@gmail.com", "123"));

        Init_Promos();
        Init_DeceasedData();
        Init_Dates();
        Init_CoffinsData();
        Init_Accessories();
    }

    private static void Assign_Items(ArrayList<Integer> arrayList, int start_value,int end){
        for(int i=start_value;i<=end;i++){
            arrayList.add(i);
        }
    }

    private static void Init_Dates(){
        Assign_Items(dayList, 1, 31);
        Assign_Items(hourList, 0, 24);
        Assign_Items(minuteList, 0, 60);
        Assign_Items(yearList, 1940, 2023);
        Assign_Months();
    }

    private static void Init_DeceasedData(){
        deceasedData.add(new Deceased("Christian Aiden Wijaya", 123,
                new GregorianCalendar(1995, Calendar.DECEMBER, 20).getTime(),
                new GregorianCalendar(2023, Calendar.MARCH, 31).getTime(),
                "Male", "Chatolic Christian"));

        deceasedData.add(new Deceased("Gilang Kurniawan", 124,
                new GregorianCalendar(2003, Calendar.FEBRUARY, 19).getTime(),
                new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(),
                "Male", "Islam"));
    }

    private static void Init_CoffinsData(){
        coffinsData.add(new Coffin(
                new Purchaseable("Fiberboard Jepara Coffin",4.5f, 23,
                        "https://placekitten.com/300/300", "Tangerang Selatan") ,
                5000000, "Condition: New\n" +
                "Unit Weight: 100 - 250g\n" +
                "Category: Coffin", "",
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                },
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                }
        ));

        coffinsData.add(new Coffin(
                new Purchaseable("Fiberboard Jepara Coffin",4.5f, 23,
                        "https://placekitten.com/300/300", "Tangerang Selatan") ,
                5000000, "Condition: New\n" +
                "Unit Weight: 100 - 250g\n" +
                "Category: Coffin", "",
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                },
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                }
        ));
    }

    private static void Init_Accessories(){
        otherAppliancesData.add(new Accessory(
                new Purchaseable("Fiberboard Jepara Coffin",4.5f, 23,
                        "https://placekitten.com/300/300", "Tangerang Selatan") ,
                5000000, "Condition: New\n" +
                "Unit Weight: 100 - 250g\n" +
                "Category: Coffin", "",
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                },
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                }
        ));

        otherAppliancesData.add(new Accessory(
                new Purchaseable("Fiberboard Jepara Coffin",4.5f, 23,
                        "https://placekitten.com/300/300", "Tangerang Selatan") ,
                5000000, "Condition: New\n" +
                "Unit Weight: 100 - 250g\n" +
                "Category: Coffin", "",
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                },
                new ArrayList<String>(){
                    {
                        add("");
                        add("");
                    }
                }
        ));
    }

    private static void Init_Promos(){
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
    }

    private static void Assign_Months(){
        String[] months_name = {"January",
                            "February",
                            "March",
                            "April",
                            "May",
                            "June",
                            "July",
                            "August",
                            "September",
                            "October",
                            "November",
                            "December"
                            };
        for(int i=0;i<months_name.length;i++){
            monthList.add(months_name[i]);
        }
    }
}
