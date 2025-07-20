import android.content.Context
import com.example.teste.entity.PostEntity
import com.example.teste.service.listener.APIListener
import com.example.teste.service.repository.BaseRepository
import com.example.teste.service.repository.remote.PostService
import com.example.teste.service.repository.remote.RetrofitClient

class PostsRepository(context: Context) : BaseRepository(context) {

    private val remote = RetrofitClient.getService(PostService::class.java)

    fun list (listener: APIListener<List<PostEntity>>) {
        executeCall(remote.listCall(), listener)
    }

}