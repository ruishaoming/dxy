package com.dxy.happy.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dxy.happy.R;
import com.zhy.autolayout.AutoLayoutActivity;

import java.io.FileNotFoundException;


public class HeaderPhotoActivity extends AutoLayoutActivity implements View.OnClickListener {

    private final int IMAGE_CAPTURE_OK = 100;
    private final int REQUEST_ALBUM_OK = 101;

    private Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_photo);

        findViewById(R.id.mine_dialog_photo).setOnClickListener(this);
        findViewById(R.id.mine_dialog_picture).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //拍照
            case R.id.mine_dialog_photo:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, IMAGE_CAPTURE_OK);
                break;
            //打开相册
            case R.id.mine_dialog_picture:
                Intent albumIntent = new Intent(Intent.ACTION_PICK, null);
                albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(albumIntent, REQUEST_ALBUM_OK);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            //相机返回
            if (requestCode == IMAGE_CAPTURE_OK) {
                //两种方式 获取拍好的图片
                if (data.getData() != null || data.getExtras() != null) { //防止没有返回结果
                    Uri uri = data.getData();
                    if (uri != null) {
                        photo = BitmapFactory.decodeFile(uri.getPath()); //拿到图片
                    }
                    if (photo == null) {
                        Bundle bundle = data.getExtras();
                        if (bundle != null) {
                            photo = (Bitmap) bundle.get("data");
                            //获得拍照的照片
                            Toast.makeText(this, "photo------------------------" + photo, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "找不到图片", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                //相册的返回
            } else if (requestCode == REQUEST_ALBUM_OK) {
                Uri uri = data.getData();
                Log.e("uri", uri.toString());
                ContentResolver cr = this.getContentResolver();
                try {
                    //获得相册选中的照片
                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                    Toast.makeText(this, "bitmap------------------------" + bitmap, Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Log.e("Exception", e.getMessage(), e);
                }

            }
        }

    }
}
