package main;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import constants.SystemConstants;


public class FileOperator
{
    public String readFile(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        StringBuilder fileText = new StringBuilder();

        try (FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String fileLine;

            while ((fileLine = bufferedReader.readLine()) != null)
            {
                fileText.append(fileLine);
                fileText.append(SystemConstants.NEW_LINE);
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File " + fileName + " not found.");
            throw e;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return fileText.toString();
    }


    public void topThreeWords(String fileName) throws FileNotFoundException
    {
        HashMap<String, Integer> wordsCount = new HashMap<>();

        String fileText = readFile(fileName);

        String[] words = fileText.split("\\s+");

        for (String currentWord : words)
        {
            wordsCount.computeIfPresent(currentWord, (word, count) -> {
                return count + 1;
            });

            wordsCount.putIfAbsent(currentWord, 1);
        }

        LinkedHashMap<String, Integer> sortedByCount = wordsCount.entrySet()
                        .stream()
                        .limit(3)
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedByCount.forEach((word, count) -> {
            System.out.println(word + " : " + count);
        });
    }


    public boolean searchStringInFile(String fileName, String searchString) throws FileNotFoundException
    {
        String fileText = readFile(fileName);

        if (fileText.contains(searchString))
        {
            return true;
        }

        return false;
    }


    public void copy(String fileName, String destinationFileName) throws FileAlreadyExistsException
    {
        File file = new File(fileName);
        File destinationFile = new File(destinationFileName);

        try
        {
            Files.copy(file.toPath(), destinationFile.toPath());
            System.out.println("Copy successful.");
        }
        catch (NoSuchFileException e)
        {
            System.err.println("File " + fileName + " does not exist.");
        }
        catch (FileAlreadyExistsException e)
        {
            System.err.println("File " + destinationFileName + " already exists.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public void rename(String fileName, String newName)
    {
        File file = new File(fileName);

        if (!fileExist(file))
        {
            return;
        }

        File newFile = new File(newName);

        if (file.renameTo(newFile))
        {
            System.out.println("File " + fileName + " successfuly renamed to " + newName + ".");
        }
    }


    public void delete(String fileName)
    {
        File file = new File(fileName);

        if (!fileExist(file))
        {
            return;
        }

        if (file.delete())
        {
            System.out.println("File " + fileName + " deleted successfuly.");
        }
    }


    private boolean fileExist(File file)
    {
        if (file.exists())
        {
            return true;
        }

        System.err.println("File " + file.getName() + " does not exist.");
        return false;
    }
}
