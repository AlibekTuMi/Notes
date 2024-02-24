import java.util.Scanner;
import Controler.ControlerClass;
import Model.ModelClassEng;
import Model.ModelClassRus;
import View.ViewClassEng;
import View.ViewClassRus;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Выберите язык:");
        System.out.println("Select a language");
        System.out.println("1 ENGLISH");
        System.out.println("2 Русский");
        
        Scanner scanner = new Scanner(System.in); 
        String choice = scanner.nextLine();
            if (!choice.equals("1")&&!choice.equals("2")) {
                new ViewClassRus().errorCommand();
                new ViewClassEng().errorCommand();
                main(args);
            }

        switch (choice) {
            case "1":
                System.out.println("\nYour choice ENGLISH");
                ControlerClass controlerClassEng = new ControlerClass(new ModelClassEng(), new ViewClassEng());
                new ViewClassEng().greeting();
                new ViewClassEng().enterCommand();
                controlerClassEng.run();
                break;
            case "2":
                System.out.println("\nВы выбрали РУССКИЙ");
                ControlerClass controlerClassRus = new ControlerClass(new ModelClassRus(), new ViewClassRus());
                new ViewClassRus().greeting();
                new ViewClassRus().enterCommand();
                controlerClassRus.run();
                break;
        }
        scanner.close();
    }
}
