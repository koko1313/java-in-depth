package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FolderOperator
{
    public void printFolderTreeDFS(String folderName)
    {
        File folder = new File(folderName);

        if (!folderExist(folder) || !isDirectory(folder))
        {
            return;
        }

        findFolderSubDirectoriesDFS(folder);
    }


    public void searchFile(String folderName, String fileName)
    {
        File folder = new File(folderName);

        if (!folderExist(folder) || !isDirectory(folder))
        {
            return;
        }

        if (findFile(folder, fileName))
        {
            System.out.println("File " + fileName + " found in " + folderName + ".");
        }
        else
        {
            System.out.println("File " + fileName + " was not found in " + folderName + ".");
        }
    }


    public void searchFile(String folderName, Pattern fileNamePattern)
    {
        File folder = new File(folderName);

        if (!folderExist(folder) || !isDirectory(folder))
        {
            return;
        }

        if (findFile(folder, fileNamePattern))
        {
            System.out.println("File " + fileNamePattern + " found in " + folderName + ".");
        }
        else
        {
            System.out.println("File " + fileNamePattern + " was not found in " + folderName + ".");
        }
    }


    public void searchString(String folderName, String searchString)
    {
        File folder = new File(folderName);

        if (!folderExist(folder) || !isDirectory(folder))
        {
            return;
        }

        findString(folder, searchString);
    }


    private void findFolderSubDirectoriesDFS(File folder)
    {
        for (File file : folder.listFiles())
        {
            System.out.println(file.getPath() + " : " + file.length());

            if (file.isDirectory())
            {
                findFolderSubDirectoriesDFS(file, 1);
            }
        }
    }


    private void findFolderSubDirectoriesDFS(File folder, int level)
    {
        for (File file : folder.listFiles())
        {
            // print dash for sub-directories
            for (int i = 0; i < level; i++)
            {
                System.out.print("-");
            }

            System.out.println(file.getPath() + " : " + file.length());

            if (file.isDirectory())
            {
                findFolderSubDirectoriesDFS(file, level + 1);
            }
        }
    }


    private boolean findFile(File folder, String fileName)
    {
        File[] filesInCurrentDirectory = folder.listFiles();

        for (File currentFile : filesInCurrentDirectory)
        {
            if (currentFile.isDirectory())
            {
                if (findFile(currentFile, fileName))
                {
                    return true;
                }
            }

            if (currentFile.getName().equals(fileName))
            {
                return true;
            }
        }

        return false;
    }


    private boolean findFile(File folder, Pattern fileNamePattern)
    {
        File[] filesInCurrentDirectory = folder.listFiles();

        for (File currentFile : filesInCurrentDirectory)
        {
            if (currentFile.isDirectory())
            {
                if (findFile(currentFile, fileNamePattern))
                {
                    return true;
                }
            }

            Matcher m = fileNamePattern.matcher(currentFile.getName());

            if (m.find())
            {
                return true;
            }
        }

        return false;
    }


    private void findString(File folder, String searchString)
    {
        File[] filesInCurrentDirectory = folder.listFiles();

        for (File currentFile : filesInCurrentDirectory)
        {
            if (currentFile.isDirectory())
            {
                findString(currentFile, searchString);
            }
            else if (currentFile.isFile())
            {
                try (FileReader fileReader = new FileReader(currentFile);
                                BufferedReader bufferedReader = new BufferedReader(fileReader))
                {
                    String fileLine;
                    int lineNumber = 1;
                    while ((fileLine = bufferedReader.readLine()) != null)
                    {
                        if (fileLine.contains(searchString))
                        {
                            System.out.println("'" + searchString + "' found in " + currentFile.getPath() + " on line " + lineNumber);
                        }
                        lineNumber++;
                    }
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


    private boolean folderExist(File folder)
    {
        if (folder.exists())
        {
            return true;
        }

        System.err.println("Folder " + folder.getName() + " does not exist.");
        return false;
    }


    private boolean isDirectory(File folder)
    {
        if (folder.isDirectory())
        {
            return true;
        }

        System.err.println(folder.getName() + " is not a directory!");
        return false;
    }

}
