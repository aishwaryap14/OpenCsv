
package com.project;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteCsv {
    static final String LIST_SAMPLE = "C:\\Users\\HP\\IdeaProjects\\CsvProject\\Resource\\list-sample11.json";
    public static void main(String[] args) throws IOException, CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get(LIST_SAMPLE));
            StatefulBeanToCsv<User> statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            List<User> userList = new ArrayList<>();
            userList.add(new User("Sachin Tendulkar","sachin@example.com","+91-9999999999","india"));
            userList.add(new User("Barak Obama","barak.obama@example.com","+1-1111111111","United States"));
            //statefulBeanToCsv.write(userList); // used to convert java to csv
            System.out.println(userList);
            writer.write(gson.toJson(userList));
            writer.close();
        }
        catch (IOException e)
        {

        }
    }
}
