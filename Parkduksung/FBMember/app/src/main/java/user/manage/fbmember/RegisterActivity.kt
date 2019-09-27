package user.manage.fbmember

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val accountManager = AccountManager.getInstance()

        register_inform.setOnClickListener {
            val nextIntent = Intent(this, LoginActivity::class.java)
            accountManager.createUser(
                register_id.text.toString(),
                register_pw.text.toString(),
                register_name.text.toString(),
                object : AccountManager.CallBack {
                    override fun onSuccess(user: FirebaseUser?) {
                        Log.d(TAG, "create : ${user?.email}")
                        Log.d(TAG, "create : ${user?.displayName}")
                        Log.d(TAG, "create : ${user?.uid}")
                        startActivity(nextIntent)
                        finish()
                    }

                    override fun onFailure(message: String) {
                        Log.d(TAG, message)
                    }
                })

        }
        register_back.setOnClickListener {
            val nextIntent = Intent(this, LoginActivity::class.java)
            startActivity(nextIntent)
            finish()
        }
        register_exit.setOnClickListener {
            finish()
        }
    }


    companion object {
        private const val TAG = "RegisterActivity"
    }

}

