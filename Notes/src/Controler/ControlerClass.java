package Controler;

import java.io.File;
import java.util.Scanner;

import Controler.Interfaces.Command;
import Controler.Interfaces.iGetModel;
import Controler.Interfaces.iGetView;

public class ControlerClass {
    private iGetModel model;
    private iGetView view;

    public ControlerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    public boolean checkFile() {
        String folderPathread = "C:\\Users\\Public\\Documents\\Папка для заметок";
        File folderread = new File(folderPathread);
        File[] filesread = folderread.listFiles();
        if (filesread == null) {
            view.enterCommand();
            run();
            return false;
        } else {
            return true;
        }
    }

    public void run() {
        Command command = Command.NONE;
        boolean ver = true;
        while (ver) {
            try (Scanner scanner = new Scanner(System.in)) {
                String choice = scanner.nextLine();
                try {
                    command = Command.valueOf(choice.toUpperCase());
                } catch (IllegalArgumentException e) {
                    view.errorCommand();
                    view.enterCommand();
                    run();
                }
                switch (command) {
                    case CREATE:
                        model.createNotes();
                        view.enterCommand();
                        run();
                        break;

                    case LIST:
                        view.listNotes();
                        view.enterCommand();
                        run();
                        break;

                    case READ:
                        view.listNotes();
                        if (checkFile()==true) {
                            model.readNotes();
                            view.enterCommand();
                            run();
                        }
                        break;

                    case UPDATE:
                        view.listNotes();
                        if (checkFile()==true) {
                            model.updateNotes();
                            view.enterCommand();
                            run();
                        }
                        break;

                    case DELETE:
                        view.listNotes();
                        if (checkFile()==true) {
                            model.deleteNotes();
                            view.enterCommand();
                            run();
                        }
                        break;

                    case EXIT:
                        view.exitProgramm();
                        ver = false;
                        break;

                    default:
                        break;

                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }

        }
    }
}
