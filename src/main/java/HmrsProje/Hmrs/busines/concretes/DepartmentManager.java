package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.DepartmentService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.DepartmentDao;
import HmrsProje.Hmrs.entity.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService{
	
	private DepartmentDao departmentDao;
	
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(departmentDao.findAll(),"Data listelendi");
		
	}

	@Override
	public Result add(Department department) {
		departmentDao.save(department);
		return new SuccessResult("eklendi");
	}

}
