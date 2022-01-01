package co.obss.tr.obsstest.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.model.ApiResponse
import co.obss.tr.obsstest.model.Character
import co.obss.tr.obsstest.network.RickAndMortyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersFragment : Fragment(R.layout.fragment_characters), Callback<ApiResponse> {

    lateinit var progressBar: ProgressBar
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var recyclerView: RecyclerView

    private var charactersAdapter = CharactersAdapter()
    private var characters: List<Character>? = null

    private var handler = Handler()
    private var refreshJob = Runnable {
        getCharacters()
        recall()
    }

    fun recall() {
        handler.postDelayed(refreshJob, 5000)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        getCharacters()
        handler.post(refreshJob)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(refreshJob)
    }

    fun initViews(view: View) {
        progressBar = view.findViewById(R.id.loading)

        swipeRefreshLayout = view.findViewById(R.id.swipe)
        swipeRefreshLayout.setOnRefreshListener {
            getCharacters()
        }
        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.adapter = charactersAdapter


    }

    fun getCharacters() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val service = retrofit.create(RickAndMortyService::class.java)

        progressBar.visibility = View.VISIBLE
        service.getCharacters().enqueue(this)
    }

    override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
        if (response.isSuccessful) {
            val apiResponse = response.body()
            val results = apiResponse?.results
            results?.let {
                charactersAdapter.apply {
                    characters = it
                    notifyDataSetChanged()
                }
            }
        }
        progressBar.visibility = View.GONE
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
        Log.e("service response", "fail", t)
        progressBar.visibility = View.GONE
        swipeRefreshLayout.isRefreshing = false
    }

}