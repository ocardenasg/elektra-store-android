package mx.com.elektra.store

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import mx.com.elektra.store.components.PrincipalBanner

class MainActivity : AppCompatActivity(), PrincipalBanner.BannerInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getBannerURL(): String {
        return "https://ekt-atap.s3.amazonaws.com/assets/app/home_main_banner.png"
    }

    override fun onClick() {
        Toast.makeText(this, "BANNER_CLICK" , Toast.LENGTH_SHORT).show()
    }
}
