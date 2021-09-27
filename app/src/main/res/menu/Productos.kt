package menu


import androidx.room.*
import androidx.room.Entity
import androidx.room.Query


@Entity
data class Productos(
 @PrimaryKey(autoGenerate = true)
 var ProductosId : Long,
 var Descripcion : String,
 var Existencias : String,
 var Costo : Float,
 var ValorInventario : Float,
)

@Dao
interface ProductosDao{
 @Insert
 suspend fun insert (productos: Productos)

 @Update
 suspend fun Update(productos: Productos)

 @Query(value =  "SELECT * FROM Productos WHERE ProductosId= :key")
 suspend fun  Find (key: Long): Productos?
}
