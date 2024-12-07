import org.junit.jupiter.api.Test;

public class TestCalculator {
    int a = 16;
    int b = 25;


    @Test
    public void testCalculatorImpl() {
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.add(a, b));
        System.out.println(calculator.sub(a, b));
        System.out.println(calculator.mul(a, b));
        System.out.println(calculator.div(a, b));
    }

    @Test
    public void testCalculatorLogImpl() {
        Calculator calculator = new CalculatorLogImpl();
        System.out.println(calculator.add(a, b));
        System.out.println(calculator.sub(a, b));
        System.out.println(calculator.mul(a, b));
        System.out.println(calculator.div(a, b));
    }

    @Test
    public void testCalculatorProxyImpl() {
        Calculator calculator = new CalculatorImpl();
        Calculator calculatorProxy = new CalculatorStaticProxyImpl(calculator);
        calculatorProxy.add(a, b);
    }

    @Test
    public void testProxyFactory() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(a, b);
    }
}
