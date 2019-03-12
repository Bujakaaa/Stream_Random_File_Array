import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final String ALFABET = "ABCDEFGHIJKLMNOPRSTUWXYZ";
    public static final Integer [] LICZBY = new Integer [] {1,2,3,6,7,8,22,35,6,2,999};

    public static void main(String[] args) throws IOException {


//        1. Wygeneruj strumień losowo wybranych liter alfabetu.
//        Stream.generate(Supplier<T> supplier)
//        2. Ogranicz ilość losowanych liter do 10.
//        Stream.limit(long maxSize)
//        3. Posortuj strumień wylosowanych liter
//        Stream.sorted()
//        4. Wypisz każdą z liter na konsoli w nowej linii,
//                Stream.forEach(Consumer<? super T> action)

        Stream <Character> losowanieLiter = Stream
                .generate(() -> {
            int pozycja = new Random().nextInt(ALFABET.length());
            return ALFABET.charAt(pozycja);
        });
        losowanieLiter
                .limit(10)
                .sorted()
                .forEach(System.out::print);

        System.out.println();
//
//        1. Stwórz strumień liczb całkowitych z tablicy 10 dowolnych liczb całkowitych, każda z nich z zakresu od 0 do 100.
//        Arrays.stream(T[] array)
//        2. Przefiltruj strumień, aby zawierał tylko liczby parzyste.
//        Stream.filter(Predicate<? super T> predicate)
//        3. Przekształć strumień, aby zawierał wartości liczb przemnożone przez 10.
//        Stream.map(Function<? super T, ? extends R> mapper)
//        4. Posortuj strumień w kolejności malejącej – uzyskaj komparator metodą Collections.reverseOrder()
//        Stream.sorted(Comparator<? super T> comparator)
//        5. Pomiń 3 pierwsze elementy strumienia.
//                Stream.skip(long n)
//        6. Wypisz każdą z wartości na konsoli w nowej linii,
//                Stream.forEach(Consumer<? super T> action)


         Arrays
                .stream(LICZBY)
                .filter(liczba -> liczba % 2 == 0)
                .map(liczba -> liczba * 10)
                .sorted(Collections.reverseOrder())
                .skip(3)
                .forEach(System.out::println);

        System.out.println();
//        1. Stwórz strumień linii pochodzących z pliku ‘produkty.txt’.
//        Files.lines(Path path)
//        2. Przekształć strumień, aby zawierał nazwy produktów (element na drugiej pozycji z
//                elementów danej linii oddzielonych średnikami).
//                Stream.map(Function<? super T, ? extends R> mapper)
//        3. Przefiltruj strumień, aby zawierał tylko nazwy produktów kończących się literą ‘o’.
//        Stream.filter(Predicate<? super T> predicate)
//        4. Wypisz każdą z wartości na konsoli w nowej linii,
//                Stream.forEach(Consumer<? super T> action)

        Files.lines(Paths.get("produkty.txt"));


    }
}
