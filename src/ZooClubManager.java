import java.io.File;
import java.util.Scanner;

public class ZooClubManager {

    private static Scanner scanner = new Scanner(System.in);

    static void start(Zooclub zooclub) {
        boolean isOn = true;
        while (isOn) {
            System.out.println("Choose function" +
                    "\n1 - Add person to map" +
                    "\n2 - Add pet to person" +
                    "\n3 - Remove pet from person" +
                    "\n4 - Remove person from map" +
                    "\n5 - Remove pet from all persons" +
                    "\n6 - Print all persons with pets" +
                    "\n7 - Write or rewrite zoo club to the file" +
                    "\n8 - Write or supplement zoo club to the file" +
                    "\n9 - Serialize zoo club to the file" +
                    "\n10 - Deserialize zoo club from the file" +
                    "\n0 - Exit");
            System.out.println("------------------------------------");
            int function = scanner.nextInt();
            switch (function) {
                case 1:
                    System.out.println("Input person's name:");
                    String personNameToAdd = scanner.next();
                    zooclub.addPerson(new Person(personNameToAdd));
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    System.out.println("Input person's name and pet's name");
                    String personNameForPet = scanner.next();
                    String petNameToAdd = scanner.next();
                    zooclub.addPetToPerson(new Person(personNameForPet), new Pet(petNameToAdd));
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    System.out.println("Input person's name and pet's name");
                    String personNameToRemovePet = scanner.next();
                    String petNameToRemove = scanner.next();
                    zooclub.removePetFromPerson(new Person(personNameToRemovePet), new Pet(petNameToRemove));
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    System.out.println("Input person's name:");
                    String personNameToRemove = scanner.next();
                    zooclub.removePerson(new Person(personNameToRemove));
                    break;
                case 5:
                    System.out.println("Input pet's name:");
                    String petNameToRemoveAllPets = scanner.next();
                    zooclub.removePetFromAllPersons(new Pet(petNameToRemoveAllPets));
                    break;
                case 6:
                    zooclub.printZooClub();
                    System.out.println("------------------------------------");
                    break;
                case 7:
                    System.out.println("Input file's name you want write/rewrite zoo club to:");
                    String inputFileNameWrite = scanner.next();
                    FileManager.write(new File(inputFileNameWrite), zooclub);
                    System.out.println("------------------------------------");
                    break;
                case 8:
                    System.out.println("Input file's name you want to write/supplement zoo club to:");
                    String inputFileNameSupplement = scanner.next();
                    FileManager.supplement(new File(inputFileNameSupplement), zooclub);
                    System.out.println("------------------------------------");
                    break;
                case 9:
                    System.out.println("Input file's name for serializing:");
                    String serializeFile = scanner.next();
                    FileManager.serialize(zooclub, new File(serializeFile));
                    System.out.println("------------------------------------");
                    break;
                case 10:
                    System.out.println("Input file's name for deserializing:");
                    String deserializingFile = scanner.next();
                    FileManager.deSerialize(new File(deserializingFile));
                    System.out.println("------------------------------------");
                    break;
                case 0:
                    isOn = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Wrong function, choose again");
                    break;
            }
        }
    }
}
