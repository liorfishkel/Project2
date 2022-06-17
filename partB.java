import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class partB {
    public static void main(String[] args){
        //Q3a
        int q = 6571;
        HashMap<Integer,Integer> Q1 = new HashMap<>();
        HashMap<Integer,Integer> Q2 = new HashMap<>();
        for (int i = 0; i < q; i++){
            // Q1
            int j1 = (int) Math.pow(i, 2);
            j1 = j1 % q;
            if (j1 < 0){
                j1 += q;
            }
            if (Q1.containsKey(j1)){
                Q1.put(j1, Q1.get(j1) + 1);
            }
            else {
                Q1.put(j1, 1);
            }

            //Q2
            int j2 = (int) Math.pow(i, 2) * (int) Math.pow(-1,i);
            j2 %= q;
            if (j2 < 0){
                j2 += q;
            }
            if (Q2.containsKey(j2)){
                Q2.put(j1, Q1.get(j2) + 1);
            }
            else {
                Q2.put(j2, 1);
            }
        }

        System.out.println("Q1 size is " + Q1.keySet().size());
        System.out.println("Q2 size is " + Q2.keySet().size());


        //Q3b
        int QPError = 0;
        int AQPError = 0;
        int p = 1000000007;
        int m = q;
        for (int i = 0; i < 100; i++) {
            QPHashTable QPhash = new QPHashTable(m, p);
            AQPHashTable AQPhash = new AQPHashTable(m,p);
            Random random = new Random();
            for (int j = 0; j < m; j++){
                int b = random.nextInt(0,100);
                int a = 100 * j + b;
                try {
                    QPhash.Insert(new HashTableElement(a, 0));
                }
                catch (Exception e){
                    QPError++;
                }
                try {
                    AQPhash.Insert(new HashTableElement(a,0));
                }
                catch (Exception e){
                    AQPError++;
                }
            }
        }
        System.out.println("QPError = " + QPError);
        System.out.println("AQPError = " + AQPError);


        //Q4a
        m = 10000019;
        p = 1000000007;
        int n = (int) Math.floor(m/2);
        long start;
        long end;
        System.out.println("\nWe check class LPHashTable");
        start = System.nanoTime();
        Random random = new Random();
        LPHashTable hashTable = new LPHashTable(m,p);
        for (int j = 0; j < n; j++) {
            int b = random.nextInt(0, 100);
            int a = 100 * j + b;
            try {
                hashTable.Insert(new HashTableElement(a, 0));
            } catch (Exception e) {
            }
        }
        end = System.nanoTime();
        System.out.println("time = " + (end - start));

        System.out.println("\nWe check class QPHashTable");
        start = System.nanoTime();
        QPHashTable hashTable2 = new QPHashTable(m,p);
        for (int j = 0; j < n; j++) {
            int b = random.nextInt(0, 100);
            int a = 100 * j + b;
            try {
                hashTable2.Insert(new HashTableElement(a, 0));
            } catch (Exception e) {
            }
        }
        end = System.nanoTime();
        System.out.println("time = " + (end - start));

        System.out.println("\nWe check class AQPHashTable");
        start = System.nanoTime();
        AQPHashTable hashTable3 = new AQPHashTable(m,p);
        for (int j = 0; j < n; j++) {
            int b = random.nextInt(0, 100);
            int a = 100 * j + b;
            try {
                hashTable3.Insert(new HashTableElement(a, 0));
            } catch (Exception e) {
            }
        }
        end = System.nanoTime();
        System.out.println("time = " + (end - start));

        System.out.println("\nWe check class DoubleHashTable");
        start = System.nanoTime();
        DoubleHashTable hashTable4 = new DoubleHashTable(m,p);
        for (int j = 0; j < n; j++) {
            int b = random.nextInt(0, 100);
            int a = 100 * j + b;
            try {
                hashTable4.Insert(new HashTableElement(a, 0));
            } catch (Exception e) {
            }
        }
        end = System.nanoTime();
        System.out.println("time = " + (end - start));

        //Q4b
        System.out.println("\nSECOND PART");
        n = (int) Math.floor(m*19/20);
        System.out.println("\nWe check class LPHashTable");
        start = System.nanoTime();
        hashTable = new LPHashTable(m,p);
        for (int j = 0; j < n; j++) {
            int b = random.nextInt(0, 100);
            int a = 100 * j + b;
            try {
                hashTable.Insert(new HashTableElement(a, 0));
            } catch (Exception e) {
            }
        }
        end = System.nanoTime();
        System.out.println("time = " + (end - start));

        System.out.println("\nWe check class AQPHashTable");
        start = System.nanoTime();
        hashTable3 = new AQPHashTable(m,p);
        for (int j = 0; j < n; j++) {
            int b = random.nextInt(0, 100);
            int a = 100 * j + b;
            try {
                hashTable3.Insert(new HashTableElement(a, 0));
            } catch (Exception e) {
            }
        }
        end = System.nanoTime();
        System.out.println("time = " + (end - start));

        System.out.println("\nWe check class DoubleHashTable");
        start = System.nanoTime();
        hashTable4 = new DoubleHashTable(m,p);
        for (int j = 0; j < n; j++) {
            int b = random.nextInt(0, 100);
            int a = 100 * j + b;
            try {
                hashTable4.Insert(new HashTableElement(a, 0));
            } catch (Exception e) {
            }
        }
        end = System.nanoTime();
        System.out.println("time = " + (end - start));

        //Q5
        System.out.println("Question 5\n");
        m = 10000019;
        p = 1000000007;
        n = (int) Math.floor(m/2);
        DoubleHashTable doubleHashTable = new DoubleHashTable(m, p);

        int a;
        long endTime;
        long startTime = System.nanoTime();
        for(int j = 0; j < 6; j++){
            //Inserts
            for(int i = 0; i < n; i++){
                a = 100 * i + random.nextInt(0, 100);
                try{
                    doubleHashTable.Insert(new HashTableElement(i, a));
                }
                catch (Exception e){
                    //should never get here
                }
            }
            //Deletions
            for(int i = 0; i < n; i++){
                try{
                    doubleHashTable.Delete(i);
                }
                catch(Exception e){
                    //should never get here
                }
            }
            if(j == 2){
                endTime = System.nanoTime();
                System.out.println("First 3 iterations\n");
                System.out.println(endTime - startTime);
                startTime = System.nanoTime();
            }
        }
        endTime = System.nanoTime();
        System.out.println("Last 3 iterations\n");
        System.out.println(endTime - startTime);
    }
}
