
/*
  @author   george
  @project   Default (Template) Project
  @class  ${NAME}
  @version  1.0.0 
  @since 20.09.23 - 19.24
*/

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    public static List<CafeRecord> getRecordsByPrice(List<CafeRecord> records) {

        return records.stream()
                .sorted(Comparator.comparing(CafeRecord::getPrice))
                .toList();
    }
    public static String getFavoriteItem(Client client, List<CafeRecord> cafeRecords) {

        // get all items of the client
        List<Item> items = cafeRecords.stream()
                .filter(rec -> rec.getClient().equals(client))
                .map(CafeRecord::getItem)
                .toList();
        items.forEach(System.out::println);

        final Map<String, Long> map = items.stream()
                .map(item -> item.getName())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       List<ItemCount> counts = new ArrayList<>();

       map.entrySet().forEach( entry ->
               { counts.add(new ItemCount(entry.getKey(),  entry.getValue()));}
       );
        System.out.println(counts);
        String favorite = counts.stream()
                .max(Comparator.comparing(ItemCount::getCount))
                .orElse(null)
                .getName();


        return favorite;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");


        Ingredient water = new Ingredient("BonAqua", LocalDate.of(2024, 1, 1));
        Ingredient coffee = new Ingredient("Arabiqua", LocalDate.of(2024, 5, 1));
        Ingredient milk = new Ingredient("Ферма", LocalDate.of(2023, Month.NOVEMBER, 1));
        Ingredient iceCream = new Ingredient("Рудь", LocalDate.of(2023, Month.DECEMBER, 1));
        Ingredient lemon = new Ingredient("Лимон", LocalDate.of(2023, Month.OCTOBER, 1));
        Ingredient martini = new Ingredient("Marengo", LocalDate.of(2024, Month.OCTOBER, 1));
        Ingredient juice = new Ingredient("Orange", LocalDate.of(2023, Month.OCTOBER, 15));
        Ingredient sugar = new Ingredient("Sugar", LocalDate.of(2025, Month.OCTOBER, 15));
//-----------------------------------------------------------------------------------------------------------
        Item americano = new Item(ItemType.DRINK, "americano", List.of(water, coffee, sugar));
        Item latte = new Item(ItemType.DRINK, "latte", List.of(water, coffee, sugar, milk));
        Item gliasseCoffee = new Item(ItemType.DRINK, "Gliasse", List.of(water, coffee, sugar, iceCream));
        Item cocktail = new Item(ItemType.DRINK, "cocktail", List.of(martini, juice, lemon));

        //----------------------------------------------------------------------------

        Client john = new Client("John Lennon", LocalDate.of(1940, 12, 6), "12345");
        Client freddy = new Client("Freddy Mercury", LocalDate.of(1950, 11, 6), "12345");
        Client paul = new Client("Paul McCartney", LocalDate.of(1941, 6, 6), "12345");

//--------------------------------------------------------------------------------------
        Worker britney = new Worker("Britney Spears", LocalDate.of(1970, 3, 1), "Barista");
        Worker tarja = new Worker("Tarja Turunen", LocalDate.of(1972, 3, 1), "Waitress");

//----------------------------------------------------------------

        CafeRecord r1 = new CafeRecord(john, americano, britney, 40, LocalDate.of(2023, Month.SEPTEMBER, 15));
        CafeRecord r2 = new CafeRecord(paul, americano, tarja, 45, LocalDate.of(2023, 9, 16));
        CafeRecord r3 = new CafeRecord(freddy, latte, tarja, 50, LocalDate.of(2023, 9, 17));
        CafeRecord r4 = new CafeRecord(freddy, americano, tarja, 45, LocalDate.of(2023, 9, 18));
        CafeRecord r5 = new CafeRecord(freddy, gliasseCoffee, tarja, 60, LocalDate.of(2023, 9, 19));
        CafeRecord r6 = new CafeRecord(freddy, gliasseCoffee, britney, 60, LocalDate.of(2023, 9, 20));
        CafeRecord r7 = new CafeRecord(freddy, cocktail, britney, 100, LocalDate.of(2023, 9, 16));
        List<CafeRecord> records = List.of(r1,r2, r3, r4, r5, r6, r7);
        //------------------------------------------------------------------------------------------------
        System.out.println(getFavoriteItem(freddy, records));
        getRecordsByPrice(records).forEach(System.out::println);

    }


}
