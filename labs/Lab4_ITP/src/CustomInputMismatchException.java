import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomInputMismatchException {
    private static final Logger logger = Logger.getLogger(CustomInputMismatchException.class.getName());

    public static void main(String[] args) throws Exception {
        Handler fileHandler = new FileHandler("%h/Desktop/myJavaLog.log");
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);

        Scanner sc = new Scanner(System.in);

        try  {
            int a = sc.nextInt();
            System.out.println(a);
        } catch (InputMismatchException e) {
            logger.log(Level.INFO, "info", e);
        } finally {
            sc.close();
        }
    }
}


