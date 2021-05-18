package com.wangxingxing.homepageanim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;

public class OaidActivity extends AppCompatActivity implements IIdentifierListener {

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oaid);

        tvContent = findViewById(R.id.tv);

        MdidSdkHelper.InitSdk(getApplicationContext(), true, this);
    }

    @Override
    public void OnSupport(boolean b, IdSupplier idSupplier) {

        if(idSupplier==null) {
            return;
        }
        String oaid=idSupplier.getOAID();
        String vaid=idSupplier.getVAID();
        String aaid=idSupplier.getAAID();

        StringBuilder builder=new StringBuilder();
        builder.append("support: ").append(idSupplier.isSupported()?"true":"false").append("\n");
        builder.append("OAID: ").append(oaid).append("\n");
        builder.append("VAID: ").append(vaid).append("\n");
        builder.append("AAID: ").append(aaid).append("\n");

        String idstext=builder.toString();
        Log.d("SdkDemo: ", idstext);
        onIdsAvalid(idstext);
    }

    public void onIdsAvalid(@NonNull final String ids) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvContent.setText(ids);
            }
        });
    }
}