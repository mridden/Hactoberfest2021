import java.io.*;
public class FilterInput {

   public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("G:\\CV.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i = 0;
                    while ((i = bin.read()) != 13) {
                        System.out.print((char)(i));
                    }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
