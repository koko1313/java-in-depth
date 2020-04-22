package main;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.regex.Pattern;

public class Main
{

    public static void main(String[] args)
    {
        FileOperator fileOperator = new FileOperator();
        FolderOperator folderOperator = new FolderOperator();

//        try
//        {
//            System.out.println(fileOperator.readFile("text.txt"));
//        }
//        catch (FileNotFoundException e1)
//        {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }

//        try
//        {
//            fileOperator.topThreeWords("text.txt");
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }

//        folderOperator.printFolderTreeDFS("Test Folder");

//        fileOperator.rename("text.txt", "text2.txt");

//        try
//        {
//            System.out.println(fileOperator.searchStringInFile("text.txt", "line"));
//        }
//        catch (FileNotFoundException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        try
//        {
//            fileOperator.copy("text.txt", "text2.txt");
//        }
//        catch (FileAlreadyExistsException e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//        fileOperator.delete("text.txt");

//        folderOperator.searchFile("Test Folder", "*findMe.txt");

//        Pattern pattern = Pattern.compile("find(.*)Me.txt");
//        folderOperator.searchFile("Test Folder", pattern);

//        folderOperator.searchString("Test Folder", "gg");
    }

}
