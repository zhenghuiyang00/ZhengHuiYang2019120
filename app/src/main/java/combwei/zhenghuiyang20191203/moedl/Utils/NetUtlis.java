package combwei.zhenghuiyang20191203.moedl.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtlis {

    private static NetUtlis netUtlis=new NetUtlis();

    public NetUtlis() {
    }

    public static NetUtlis getInstance() {
        return netUtlis;
    }

    //getJson
    @SuppressLint("StaticFieldLeak")
    public void getJson(final String httpurl, final Mycallback mycallback){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                mycallback.getJson(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
               InputStream inputStream=null;
               String json="";
                try {
                    URL url = new URL(httpurl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    if (httpURLConnection.getResponseCode()==200){
                         inputStream = httpURLConnection.getInputStream();
                         json=json(inputStream);
                    }else {
                        Log.e("xxx","请求失败");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return json;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }

    //json
    public String json(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len=-1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        return new String(byteArrayOutputStream.toByteArray());
    }

    //接口
    public interface Mycallback{
        void getJson(String json);
    }
    //getPhoto
    @SuppressLint("StaticFieldLeak")
    public void getPhoto(final String photoUrl, final ImageView imageView){
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                InputStream inputStream=null;
                Bitmap bitmap=null;
                try {
                    URL url = new URL(photoUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                        bitmap=bitmap(inputStream);
                    }else {
                        Log.e("xxx","请求失败");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return bitmap;
            }
        }.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }


    //photo
    public Bitmap bitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }

    //网络判断
    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null && activeNetworkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }


    //Wifi判断
    public boolean ifWifi(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType()==ConnectivityManager.TYPE_WIFI){
            return true;
        }else {
            return false;
        }
    }


    //移动网络判断
    public boolean ifMobile(Context context){
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType()==ConnectivityManager.TYPE_MOBILE){
            return true;
        }else {
            return false;
        }
    }


}
