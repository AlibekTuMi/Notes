package Model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import Controler.Interfaces.iGetModel;

public class ModelClassEng implements iGetModel {
    View.ViewClassRus view = new View.ViewClassRus();

    @Override
    public void createNotes() {
        try {
            String uniqueIDString = UUID.randomUUID().toString().substring(0, 4); // уникальный id
            String heading = promodel(view.heading()); // заголовок
            String namefile = heading + "-" + uniqueIDString + ".csv"; // название файла
            Date currentDate = new Date(); // дата
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); // формат даты
            String formattedDate = dateFormat.format(currentDate); // конвертация даты, готовая для записи
            String createNote = promodel(view.createNotes()); // содерджимое заметки
            String folderPath = "C:\\Users\\Public\\Documents\\Папка для заметок"; // путь к папке заметки
            File filenamepath = new File(folderPath); // объект FileWriter
            if (!filenamepath.exists()) {
                filenamepath.mkdirs();
            }
            File file = new File(namefile); // название
            File newFile = new File(folderPath, file.getName());
            FileWriter fileWriter = new FileWriter(newFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(view.headingFile());
            bufferedWriter.write(heading);
            bufferedWriter.newLine();
            bufferedWriter.write(createNote);
            bufferedWriter.newLine();
            bufferedWriter.write(view.dateOfCreation());
            bufferedWriter.write(formattedDate);
            bufferedWriter.close();
            view.fileRecording();

        } catch (IOException e) {
            view.errorRecord();
            e.printStackTrace();
        }
    }

    @Override
    public void readNotes() {     
        String howNote = promodel(view.howNote()) + ".csv";
        String folderPath = "C:\\Users\\Public\\Documents\\Папка для заметок";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        boolean fileFound = false;
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(howNote)) {
                    fileFound = true;
                    try {
                        Scanner fileScanner = new Scanner(file);
                        view.content();
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                        System.out.println();
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        view.errorRead();
                        e.getMessage();
                    }
                    break;
                }
            }
        }
        if (!fileFound) {
            view.fileNotFound();
        }
    }

    @Override
    public void updateNotes() {
        String heading = promodel(view.nameUpdateFile()) + ".csv"; // название файла
        String head = heading.substring(0, heading.length() - 9) + "\n"; // заголовок
        String folderPath = "C:\\Users\\Public\\Documents\\Папка для заметок";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        boolean fileFound = false;

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (!files[i].getName().equals(heading)) {
                    fileFound = false;
                }

                else if (files[i].getName().equals(heading)) {
                    fileFound = true;
                    Date currentDate = new Date(); // дата
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); // формат даты
                    String formattedDate = view.newDate() + dateFormat.format(currentDate);
                    new File(folderPath + File.separator + heading);
                    String newNote = promodel(view.createNewNotes());
                    File newfile = new File(heading);
                    File newfile1 = new File(folderPath, newfile.getName());
                    try (FileWriter fileWriter = new FileWriter(newfile1)) {
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(view.headingFile());
                        bufferedWriter.write(head);
                        bufferedWriter.newLine();
                        bufferedWriter.write(newNote);
                        bufferedWriter.newLine();
                        bufferedWriter.write(view.dateOfChange());
                        bufferedWriter.write(formattedDate);
                        bufferedWriter.close();
                        view.updateInput();

                    } catch (IOException e) {
                        view.errorUpdate();
                        e.printStackTrace();
                    }
                }
            }
        }
        if (fileFound == false) {
            view.fileNotFound();
        }
    }

    @Override
    public void deleteNotes() {
        String deleteNote = promodel(view.deleteNote()) + ".csv";
        String folderPath = "C:\\Users\\Public\\Documents\\Папка для заметок";
        File fileToDelete = new File(folderPath + File.separator + deleteNote);

        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                view.fileDeleted();
            } else {
                view.delFiled();
            }
        } else {
            view.fileNotFound();
        }
    }

    @Override
    public String promodel(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();

    }

}
