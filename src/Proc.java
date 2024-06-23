import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Proc {

    private static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<User> users = readUsersFromFile("file.txt");

        // Виводимо зчитані об'єкти для перевірки
        for (User user : users) {
            System.out.println(user);
        }

        writeUsersToJsonFile(users, "user.json");
    }

    private static List<User> readUsersFromFile(String fileName) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Пропускаємо перший рядок (заголовок)
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\s+"); // розділяємо рядок по пробілах
                if (data.length >= 2) { // маємо дві колонки: ім'я та вік
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    User user = new User(name, age);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static void writeUsersToJsonFile(List<User> users, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
