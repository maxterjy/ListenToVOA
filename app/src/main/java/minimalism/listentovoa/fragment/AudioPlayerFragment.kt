package minimalism.listentovoa.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import minimalism.listentovoa.R

/**
 * A simple [Fragment] subclass.
 */
class AudioPlayerFragment : Fragment() {

    val mUrl: String by lazy {
        arguments?.getString(URL_TAG, "default_url") ?: "url_fail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playAudio()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audio_player, container, false)
    }

    fun playAudio() {
        Toast.makeText(context, mUrl, Toast.LENGTH_LONG)
    }

    companion object {
        val URL_TAG = "url"

        fun newInstance(url: String): AudioPlayerFragment {
            val f = AudioPlayerFragment()
            val args = Bundle()
            args.putString(URL_TAG, url)
            f.arguments = args

            return f
        }
    }
}
