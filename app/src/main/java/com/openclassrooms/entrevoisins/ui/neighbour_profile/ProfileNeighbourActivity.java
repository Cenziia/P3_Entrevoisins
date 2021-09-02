package com.openclassrooms.entrevoisins.ui.neighbour_profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileNeighbourActivity extends AppCompatActivity {

    // UI Components
    @BindView(R.id.neighbour_page_img)
    public ImageView mImage;
    @BindView(R.id.neighbour_page_back_btn)
    public ImageButton mBackBtn;
    @BindView(R.id.neighbour_page_fav_btn)
    public FloatingActionButton mFavBtn;
    @BindView(R.id.neighbour_page_title_name_txt)
    public TextView mTitleNameTxt;
    @BindView(R.id.neighbour_page_name_txt)
    public TextView mNameTxt;
    @BindView(R.id.neighbour_page_address_txt)
    public TextView mAddressTxt;
    @BindView(R.id.neighbour_page_phone_txt)
    public TextView mPhoneTxt;
    @BindView(R.id.neighbour_page_link_txt)
    public TextView mLinkTxt;
    @BindView(R.id.neighbour_page_about_me_title_txt)
    public TextView mAboutMeTitleTxt;
    @BindView(R.id.neighbour_page_about_me_txt)
    public TextView mAboutMeTxt;

    private NeighbourApiService mApiService;
    private static String NEIGHBOUR_STRING = "neighbour";
    private static String TAG = ProfileNeighbourActivity.class.getSimpleName();

    public static  Intent newInstance(final Context context, final Neighbour neighbour) {
        Log.d(TAG, "> newInstance");
        Intent intent = new Intent(context, ProfileNeighbourActivity.class);
        Log.d(TAG, "neighbour: " + neighbour);
        intent.putExtra(NEIGHBOUR_STRING, neighbour);
        Log.d(TAG, "< newInstance");
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();
        //neighbour = mApiService.getNeighbours().get(0);
        Intent intent =getIntent();
        Neighbour neighbour = (Neighbour) intent.getParcelableExtra(NEIGHBOUR_STRING);

        Glide.with(mImage.getContext())
                .load(neighbour.getAvatarUrl())
                .centerCrop()
                .into(mImage);

        mTitleNameTxt.setText(neighbour.getName());
        mNameTxt.setText(neighbour.getName());
        mAddressTxt.setText(neighbour.getAddress());
        mPhoneTxt.setText(neighbour.getPhoneNumber());
        mAboutMeTxt.setText(neighbour.getAboutMe());
        mLinkTxt.setText("https://www.facebook.com/" + neighbour.getName());

        setFavoriteImage(neighbour);

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (neighbour.getFavorite() == false)
                    mFavBtn.setImageDrawable(getDrawable(R.drawable.ic_outline_star_24));
                    mApiService.addFavoriteNeighbour(neighbour);*/
                changeFavorite(neighbour);
            }

        });
       /* mFavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (neighbour.getFavorite() == false) {
                    mFavBtn.setImageDrawable(getDrawable(R.drawable.ic_outline_star_border_24));
                }
            }
        });*/

    }

    public void setFavoriteImage(Neighbour neighbour) {
        if (neighbour.getFavorite()) {
            mFavBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_outline_star_24));
        }
        else {
            mFavBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_outline_star_border_24));
        }
    }

    public void changeFavorite(Neighbour neighbour) {
        //return neighbour.getFavorite() == true;
        if (neighbour.getFavorite() == false) {
            mFavBtn.setImageDrawable(getDrawable(R.drawable.ic_outline_star_24));
            //return neighbour.getFavorite() == true;
            neighbour.setFavorite(true);

        } else {
            mFavBtn.setImageDrawable(getDrawable(R.drawable.ic_outline_star_border_24));
            //return neighbour.getFavorite() == false;
            neighbour.setFavorite(false);
           // mApiService.changeFavoriteNeighbour(neighbour);
        }
        //neighbour.setFavorite(true);
        mApiService.updateNeighbour(neighbour);

       System.out.println(mApiService.getFavoriteNeighbours());
//System.out.println(mApiService.getNeighbours());
       // System.out.println(mApiService.getFavoriteNeighbours());
        //System.out.println(neighbour.getFavorite());
    }

}
