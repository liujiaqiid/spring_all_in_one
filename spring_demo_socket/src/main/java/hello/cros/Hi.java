package hello.cros;


@SuppressWarnings("unused")
public class Hi {

    private final long id;
    private final String content;

    public Hi() {
        this.id = -1;
        this.content = "";
    }

    public Hi(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
