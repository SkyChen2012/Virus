package com.benson.mall.redbaby;

import java.util.ArrayList;
import java.util.List;

import com.benson.mall.redbaby.adapter.BrandAdapter;
import com.benson.mall.redbaby.adapter.NewproductAdapter;
import com.benson.mall.redbaby.parser.BrandParser;
import com.benson.mall.redbaby.vo.Brand;
import com.benson.mall.redbaby.vo.BrandCategory;
import com.benson.mall.redbaby.vo.RequestVo;
import com.benson.virus.R;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

public class BrandActivity extends BaseWapperActivity {
	private List<BrandCategory> list;
	private TextView textBrandInfoNull;
	private TextView textTitle;
	private ExpandableListView expandableLV;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void findViewById() {
		expandableLV =  (ExpandableListView) findViewById(R.id.listBrandInfo);
		//listView = (ListView) findViewById(R.id.productList);
		System.out.println(expandableLV==null);
	}
	
	//加载布局文件
	@Override
	protected void loadViewLayout() {
		setContentView(R.layout.brand_activity);
		//setContentView(R.layout.product_list_activity);
		list = new ArrayList<BrandCategory>();
		setTitle("推荐品牌");
	}
	//执行逻辑
	@Override
	protected void processLogic() {
		RequestVo reqVo = new RequestVo();
		reqVo.requestUrl = R.string.url_brand;
		reqVo.context = context;
		
		reqVo.jsonParser = new BrandParser();
		
		super.getDataFromServer(reqVo, new DataCallback<List<BrandCategory>>() {

			@Override
			public void processData(List<BrandCategory> paramObject,
					boolean paramBoolean) {
				list = paramObject;
				BrandAdapter brandAdapter = new BrandAdapter(list, expandableLV, BrandActivity.this);
				expandableLV.setAdapter(brandAdapter);
			}

			
		});
	}
	//设置监听事件
	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}
}
