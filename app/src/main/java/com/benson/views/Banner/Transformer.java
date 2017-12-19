package com.benson.views.Banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.benson.views.Banner.transformer.AccordionTransformer;
import com.benson.views.Banner.transformer.BackgroundToForegroundTransformer;
import com.benson.views.Banner.transformer.CubeInTransformer;
import com.benson.views.Banner.transformer.CubeOutTransformer;
import com.benson.views.Banner.transformer.DefaultTransformer;
import com.benson.views.Banner.transformer.DepthPageTransformer;
import com.benson.views.Banner.transformer.FlipHorizontalTransformer;
import com.benson.views.Banner.transformer.FlipVerticalTransformer;
import com.benson.views.Banner.transformer.ForegroundToBackgroundTransformer;
import com.benson.views.Banner.transformer.RotateDownTransformer;
import com.benson.views.Banner.transformer.RotateUpTransformer;
import com.benson.views.Banner.transformer.ScaleInOutTransformer;
import com.benson.views.Banner.transformer.StackTransformer;
import com.benson.views.Banner.transformer.TabletTransformer;
import com.benson.views.Banner.transformer.ZoomInTransformer;
import com.benson.views.Banner.transformer.ZoomOutSlideTransformer;
import com.benson.views.Banner.transformer.ZoomOutTranformer;

public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
}
