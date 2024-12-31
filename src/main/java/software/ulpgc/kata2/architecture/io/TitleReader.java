package software.ulpgc.kata2.architecture.io;

import software.ulpgc.kata2.architecture.model.Title;

import java.util.List;

public interface TitleReader {
    List<Title> read();
}
