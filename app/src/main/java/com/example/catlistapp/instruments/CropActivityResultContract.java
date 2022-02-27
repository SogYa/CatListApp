package com.example.catlistapp.instruments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Objects;

public class CropActivityResultContract extends ActivityResultContract<Object, Uri> {
//Контракт для работы с бибилотекой CropImage
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, Object input) {
        return CropImage.activity()
                .setAspectRatio(1,1)
                .setRequestedSize(900,900)
                .setCropShape(CropImageView.CropShape.RECTANGLE)
                .getIntent(context);
    }

    @Override
    public Uri parseResult(int resultCode, @Nullable Intent intent) {
        return Objects.requireNonNull(CropImage.getActivityResult(intent)).getUri();
    }
}
