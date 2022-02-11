package com.soarsy.ktdemo.Chapter3

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * NAME：YONG_
 * Created at: 2022/2/10 18
 * Describe:
 */
class MsgBean(val content: String,override val itemType: Int): MultiItemEntity {
 companion object {
  //定义常量的关键字是const
  //表示这是一条收到的消息
  const val TYPE_LEFT = 0
  //表示这是一条发出的消息
  const val TYPE_RIGHT = 1
 }
}