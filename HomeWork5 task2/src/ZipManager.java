import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipManager {

    private final static int BUFFER_SIZE = 1024;

    void compressFiles(List<File> listFiles, String zipPath, String folderPath) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath));

        for (File file : listFiles) {
            addFileToZip(file, zos, folderPath);
        }
        zos.flush();
        zos.close();
    }

    private void addFileToZip(File file, ZipOutputStream zos, String folderPath) throws IOException {
        String path = file.getPath();
        zos.putNextEntry(new ZipEntry(path.substring(folderPath.length())));

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read;

        while ((read = bis.read(bytesIn)) != -1) {
            zos.write(bytesIn, 0, read);
        }
        zos.closeEntry();
    }

    public void listAll(String path, List<String> res)
            throws IOException {
        File dir = new File(path);
        File[] list = dir.listFiles();

        for (File f : list) {
            if (f.isDirectory()) {
                res.add(f.getCanonicalPath());
                listAll(f.getCanonicalPath(), res);
            }
        }
    }
}
