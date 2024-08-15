package CENG211_Homeworks.G17_CENG211_HW1;

import java.io.*;
import java.util.*;

public class FileIO
{

    private String file;

    private String line;

    private int count;


    private int getFileLines(String file)
    {
        count = 0;

        try
        {
            BufferedReader inFileStream = new BufferedReader(new FileReader(file));
            while((line= inFileStream.readLine())!=null)
            {
                count++;
            }
            inFileStream.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
        catch (IOException e)
        {
            System.out.println("Error reading from file ");
        }


        return count;
    }


    public Product[] readProductItems()
    {
        file="products.csv";
        int size = getFileLines(file);

        Product[] productArray = new Product[size];

        count=0;

        try
        {
            BufferedReader inFileStream = new BufferedReader(new FileReader(file));
            line = inFileStream.readLine();

            while (line != null)
            {
                StringTokenizer parser = new StringTokenizer(line, ";");

                int ID = Integer.parseInt(parser.nextToken());
                String productName = parser.nextToken();
                double price =Double.parseDouble(parser.nextToken().replaceAll(",", "."));

                productArray[count] = new Product(ID, productName, price);

                count ++;

                line = inFileStream.readLine();
            }

            inFileStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
        catch (IOException e)
        {
            System.out.println("Error reading from file ");
        }

        return productArray;
    }


    public ShopAssistant[] readShopAssistantItems()
    {
        file="shopAssistants.csv";

        int size = getFileLines(file);

        ShopAssistant[] shopAssistantArray = new ShopAssistant[size];

        count=0;

        try
        {
            BufferedReader inFileStream = new BufferedReader(new FileReader(file));
            line = inFileStream.readLine();

            while (line != null)
            {
                StringTokenizer parser = new StringTokenizer(line, ";");

                int ID = Integer.parseInt(parser.nextToken());
                String name = parser.nextToken();
                String surname = parser.nextToken();
                String phoneNumber = parser.nextToken();

                shopAssistantArray[count] = new ShopAssistant(ID, name, surname, phoneNumber);

                count ++;

                line = inFileStream.readLine();
            }

            inFileStream.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
        catch (IOException e)
        {
            System.out.println("Error reading from file ");
        }

        return shopAssistantArray;
    }
}

