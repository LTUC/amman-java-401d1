/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        // old way ...

        // new way -> 2 options
        Path path = Paths.get("unicorns.txt");

        // option 1, using Files to read all lines
//        try {
//            List<String> lines = Files.readAllLines(path);
//            System.out.println(lines.size());
//
//        } catch (IOException ex){
//            ex.printStackTrace();
//        }

        BufferedReader reader = null;
        // option 2
        try {
            reader = Files.newBufferedReader(path);
            String line = reader.readLine();

            while(line != null){
                System.out.println("- "+line);
                line = reader.readLine();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch(IOException e){
                    System.out.println("an error occurred while closing the file");
                }
            }
        }




        // no duplicates
//        Set<Integer> set = new HashSet();
//        set.add(5);
//        set.add(10);
//        set.add(15);
//
//        for(Integer i : set){
//            System.out.println(i);
//        }
//
//        set.add(5);
//        set.add(20);
//        System.out.println("Log after adding 2 items ...");
//        for(Integer i : set){
//            System.out.println(i);
//        }
//
//        set.remove(5);
//        System.out.println("Log after adding removing 5 ...");
//        for(Integer i : set){
//            System.out.println(i);
//        }

        // Track the votes on certain Items
        // A  , B , C , D , E , F
//        HashMap<String, Integer> itemsVoting = new HashMap<String, Integer>();
//
//        itemsVoting.put("A",0);
//        itemsVoting.put("B",0);
//        itemsVoting.put("C",0);
//        itemsVoting.put("E",0);
//        itemsVoting.put("F",0);
//
//        itemsVoting.put("A", itemsVoting.get("A")+1);
//        itemsVoting.put("A", itemsVoting.get("A")+1);
//        itemsVoting.put("B", itemsVoting.get("B")+1);
//        itemsVoting.put("C", itemsVoting.get("C")+1);
//
//        // Map Entry (Key, Value)
//        for(Map.Entry item : itemsVoting.entrySet()){
//            System.out.println(item);
//        }
//
//        // Map Keys
//        for(String key: itemsVoting.keySet()){
//            System.out.println(key);
//        }
//
//        // Map Values
//        for(Integer val : itemsVoting.values()){
//            System.out.println(val);
//        }


    }
}