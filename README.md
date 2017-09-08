# dolarpy-wrapper-java

API wrapper for DolarPy https://dolar.melizeche.com
https://github.com/melizeche/dolarPy

## Install

```
TODO
```

## Usage
```java
import com.melizeche.dolarpy.DolarPy

DolarPy dolar = new DolarPy();

dolar.getProvidersList() // 'bcp', 'maxicambios', 'cambioschaco', etc...
dolar.get() // Returns a Provider Object. default: BCP
dolar.get("maxicambios") // Returns Provider: maxicambios Object
dolar.get("maxicambios").getVenta() //Returns BigDecimal buy value from cambioschaco
dolar.getCompra() // Returns BigDecimal buy value from defaul Provider(bcp)
dolar.getCompra("cambioschaco") // Returns BigDecimal buy value from cambioschaco
dolar.getVenta("amabay") // Returns BigDecimal sell value from Amambay
dolar.get().getUpdated() // Returns LocalDateTime timestamp
```

## Provider Object properties and methods
```java
    private String name;
    private BigDecimal compra;
    private BigDecimal venta;
    private LocalDateTime updated;

    public String getName();
    public void setName(String name);
    public BigDecimal getCompra();
    public void setCompra(BigDecimal compra);
    public BigDecimal getVenta();
    public void setVenta(BigDecimal venta);
    public LocalDateTime getUpdated();
    public void setUpdated(LocalDateTime updated);
```

## Requirements

- Java 8
- Gson 2.8.1


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
