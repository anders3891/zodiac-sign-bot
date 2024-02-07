package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ZodiacSignBot extends TelegramLongPollingBot {
    public ZodiacSignBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);

        if (!update.hasMessage()) {
            return;
        }
        Message message = update.getMessage();
        if (!message.hasText()){
            return;
        }
        String text = message.getText();
        if ("/start".equals(text)){
            SendMessage sendMessage = SendMessage.builder()
                    .text("Введите дату в формате ДД.ММ для определения знака зодиака")
                    .chatId(message.getChatId())
                    .build();
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        if (text.matches("\\d{2}\\.\\d{2}")) {
            int day = Integer.parseInt(text.substring(0, text.indexOf('.')));
            int month = Integer.parseInt(text.substring(text.indexOf('.') + 1));
            System.out.println("Знак зодиака:" + " " + ZodiacUtils.getSignName(day, month));
            SendMessage sendMessage = SendMessage.builder()
                    .text("Знак зодиака:" + "" + ZodiacUtils.getSignName(day, month))
                    .chatId(message.getChatId())
                    .build();
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else {
            SendMessage sendMessage = SendMessage.builder()
                    .text("Введите дату в формате ДД.ММ для определения знака зодиака")
                    .chatId(message.getChatId())
                    .build();
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }

    }




    @Override
    public String getBotUsername() {
        return "test_telegram1_stepik_bot";
    }
}
