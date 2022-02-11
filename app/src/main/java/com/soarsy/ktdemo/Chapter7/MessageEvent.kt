package com.soarsy.ktdemo.Chapter7

/**
 * NAME：YONG_
 * Created at: 2022/2/11 17
 * Describe:
 */
class MessageEvent(var type:MessageType,var string: String) {

 enum class MessageType {
  ShowToast,
  ShowLog,
 }
}