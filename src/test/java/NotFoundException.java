public class NotFoundException extends RuntimeException{
    private String message;
    public NotFoundException(String phrase) {
        message = String.format("[ERROR]-NotFoundException\tФраза '%s' не была найдена", phrase);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
