package com.benson.Activity.XXFragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.benson.Tools.DispatchHandler;
import com.benson.virus.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.benson.Activity.XXFragment
 * Created by Benson on 2017/12/20-下午2:39.
 */

public class wipeRefreshFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,AdapterView.OnItemClickListener,Handler.Callback {

    private static final String Tag = "wipeRefreshFragment";
    private static final int REFRESH_COMPLETE = 0X110;

    private View view;
    private SwipeRefreshLayout mSwipeLayout;
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mDatas = new ArrayList<String>(Arrays.asList("Java", "Javascript", "C++", "Ruby", "Json",
            "HTML"));

    private Handler mHandler = new Handler(this);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.layout3, container, false);

        initView();
        return view;
    }

    private void initView() {

        mListView = (ListView)view.findViewById(R.id.xx_listview);
        mSwipeLayout = (SwipeRefreshLayout)view.findViewById(R.id.xx_swipe_ly);

        mSwipeLayout.setOnRefreshListener(this);
        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_expandable_list_item_1,mDatas);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

    }

    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i(Tag,"[position:"+position+"][id:"+id+"]");
        TextView mTextView = (TextView)view.findViewById(android.R.id.text1);
        mTextView.setText(mTextView.getText() + "+ fuck me !");
    }

    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.what)
        {
            case REFRESH_COMPLETE:
                mDatas.addAll(Arrays.asList("Lucene", "Canvas", "Bitmap"));
                mAdapter.notifyDataSetChanged();
                mSwipeLayout.setRefreshing(false);
                break;

        }
        return true;

    }
}
