import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ParseMode


fun main() {
    println("- Bot Iniciado -")

    val bot = bot {

        token = Apikey.miToken

        dispatch {

            command("help") {
                val help = """
                    */saludo* | El Bicho te saluda!
                    */champions* | Cantidad de Champions del Bicho
                    */abdominales* | Ay my madre! Abdominales del Bicho
                    */piernas* | La piernas del Bicho?
                    */su* | Te envío un audio especial ;)
                    */encuesta* | Quién es el jugador mas guapo?
                    */novia* | Meme de por que soy mejor que tu novia
                    */bichosexualidad* | Mide tu compatibilidad
                """.trimIndent()
                bot.sendMessage(
                        chatId = ChatId.fromId(message.chat.id),
                        text = help,
                        parseMode = ParseMode.MARKDOWN
                )
            }

            command("saludo") {

                val respuesta_saludo1 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "EL BICHOOOOOOO")
                val respuesta_saludo2 = bot.sendAnimation(chatId = ChatId.fromId(update.message!!.chat.id), "https://media.giphy.com/media/xT1XGVp95GDPgFYmUE/giphy.gif" )

            }

            command("abdominales") {

                val respuesta_abdominales = bot.sendAnimation(chatId = ChatId.fromId(update.message!!.chat.id), "https://i.pinimg.com/originals/63/9f/28/639f282e144c61fc5ff1a4d3482c952e.gif" )

            }

            command("piernas") {

                val respuesta_piernas = bot.sendPhoto(chatId = ChatId.fromId(update.message!!.chat.id), "https://hips.hearstapps.com/dm.h-cdn.co/assets/17/43/980x735/sd-aspect-1509033894-cristiano-1.jpg?resize=480:*" )

            }

            command("encuesta") {

                val respuesta_encuesta = bot.sendPoll(chatId = ChatId.fromId(update.message!!.chat.id), "¿Quién es el jugador más sexy?", listOf("Cristiano Ronaldo","Cristiano Ronaldo","También Cristiano Ronaldo"), isAnonymous = true, type = null, allowsMultipleAnswers = false, correctOptionId = null, isClosed = null, disableNotification = null, replyToMessageId = null, replyMarkup= null)

            }

            command("bichosexualidad") {

                var verificacionBichosexualidad = 1
                val respuesta_bichosexualidad1 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Bienvenido a la calculadora de Bichosexualidad")
                val respuesta_bichosexualidad2 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Aquí veremos que tan grande es tu % de compatibilidad con El Bicho")
                val respuesta_bichosexualidad3 = """
                    *¿Cuantas veces piensas en El Bicho al día?*
                    *A* | Una o ninguna vez al día.
                    *B* | Entre 2 a 5 veces al día.
                    *C* | Sobre 10 veces al día.
                    *D* | Mi vida consiste en pensar en él.
                """.trimIndent()
                bot.sendMessage(
                        chatId = ChatId.fromId(message.chat.id),
                        text = respuesta_bichosexualidad3,
                        parseMode = ParseMode.MARKDOWN
                )
                /*
                text {
                    bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = text)
                }
                 */
            }
        }
    }
    bot.startPolling()
}
