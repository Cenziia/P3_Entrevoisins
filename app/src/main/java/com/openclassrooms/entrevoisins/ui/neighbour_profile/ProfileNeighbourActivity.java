package com.openclassrooms.entrevoisins.ui.neighbour_profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_neighbour);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();
        //int poop = getIntent().getIntExtra("neighbourID", 0);
        //long poop = getIntent().getLongExtra("neighbourID", -1);
        //neighbour.setId(poop);
        //String NAME = getIntent().getDataString();
        //GetNeighbour();
        Intent intent =getIntent();
        Neighbour neighbour = (Neighbour) intent.getParcelableExtra("neighbour");

        Glide.with(mImage.getContext())
                .load(getDrawable(R.drawable.image_test))
                .centerCrop()
                .into(mImage);

        mTitleNameTxt.setText(neighbour.getName());
        mNameTxt.setText(neighbour.getName());
        mAddressTxt.setText(neighbour.getAddress());
        mPhoneTxt.setText(neighbour.getPhoneNumber());
        mAboutMeTxt.setText(neighbour.getAboutMe());
        mLinkTxt.setText("https://www.facebook.com/" + neighbour.getName());

        //setFavoriteImage(neighbour);

    }

    public void setFavoriteImage(Neighbour neighbour) {
        if (neighbour.getFavorite()) {
            mFavBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_outline_star_24));
        }
        else {
            mFavBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_outline_star_border_24));
        }
    }


}