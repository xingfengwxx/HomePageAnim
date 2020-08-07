package com.wangxingxing.homepageanim.modleviewer;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.RequestOptions;
import com.makeramen.roundedimageview.RoundedImageView;
import com.sofakingforever.stars.AnimatedStarsView;
import com.wangxingxing.homepageanim.R;
import com.wangxingxing.homepageanim.recycleview.CircleRecyclerView;
import com.wangxingxing.homepageanim.recycleview.CircleRecyclerViewAdapter;
import com.wangxingxing.homepageanim.recycleview.CircularViewMode;
import com.wangxingxing.homepageanim.recycleview.UserInfoBean;
import com.wangxingxing.homepageanim.weight.CircleImageView;

import org.andresoviedo.android_3d_model_engine.camera.CameraController;
import org.andresoviedo.android_3d_model_engine.collision.CollisionController;
import org.andresoviedo.android_3d_model_engine.controller.TouchController;
import org.andresoviedo.android_3d_model_engine.services.SceneLoader;
import org.andresoviedo.android_3d_model_engine.view.ModelRenderer;
import org.andresoviedo.android_3d_model_engine.view.ModelSurfaceView;
import org.andresoviedo.util.android.AndroidURLStreamHandlerFactory;
import org.andresoviedo.util.android.ContentUtils;
import org.andresoviedo.util.event.EventListener;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import jp.wasabeef.glide.transformations.BitmapTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class ModelViewerActivity extends Activity implements EventListener {

    private static final String TAG = "ModelViewerActivity";

    // Custom handler: org/andresoviedo/util/android/assets/Handler.class
    // 为了取到assets路径下的model文件
    static {
        System.setProperty("java.protocol.handler.pkgs", "org.andresoviedo.util.android");
        URL.setURLStreamHandlerFactory(new AndroidURLStreamHandlerFactory());
    }

    private String[] permissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private AnimatedStarsView mAnimatedStarsViewWhite;
    private AnimatedStarsView mAnimatedStarsView;
    private FrameLayout mFrameLayoutRoot;
    private CircleRecyclerView mCrvUser;
    private CircleImageView mImageViewTest;

    private List<UserInfoBean> mData;
    private CircleRecyclerViewAdapter mAdapter;

    private ModelSurfaceView gLView;
    private TouchController touchController;
    private SceneLoader scene;
    private ModelViewerGUI gui;
    private CollisionController collisionController;
    private CameraController cameraController;

    //GLSurfaceView背景颜色,默认为黑色
    private float[] backgroundColor = new float[]{0.0f, 0.0f, 0.0f, 1.0f};

    private URI mURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_viewer);
        //getAssetsModel();

        initView();
        initData();
        checkPermission();
        loadModel();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAnimatedStarsView.onStart();
        mAnimatedStarsViewWhite.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAnimatedStarsViewWhite.onStop();
        mAnimatedStarsView.onStop();
    }

    private void checkPermission() {
        if (!PermissionUtils.isGranted(permissions)) {
            PermissionUtils.permission(permissions).request();
        } else {
            boolean copyState = ResourceUtils.copyFileFromAssets("models/earth.obj", getExternalCacheDir().getAbsolutePath() + File.separator + "models/earth.obj");
            ResourceUtils.copyFileFromAssets("models/earth.mtl", getExternalCacheDir().getAbsolutePath() + File.separator + "models/earth.mtl");
            ResourceUtils.copyFileFromAssets("models/surface.jpg", getExternalCacheDir().getAbsolutePath() + File.separator + "models/surface.jpg");
            ResourceUtils.copyFileFromAssets("models/surface_b.jpg", getExternalCacheDir().getAbsolutePath() + File.separator + "models/surface_b.jpg");

            Log.i(TAG, "onCreate: copyState=" + copyState + ", path=" + getExternalCacheDir().getAbsolutePath());

//            Uri uri = UriUtils.file2Uri(new File(getExternalCacheDir() + File.separator + "earth.obj"));
//            mURI = URI.create(uri.toString());
            File file = new File(getExternalCacheDir() + File.separator + "models/earth.obj");
//            mURI = file.toURI();
//            ContentUtils.setCurrentDir(file.getParentFile());
        }
    }

    private void initView() {
        mAnimatedStarsView = findViewById(R.id.stars);
        mAnimatedStarsViewWhite = findViewById(R.id.stars_white);
        mFrameLayoutRoot = findViewById(R.id.fl_root);
        mCrvUser = findViewById(R.id.crv_user);

        CircularViewMode circularViewMode = new CircularViewMode();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mCrvUser.setLayoutManager(linearLayoutManager);
        mCrvUser.setViewMode(circularViewMode);
        mCrvUser.setNeedCenterForce(true);
        mCrvUser.setNeedLoop(true);

        mImageViewTest = findViewById(R.id.iv_test);

//        Glide.with(this).load(R.drawable.icon_female_d).into(mImageViewTest);

//        Glide.with(this).load("https://image.niwoxuexi.com/blog/content/5c0d4b1972-loading.gif").into(mImageViewTest);

//        Glide.with(this).load("http://cdn.sbnh.cn/loading.gif").into(mImageViewTest);
//

//        MultiTransformation multiTransformation = new MultiTransformation(new RoundedCornersTransformation(128, 0));
//        Glide.with(this)
//                .load("http://cdn.sbnh.cn/loading-spinner")
//                .apply(RequestOptions.bitmapTransform(multiTransformation))
//                .into(mImageViewTest);

    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add(new UserInfoBean("user" + i));
        }
        mAdapter = new CircleRecyclerViewAdapter(mData, true);
        mCrvUser.setAdapter(mAdapter);
    }

    private void loadModel() {
        ContentUtils.provideAssets(this);
        Uri uri = Uri.parse("assets://" + getPackageName() + "/models/" + "earth.obj");
        try {
            mURI = new URI(uri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "loadModel: mURI=" + mURI);

        scene = new SceneLoader(this, mURI, 0, gLView);

        backgroundColor = getFloatArrayFromARGB("#1e0b44");

        gLView = new ModelSurfaceView(this, backgroundColor, scene);
        gLView.addListener(this);
//        setContentView(gLView);
        scene.setView(gLView);

        touchController = new TouchController(this);
        touchController.addListener(this);

        collisionController = new CollisionController(gLView, scene);
        collisionController.addListener(scene);
        touchController.addListener(collisionController);
        touchController.addListener(scene);

        cameraController = new CameraController(scene.getCamera());
        gLView.getModelRenderer().addListener(cameraController);
        touchController.addListener(cameraController);

        gui = new ModelViewerGUI(gLView, scene);
        touchController.addListener(gui);
        scene.addGUIObject(gui);

        scene.init();

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(400, 400);
        int marginLeft = ScreenUtils.getScreenWidth() - 400;
        int marginTop = ScreenUtils.getScreenHeight() / 2 - 400 + 100;
        layoutParams.setMargins(marginLeft, marginTop, 0, 0);
        gLView.setLayoutParams(layoutParams);

        mFrameLayoutRoot.addView(gLView);
    }

    private void getAssetsModel() {
        try {
            String[] modelPath = getAssets().list("model");
            for (String s : modelPath) {
                Log.d(TAG, "path=" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onEvent(EventObject event) {
        if (event instanceof ModelRenderer.ViewEvent) {
            ModelRenderer.ViewEvent viewEvent = (ModelRenderer.ViewEvent) event;
            if(viewEvent.getCode() == ModelRenderer.ViewEvent.Code.SURFACE_CHANGED) {
                touchController.setSize(viewEvent.getWidth(), viewEvent.getHeight());
                gLView.setTouchController(touchController);

                // process event in GUI
                if (gui != null) {
                    gui.setSize(viewEvent.getWidth(), viewEvent.getHeight());
                    gui.setVisible(true);
                }
            }
        }
        return true;
    }

    private float[] getFloatArrayFromARGB(String argb){
        int color_base = Color.parseColor(argb);
        int red = Color.red(color_base);
        int green = Color.green(color_base);
        int blue = Color.blue(color_base);
        int alpha = Color.alpha(color_base);

        return new float[]{
                (red / 255f),
                (green / 255f),
                (blue / 255f),
                (alpha / 255f)
        };
    }


}