package ex2;

import java.io.*;
import java.util.ArrayList;

public class UserToJasonWriter {
    public void userToJasonWriter() {
        writerUserToJson(userArrayMaker(userFileRider()));
    }
    private ArrayList <String> userFileRider () {
        ArrayList <String> file = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line=reader.readLine()) != null ) {
                file.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    private ArrayList <User> userArrayMaker (ArrayList <String> file) {
        ArrayList <User> users = new ArrayList<>();
        for (String s : file) {
            User user = new User();
            String [] array = s.split(" ");
            if (array[0].equals("name") && array[1].equals("age")) {continue;}
            user.setName(array[0]);
            user.setAge(Integer.parseInt(array[1]));
            users.add(user);
        }
        return users;
    }
    private void writerUserToJson(ArrayList <User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user.json"))){
            writer.write("[");
            for (int i =0; i < users.size(); i++) {
                if (i == users.size() - 1) {
                    writer.write(users.get(i).toJson());
                } else {
                    writer.write(users.get(i).toJson());
                    writer.write(",");
                }
            }
            writer.write("\n]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
