package com.mygdx.drop;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;



public class AndroidLauncher extends AndroidApplication {
    private AdView madView;
    private final String ADCODE ="ca-app-pub-8592347779733291/4023317760";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();

        RelativeLayout layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams gameViewParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        gameViewParams.bottomMargin = 150;

        View gameView = initializeForView(new Drop(), cfg);
        layout.addView(gameView, gameViewParams);

        madView = new AdView(this);
        madView.setAdUnitId(ADCODE);
        madView.setAdSize(AdSize.BANNER);

        RelativeLayout.LayoutParams adParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        adParams.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);

        layout.addView(madView, adParams);

        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);

        setContentView(layout);

    }

    public void setupAd(){
        madView = new AdView(this);
        madView.setVisibility(View.INVISIBLE);
        madView.setBackgroundColor(0xff000000); // black
        madView.setAdUnitId(ADCODE);
        madView.setAdSize(AdSize.SMART_BANNER);
    }
}
