package co.obss.tr.obsstest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.model.Product

class MyCustomAdapter : RecyclerView.Adapter<MyCustomAdapter.MyViewHolder>() {

    var products: ArrayList<Product>? = null
    var myAdapterListener: MyAdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(myAdapterListener, view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        products?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount() = products?.size ?: 0

    class MyViewHolder(val myAdapterListener: MyAdapterListener?, itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.image)
        private val textView: TextView = itemView.findViewById(R.id.text)
        private val deleteView: TextView = itemView.findViewById(R.id.delete)

        fun bind(product: Product) {
            imageView.setImageResource(product.imageDrawable)
            textView.text = product.name
            deleteView.setOnClickListener {
                myAdapterListener?.onProductDelete(product)
            }
        }

    }

    interface MyAdapterListener {
        fun onProductDelete(product: Product)
    }
}