import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<Music> readMusic(String fileName) {
        List<Music> tracks = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            File music = new File(fileName);
            bufferedReader = new BufferedReader(new FileReader(music));
            String line;
            boolean firstLine = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] characteristics = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                tracks.add(createMusic(characteristics));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tracks;
    }

    private static Music createMusic(String[] ch) {
        Music music = new Music();
        music.setArtist(ch[2]);
        music.setAlbumName(ch[3]);
        music.setTrackName(ch[4]);
        music.setPopularity(Integer.parseInt(ch[5]));
        music.setDurationMs(Integer.parseInt(ch[6]));
        music.setExplicit(Boolean.parseBoolean(ch[7]));
        music.setDanceability(Double.parseDouble(ch[8]));
        music.setEnergy(Double.parseDouble(ch[9]));
        music.setKey(Integer.parseInt(ch[10]));
        music.setLoudness(Double.parseDouble(ch[11]));
        music.setMode(Integer.parseInt(ch[12]));
        music.setSpeechiness(Double.parseDouble(ch[13]));
        music.setAcousticness(Double.parseDouble(ch[14]));
        music.setInstrumentalness(Double.parseDouble(ch[15]));
        music.setLiveness(Double.parseDouble(ch[16]));
        music.setValence(Double.parseDouble(ch[17]));
        music.setTempo(Double.parseDouble(ch[18]));
        music.setTimeSignature(Integer.parseInt(ch[19]));
        music.setTrackGenre(ch[20]);

        return music;
    }
}
