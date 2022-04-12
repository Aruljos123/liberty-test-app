package liberty_test_app.liberty.test.app;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Hello world!
 *
 */
@ApplicationPath("resttest")
public class App extends Application
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
