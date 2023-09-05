package pl.sebastianklimas.apigithub.exceptions;

public class CustomExceptionBody {
    private int status;
    private String message;

    public CustomExceptionBody() {
    }

    public CustomExceptionBody(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
