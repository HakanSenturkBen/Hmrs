package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.AddressService;
import HmrsProje.Hmrs.busines.abstracts.EmployerService;
import HmrsProje.Hmrs.busines.abstracts.MembershipService;
import HmrsProje.Hmrs.busines.abstracts.UserService;
import HmrsProje.Hmrs.core.utilities.business.BusinessRules;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.ErrorResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.EmployerDao;
import HmrsProje.Hmrs.entity.concretes.Address;
import HmrsProje.Hmrs.entity.concretes.Employer;
import HmrsProje.Hmrs.entity.concretes.Membership;
import HmrsProje.Hmrs.entity.concretes.User;
import HmrsProje.Hmrs.entity.dtos.EmployerDto;

@Service
public class EmployerManager implements EmployerService {
	EmployerDao employerDao;
	
	AddressService addressService;
	MembershipService membershipService;
	UserService userService;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	public EmployerManager(EmployerDao employerDao, AddressService addressService,
			MembershipService membershipService,UserService userService) {
		super();
		this.employerDao = employerDao;
		this.addressService = addressService;
		this.membershipService = membershipService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(EmployerDto employerDto) {
		Address address= new Address(0,employerDto.getStreetName(),employerDto.getDistrictName(),employerDto.getCityName(),employerDto.getCountryName());
		Membership membership=new Membership(0,employerDto.getEmail(),employerDto.getPassword(),employerDto.getPasswordAgain());
		User user= new User(0,employerDto.getFirstName(),employerDto.getSurName());
		
		var result= BusinessRules.run(userId(user),
				  membershipId(membership),
				  addAddressId(address),
				  isEmail(membership.getEmail()));
		
		if (result!=null) {
			return result;
		}
		
		Employer employer=new Employer(0,user.getId(),
								membership.getId(),
								address.getId(),
								employerDto.getCompanyName(),
								employerDto.getDomainName(),
								employerDto.getEmailSameDomain(),
								employerDto.getTaxNumber(),
								employerDto.getTaxOffice());
		employerDao.save(employer);
		return new SuccessResult("Eklendi");
	}
	
	Result isEmail(String email) {
		var registerResult=membershipService.getByEmail(email);
		if(registerResult!=null) return new ErrorResult("Email adresi sistemde kayıtlı");
		if(BusinessRules.isEmail(email)) return new ErrorResult("geçersiz email adresi");
		return null;
	}
	
	
	Result userId (User user) {
		userService.add(user);
		return new SuccessResult(user.getId()+"");
	}
	
	Result membershipId (Membership membership) {
		if(membership.getPassword().compareTo(membership.getPasswordAgain())==0) {
			membershipService.add(membership);
			 return new SuccessResult(membership.getId()+"");	
		}
		return new ErrorResult("Parola tekrarı hatalı");
	}
	
	Result addAddressId (Address address) {
		 addressService.add(address);
		 return new SuccessResult(address.getId()+"");
	}

	@Override
	public DataResult<Employer> getBycompanyName(String name) {
		return new SuccessDataResult<Employer>(employerDao.getBycompanyName(name));
	}

}
