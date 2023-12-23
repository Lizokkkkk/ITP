import java.util.List;
import java.util.stream.Collectors;

public class MusicFilter {

    @DataProcessor
    public List<Music> filterByArtist(List<Music> tracks, String artist) {
        return tracks.stream()
                .filter(music -> music.getArtist().contains(artist))
                .collect(Collectors.toList());
    }

    @DataProcessor
    public List<Music> filterByAlbumName(List<Music> tracks, String albumName) {
        return tracks.stream()
                .filter(music -> music.getAlbumName().contains(albumName))
                .collect(Collectors.toList());
    }

    @DataProcessor
    public List<Music> filterByTrackName(List<Music> tracks, String trackName) {
        return tracks.stream()
                .filter(music -> music.getTrackName().contains(trackName))
                .collect(Collectors.toList());
    }

    @DataProcessor
    public List<Music> filterByTrackGenre(List<Music> tracks, String trackGenre) {
        return tracks.stream()
                .filter(music -> music.getTrackGenre().contains(trackGenre))
                .collect(Collectors.toList());
    }
}
