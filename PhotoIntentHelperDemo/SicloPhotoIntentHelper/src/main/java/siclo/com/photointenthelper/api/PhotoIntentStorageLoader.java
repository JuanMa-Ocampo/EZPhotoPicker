package siclo.com.photointenthelper.api;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.IOException;

import siclo.com.photointenthelper.storage.PhotoIntentHelperStorage;

/**
 * Created by ericta on 11/13/16.
 */

public class PhotoIntentStorageLoader {

    private PhotoIntentHelperStorage photoIntentHelperStorage;

    public PhotoIntentStorageLoader(Context context) {
        photoIntentHelperStorage = PhotoIntentHelperStorage.getInstance(context);
    }

    public String loadLatestStoredPhotoName() {
        return photoIntentHelperStorage.loadLatestStoredPhotoName();
    }

    public String loadLatestStoredPhotoDir() {
        return photoIntentHelperStorage.loadLatestStoredPhotoDir();
    }

    public Bitmap loadLatestStoredPhotoBitmap() throws IOException {
        return loadLatestStoredPhotoBitmap(0);
    }

    public Bitmap loadLatestStoredPhotoBitmap(int maxScaleSize) throws IOException {
        String storedPhotoDir = loadLatestStoredPhotoDir();
        String storedPhotoName = loadLatestStoredPhotoName();
        return loadStoredPhotoBitmap(storedPhotoDir, storedPhotoName, maxScaleSize);
    }
    public Bitmap loadStoredPhotoBitmap(String storedPhotoDir, String storedPhotoName) throws IOException {
        return loadStoredPhotoBitmap(storedPhotoDir, storedPhotoName, 0);
    }

    public Bitmap loadStoredPhotoBitmap(String storedPhotoDir, String storedPhotoName, int maxScaleSize) throws IOException {
        return photoIntentHelperStorage.loadStoredPhotoBitmap(storedPhotoDir, storedPhotoName, maxScaleSize);
    }
}
