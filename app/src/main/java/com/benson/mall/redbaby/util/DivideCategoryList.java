package com.benson.mall.redbaby.util;

import java.util.ArrayList;
import java.util.List;

import com.benson.mall.redbaby.vo.CategoryVo;

/**
 * com.benson.mall.redbaby.util
 * Created by Benson on 2017/9/6-下午7:46.
 */

public class DivideCategoryList {
    List<CategoryVo> totalList;


    public DivideCategoryList(List<CategoryVo> totalList) {
        super();
        this.totalList = totalList;
    }

    public List<CategoryVo> getOneLevel(){
        List<CategoryVo>  voList = new ArrayList<CategoryVo>();
        for(CategoryVo vo : totalList){
            if(vo.getParent_id().equals("0")){
                voList.add(vo);
            }
        }
        return voList;
    }
    public List<CategoryVo> getNextLevel(String listId){
        List<CategoryVo> voList = new ArrayList<CategoryVo>();
        for(CategoryVo vo : totalList){
            if(vo.getParent_id().equals(listId)){
                voList.add(vo);
            }
        }
        return voList;
    }


}
