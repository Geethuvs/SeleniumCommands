package WorkOutPrgm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetSampleProgram {
    public static void main(String args[]){
        Set<String> names=new HashSet<>();
        names.add("Apple");
        names.add("Strawberry");
        names.add("Blueberry");
        names.add("Orange");
        names.add("Grapes");
        System.out.println(names);

        // To remove elements from the list
        names.remove("Orange");
        System.out.println(names);

        // For-each loop
        for(String name: names){
            System.out.println(name);
        }

        // Iterator
        Iterator<String> itName= names.iterator();
        while(itName.hasNext()){
            System.out.println(itName.next());
        }

        //Print size of the set
        int size=names.size();
        System.out.println(size);

        //To check the set is empty or not
        System.out.println(names.isEmpty());

        // To clear the set
        names.clear();
        System.out.println(names);
        System.out.println(names.isEmpty());
    }
}
