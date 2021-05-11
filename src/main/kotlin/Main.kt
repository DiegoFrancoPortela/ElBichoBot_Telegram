import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.network.fold

class Main {

    fun main(args: Array<String>) {
        val bot = bot{
            token = Apikey.miToken

            dispatch {
                command("start") {
                    val result = bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Hi there!")
                    result.fold({
                        // do something here with the response
                    },{
                        // do something with the error
                    })
                }
            }
        }
        bot.startPolling()
    }
}
