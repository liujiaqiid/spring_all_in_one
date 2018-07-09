package hello.cache;

@SuppressWarnings("unused")
public interface BookRepository {

    Book getByIsbn(String isbn);

}
