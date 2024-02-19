package com.example.cinema

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cinema.databinding.FragmentNewsBinding
import com.example.cinema.retrofit.MyRetrofit
import com.example.cinema.retrofit.`interface`.RetrofitFunctions
import com.example.cinema.retrofit.model.DataMovie
import retrofit2.Call
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding: FragmentNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val context = requireContext()

//        Retrofit
        val retrofit = MyRetrofit().getNews()
        val api = retrofit.create(RetrofitFunctions::class.java)
        val call = api.getData()
        call.enqueue(object: retrofit2.Callback<List<DataMovie>>, NewsAdapterEvents {
            override fun onResponse(
                call: Call<List<DataMovie>>,
                response: Response<List<DataMovie>>
            ) {
                binding.recyclerNews.adapter = NewsAdapter(context, response.body() as List<DataMovie>, this)
            }

            override fun onFailure(call: Call<List<DataMovie>>, t: Throwable) {
                Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onItemClick(position: Int) {
                val intent = Intent(context, NewsActivity::class.java)
                intent.putExtra(Const.news, position)
                activity?.startActivity(intent)
            }
        })
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}