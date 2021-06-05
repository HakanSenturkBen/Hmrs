package HmrsProje.Hmrs.busines.abstracts;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.User;


public interface UserService {
	DataResult<List<User>>getAll();
	Result add(User user);

}
