import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.JFileChooser;
public class PersonGenerator {
    public static void main(String[] args) throws IOException {
        ArrayList<String> Persondata = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String IDnum = " ";
        String Firstname = " ";
        String Lastname = " ";
        String Title = " ";
        String Fullguy = " ";
        int YOB = 0;
        boolean done = false;
        System.out.println("Enter the following information when prompted: ID #, First Name, Last Name, Title, Year of Birth");
        do{
            IDnum = SafeInput.getNonZeroLenString(in,"Enter 6 digit ID number");
            Firstname = SafeInput.getNonZeroLenString(in,"Enter First name");
            Lastname = SafeInput.getNonZeroLenString(in,"Enter Last name");
            Title = SafeInput.getNonZeroLenString(in,"Enter title");
            YOB = SafeInput.getRangedInt(in,"Enter 4 digit year of birth: ",1000,9999);
            Fullguy = IDnum + ", " + Firstname + ", " + Lastname + ", " + Title + ", " + YOB;
            Persondata.add(Fullguy);
            done = SafeInput.getYNConfirm(in,"Would you like to end? Enter Y to quit. Enter N to add another");

        }while(!done);
        System.out.println(Persondata);
        Path path = Paths.get("C:\\Users\\legol\\IdeaProjects\\Person_Model\\src\\PersonTestData.txt");
        //create file
        try {
            Path createdFilePath = Files.createFile(path);
            System.out.println("Created a file at : "+createdFilePath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Files.write(path, Persondata);
    }
}