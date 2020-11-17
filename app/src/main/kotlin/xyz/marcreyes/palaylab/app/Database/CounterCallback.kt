package xyz.marcreyes.palaylab.app.Database

interface CounterCallback<T> {
    fun callback(data: T)
}