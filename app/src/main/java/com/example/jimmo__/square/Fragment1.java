package com.example.jimmo__.square;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Fragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.frag1, container, false);
        final ImageView img1 = (ImageView) view.findViewById(R.id.image1);
        final ImageView img2 = (ImageView) view.findViewById(R.id.image2);
        final ImageView img3 = (ImageView) view.findViewById(R.id.image3);
        final ImageView img4 = (ImageView) view.findViewById(R.id.image4);
        final ImageView img5 = (ImageView) view.findViewById(R.id.image5);
        final ImageView img6 = (ImageView) view.findViewById(R.id.image6);
        final ImageView img7 = (ImageView) view.findViewById(R.id.image7);
        final ImageView img8 = (ImageView) view.findViewById(R.id.image8);
        final ImageView img9 = (ImageView) view.findViewById(R.id.image9);
        final ImageView img10 = (ImageView) view.findViewById(R.id.image10);
        final ImageView img11 = (ImageView) view.findViewById(R.id.image11);
        final ImageView img12 = (ImageView) view.findViewById(R.id.image12);


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               img1.setImageResource(R.drawable.cleaner_2);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setImageResource(R.drawable.consent_2);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img3.setImageResource(R.drawable.fans_2);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img4.setImageResource(R.drawable.iron_2);
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img5.setImageResource(R.drawable.kettle_2);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img6.setImageResource(R.drawable.light_2);
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img7.setImageResource(R.drawable.microwave_2);
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img8.setImageResource(R.drawable.oven_2);
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img9.setImageResource(R.drawable.refrigerator_2);
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img10.setImageResource(R.drawable.speaker_2);
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img11.setImageResource(R.drawable.tv_2);
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img12.setImageResource(R.drawable.washer_2);
            }
        });

        img1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img1.setImageResource(R.drawable.cleaner_3);
                return true;
            }
        });
        img2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img2.setImageResource(R.drawable.consent_3);
                return true;
            }
        });
        img3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img3.setImageResource(R.drawable.fans_3);
                return true;
            }
        });
        img4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img4.setImageResource(R.drawable.iron_3);
                return true;
            }
        });
        img5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img5.setImageResource(R.drawable.kettle_3);
                return true;
            }
        });
        img6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img6.setImageResource(R.drawable.light_3);
                return true;
            }
        });
        img7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img7.setImageResource(R.drawable.microwave_3);
                return true;
            }
        });
        img8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img8.setImageResource(R.drawable.oven_3);
                return true;
            }
        });
        img9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img9.setImageResource(R.drawable.refrigerator_3);
                return true;
            }
        });
        img10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img10.setImageResource(R.drawable.speaker_3);
                return true;
            }
        });
        img11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img11.setImageResource(R.drawable.tv_3);
                return true;
            }
        });
        img12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                img12.setImageResource(R.drawable.washer_3);
                return true;
            }
        });




      return view;
    }
}