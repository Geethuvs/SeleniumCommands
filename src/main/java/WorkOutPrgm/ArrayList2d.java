package WorkOutPrgm;

import java.util.ArrayList;

public class ArrayList2d {

    public static void main(String[] args) {


        ArrayList<String> snacksList = new ArrayList<String>();
        snacksList.add("Chips");
        snacksList.add("Rolls");
        snacksList.add("Cutlet");
        System.out.println(snacksList);

        ArrayList<String> drinksList=new ArrayList<String>();
        drinksList.add("Coffee");
        drinksList.add("Fresh juice");
        drinksList.add("Milk shakes");
        System.out.println(drinksList);

        ArrayList<String> fruitsList=new ArrayList<String>();
        fruitsList.add("Mango");
        fruitsList.add("Apple");
        fruitsList.add("Watermelon");
        System.out.println(fruitsList);

        ArrayList<ArrayList<String>> bakeryList=new ArrayList<ArrayList<String>>();
        bakeryList.add(snacksList);
        bakeryList.add(drinksList);
        bakeryList.add(fruitsList);
        System.out.println(bakeryList);

        ArrayList s=bakeryList.get(0);
        System.out.println(s);
        ArrayList d=bakeryList.get(1);
        System.out.println(d);
        ArrayList f=bakeryList.get(2);
        System.out.println(f);

        String s1=bakeryList.get(0).get(0);
        System.out.println(s1);
        String s2=bakeryList.get(1).get(2);
        System.out.println(s2);
        bakeryList.get(0).add("Candy");
        bakeryList.get(1).add("Mojito");
        bakeryList.get(2).add("Strawberry");
        System.out.println(bakeryList);

        System.out.println("For loop");
        //System.out.println(bakeryList.size());
        for(int i=0;i<bakeryList.size();i++)
        {
            for(int j=0;j<bakeryList.get(i).size();j++)
            {
                System.out.println(bakeryList.get(i).get(j));
            }
        }

    }
}
