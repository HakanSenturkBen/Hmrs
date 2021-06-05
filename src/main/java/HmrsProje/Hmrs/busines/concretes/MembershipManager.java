package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.MembershipService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.MembershipDao;
import HmrsProje.Hmrs.entity.concretes.Membership;

@Service
public class MembershipManager implements MembershipService{
	
	MembershipDao membershipDao;

	@Autowired
	public MembershipManager(MembershipDao membershipDao) {
		super();
		this.membershipDao = membershipDao;
	}

	@Override
	public DataResult<List<Membership>> getAll() {
		return new SuccessDataResult<List<Membership>>(membershipDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Membership membership) {
		membershipDao.save(membership);
		return new SuccessResult("eklendi");
	}

	@Override
	public DataResult<Membership> getByEmail(String email) {
		return new SuccessDataResult<Membership>(membershipDao.getByEmail(email));
		
		
	}
	

}
