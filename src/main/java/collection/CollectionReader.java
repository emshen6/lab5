package collection;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.PriorityQueue;

public class CollectionReader {


    public PriorityQueue<StudyGroup> readCollection(String envVariable) {
        String fileName = System.getenv().get(envVariable);
        Path myPath = Paths.get(fileName);

        try (InputStreamReader in = new InputStreamReader(new FileInputStream(fileName))) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .withIgnoreQuotations(true)
                    .build();
            CSVReader csvReader = new CSVReaderBuilder(in)
                    .withSkipLines(0)
                    .withCSVParser(parser)
                    .build();
            List<String[]> lines = csvReader.readAll();
            PriorityQueue<StudyGroup> studyGroups = new PriorityQueue<>();
            for (String[] line : lines) {
                studyGroups.add(StudyGroup.builder()
                        .name(line[0])
                        .coordinates(new Coordinates(Float.parseFloat(line[1]), Float.parseFloat(line[2])))
                        .studentsCount(Long.parseLong(line[3]))
                        .formOfEducationEnum(FormOfEducation.valueOf(line[4]))
                        .semesterEnum(Semester.valueOf(line[5]))
                        .groupAdmin(new Person(line[6], LocalDate.parse(line[7]), Double.parseDouble(line[8]), Double.parseDouble(line[9]), line[10]))
                        .build());
                Id.last += 1;
            }
            return studyGroups;
        } catch (IOException | CsvException e) {
            return null;
        }

    }
}
