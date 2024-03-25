package com.tirexmurina.patternapp.presentation.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tirexmurina.patternapp.R
import com.tirexmurina.patternapp.databinding.ItemCatalogMainBinding
import com.tirexmurina.patternapp.domain.repository.entity.Product

class HomeAdapter () : RecyclerView.Adapter<HomeViewHolder>() {

    var products: List<Product> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCatalogMainBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size
}

class HomeViewHolder(
    private val binding: ItemCatalogMainBinding
) : RecyclerView.ViewHolder(binding.root){
    private var resources = itemView.context.resources
    fun bind(
        product: Product?
    ){
        if (product != null){
            with(binding){
                itemTitle.text = product.title
                itemDescription.text = product.description
                itemPriceNew.text = String.format(resources.getString(R.string.pricing_template_string), product.price)
                val oldPrice = (product.price.toInt()*(100+product.discountPercentage.toFloat())/100).toInt().toString()
                itemPriceOld.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                itemPriceOld.text = String.format(resources.getString(R.string.pricing_template_string), oldPrice)
                populateViewPager(product.images)
            }
        }
    }

    private fun populateViewPager(images: List<String>) {
        val adapter = ImageViewPagerAdapter()
        binding.itemImageViewpager.adapter = adapter
        binding.itemImageViewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        (binding.itemImageViewpager.adapter as? ImageViewPagerAdapter)?.pics =  images
        binding.indicator.attachToPager(binding.itemImageViewpager)
    }
}
