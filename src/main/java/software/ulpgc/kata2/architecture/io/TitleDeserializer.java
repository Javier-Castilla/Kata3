package software.ulpgc.kata2.architecture.io;

import software.ulpgc.kata2.architecture.model.Title;

public interface TitleDeserializer {
    Title deserialize(String line);
}
