import database.EntityDao;
import lombok.extern.log4j.Log4j;
import model.Owner;
import java.util.List;

import java.util.Scanner;

@Log4j
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        do{
            System.out.println("Podaj komendę [insert, list, delete, modify]");
            command = scanner.nextLine();

            if(command.startsWith("insert")){ //insert Krzysztof Kozłowski 27
                handleOwnerAdd(command);
            }else if(command.startsWith("list")){// list
                handleListOwner(command);
            }else if(command.startsWith("delete")){// delete 1
                handleDeleteOwner(command);
            }else if(command.startsWith("update")){// modify mariusz kowalski 30 1
                handleOwnerUpdate(command);
            }else if(command.startsWith("petadd")){
                handleAddPetToOwner(command);
            }else if(command.startsWith("petlist")){
                handlePrintOwnerPets(command);
            }else if(command.startsWith("petdelete")){
                handlePetDelete(command);
            }else if(command.startsWith("petupdate")){
                handlePetUpdate(command);
            }
        }while (!command.equalsIgnoreCase("quit"));
    }

    private static void handlePetUpdate(String command) {

    }

    private static void handlePetDelete(String command) {

    }

    private static void handlePrintOwnerPets(String command) {

    }

    private static void handleAddPetToOwner(String command) {

    }

    private static void handleOwnerUpdate(String command) {
        EntityDao<Owner> studentEntityDao = new EntityDao<>();
        String[] words = command.split(" ");
        Owner owner = Owner.builder()
                .firstName(words[1])
                .lastName(words[2])
                .age(Integer.parseInt(words[3]))
                .id(Long.parseLong(words[4]))
                .build();

        studentEntityDao.insertOrUpdate(owner);
    }

    private static void handleDeleteOwner(String command) {
        EntityDao<Owner> studentEntityDao = new EntityDao<>();
        String[] words = command.split(" ");

        System.out.println("Success: " + studentEntityDao.delete(Long.valueOf(words[1]), Owner.class));
    }

    private static void handleListOwner(String command) {
        EntityDao<Owner> studentEntityDao = new EntityDao<>();
        List<Owner> studentList = studentEntityDao.getAll(Owner.class);

        log.info("List:");
        studentList.forEach(log::info);
    }

    private static void handleOwnerAdd(String command) {
        EntityDao<Owner> ownerEntityDao = new EntityDao<>();
        String[] words = command.split(" ");
        Owner owner = Owner.builder()
                .firstName(words[1])
                .lastName(words[2])
                .age(Integer.parseInt(words[3]))
                .build();
        ownerEntityDao.insertOrUpdate(owner);
    }
}
