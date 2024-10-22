import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testing_day1.data.Task
import com.example.testing_day1.data.Result.Success
import com.example.testing_day1.data.source.local.TasksDao
import com.example.testing_day1.data.source.local.TasksLocalDataSource
import com.example.testing_day1.data.source.local.ToDoDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class TasksLocalDataSourceTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ToDoDatabase
    private lateinit var tasksDao: TasksDao
    private lateinit var tasksLocalDataSource: TasksLocalDataSource

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ToDoDatabase::class.java
        ).allowMainThreadQueries()
            .build()

        tasksDao = database.taskDao()

        tasksLocalDataSource = TasksLocalDataSource(tasksDao)
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveTask_retrievesTask() = runTest {

        val task = Task(id = "1", title = "Test Task", description = "Test Description")

        tasksLocalDataSource.saveTask(task)

        val result = tasksLocalDataSource.getTask(task.id)

        val retrievedTask = (result as Success).data

        assertThat(result, `is`(Success(task)))
        assertThat(retrievedTask.id, `is`("1"))
        assertThat(retrievedTask.title, `is`("Test Task"))
        assertThat(retrievedTask.description, `is`("Test Description"))
    }

    @Test
    fun completeTask_retrievedTask() = runTest {

        val task = Task(id = "2", title = "Test Task", description = "Test Description")
        tasksLocalDataSource.saveTask(task)

        tasksLocalDataSource.completeTask(task)

        val result = tasksLocalDataSource.getTask(task.id)
        val retrievedTask = (result as Success).data

        assertThat(result, notNullValue())
        assertThat(retrievedTask.id, `is`("2"))
        assertThat(retrievedTask.isCompleted, `is`(true))
    }
}
