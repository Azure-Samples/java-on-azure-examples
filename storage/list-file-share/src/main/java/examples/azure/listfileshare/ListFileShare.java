package examples.azure.storage.listfileshare;

import com.azure.storage.file.share.ShareDirectoryClient;
import com.azure.storage.file.share.ShareFileClientBuilder;
import com.azure.storage.file.share.models.ShareFileItem;

public class ListFileShare {
    public static void main(String[] args) {
        String connectionString = System.getenv("STORAGE_ACCOUNT_CONNECTION_STRING");
        String shareName = System.getenv("STORAGE_SHARE_NAME");

        ShareDirectoryClient directoryClient = new ShareFileClientBuilder()
            .connectionString(connectionString)
            .shareName(shareName)
            .resourcePath("")
            .buildDirectoryClient();

        listFilesAndDirectories(directoryClient, "");
    }

    private static void listFilesAndDirectories(ShareDirectoryClient directoryClient, String path) {
        for (ShareFileItem item : directoryClient.listFilesAndDirectories()) {
            String itemPath = path.isEmpty() ? item.getName() : path + "/" + item.getName();
            System.out.println(itemPath);

            if (item.isDirectory()) {
                ShareDirectoryClient subDirectoryClient = directoryClient.getSubdirectoryClient(item.getName());
                listFilesAndDirectories(subDirectoryClient, itemPath);
            }
        }
    }
}
