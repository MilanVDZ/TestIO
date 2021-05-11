import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PathApp {
    public static void main(String[] args) {
        //CREATING DIRECTORY + 2 .TXT FILES
        try {
            Path p1 = Paths.get("..\\..\\FromMilanToPearl\\message.txt");
            Path p2 = Paths.get("..\\..\\FromMilanToPearl\\animal.txt");
            if(Files.notExists(p1.getParent())){
                Files.createDirectory(p1.getParent());
            }
            if (Files.notExists(p1)) {
                Files.createFile(p1);
                Files.createFile(p2);
                System.out.println("Files are created!");
            } else System.out.println("Files already exist!");
        }catch (IOException e){
            e.printStackTrace();
        }


        //WRITING STRING
        FileWriter file = null;
        try {
            file = new FileWriter("..\\..\\FromMilanToPearl\\message.txt", true);
            file.write("Wat is het toppunt van gemengde gevoelens? Je schoonmoeder in je gloednieuwe BMW een ravijn in zien rijden.");
        } catch(IOException ex){
            System.out.println("Oops, something went wrong!" + ex.getMessage());
        }
        finally {
            try{
                if(file != null) file.close();
            } catch (IOException ex){
                System.err.println("Error closing file!");
            }
        }


        //READING STRING
        try {
            FileReader fileReader = new FileReader("..\\..\\FromMilanToPearl\\message.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }


        //WRITING AND READING OBJECT
        try{
            Alpaca alpaca = new Alpaca("Jenny", true);
            FileOutputStream fileOutputStream = new FileOutputStream("..\\..\\FromMilanToPearl\\animal.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(alpaca);

            FileInputStream fileInputStream = new FileInputStream("..\\..\\FromMilanToPearl\\animal.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Alpaca alpaca2 = (Alpaca) objectInputStream.readObject();

            System.out.println(alpaca2);

            objectInputStream.close();
            objectOutputStream.close();

        } catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}