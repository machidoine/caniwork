package com.bnpparibas.caniwork.infra.csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvUtil {

    public static <T> List<T> readFile(String pathFile, Class<T> clazz) {

        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper mapper = new CsvMapper();
        File file = null;
        try {
            file = new File(pathFile);
            MappingIterator<T> readValues =
                    mapper.reader(clazz).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
