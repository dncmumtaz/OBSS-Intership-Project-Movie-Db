package co.obss.tr.obsstest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.obss.tr.obsstest.R
import co.obss.tr.obsstest.model.Character
import co.obss.tr.obsstest.model.Product
import com.bumptech.glide.Glide

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.MyViewHolder>() {

    var characters: List<Character>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        characters?.let {
            holder.bind(it[position])
        }
    }

    override fun getItemCount() = characters?.size ?: 0

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.image)
        private val textView: TextView = itemView.findViewById(R.id.text)
        private val deleteView: TextView = itemView.findViewById(R.id.delete)

        fun bind(character: Character) {
            Glide.with(imageView.context)
                .load(character.image)
                .error(R.drawable.avatar)
                .into(imageView)
            textView.text = character.name
        }

    }
}