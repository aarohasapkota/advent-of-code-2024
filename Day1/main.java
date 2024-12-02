import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

import static java.lang.Math.abs;

public class main {
    public static void main(String[] args) {
//Creating arraylists to store the values of the two columns
        ArrayList<Integer> c1= new ArrayList<>();
        ArrayList<Integer> c2= new ArrayList<>();
        //Creating sum variable to store the sum of the products of the two columns.
        int sum = 0;


        try{
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split("   ");
                c1.add(Integer.parseInt(parts[0]));
                c2.add(Integer.parseInt(parts[1]));
            }
        } catch(FileNotFoundException e){
            System.out.println("An error occurred.");
        }


        c1 = sortArray(c1);
        c2 = sortArray(c2);

        System.out.println(c1);
        System.out.println(c2);

        int l = c1.size();
        for(int i = 0; i <l; i++){
            int n = c1.get(i);
            int count = getOccurences(c2, n);
            sum = sum + (n*count);
        }

        System.out.println(sum);

    }

    public static ArrayList<Integer> sortArray(ArrayList<Integer> a) {
        Collections.sort(a);
        return a;
    }

    public static int getOccurences(ArrayList<Integer> c, int n){
        int ind = c.indexOf(n);
        if (ind == -1){
            return 0;
        }
        int count = 0;
        for(int i = ind;i<c.size();i++){
            if(c.get(i) == n){
                count++;
            }else{
                break;
            }
        }
        return count;

    }
}
