package com.example.primerparcial_aplicada2.Data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import menu.Productos
import menu.ProductosDao
import java.security.AccessControlContext

@Database(
    entities = [Productos ::class],
    version = 1,
    exportSchema = false
)


abstract class Db : RoomDatabase() {
    abstract val productosDao: ProductosDao

    companion object{

        @Volatile
        private  var INSTANCE:Db? = null

        fun getIntance (context: Contex): Db {
            synchronized(lock =  this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Db::class.java,
                        name: "Db"
                    )

                    .fallbackToDestructiveMigration()
                        .builld()


                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}