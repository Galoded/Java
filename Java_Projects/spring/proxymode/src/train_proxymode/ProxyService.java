package train_proxymode;

public class ProxyService implements IStudentService {

	private IStudentService stu;

	public void setStu(IStudentService stu) {
		this.stu = stu;
	}

	@Override
	public void goClass() {
		System.out.println("---微积分很难，你代我去---");
		stu.goClass();
	}
}
