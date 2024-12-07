// 静态代理类的实现
// 代理类CalculatorProxyImpl中并不会实现Calculator中四种方法的具体业务逻辑
// 业务逻辑的处理写在CalculatorImpl的业务实现类里，代理只负责添加实现业务的上下文附加功能
public class CalculatorStaticProxyImpl implements Calculator {
    private Calculator target;

    public CalculatorStaticProxyImpl(Calculator target) {
        this.target = target;
    }
    @Override
    public int add(int i, int j) {
        // 代理方法实现附加功能
        System.out.println("[日志] add 方法开始了，参数是：" + i + " " + j);
        // 通过目标对象实现业务逻辑
        int addResult = target.add(i, j);
        // 代理方法 附加功能
        System.out.println("[日志] add 方法结束了，结果是：" + addResult);

        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
