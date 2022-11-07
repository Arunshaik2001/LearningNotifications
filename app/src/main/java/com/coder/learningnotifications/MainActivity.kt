package com.coder.learningnotifications

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import com.coder.learningnotifications.ui.theme.LearningNotificationsTheme
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LearningNotificationsTheme {
                // A surface container using the 'background' color from the theme

                LaunchedEffect(key1 = true){


                    Dexter.withContext(this@MainActivity)
                        .withPermissions(
                            Manifest.permission.POST_NOTIFICATIONS,
                        )
                        .withListener(object : MultiplePermissionsListener {
                            override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                            }

                            override fun onPermissionRationaleShouldBeShown(
                                permissions: List<PermissionRequest?>?,
                                token: PermissionToken?
                            ) {

                            }
                        })
                        .check()

                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearningNotificationsTheme {
        Greeting("Android")
    }
}