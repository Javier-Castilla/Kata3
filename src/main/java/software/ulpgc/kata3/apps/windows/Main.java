package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata2.architecture.io.DatasetDownloader;
import software.ulpgc.kata2.architecture.io.TsvFileTitleDeserializer;
import software.ulpgc.kata2.architecture.io.TsvFileTitleReader;
import software.ulpgc.kata2.architecture.model.Title;
import software.ulpgc.kata3.apps.windows.io.MockBarchartLoader;
import software.ulpgc.kata3.apps.windows.view.MainFrame;
import software.ulpgc.kata3.architecture.control.ToggleCommand;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.add("toggle", new ToggleCommand(frame.display(), new MockBarchartLoader(loadTitles())))
                .setVisible(true);
    }

    public static List<Title> loadTitles() {
        File file = new File(DatasetDownloader.checkFile());
        return new TsvFileTitleReader(file, new TsvFileTitleDeserializer()).read();
    }
}
