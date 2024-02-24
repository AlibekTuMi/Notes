package View;

import java.io.File;

import Controler.Interfaces.iGetView;

public class ViewClassEng implements iGetView{
@Override
    public void listNotes() {
        String folderPath = "C:\\Users\\Public\\Documents\\Папка для заметок"; 

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            boolean txtFilesExist = false;

            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".csv")) {
                    txtFilesExist = true;
                    break;
                }
            }

            if (txtFilesExist) {
                for (File file : files) {
                    System.out.println(file.getName().substring(0,file.getName().length()-4));
                }
                System.out.println();
                
            } else {

                System.out.println("No notes found, create a new one!\n");
            }
        } else {
            System.out.println("The specified folder does not exist or is not a directory!\n");
        }
    }

    @Override
    public String heading() {
        return "Enter the name of the new file:";
    }

    @Override
    public String createNotes() {
        return "Write your note:";
    }

    @Override
    public void exitProgramm() {
        System.out.println("\nThe program is closing, goodbye!");
    }

    @Override
    public String howNote() {
        return "Write the name of the note:\n";
    }

    @Override
    public void greeting() {
        System.out.println("\nHello! This is a NOTES app!");
        System.out.println("Enter the command:");
    }

    @Override
    public void enterCommand() {
        System.out.println(
                "CREATE - create a new note\nLIST - display a list of notes\nREAD - read the note\nUPDATE - edit a note\nDELETE - delete a note\nEXIT - close the application");
    }

    @Override
    public void errorCommand() {
        System.out.println("Invalid command, repeat the input!\n");
    }

    @Override
    public String deleteNote() {
        return "Enter the name of the file to delete!\n";
    }

    @Override
    public void fileDeleted() {
        System.out.println("The file has been successfully deleted!\n");
    }

    @Override
    public void delFiled() {
        System.out.println("The file could not be deleted!\n");
    }

    @Override
    public void fileNotFound() {
        System.out.println("The file was not found!\n");
    }

    @Override
    public void content() {
        System.out.println("The contents of the file!\n");
    }

    @Override
    public void errorRead() {
        System.out.println("Error reading the file!\n");
    }

    @Override
    public void fileRecording() {
        System.out.println("The file is recorded!\n");
    }

    @Override
    public void errorRecord() {
        System.out.println("Error writing the file!\n");
    }

    @Override
    public String createNewNotes() {
        return "Write a new note!\n";
    }

    @Override
    public String newDate() {
        return "File modification date:";
    }

    @Override
    public void updateInput() {
        System.out.println("\nChanges have been made!");
    }

    @Override
    public void errorUpdate() {
        System.out.println("\nNote editing error!");
    }

    @Override
    public String nameUpdateFile() {
        return "\nEnter the name of the file to be modified:";
    }

    @Override
    public void errorInput() {
        System.out.println("\nEnter more than 6 characters!\n");
    }

    @Override
    public String headingFile() {
        return "Heading: ";
    }

    @Override
    public String dateOfChange() {
        return "Date the note was changed: ";
    }

    @Override
    public String dateOfCreation() {
        return "Date the note was created: ";
    }

   
    
}
