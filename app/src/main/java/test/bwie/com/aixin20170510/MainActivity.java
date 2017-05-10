package test.bwie.com.aixin20170510;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String data = (String) msg.obj;

                    Toast.makeText(MainActivity.this, "000" + data, Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    String data1 = (String) msg.obj;
                    Log.i("zzz", data1.toString());
                    Toast.makeText(MainActivity.this, "000" + data1, Toast.LENGTH_SHORT).show();
                    break;

                case 4:
                    String data4 = (String) msg.obj;
                    Log.i("zzz", data4.toString());
                    Toast.makeText(MainActivity.this, "000" + data4, Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    String data5 = (String) msg.obj;
                    Log.i("zzz", data5.toString());
                    Toast.makeText(MainActivity.this, "000" + data5, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    String url = "http://result.eolinker.com/X39jyd7dd8d690677289995f22d9d77fafd75839e51385e?uri=tt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gettong = (Button) findViewById(R.id.gettong);
        Button getyi = (Button) findViewById(R.id.getyi);
        Button posttong = (Button) findViewById(R.id.posttong);
        Button postyi = (Button) findViewById(R.id.postyi);
        gettong.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            OkHttpClient client = new OkHttpClient();
                            Request request = new Request.Builder()
                                    .url(url)
                                    .build();

                            Response response = null;
                            try {
                                response = client.newCall(request).execute();
                                Message message = handler.obtainMessage(0, response.body().string());
                                message.sendToTarget();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    }).start();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        getyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(url)
                                .build();
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Message message = handler.obtainMessage(1, response.body().string());
                                message.sendToTarget();
                            }
                        });
                    }
                }).start();


            }
        });
        posttong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url2 = "http://admin.wap.china.com/user/NavigateTypeAction.do?processID=getNavigateNews";
                        OkHttpClient client = new OkHttpClient();
                        //page=1&code=news&pageSize=20&parentid=0&type=1

                        RequestBody body = new FormBody.Builder()
                                .add("page", "1")
                                .add("code", "news")
                                .add("pageSize", "20")
                                .add("parentid", "0")
                                .add("type", "1")
                                .build();


                        Request request = new Request.Builder()
                                .url(url2)
                                .post(body)
                                .build();
                        try {
                            Response response = client.newCall(request).execute();
                            Message message = handler.obtainMessage(4, response.body().string());
                            message.sendToTarget();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        });
        postyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //?uri=news
                        String url2 = "http://admin.wap.china.com/user/NavigateTypeAction.do?processID=getNavigateNews";
                        OkHttpClient client = new OkHttpClient();

                        RequestBody body = new FormBody.Builder()
                                .add("page", "2")
                                .add("code", "news")
                                .add("pageSize", "20")
                                .add("parentid", "0")
                                .add("type", "1")
                                .build();
                        Request request = new Request.Builder()
                                .url(url2)
                                .post(body)
                                .build();
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Message message = handler.obtainMessage(5, response.body().string());
                                message.sendToTarget();
                            }
                        });
                    }
                }).start();


            }
        });
    }
}
