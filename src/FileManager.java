import java.io.*;

public class FileManager {

    static void write(File file, Zooclub zooclub) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(zooclub.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void supplement(File file, Zooclub zooclub) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.newLine();
            bw.write(zooclub.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void serialize(Zooclub zooclub, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(zooclub);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deSerialize(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Zooclub zoo = (Zooclub) ois.readObject();
            System.out.println(zoo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
