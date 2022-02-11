package com.soarsy.ktdemo.Chapter3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.soarsy.ktdemo.R
import java.lang.IllegalArgumentException

/**
 * NAME：YONG_
 * Created at: 2022/2/11 11
 * Describe:
 */
class MsgAdapter(private val msgList:List<MsgBean>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

 inner class LeftViewHolder(view: View):RecyclerView.ViewHolder(view){
  val leftMsg=view.findViewById<TextView>(R.id.tv_left)
 }

 inner class RightViewHolder(view: View):RecyclerView.ViewHolder(view){
  val rightMsg=view.findViewById<TextView>(R.id.tv_right)
 }

 override fun getItemCount(): Int {
  return msgList.size
 }

 override fun getItemViewType(position: Int): Int {
  return msgList[position].itemType
 }

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
  return when(viewType){
   MsgBean.TYPE_LEFT->LeftViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_msg_left, parent, false))
   MsgBean.TYPE_RIGHT->RightViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_msg_right, parent, false))
   else->throw IllegalArgumentException()
  }
 }

 override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
  val msgBean = msgList[position]
  when(holder){
   is LeftViewHolder->holder.leftMsg.text=msgBean.content
   is RightViewHolder->holder.rightMsg.text=msgBean.content
   else -> throw IllegalArgumentException()
  }
 }

}