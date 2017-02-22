package siclo.com.ezphotopicker.ui;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.util.ArrayList;

import siclo.com.ezphotopicker.models.PhotoIntentException;

/**
 * Created by ericta on 11/13/16.
 */

interface PhotoIntentHelperContract {

    interface View{

        void openGallery(boolean isAllowMultipleSelect);

        void showLoading();

        void finishPickPhotoWithSuccessResult(String pickedPhotoName, ArrayList<String> pickedPhotoNames);

        void showPickPhotoFromGalleryError(int unexpectedErrorStringResource);

        void finishWithNoResult();

        void requestCameraAndExternalStoragePermission(boolean needToAddToGallery);

        void openCamera();

        void requestReadExternalStoragePermission();

        void showToastMessagePermissionDenied(int permisionDeniedErrorStringResource);

        void sendBroadcastToScanFileInGallery(File file);
    }

    interface Presenter{

        void onCreate(Bundle savedInstanceState) throws PhotoIntentException;

        void onPhotoPickedFromGallery(Intent data);

        void onRequestCameraPermissionGranted();

        void onRequestPermissionDenied();

        void onDestroy();

        void onPhotoPickedFromCamera(File filesDir);

        void onRequestReadExternalPermissionGranted();
    }

}
