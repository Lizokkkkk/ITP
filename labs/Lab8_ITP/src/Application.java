public class Application {
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.registerDataProcessor(new MusicFilter());

        String sourceLink = "C:\\Users\\Natalya\\Desktop\\Lab8_ITP\\src\\train.csv";

        dataManager.loadData(sourceLink);
        dataManager.processData("filterByArtist", "Gen Hoshino");
        dataManager.saveData("C:\\Users\\Natalya\\Desktop\\Lab8_ITP\\src\\results\\GenHoshinoMusic.csv");

        dataManager.loadData(sourceLink);
        dataManager.processData("filterByTrackGenre", "acoustic");
        dataManager.saveData("C:\\Users\\Natalya\\Desktop\\Lab8_ITP\\src\\results\\AcousticMusic.csv");

        dataManager.shutdown();
    }
}
