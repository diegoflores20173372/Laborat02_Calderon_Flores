package com.danp_labs.testcompose

data class Department(var depId: Int = 0, var depName: String = "") {
    override fun toString(): String {
        return "$depId $depName"
    }
}
