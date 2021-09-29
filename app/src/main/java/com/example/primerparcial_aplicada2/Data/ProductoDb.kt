package com.example.primerparcial_aplicada2.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.primerparcial_aplicada2.Model.Productos


@Database(
    entities = [Productos::class],
    version =  1,
    exportSchema = false
)
abstract class ProductoDb : RoomDatabase() {
    abstract  val productoDao: ProductoDao

    companion object{
        @Volatile
        private var INSTANCE: ProductoDb? = null

        fun getInstance(context: Context): ProductoDb{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductoDb::class.java,
                        "ProductoDb"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}