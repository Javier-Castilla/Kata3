package software.ulpgc.kata3.apps.windows.io;


import software.ulpgc.kata2.architecture.model.Title;
import software.ulpgc.kata3.architecture.io.BarchartLoader;
import software.ulpgc.kata3.architecture.model.Barchart;

import java.util.List;

public class MockBarchartLoader implements BarchartLoader {
    private static final int BARCHART_AMOUNT = 4;
    private final List<Title> films;
    private final Barchart titleTypeBarchart;
    private final Barchart genreBarchart;
    private final Barchart runtimeBarchart;
    private final Barchart startYearBarchart;
    private int id;

    public MockBarchartLoader(List<Title> films) {
        this.films = films;
        this.titleTypeBarchart = titleTypeBarchart();
        this.genreBarchart = genreBarchart();
        this.runtimeBarchart = runtimeBarchart();
        this.startYearBarchart = startYearBarchart();
        this.id = -1;
    }

    @Override
    public Barchart load() {
        return switch (this.id = ++id % BARCHART_AMOUNT) {
            case 0 -> titleTypeBarchart;
            case 1 -> genreBarchart;
            case 2 -> runtimeBarchart;
            case 3 -> startYearBarchart;
            default -> throw new IllegalStateException("Unexpected value: " + id);
        };
    }

    private Barchart startYearBarchart() {
        Barchart barchart = new Barchart("TitleType Barchart", "X", "Y");
        for (Title film : films)
            barchart.put(String.valueOf(film.startYear()), barchart.getOrDefault(String.valueOf(film.startYear()), 0) + 1);
        return barchart;
    }

    private Barchart runtimeBarchart() {
        Barchart barchart = new Barchart("TitleType Barchart", "X", "Y");
        for (Title film : films)
            barchart.put(String.valueOf(film.runtimeMinutes()), barchart.getOrDefault(String.valueOf(film.runtimeMinutes()), 0) + 1);
        return barchart;
    }

    private Barchart genreBarchart() {
        Barchart barchart = new Barchart("TitleType Barchart", "X", "Y");
        for (Title film : films)
            for (Title.Genre genre : film.genres())
                barchart.put(genre.toString(), barchart.getOrDefault(genre.toString(), 0) + 1);
        return barchart;
    }

    private Barchart titleTypeBarchart() {
        Barchart barchart = new Barchart("TitleType Barchart", "X", "Y");
        for (Title film : films)
            barchart.put(film.titleType().toString(), barchart.getOrDefault(film.titleType().toString(), 0) + 1);
        return barchart;
    }
}
