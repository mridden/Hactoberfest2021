import java.io.*;
public class FilterOutput {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("G:\\CV.txt");
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i = 0;
            while ((i = bin.read()) != 13) {
                        System.out.print((char)(i));
            }


        File data = new File("G:\\CV.txt");
        FileOutputStream file = new FileOutputStream(data);
        FilterOutputStream filter = new FilterOutputStream(file);
        String s = " Nama : Rizal Elsa Fanny";
        byte b[]=s.getBytes();
        filter.write(b);
        filter.flush();
        filter.close();
        file.close();
        System.out.println("Data berhasil dibuat");
    }
}
