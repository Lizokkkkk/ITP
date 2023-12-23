public class Music {
    private String artist;
    private String albumName;
    private String trackName;
    private int popularity;
    private int durationMs;
    private boolean explicit;
    private double danceability;
    private double energy;
    private int key;
    private double loudness;
    private int mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private int timeSignature;
    private String trackGenre;

    public Music() {}

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    public boolean getExplicit() {
        return explicit;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getEnergy() {
        return energy;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public double getValence() {
        return valence;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTimeSignature(int timeSignature) {
        this.timeSignature = timeSignature;
    }

    public int getTimeSignature() {
        return timeSignature;
    }

    public void setTrackGenre(String trackGenre) {
        this.trackGenre = trackGenre;
    }

    public String getTrackGenre() {
        return trackGenre;
    }
}
