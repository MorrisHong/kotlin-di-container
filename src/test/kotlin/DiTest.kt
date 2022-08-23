import org.junit.jupiter.api.Test
import user.UserService
import kotlin.test.assertNotNull

class DiTest {

    @Test
    fun `메롱`() {
        val userService = DiService.getObject(UserService::class.java)
//        userService.printHello()
//        userService.userRepository?.printHello()
        assertNotNull(userService)
        assertNotNull(userService.userRepository)
        userService.printHello()
        userService.userRepository!!.printHello()
    }
}