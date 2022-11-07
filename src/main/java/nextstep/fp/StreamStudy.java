package nextstep.fp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        String contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
	    final String[] split = contents.split("\\P{L}+");

	    return Arrays.stream(split)
	                 .filter(word -> word.length() > 12)
	                 .count();
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths.get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("\\P{L}+"));

	    words.stream()
	         .filter(w -> w.length() > 12)
	         .sorted(Comparator.comparingInt(String::length).reversed())
	         .map(String::toLowerCase)
	         .distinct()
	         .limit(100)
	         .forEach(System.out::println);
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream().map(x -> 2 * x).collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
	    return numbers.stream()
	                  .filter(number -> number > 3)
	                  .map(number -> number * 2)
	                  .reduce(0, Integer::sum);
    }
}
