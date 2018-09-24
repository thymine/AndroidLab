package me.zhang.workbench.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zhang.workbench.R;
import me.zhang.workbench.utils.UiUtils;

public class RecyclerActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        mRecyclerView.addItemDecoration(new SpacesItemDecoration((int) UiUtils.convertDpToPixel(2, this)));
        List<String> imageList = new ArrayList<>();
        imageList.addAll(Arrays.asList(Images.imageUrls));
        mRecyclerView.setAdapter(new RecyclerAdapter(this, imageList));
    }
}