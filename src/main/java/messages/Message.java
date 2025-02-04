package messages;

import java.time.LocalTime;
import java.util.Objects;

public class Message {
    private String sender;
    private LocalTime time;
    private String messageText;

    public Message(String sender, LocalTime time, String messageText) {
        this.sender = sender;
        this.time = time;
        this.messageText = messageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(sender, message.sender) && Objects.equals(time, message.time) && Objects.equals(messageText, message.messageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, time, messageText);
    }

    public String getSender() {
        return sender;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getMessageText() {
        return messageText;
    }
}
