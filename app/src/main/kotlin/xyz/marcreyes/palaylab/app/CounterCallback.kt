package xyz.marcreyes.palaylab.app

interface CounterCallback<T> {
    fun callback(data: T)
}