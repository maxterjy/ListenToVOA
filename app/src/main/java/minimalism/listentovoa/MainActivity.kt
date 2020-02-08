package minimalism.listentovoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import minimalism.listentovoa.fragment.AudioPlayerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        val url = "https://av.voanews.com/clips/VLE/2020/02/08/20200208-003000-VLE122-program_hq.mp3"
        ft.add(R.id.audio_player_container, AudioPlayerFragment.newInstance(url))
        ft.commit()
    }

    fun test() {
        val queue = Volley.newRequestQueue(this)
        val url = "http://www.google.com"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                Log.i("thach", "response: ${response}")
            },
            Response.ErrorListener {
                Log.i("thach", "error: ${it.message}")
            })

        queue.add(stringRequest)
    }

}
