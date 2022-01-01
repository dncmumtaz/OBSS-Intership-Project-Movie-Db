package co.obss.tr.obsstest.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.model.Product

class ListFragment : Fragment(R.layout.fragment_list), MyCustomAdapter.MyAdapterListener {

    private lateinit var buttonDelete: Button
    private lateinit var recyclerView: RecyclerView

    private val products = arrayListOf<Product>()
    private var adapter = MyCustomAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonDelete = view.findViewById(R.id.delete)
        recyclerView = view.findViewById(R.id.recycler)

        buttonDelete.setOnClickListener {
            products.removeFirstOrNull()
            adapter.notifyItemRemoved(0)
        }

        for (i in 1..10) {
            products.add(Product(R.drawable.avatar, "Product $i"))
        }
        adapter.products = products
        adapter.myAdapterListener = this

        recyclerView.adapter = adapter
    }

    override fun onProductDelete(product: Product) {
        products.remove(product)
        adapter.notifyDataSetChanged()
    }

}