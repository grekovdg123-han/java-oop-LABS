package com.mycompany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lab04Main {

    public static void main(String[] args) {

        // 1. Создаём список из 10 квартир
        List<Apartment> apartments = Arrays.asList(
            new Apartment(1, "ул. Ленина, 1", 45.0, 1, 5_000_000),
            new Apartment(2, "пр. Мира, 10", 65.5, 2, 8_500_000),
            new Apartment(3, "ул. Пушкина, 5", 30.0, 1, 4_000_000),
            new Apartment(4, "ЖК Солнечный", 80.0, 3, 12_000_000),
            new Apartment(1, "ул. Ленина, 1", 45.0, 1, 5_000_000), // Дубликат первой квартиры
            new Apartment(6, "пр. Победы, 22", 55.0, 2, 7_000_000),
            new Apartment(7, "ул. Гагарина, 8", 120.0, 4, 18_000_000),
            new Apartment(8, "ЖК Лесной", 42.0, 1, 4_500_000),
            new Apartment(9, "пр. Мира, 15", 75.0, 3, 11_000_000),
            new Apartment(10, "ул. Советская, 3", 51.0, 2, 6_500_000)
        );

        // 2. Три сортировки
        System.out.println("=== СОРТИРОВКА ПО АДРЕСУ ===");
        List<Apartment> byAddress = new ArrayList<>(apartments);
        byAddress.sort(Comparator.comparing(Apartment::getAddress));
        byAddress.forEach(System.out::println);

        System.out.println("\n=== СОРТИРОВКА ПО ПЛОЩАДИ ===");
        List<Apartment> byArea = new ArrayList<>(apartments);
        byArea.sort(Comparator.comparingDouble(Apartment::getArea));
        byArea.forEach(System.out::println);

        System.out.println("\n=== СОРТИРОВКА ПО ЦЕНЕ ===");
        List<Apartment> byPrice = new ArrayList<>(apartments);
        byPrice.sort(Comparator.comparingDouble(Apartment::getPrice));
        byPrice.forEach(System.out::println);

        // 3. Set: проверяем удаление дубликата
        Set<Apartment> uniqueApartments = new HashSet<>(apartments);
        System.out.println("\n=== ПРОВЕРКА SET ===");
        System.out.println("Элементов в List: " + apartments.size());
        System.out.println("Элементов в Set: " + uniqueApartments.size());

        // 4. Map: группировка по количеству комнат
        Map<Integer, List<Apartment>> byRooms = apartments.stream()
            .collect(Collectors.groupingBy(Apartment::getRooms));

        System.out.println("\n=== ГРУППИРОВКА ПО КОМНАТАМ ===");
        byRooms.forEach((rooms, list) -> {
            System.out.println(rooms + " комн.:");
            list.forEach(apartment -> System.out.println("  " + apartment));
        });

        // 5. Stream API: фильтрация
        List<Apartment> largeApartments = apartments.stream()
            .filter(apartment -> apartment.getArea() > 50)
            .collect(Collectors.toList());

        System.out.println("\n=== КВАРТИРЫ ПЛОЩАДЬЮ БОЛЬШЕ 50 м² ===");
        largeApartments.forEach(System.out::println);

        // 6. Stream API: средняя цена по количеству комнат
        Map<Integer, Double> averagePriceByRooms = apartments.stream()
            .collect(Collectors.groupingBy(
                Apartment::getRooms,
                Collectors.averagingDouble(Apartment::getPrice)
            ));

        System.out.println("\n=== СРЕДНЯЯ ЦЕНА ПО КОЛИЧЕСТВУ КОМНАТ ===");
        averagePriceByRooms.forEach((rooms, averagePrice) ->
            System.out.printf("%d комн.: %.0f руб.%n", rooms, averagePrice)
        );

        // 7. Сравнение скорости поиска в ArrayList и HashSet
        System.out.println("\n=== СРАВНЕНИЕ СКОРОСТИ ПОИСКА ===");

        List<Apartment> bigList = new ArrayList<>();
        Set<Apartment> bigSet = new HashSet<>();

        for (int i = 0; i < 100_000; i++) {
            Apartment apartment = new Apartment(
                i, "Адрес " + i, 40.0, 1, 4_000_000
            );
            bigList.add(apartment);
            bigSet.add(apartment);
        }

        Apartment target = new Apartment(
            100_000, "Искомая квартира", 50.0, 2, 5_000_000
        );
        bigList.add(target);
        bigSet.add(target);

        long listStart = System.nanoTime();
        boolean foundInList = bigList.contains(target);
        long listTime = System.nanoTime() - listStart;

        long setStart = System.nanoTime();
        boolean foundInSet = bigSet.contains(target);
        long setTime = System.nanoTime() - setStart;

        System.out.printf(
            "ArrayList: %.3f мс, найдено: %b%n",
            listTime / 1_000_000.0, foundInList
        );
        System.out.printf(
            "HashSet:   %.3f мс, найдено: %b%n",
            setTime / 1_000_000.0, foundInSet
        );
    }
}