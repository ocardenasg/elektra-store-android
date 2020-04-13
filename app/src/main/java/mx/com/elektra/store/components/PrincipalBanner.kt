package mx.com.elektra.store.components

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import mx.com.elektra.store.R

class PrincipalBanner : Fragment() {
    private var bannerImageView: ImageView? = null
    private var listener: BannerInterface? = null
    private var bannerView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bannerView = inflater.inflate(R.layout.fragment_principal_banner, container, false)

        bannerImageView = bannerView?.findViewById(R.id.banner)
        bannerImageView?.setOnClickListener {
            listener?.onClick()
        }

        val bannerUrl: String? = listener?.getBannerURL()

        Picasso.get()
            .load(bannerUrl)
            .placeholder(R.drawable.banner_primary)
            .error(R.drawable.banner_primary)
            .into(bannerImageView)

        return bannerView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            listener = context as BannerInterface
        } catch (e: ClassCastException) {
            throw ClassCastException("${context.toString()}: [LoadBannerListener] interface needs to be implemented.")
        }
    }

    interface BannerInterface {
        fun getBannerURL(): String
        fun onClick()
    }
}
