import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileWork {
    public static void main(String[] args) throws NullPointerException {
        BufferedReader br = null;
        try {
            File file1 = new File("newFile.txt");
            File file2 = new File("secondFile.txt");

            PrintWriter pw2 = new PrintWriter(file2);

            br = new BufferedReader(new FileReader(file1));
            String line;
            while ((line = br.readLine()) != null) {
                pw2.println(line);
            }

            pw2.close();

        } catch(IOException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                br.close();
            } catch (NullPointerException | IOException e) {
                System.out.println("Error: " + e);
            }
        }

    }
}

