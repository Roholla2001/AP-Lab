package ceit.aut.ac.ir.utils;

import java.awt.*;
import java.io.*;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(File file) throws IOException {
        //TODO: Phase1: read content from file
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String text = "";
        while(bufferedReader.ready())
            text += (char)bufferedReader.read();

        fileReader.close();
        bufferedReader.close();
        return text;
        // done
    }

    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = getProperFileName(content);

        // DO
        File file = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(content);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // done
    }

    //TODO: Phase1: define method here for reading file with InputStream
    public static String fileInputStream(File file) throws IOException {
        FileInputStream fos = new FileInputStream(file);
        BufferedInputStream bos = new BufferedInputStream(fos);

        String text = "";
        while(bos.available() > 0)
            text += (char)bos.read();

        bos.close();
        fos.close();
        return text;
    }

    //TODO: Phase1: define method here for writing file with OutputStream
    public static void fileOutputStream(String content) {
        String fileName = getProperFileName(content);

        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file); BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] toByteArr = content.getBytes();
            bos.write(toByteArr);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: Phase2: proper methods for handling serialization

    private static String getProperFileName(String content) {
        String name = "";
        int loc = content.indexOf("\n");
        if (loc != -1) {
            name = content.substring(0, loc);
        }
        else if (!content.isEmpty()) {
            name = content;
        }
        else
            name = System.currentTimeMillis() + "_new file"; // removed the .txt
        return "./notes/" + name + ".txt";
    }
}
