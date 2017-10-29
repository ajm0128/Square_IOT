package com.example.jimmo__.square;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Fragment2 extends Fragment {
    ArrayList<item> itemList;


    HttpUtil issueUtil;
    HttpUtil initIssueUtil;
    String currentSize = "";
    String currentTime = "";
    Handler handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        View view = inflater.inflate(R.layout.frag2, container, false);



        handler = new Handler();


        itemList = new ArrayList<>();


        final MyListAdapter myListAdapter = new MyListAdapter(getContext(), itemList);

        ListView listView = (ListView) view.findViewById(R.id.listview1);
        listView.setAdapter(myListAdapter);


        currentTime = String.valueOf(System.currentTimeMillis());


        issueUtil = new HttpUtil();
        issueUtil.setMethod(issueUtil.HTTP_METHOD_GET)
                .setUrl("https://api.artik.cloud/v1.1/messages?count=100&order=desc&sdid=3955a5541fe64978b8f73dd8b9983895&startDate=1509186812056&endDate=" + currentTime)
                .setCallback(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//                        Log.e("RESPONSE" , response.body().string());
                        String tmpSize = "";
                        JSONObject res = null;
                        String res_str = response.body().string();
                        Log.e("res", res_str);
                        try {
                            res = new JSONObject(res_str);
                            tmpSize = res.getString("size");
                            Log.e("tmpSize", tmpSize);


                            if (!currentSize.equals(tmpSize)) {
                                JSONArray data = res.getJSONArray("data");
                                JSONObject currentMessage = (JSONObject) data.get(0);
                                String MESSAGE_CONTENTS = currentMessage.getJSONObject("data").getString("MESSAGE_CONTENTS");
                                String MESSAGE_TYPE = currentMessage.getJSONObject("data").getString("MESSAGE_TYPE");
                                notificationSomethings(MESSAGE_TYPE, MESSAGE_CONTENTS);

                                item tmp = new item();
                                tmp.setName("차단완료");
                                if(MESSAGE_TYPE.equals("002")){
                                    tmp.setContents("192.168.1.8 에서 관리자 웹 페이지 로그인 시도");
                                }
                                else{
                                    tmp.setContents("192.168.1.8 에서 ssh 로그인 시도");
                                }

                                itemList.add(tmp);

                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        myListAdapter.notifyDataSetChanged();
                                    }
                                });


                                currentSize = tmpSize;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        try {
                            Thread.sleep(100000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        currentTime = String.valueOf(System.currentTimeMillis());
                        issueUtil.setUrl("https://api.artik.cloud/v1.1/messages?count=100&order=desc&sdid=3955a5541fe64978b8f73dd8b9983895&startDate=1509186812056&endDate=" + currentTime);
                        issueUtil.execute();

                    }
                })
                .setMethod(issueUtil.HTTP_METHOD_GET);



        initIssueUtil = new HttpUtil();
        initIssueUtil.setMethod(initIssueUtil.HTTP_METHOD_GET)
                .setUrl("https://api.artik.cloud/v1.1/messages?count=100&order=desc&sdid=3955a5541fe64978b8f73dd8b9983895&startDate=1509186812056&endDate=" + currentTime)
                .setCallback(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
//                        Log.e("RESPONSE" , response.body().string());
                        try {
                            JSONObject res = new JSONObject(response.body().string());
                            currentSize = res.getString("size");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        currentTime = String.valueOf(System.currentTimeMillis());
                        issueUtil.setUrl("https://api.artik.cloud/v1.1/messages?count=100&order=desc&sdid=3955a5541fe64978b8f73dd8b9983895&startDate=1509186812056&endDate=" + currentTime);
                        issueUtil.execute();
                    }
                })
                .setMethod(initIssueUtil.HTTP_METHOD_GET)
                .execute();


        return view;
    }


    public void notificationSomethings(String message_type, String message_contents) {


        Resources res = getResources();

        Intent notificationIntent = new Intent(getActivity(), MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getActivity(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());

        builder.setContentTitle("Square")
                .setContentText(message_contents)
                .setTicker(message_type)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.mipmap.ic_launcher))
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            builder.setCategory(Notification.CATEGORY_MESSAGE)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
        }

        NotificationManager nm = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1234, builder.build());

        Vibrator m_vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        m_vibrator.vibrate(2);

    }


}




