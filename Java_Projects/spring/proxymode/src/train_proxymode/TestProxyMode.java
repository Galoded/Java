package train_proxymode;

public class TestProxyMode {

	public static void main(String[] args) {
		IStudentService stu = new StudentService();
		ProxyService proxy = new ProxyService();
		proxy.setStu(stu);
		proxy.goClass();
	}
}
