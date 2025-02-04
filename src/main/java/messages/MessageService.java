package messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MessageService {
    List<Message> messages=new ArrayList<>();
    public void readFromFile(Path path) {
        try(BufferedReader reader= Files.newBufferedReader(path)){
            String line;
            while((line =reader.readLine())!=null){
                List<String> lines=List.of(line,reader.readLine());
                reader.readLine();
                messages.add(messageFromBlock(lines));
            }

        }catch(IOException ioe){
            throw new IllegalArgumentException("File not found! "+path);
        }
    }

    private Message messageFromBlock(List<String> lines) {
        String[] words=lines.get(0).split(" ");
        return new Message(words[0], LocalTime.parse(words[1]),lines.get(1));
    }

    public List<Message> getMessages() {
        return messages;
    }

    public boolean isMessagesInOrder() {
        if(messages.size()<2){
            return true;
        }
        return messages.equals(messages.stream().sorted(Comparator.comparing(Message::getTime)).toList());
    }
}
