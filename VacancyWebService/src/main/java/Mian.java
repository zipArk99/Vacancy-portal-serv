import com.app.vacancywebservice.service.impl.VacancyServiceImpl;
import com.app.vacancywebservice.util.HibernateUtil;

public class Mian {

public static void main(String[] args) {
	VacancyServiceImpl impl = new VacancyServiceImpl();
	System.out.println(impl.fetchVacancies());
}
}
