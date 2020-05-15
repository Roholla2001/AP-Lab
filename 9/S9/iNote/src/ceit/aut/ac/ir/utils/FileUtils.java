package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;

import java.io.*;
import java.util.*;

public class FileUtils {

    private static final String NOTES_PATH = "./notes2/";

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
    public static Note[] getNotesInDirectory() {
        File[] files = getFilesInDirectory();
        Note[] notes = new Note[files.length];
        int i = 0;
        for(File file: files) {
            try(FileInputStream fis = new FileInputStream(file)) {
                ObjectInputStream ois = new ObjectInputStream(fis);
                notes[i++] = (Note)ois.readObject();
                ois.close();
            }
            catch(IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return notes;
    }

    public static void saveNote(String content) {
        Note note = new Note(getTitle(content), content, new Date().toString());

        File file = new File(getProperFileName(content));

        try(FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(note);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Note readNote(File file) {
        try(FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            Note note = (Note)ois.readObject();
            return note;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }





    private static String getProperFileName(String content) {
        return NOTES_PATH + getTitle(content) + ".txt";
    }

    private static String getTitle(String content) {
        String name = "";
        int loc = content.indexOf("\n");
        if (loc != -1) {
            name = content.substring(0, loc);
        }
        else if (!content.isEmpty()) {
            name = content;
        }
        else
            name = System.currentTimeMillis() + "_new file";
        return name;
    }
}
