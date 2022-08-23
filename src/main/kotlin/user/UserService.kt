package user

import Di


open class UserService {

    @field:Di var userRepository: UserRepository? = null

    constructor()

    fun printHello() {
        println("Hello ${this}")
    }
}