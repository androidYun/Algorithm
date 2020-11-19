package com.xhs.algorithm

object Main3 {
    @JvmStatic
    fun main(args: Array<String>) {
        /**
         * 第一列
         */
        val l1 = ListNode(2)
        val l2 = ListNode(4)
        val l3 = ListNode(3)
        l1.next = l2
        l2.next = l3
        /**
         * 第二列
         */
        val l11 = ListNode(8)
        val l22 = ListNode(6)
        val l33 = ListNode(4)
        l11.next = l22
        l22.next = l33
        var addTwoNumbers = addTwoNumbers(l1, l11)
        while (addTwoNumbers != null) {
            println("打印数据${addTwoNumbers.value}")
            addTwoNumbers = addTwoNumbers.next
        }
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