package com.example.testing_day1.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testing_day1.data.Task
import com.example.testing_day1.data.source.local.ToDoDatabase
import com.example.testing_day1.data.source.local.TasksDao
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
class TasksDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ToDoDatabase
    private lateinit var taskDao: TasksDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ToDoDatabase::class.java
        ).allowMainThreadQueries()
            .build()

        taskDao = database.taskDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun getTaskByID_task1_returnsSameTask() = runTest {

        val task = Task(id = "1", title = "Test Task")

        taskDao.insertTask(task)

        val result = taskDao.getTaskById(task.id)

        assertThat(result, notNullValue())
        assertThat(result?.title, `is`(task.title))
    }

    @Test
    fun updateTask_AndGetById() = runTest {

        val initialTask = Task(id = "1", title = "Initial Task", description = "Initial Description")
        taskDao.insertTask(initialTask)

        val updatedTask = Task(id = initialTask.id, title = "Updated Task", description = "Updated Description")

        val rowsUpdated = taskDao.updateTask(updatedTask)

        val result = taskDao.getTaskById(initialTask.id)

        assertThat(rowsUpdated, `is`(1))
        assertThat(result, notNullValue())
        assertThat(result?.title, `is`("Updated Task"))
        assertThat(result?.description, `is`("Updated Description"))
    }

}
