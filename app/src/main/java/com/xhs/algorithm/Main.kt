package com.xhs.algorithm

import android.os.Build
import androidx.annotation.RequiresApi

object Main {
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @JvmStatic
    fun main(args: Array<String>) {
        val url = "http://192.168.1.88:8278/apks/leader/app_com.xhs.leader-1.0-2020-12-02.apk"
        val substringBeforeLast = url.substringBeforeLast("/", "/")
        println("测试${substringBeforeLast}")
    }


    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var flag = 0
        var startListNode: ListNode = ListNode(0)
        var current: ListNode? = startListNode
        var l11 = l1
        var l22 = l2
        var num = 0
        while (l11 != null) {
            val targetNode = ListNode(0)
            if (l11 != null && l22 != null) {
                val i = l11.value + l22.value + flag
                if (i >= 10) {
                    flag = i / 10
                    targetNode.value = i % 10
                } else {
                    flag = 0
                    targetNode.value = i
                }
                num = i / 10
            }
            current?.next = targetNode
            current = targetNode
            l11 = l11.next
            l22 = l22?.next
        }
        if (num == 1) {
            current?.next = ListNode(1)
        }
        return startListNode.next
    }

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }
}