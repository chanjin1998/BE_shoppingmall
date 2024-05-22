package exercise.etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> sportStars = new ArrayList<>();
        Map<Integer, String> fruits = new HashMap<>();
        sportStars.add("김연아");
        sportStars.add("박태환");
        sportStars.add("손흥민");
        sportStars.add("황희찬");
        sportStars.add("이강인");

        fruits.put(1,"apple");
        fruits.put(2,"melon");
        fruits.put(3,"watermelon");
        fruits.put(4,"orange");
        fruits.put(5,"banana");



        for (int i = 0; i< sportStars.size();i++){
            System.out.println(sportStars.get(i));
        }
        // Iterator 문
        Iterator<String> sportStarIterator = sportStars.iterator();
        while(sportStarIterator.hasNext()){
            System.out.println(sportStarIterator.next());
        }
        Iterator<String> fruitIterator = fruits.values().iterator();
        while(fruitIterator.hasNext()){
            System.out.println(fruitIterator.next());
        }
        Iterator<Integer> keyFruitIterator = fruits.keySet().iterator();
        while(keyFruitIterator.hasNext()){
            System.out.println(keyFruitIterator.next());
        }
        // for each 문
        for (String sportStar : sportStars){
            if (sportStar == "김연아")
                sportStars.remove(sportStar);
            System.out.println(sportStar);
        }
        for (String fruit : fruits.values()){
            System.out.println(fruit);
        }
    }
}
