package io.github.projectbukirin.palaylab

interface CounterCallback<T> {
    fun callback(data: T)
}