package com.wangxingxing.homepageanim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.constant.PermissionConstants
import com.blankj.utilcode.util.PermissionUtils

class KTTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kttest)

        PermissionUtils.permissionGroup(PermissionConstants.MICROPHONE)
            .rationale { activity, shouldRequest -> /*PermissionHelper.showRationaleDialog(activity, shouldRequest)*/ }
            .callback(object : PermissionUtils.FullCallback {
                override fun onGranted(permissionsGranted: List<String>) {
//                    LogUtils.d(permissionsGranted)
//                    showSnackbar(true, "Microphone is granted")
//                    itemsView.updateItems(bindItems())
                }

                override fun onDenied(permissionsDeniedForever: List<String>,
                                      permissionsDenied: List<String>) {
//                    LogUtils.d(permissionsDeniedForever, permissionsDenied)
//                    if (permissionsDeniedForever.isNotEmpty()) {
//                        showSnackbar(false, "Microphone is denied forever")
//                    } else {
//                        showSnackbar(false, "Microphone is denied")
//                    }
//                    itemsView.updateItems(bindItems())
                }
            })
            .request()
    }
}