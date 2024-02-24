package View;

import java.io.File;

import Controler.Interfaces.iGetView;

public class ViewClassRus implements iGetView{
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
                System.out.println("\nСписок файлов с полным названием:");
                for (File file : files) {
                    System.out.println(file.getName().substring(0,file.getName().length()-4));
                }
                System.out.println();
                
            } else {

                System.out.println("\nЗаметки не найдены, создайте новую!\n");
            }
        } else {
            System.out.println("Указанная папка не существует или не является директорией!\n");
        }
    }
    // String className = fullName + file.getName().replace(".java", "");
    @Override
    public String heading() {
        return "Введите название нового файла:";
    }

    @Override
    public String createNotes() {
        return "Напишите вашу заметку:";
    }

    @Override
    public void exitProgramm() {
        System.out.println("\nПрограмма закрывается, до свидания!");
    }

    @Override
    public String howNote() {
        return "Напишите название заметки без .csv :\n";
    }

    @Override
    public void greeting() {
        System.out.println("\nЗдравствуйте! Это приложение ЗАМЕТКИ!");
        System.out.println("Введите команду:");
    }

    @Override
    public void enterCommand() {
        System.out.println(
                "CREATE - создать новую заметку\nLIST - вывести список заметок\nREAD - прочесть заметку\nUPDATE - редактировать заметку\nDELETE - удалить заметку\nEXIT - закрыть приложение");
    }

    @Override
    public void errorCommand() {
        System.out.println("Неверная команда, повторите ввод!\n");
    }

    @Override
    public String deleteNote() {
        return "Введите название удаляемого файла!\n";
    }

    @Override
    public void fileDeleted() {
        System.out.println("Файл успешно удалён!\n");
    }

    @Override
    public void delFiled() {
        System.out.println("Не удалось удалить файл!\n");
    }

    @Override
    public void fileNotFound() {
        System.out.println("Файл не найден!\n");
    }

    @Override
    public void content() {
        System.out.println("Содержимое файла!\n");
    }

    @Override
    public void errorRead() {
        System.out.println("Ошибка при чтении файла!\n");
    }

    @Override
    public void fileRecording() {
        System.out.println("Файл записан!\n");
    }

    @Override
    public void errorRecord() {
        System.out.println("Ошибка при записи файла!\n");
    }

    @Override
    public String createNewNotes() {
        return "Напишите новую заметку!\n";
    }

    @Override
    public String newDate() {
        return "Дата изменения файла: ";
    }

    @Override
    public void updateInput() {
        System.out.println("\nИзменения внесены!");
    }

    @Override
    public void errorUpdate() {
        System.out.println("\nОшибка редактирования заметки!");
    }

    @Override
    public String nameUpdateFile() {
        return "\nВведите название изменяемого файла:";
    }

    @Override
    public void errorInput() {
        System.out.println("\nВведите больше 6 символов!\n");
    }
    @Override
    public String headingFile() {
        return "Заголовок: ";
    }
    @Override
    public String dateOfChange() {
        return "Дата изменения заметки: ";
    }
    @Override
    public String dateOfCreation() {
        return "Дата создания заметки: ";
    }

    
}
