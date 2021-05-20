import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.*
import com.github.kotlintelegrambot.entities.dice.DiceEmoji
import com.github.kotlintelegrambot.entities.polls.PollType

fun main() {
    println("- Bot Iniciado -")

    val bot = bot {

        token = Apikey.miToken

        dispatch {

            command("help") {
                val help = """
                    */saludo* | El Bicho te saluda!
                    */vamosadormir* | El bicho te da las buenas noches!
                    */champions* | Cantidad de Champions del Bicho
                    */abdominales* | Ay my madre! Abdominales del Bicho
                    */piernas* | La piernas del Bicho?
                    */encuesta* | Quién es el jugador mas guapo?
                    */novia* | Meme de por que soy mejor que tu novia
                    */bichosexualidad* | Mide tu compatibilidad
                    */conocerCR7* | Te hace un test sobre el BICHOO
                    */penalti* | Tira un penalti como El Bicho
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
            command("vamosadormir") {

                val respuesta_vamosadormir1 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "BOA NOITE")
                val respuesta_vamosadormir2 = bot.sendPhoto(chatId = ChatId.fromId(update.message!!.chat.id), "https://fotografias.antena3.com/clipping/cmsimages02/2016/11/25/E49E040B-096B-4B43-93D8-2B69E2B0DFFF/58.jpg" )

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

                val respuesta_bichosexualidad1 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Bienvenido a la calculadora de Bichosexualidad")
                val respuesta_bichosexualidad2 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Aquí veremos que tan grande es tu % de compatibilidad con El Bicho")

                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿El Bicho o Messi?",
                    options = listOf("Messi", "El Bicho"),
                    correctOptionId = 1,
                    isAnonymous = true
                )

                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿Cuantos balones de Oro tiene el Bicho?",
                    options = listOf("2", "7", "5"),
                    correctOptionId = 2,
                    isAnonymous = true
                )

            }

            command("conocerCR7") {

                val respuesta_bichosexualidad1 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Bienvenido a este pequeño test")
                val respuesta_bichosexualidad2 = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Aquí veremos que tanto conoces al BICHOOO")

                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿Equipo en el que debuto?",
                    options = listOf("United", "Sporting Lisboa", "Madrid"),
                    correctOptionId = 1,
                    isAnonymous = true
                )

                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿Equipo actual?",
                    options = listOf("Juventus", "Madrid", "Chelsea"),
                    correctOptionId = 0,
                    isAnonymous = true
                )


                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿Hijos que tiene?",
                    options = listOf("1", "2", "3"),
                    correctOptionId = 2,
                    isAnonymous = true
                )

            }
            command("penalti") {

                val respuesta_dados = bot.sendDice(chatId = ChatId.fromId(update.message!!.chat.id), DiceEmoji.Football)

            }
        }
    }
    bot.startPolling()
}