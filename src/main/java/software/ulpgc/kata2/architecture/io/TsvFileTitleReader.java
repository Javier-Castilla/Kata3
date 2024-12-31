package software.ulpgc.kata2.architecture.io;

import software.ulpgc.kata2.architecture.model.Title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleReader implements TitleReader {
    private final File file;
    private final TitleDeserializer deserializer;

    public TsvFileTitleReader(File file, TitleDeserializer deserializer) {
        this.file = file;
        this.deserializer = deserializer;
    }

    @Override
    public List<Title> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            return readWith(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Title> readWith(BufferedReader reader) throws IOException {
        String line;
        List<Title> titles = new ArrayList<>();
        while ((line = reader.readLine()) != null)
            titles.add(deserializer.deserialize(line));
        return titles;
    }
}
