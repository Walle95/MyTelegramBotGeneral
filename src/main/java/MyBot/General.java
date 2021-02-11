package MyBot;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Dice;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import java.util.ArrayList;
import java.util.List;

public class General extends TelegramWebhookBot {
    private static final String TOKEN = "1206500522:AAHjmvs96b1O-F9r53P2cNlzPKrncUWE_dM";
    private static final String USERNAME = "education69_bot";

    Emodji emodji = new Emodji();
    TextManager textManager = new TextManager();

    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();


            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText(textManager.text7);
                SendPhoto sendPhoto = new SendPhoto().setChatId(chat_id);
                try {
                    sendPhoto.setPhoto("https://i.pinimg.com/736x/37/78/c3/3778c399e77ebe77f309b8bdf7be4e05.jpg");
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

                // Создаем клавиатуру
                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                //Меняем размер кнопок
                keyboardMarkup.setResizeKeyboard(true);
                // Создаем массив кнопок
                List<KeyboardRow> keyboard = new ArrayList<>();

                // Create a keyboard row
                KeyboardRow row = new KeyboardRow();

                //ассортимент
                row.add(textManager.text6);
               // Add the first row to the keyboard
                keyboard.add(row);

                //условия доставки
                row = new KeyboardRow();
                row.add(textManager.text2);
                keyboard.add(row);

                //связаться с нами
                row = new KeyboardRow();
                row.add(textManager.text1);
                keyboard.add(row);

                // Set the keyboard to the markup
                keyboardMarkup.setKeyboard(keyboard);
                // Add it to the message
                message.setReplyMarkup(keyboardMarkup);

                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (message_text.equals(textManager.text1))
            {
                    SendMessage message2 = new SendMessage().setChatId(chat_id).setText(textManager.text4 + "\n\n"
                            + emodji.emodjiPhone + "Phone:" + " 8-913-763-24-84" + "\n"
                            + emodji.emodjiEmail + "Email:" + " valentinshabanov95@gmail.com");
                try {
                    execute(message2); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (message_text.equals(textManager.text2))
            {
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(textManager.text5);
                try {
                    execute(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public BotApiMethod onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public String getBotPath() {
        return  "https://50a4f96ef531.ngrok.io";
    }
}
