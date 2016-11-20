import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public final static String ZIP_AUDIO_PATH = "D:\\audio.zip";
    public final static String ZIP_VIDEO_PATH = "D:\\video.zip";
    public final static String ZIP_IMAGE_PATH = "D:\\image.zip";

    public static void main(String[] args) throws IOException {
        List<String> folders = new ArrayList<>();
        ZipManager zipManager = new ZipManager();
        Scanner scanner = new Scanner(System.in);
        String folderPath = scanner.nextLine();

        folders.add(folderPath);
        zipManager.listAll(folderPath, folders);

        List<File> audio = new ArrayList<>();
        List<File> video = new ArrayList<>();
        List<File> image = new ArrayList<>();
        for (String folder : folders) {
            File dir = new File(folder);
            Collections.addAll(audio, dir.listFiles((directory, fileName) ->
                    fileName.endsWith(".mp3")
                            || fileName.endsWith(".wav")
                            || fileName.endsWith(".wma")
            ));
            Collections.addAll(video, dir.listFiles((directory, fileName) ->
                    fileName.endsWith(".mp4")
                            || fileName.endsWith(".avi")
                            || fileName.endsWith(".flv")
            ));
            Collections.addAll(image, dir.listFiles((directory, fileName) ->
                    fileName.endsWith(".jpg")
                            || fileName.endsWith(".jpeg")
                            || fileName.endsWith(".gif")
                            || fileName.endsWith(".tiff")
                            || fileName.endsWith(".png")
            ));
        }
        zipManager.compressFiles(audio, ZIP_AUDIO_PATH, folderPath);
        zipManager.compressFiles(video, ZIP_VIDEO_PATH, folderPath);
        zipManager.compressFiles(image, ZIP_IMAGE_PATH, folderPath);
    }
}
