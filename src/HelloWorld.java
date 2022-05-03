import java.io.IOException;

public class HelloWorld {
	public static void main(String[] args) throws IOException {
		Display display = new Display("Toca musica", 1280, 720);
		ScreenManager sm = new ScreenManager(display);
	}
}
