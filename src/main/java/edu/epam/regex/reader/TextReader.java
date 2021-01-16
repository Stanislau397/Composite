package edu.epam.regex.reader;

import edu.epam.regex.exception.EmptyFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextReader {

    public static final Logger logger = LogManager.getLogger(TextReader.class);

    public String readTextFromFile(String path) throws EmptyFileException {
        StringBuilder sb = new StringBuilder();
        String nextLine = "\n";

        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> sb.append(s).append(nextLine));
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "File not found", e);
        } catch (IOException e) {
            logger.log(Level.ERROR, e.getMessage());
            throw new EmptyFileException("File is empty");
        }
        return sb.toString();
    }
}
