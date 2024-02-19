package com.example.cinema

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cinema.databinding.FragmentBooksBinding
import com.example.cinema.retrofit.MyRetrofit
import com.example.cinema.retrofit.`interface`.RetrofitFunctions
import com.example.cinema.retrofit.model.DataBooks
import com.example.cinema.retrofit.model.DataCharacters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.create

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BooksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BooksFragment() : Fragment() {
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

    private lateinit var binding: FragmentBooksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBooksBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val retrofit = MyRetrofit().getBooks()
        val booksApi = retrofit.create(RetrofitFunctions::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            val books = booksApi.getBooks()
            val characters = booksApi.getCharacter()
            binding.recyclerBooks.adapter = BooksAdapter(books)
        }
    }


//    Передача данных во фрагмент
    companion object {
        fun bookInstance(args: Bundle?): BooksFragment {
            val booksFragment = BooksFragment()
            booksFragment.arguments = args
            return booksFragment
        }
    }
}