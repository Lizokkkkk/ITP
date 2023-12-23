import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    private List<Music> tracks;
    private List<Object> processors;
    private ExecutorService executorService;

    public DataManager() {
        this.processors = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        tracks = Reader.readMusic(source);
    }

    public void processData(String filterType, String filterValue) {
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class) && method.getName().equals(filterType)) {
                    try {
                        tracks = (List<Music>) method.invoke(processor, tracks, filterValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void saveData(String destination) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination))) {
            bufferedWriter.write("artists,album_name,track_name,popularity,duration_ms,explicit,danceability," +
                    "energy,key,loudness,mode,speechiness,acousticness,instrumentalness,liveness,valence,tempo," +
                    "time_signature,track_genre");
            bufferedWriter.newLine();

            for (Music music : tracks) {
                bufferedWriter.write(format(music));
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String format(Music music) {
        return String.format("%s,%s,%s,%d,%d,%s,%.1f,%.1f,%d,%.1f,%d,%.1f,%.1f,%.1f,%.1f,%.1f,%.1f,%d,%s",
                music.getArtist(),
                music.getAlbumName(),
                music.getTrackName(),
                music.getPopularity(),
                music.getDurationMs(),
                music.getExplicit(),
                music.getDanceability(),
                music.getEnergy(),
                music.getKey(),
                music.getLoudness(),
                music.getMode(),
                music.getSpeechiness(),
                music.getAcousticness(),
                music.getInstrumentalness(),
                music.getLiveness(),
                music.getValence(),
                music.getTempo(),
                music.getTimeSignature(),
                music.getTrackGenre()
        );
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
