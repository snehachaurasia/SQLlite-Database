//UI: 2 number textbox (hint : name , marks) , textbox (hint: name) , 4 buttons (insert , update , dekete , show all) , 1 textView
Linear Layout

lateinit var db: DBHelper
  lateinit var txtID: EditText
  lateinit var txtName: EditText
  lateinit var txtMarks: EditText
  lateinit var txtData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.studentdbapp)
    
        db = DBHelper(this)
txtID = findViewById(R.id.txtID)
txtName = findViewById(R.id.txtName)
txtMarks = findViewById(R.id.txtMarks)
txtData = findViewById(R.id.txtData)
	
after OnCreate():
fun insert(view: View) {
        db.insert(
            txtID.text.toString().toInt(),
            txtName.text.toString(),
            txtMarks.text.toString().toInt()
        )
        toast("Inserted")
        clearText()
    }

    fun update(view: View) {
        db.update(
            txtID.text.toString().toInt(),
            txtName.text.toString(),
            txtMarks.text.toString().toInt()
        )
        toast("Updated")
        clearText()
    }

    fun delete(view: View) {
        db.delete(txtID.text.toString().toInt())
        toast("Deleted")
        clearText()
    }

    fun showAll(view: View) {
        txtData.text = db.getAll()
        clearText()
    }

    private fun clearText() {
        txtID.text.clear()
        txtName.text.clear()
        txtMarks.text.clear()
    }

    private fun toast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
    }
