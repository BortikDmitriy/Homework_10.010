import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
       public class Main {
    public static void main(String[] args) {

        public class WordFrequencyCounter {

            public static void main(String[] args) {
                String fileName = "words.txt";
                Map<String, Integer> wordFrequency = countWordFrequency(fileName);
                printWordFrequency(wordFrequency);
            }

            /**
             * Метод для підрахунку частоти кожного слова у файлі
             *
             * @param fileName ім'я файлу зі словами
             * @return Map, де ключ - слово, значення - його частота
             */
            public static Map<String, Integer> countWordFrequency(String fileName) {
                Map<String, Integer> wordFrequency = new HashMap<>();

                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        StringTokenizer tokenizer = new StringTokenizer(line, " \t\n\r\f");
                        while (tokenizer.hasMoreTokens()) {
                            String word = tokenizer.nextToken();
                            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return wordFrequency;
            }

            /**
             * Метод для виведення частоти кожного слова відсортовано за зменшенням частоти
             *
             * @param wordFrequency Map з частотами слів
             */
            public static void printWordFrequency(Map<String, Integer> wordFrequency) {
                // Використовуємо TreeMap для автоматичного сортування за значенням (частотою)
                TreeMap<Integer, String> sortedMap = new TreeMap<>((a, b) -> b.compareTo(a));
                wordFrequency.forEach((key, value) -> sortedMap.put(value, key));

                sortedMap.forEach((value, key) -> System.out.println(key + " " + value));
            }
        }
    }
}





