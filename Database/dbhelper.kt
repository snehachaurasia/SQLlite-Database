//Right-click on the package → New → Kotlin Class/File → Name it DBHelper.
the above step is to be done on the android studio //

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "student.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE student(id INTEGER PRIMARY KEY, name TEXT, marks INTEGER)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldV: Int, newV: Int) {
        db.execSQL("DROP TABLE IF EXISTS student")
        onCreate(db)
    }

    // Insert
    fun insert(id: Int, name: String, marks: Int) {
        val cv = ContentValues()
        cv.put("id", id)
        cv.put("name", name)
        cv.put("marks", marks)
        writableDatabase.insert("student", null, cv)
    }

    // Update
    fun update(id: Int, name: String, marks: Int) {
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("marks", marks)
        writableDatabase.update("student", cv, "id=?", arrayOf(id.toString()))
    }

    // Delete
    fun delete(id: Int) {
        writableDatabase.delete("student", "id=?", arrayOf(id.toString()))
    }

    // Read
    fun getAll(): String {
        val c = readableDatabase.rawQuery("SELECT * FROM student", null)
        var result = ""
        while (c.moveToNext()) {
            result += "${c.getInt(0)}  ${c.getString(1)}  ${c.getInt(2)}\n"
        }
        c.close() 
        return result
    }
