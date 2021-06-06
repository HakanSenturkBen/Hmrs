package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.UserService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.UserDao;
import HmrsProje.Hmrs.entity.concretes.User;

@Service
public class UserManager implements UserService{
	UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(userDao.findAll(),"Listelendi");
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<User> getByPersonId(int personId) {
		return new SuccessDataResult<User>(userDao.getByid(personId));
		
	}
	

}
