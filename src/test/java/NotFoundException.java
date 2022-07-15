
import java.time.LocalDateTime;

public class NotFoundException extends RuntimeException{
    private String message;
    private LocalDateTime timeThrown;
    public NotFoundException(String phrase) {
        message = String.format("[ERROR]-NotFoundException\tФраза '%s' не была найдена", phrase);
        timeThrown = LocalDateTime.now();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeThrown(){
        return timeThrown;
    }
}
