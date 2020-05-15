package ceit.aut.ac.ir.utils;

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
        String text = "";
        while(fileReader.ready())
            text += (char)fileReader.read();

        fileReader.close();
        return text;
        // done
    }

    public static void fileWriter(String content) {
        //TODO: write content on file
        String fileName = "./notes/" + getProperFileName(content) + ".txt"; // added the ./notes/ & .txt

        // DO
        File file = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(content);
        } catch(IOException e) {
            e.printStackTrace();
        }

        // done
    }

    //TODO: Phase1: define method here for reading file with InputStream
    //TODO: Phase1: define method here for writing file with OutputStream

    //TODO: Phase2: proper methods for handling serialization

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file"; // removed the .txt
    }
}
