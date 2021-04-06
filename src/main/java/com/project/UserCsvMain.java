package com.project;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class UserCsvMain {
    static final String FILE_NAME = "C:\\Users\\HP\\IdeaProjects\\CsvProject\\Resource\\user.csv";
    static final String JSON_FILE = "C:\\Users\\HP\\IdeaProjects\\CsvProject\\Resource\\user.json";
    public static void main(String[] args) throws IOException {
        try {
            Reader bufferedReader = Files.newBufferedReader(Paths.get(FILE_NAME));
            CsvToBean<User> csvToBean = new CsvToBeanBuilder(bufferedReader).withIgnoreLeadingWhiteSpace(true)
                    .withType(User.class).build();
            // Iterator<User> iterator = csvToBean.iterator();
            List<User> iterator = csvToBean.parse();
            System.out.println(iterator);
//        while (iterator.hasNext())
//        {
//            User user = iterator.next();
//            System.out.println(user);
//        }
//        for(User user: iterator)
//        {
//            System.out.println("Name = "+ user.getName());
//            System.out.println("Email = "+ user.getEmail());
//            System.out.println("Phone Number = "+ user.getPhone());
//            System.out.println("Country = "+ user.getCountry());
//            System.out.println("================================================");
//        }

            Gson gson = new Gson();
            String Json = gson.toJson(iterator);
            FileWriter fileWriter = new FileWriter(JSON_FILE);
            fileWriter.write(Json);
            fileWriter.close();

            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(JSON_FILE));
            User[] uerObj = gson.fromJson(bufferedReader1, User[].class);
            List<User> csvUser = Arrays.asList(uerObj);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
