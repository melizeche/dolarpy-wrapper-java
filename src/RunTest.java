import com.melizeche.dolarpy.core.Provider;
import com.melizeche.dolarpy.core.ProviderRef;
import com.melizeche.dolarpy.core.Main;

import java.math.BigDecimal;



/**
 *
 * @author Marcelo Elizeche Landó <melizeche@gmail.com>
 */
public class RunTest {

    public static void main(String[] args) {

        Main dolar = new Main();
        
      
        System.out.println(dolar.getRaw());
          System.out.println(dolar.getProviders());
        System.out.println("DDDDD");
    }
}
