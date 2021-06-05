package HmrsProje.Hmrs.busines.abstracts;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.Membership;


public interface MembershipService {
	DataResult<List<Membership>>getAll();
	Result add(Membership membership);
	DataResult<Membership>getByEmail(String Email);


}
