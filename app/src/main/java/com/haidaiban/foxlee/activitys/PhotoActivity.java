package com.haidaiban.foxlee.activitys;
import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;


import com.haidaiban.foxlee.fragments.R;

/**
 * Created by jili on 3/20/15.
 */
public abstract class PhotoActivity extends Activity{
    private ImageButton img;
    private ListView itemList;
    private Bitmap photo;
    private int REQUEST_CODE_PHOTOGRAPH=11;
    private int REQUEST_CODE_LOCPIC = 12;
    private Dialog dialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);
//
//        img = (ImageButton)findViewById(R.id.ib_uploadImg);
//        img.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//                chooseType();
//            }
//        });
    }
    /**
     * 选择获取图片的方式
     */
    private void chooseType(){
        dialog = new Dialog(getBaseContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_uploadphotos, null);
        itemList = (ListView)dialogView.findViewById(R.id.listView_photos);
        itemList.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_expandable_list_item_1,getData()));
        itemList.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View conventView, int position,
                                    long id) {
                String state = Environment.getExternalStorageState();
                if(state.equals(Environment.MEDIA_MOUNTED)){
                    if(position==0){      //拍照上传
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(intent, REQUEST_CODE_PHOTOGRAPH);
                    }else if(position ==1){    //本地上传
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, REQUEST_CODE_LOCPIC);
                    }
                }else{

                }

            }
        });
        dialog.setContentView(dialogView);

        dialog.setTitle("上传照片");

        dialog.show();
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        data.add("拍照上传");
        data.add("本地上传");
        return data;
    }

    /*
     * 处理拍摄后得到的图片(non-Javadoc)
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        dialog.dismiss();
        if(data!=null&&requestCode==REQUEST_CODE_PHOTOGRAPH){   //拍照上传时
            Bundle extras = data.getExtras();
            if(extras!=null){
                photo = (Bitmap)extras.get("data");
                img.setImageBitmap(photo);
                //saveImage();
            }else{
                Toast.makeText(getBaseContext(),"未找到图片", Toast.LENGTH_LONG).show();
            }
        }
        if(resultCode==Activity.RESULT_OK)
        {
            /**
             * 当选择的图片不为空的话，在获取到图片的途径
             */
            Uri uri = data.getData();
            try {
                String[] pojo = {MediaStore.Images.Media.DATA};

                @SuppressWarnings("deprecation")
                Cursor cursor = managedQuery(uri, pojo, null, null,null);
                if(cursor!=null)
                {
                    ContentResolver cr = this.getContentResolver();
                    int colunm_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();
                    String path = cursor.getString(colunm_index);
                    /***
                     * 这里加这样一个判断主要是为了第三方的软件选择，比如：使用第三方的文件管理器的话，你选择的文件就不一定是图片了，这样的话，我们判断文件的后缀名
                     * 如果是图片格式的话，那么才可以
                     */
                    if(path.endsWith("jpg")||path.endsWith("png"))
                    {
                        photo = BitmapFactory.decodeStream(cr.openInputStream(uri));
                        img.setImageBitmap(photo);
                    }else{

                    }
                }else{

                }

            } catch (Exception e) {

            }
        }

    }


}

