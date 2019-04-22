package train_proxymode;

public class StudentService implements IStudentService {

	@Override
	public void goClass() {
		System.out.println("---去上微积分课程---");
	}
}
