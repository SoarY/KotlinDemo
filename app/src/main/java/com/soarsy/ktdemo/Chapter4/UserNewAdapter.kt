package com.soarsy.ktdemo.Chapter4

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.soarsy.ktdemo.R

/**
 * NAME：YONG_
 * Created at: 2022/2/11 15
 * Describe:
 */
class UserNewAdapter: BaseQuickAdapter<UserBean, BaseViewHolder>(R.layout.item_rcy_cont) {
    override fun convert(holder: BaseViewHolder, item: UserBean) {
        val icon = holder.getView<ImageView>(R.id.iv_herd)
        //展示图片
        icon.setImageResource(item.herd)
        //直接设置文本内容
        holder.setText(R.id.tv_name, item.name)
        holder.setText(R.id.tv_phone, item.phone)
    }
}