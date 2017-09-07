
import com.melizeche.dolarpy.core.DolarPy;
import com.melizeche.dolarpy.core.Provider;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Marcelo Elizeche Landó <melizeche@gmail.com>
 */
public class RunTest {

    public static void main(String[] args) {

        DolarPy dolar = new DolarPy();

//        System.out.println(dolar.getRaw());
//        System.out.println(dolar.getProviders());
//        System.out.println("DDDDD");
//        System.out.println(dolar.get("amambay"));
//        System.out.println(dolar.get());
//        List<Provider> all = dolar.getAll();
//        System.out.println(all.get(0));
        HashMap all = dolar.getAll();
        System.out.println(all);
        System.out.println(all.getClass());
        System.out.println(all.get("bcp"));
        System.out.println(dolar.getProvidersList());
    }
}
