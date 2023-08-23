package org.obs.basics;

import java.util.ArrayList;
import java.util.Iterator;

public class ListPrograms {
    public static void main(String[] args) {
        ArrayList<String> PgmLang=new ArrayList<String>();
        PgmLang.add("Java");
        PgmLang.add("Rubi_Shell");
        PgmLang.add("php");
        PgmLang.add("Rubi");
        PgmLang.add("Python");
        PgmLang.add(".net");



        System.out.println(PgmLang);
        int size= PgmLang.size();
        System.out.println("Size of the ArrayList = "+size);
        //Iterator<String> it=PgmLang.iterator();
        if(PgmLang.contains("Python"))
        {
            System.out.println("Python already existing");

        }
        else {
            PgmLang.add("Python");
            System.out.println(PgmLang);

        }
        int s=PgmLang.indexOf("Python");
        System.out.println(s);
        if(PgmLang.contains("Rubi"))
        {
            int r=PgmLang.indexOf("Rubi");
            System.out.println(r);
            PgmLang.remove(r);
            PgmLang.add(r,"HTML");
            System.out.println("Rubi removed in ");
            //PgmLang.repl
            System.out.println(PgmLang);

        }
        else {
            PgmLang.add("HTML");
            int h=PgmLang.indexOf("HTML");
            System.out.println("Rubi is not existing,hence added HTML in index"+h);
        }

        for(int i=0;i<PgmLang.size();i++)
        {
            //System.out.println("Array");
            System.out.println(PgmLang.get(i));
        }


    }
}
