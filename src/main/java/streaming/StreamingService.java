package streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamingService {
    private List<Content> contents=new ArrayList<>();

    public void addContent(Content content){
        contents.add(content);
    }
    public List<Content> getContentsSortedByRating(){
        return contents.stream().sorted().toList();
    }
    public List<Content> findByTitle(String title){
        return contents.stream().filter(c->c.getTitle().equals(title)).toList();
    }
    public Map<Genre, Long> countContentByGenre() {
        return contents.stream().collect(Collectors.groupingBy(Content::getGenre,Collectors.counting()));
    }
    public List<Content> getContents() {
        return contents;
    }

}
