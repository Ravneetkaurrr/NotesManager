
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;

public class NotesManager {
  public static void main (String[] args){
    Scanner s=new Scanner(System.in);
    while (true){
      System.out.println("------------NOTESMANAGER------------");
      System.out.println("1. WRTIE NOTES");
      System.out.println("2. READ NOTES");
      System.out.println("3. EXIT");
      System.out.println("Enter your choice(1-3): ");
      int choice=s.nextInt();
      s.nextLine();
      switch (choice){
        case 1: ;
          writeNotes(s);
          break;
        case 2:
          readNotes();
          break;
        case 3:
          System.out.println("EXITING, THANK YOU FOR YOUR PATIENCE");
          return;
        default:
          System.out.println("INVALID CHOICE");
      }
    }
  }
  private static void writeNotes(Scanner s) {
    System.out.println("ENTER YOUR NOTE: ");
    String note=s.nextLine();
    try{
      FileWriter fw=new FileWriter("notes.txt",true);
      fw.write(note+System.lineSeparator());
      fw.close();
      System.out.println("NOTE WRITTEN TO THE FILE SUCCESSFULLY!");

    } catch (IOException e) {
      System.out.println("ERROR WHILE WRITING NOTES: "+e.getMessage());
    }
  }
  private static void readNotes() {
    System.out.println("READING THE NOTES!");
    String line;
    boolean hasNotes=false;
    try{
      BufferedReader br= new BufferedReader(new FileReader("notes.txt"));
      while((line=br.readLine())!=null){
        System.out.println(line);
        hasNotes=true;
      }
    }
    catch(IOException e){
      System.out.println("ERROR WHILE READING NOTES: "+e.getMessage());
    }
    if(!hasNotes){
      System.out.println("Notes not found");
    }
  }
}
