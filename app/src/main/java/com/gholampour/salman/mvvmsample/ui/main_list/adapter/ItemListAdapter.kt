package com.gholampour.salman.mvvmsample.ui.main_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gholampour.salman.mvvmsample.R
import com.gholampour.salman.mvvmsample.base.BaseViewHolder
import com.gholampour.salman.mvvmsample.data.model.DoctorData
import com.gholampour.salman.mvvmsample.databinding.ItemDoctorViewBinding
import com.gholampour.salman.mvvmsample.databinding.ItemTitleViewBinding

private const val TYPE_DOCTOR = 1
private const val TYPE_TITLE = 2

class ItemListAdapter(
    private val data: MutableList<DoctorData>,
    private val adapterCallback: AdapterCallback
) : RecyclerView.Adapter<BaseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            TYPE_DOCTOR -> {
                val binding: ItemDoctorViewBinding =
                    ItemDoctorViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                ItemViewHolder(binding)
            }
            else -> {
                val binding: ItemTitleViewBinding =
                    ItemTitleViewBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                TitleViewHolder(binding)
            }
        }

    }

    override fun getItemCount() = data.size + 1

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            TYPE_TITLE
        } else {
            TYPE_DOCTOR
        }


    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun updateData(newData: List<DoctorData>) {
//        val diffCallback =
//            DoctorDiffCallback(
//                data,
//                newData
//            )
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
//        diffResult.dispatchUpdatesTo(this)


    }


    inner class ItemViewHolder(private val binding: ItemDoctorViewBinding) :
        BaseViewHolder(binding.root),
        ItemDoctorViewModel.ItemViewListener {


        override fun onClick(doctorData: DoctorData) {
            adapterCallback?.onItemClick(doctorData)
        }

        override fun onBind(position: Int) {
            val viewModel =
                ItemDoctorViewModel(
                    data[position-1],
                    this
                )
            binding.viewModel = viewModel
            binding.executePendingBindings()

        }

    }

    inner class TitleViewHolder(private val binding: ItemTitleViewBinding) :
        BaseViewHolder(binding.root) {


        override fun onBind(position: Int) {
            val viewModel =
                ItemTitleViewModel(
                    binding.root.context.getString(R.string.list_tile)
                )
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }


    }
}