package xyz.marcreyes.palaylab.app.database

interface CounterCallback<T> {
    fun callback(data: T)
}