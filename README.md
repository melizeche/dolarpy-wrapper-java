# dolarpy-wrapper-java

API wrapper for DolarPy https://dolar.melizeche.com
https://github.com/melizeche/dolarPy

## Install

```
TODO
```

## Usage
```java
import com.melizeche.dolarpy.core.DolarPy

getProvidersList() // 'bcp', 'maxicambios', 'cambioschaco', etc...
get() // Returns a Provider Object. default: BCP
get("maxicambios") // Returns Provider: maxicambios Object
getCompra() // Returns BigDecimal buy value from defaul Provider(bcp)
getCompra("cambioschaco") // Returns BigDecimal buy value from cambioschaco

```

## Requirements

- Java 8
- Gson


## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :D

## TODO

* Testing
* ~~Proper~~ Extend documentation
* More API methods

## Credits

* Marcelo Elizeche Landó

## License

This project is licensed under the terms of the Apache 2.0 License - see the [LICENSE](LICENSE) file for details
