package HmrsProje.Hmrs.busines.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.AddressService;
import HmrsProje.Hmrs.busines.abstracts.EmployeeCandidateService;
import HmrsProje.Hmrs.busines.abstracts.MembershipService;
import HmrsProje.Hmrs.busines.abstracts.PhoneService;
import HmrsProje.Hmrs.busines.abstracts.ProfessionService;
import HmrsProje.Hmrs.busines.abstracts.UserService;
import HmrsProje.Hmrs.core.utilities.business.BusinessRules;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.ErrorResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.EmployeeCandidateDao;
import HmrsProje.Hmrs.entity.concretes.Address;
import HmrsProje.Hmrs.entity.concretes.EmployeeCandidate;
import HmrsProje.Hmrs.entity.concretes.Membership;
import HmrsProje.Hmrs.entity.concretes.Phone;
import HmrsProje.Hmrs.entity.concretes.Profession;
import HmrsProje.Hmrs.entity.concretes.User;
import HmrsProje.Hmrs.entity.dtos.EmployeeCandidateDto;

@Service
public class EmployeeCandidateManager implements EmployeeCandidateService{
	EmployeeCandidateDao employeeCandidateDao;
	AddressService addressService;
	MembershipService membershipService;
	PhoneService phoneService;
	ProfessionService professionService;
	UserService userService;

	@Autowired
	public EmployeeCandidateManager(EmployeeCandidateDao employeeCandidateDao) {
		super();
		this.employeeCandidateDao = employeeCandidateDao;
	}

	public EmployeeCandidateManager(EmployeeCandidateDao employeeCandidateDao, AddressService addressService,
			MembershipService membershipService, PhoneService phoneService, ProfessionService professionService,
			UserService userService) {
		super();
		this.employeeCandidateDao = employeeCandidateDao;
		this.addressService = addressService;
		this.membershipService = membershipService;
		this.phoneService = phoneService;
		this.professionService = professionService;
		this.userService = userService;
	}

	@Override
	public DataResult<List<EmployeeCandidate>> getAll() {
		
		return new SuccessDataResult<List<EmployeeCandidate>>(employeeCandidateDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(EmployeeCandidateDto employeeCandidate) {
		Address address= new Address(0,employeeCandidate.getStreetName(),employeeCandidate.getDistrictName(),employeeCandidate.getCityName(),employeeCandidate.getCountryName());
		Membership membership=new Membership(0,employeeCandidate.getEmail(),employeeCandidate.getPassword(),employeeCandidate.getPasswordAgain());
		Phone phone=new Phone(0,employeeCandidate.getPhoneType(),employeeCandidate.getPhoneNumber());
		Profession profession= new Profession(0,employeeCandidate.getProfessionName());
		User user= new User(0,employeeCandidate.getFirstName(),employeeCandidate.getSurName());
		
		var result= BusinessRules.run(userId(user),
									  professionId(profession),
									  membershipId(membership),
									  phoneId(phone),
									  addAddressId(address),
									  isCitizenshipNumber(employeeCandidate.getCitizenshipIdentity(),user,employeeCandidate.getBornedYear()),
									  isEmail(membership.getEmail()));
		if (result!=null) {
			return result;
		}
		
		EmployeeCandidate candidate=new EmployeeCandidate(0,user.getId(),
														membership.getId(),
														profession.getId(),
														address.getId(),
														phone.getId(),
														employeeCandidate.
														getCitizenshipIdentity(),
														employeeCandidate.getBornedYear());
		
		employeeCandidateDao.save(candidate);
		
		return new SuccessResult("Eklendi");
		
	}
	Result isCitizenshipNumber(String citizenshipNumber, User user, int bornedYear ) {
		var citizenResult=employeeCandidateDao.getBycitizenshipIdentity(citizenshipNumber);
		if(citizenResult!=null) return new ErrorResult("vatandaşlık numarası sistemda kayıtlı");
		var isValid=BusinessRules.isCitizenshipIdentity(citizenshipNumber, user,bornedYear);
		if(!isValid)return new ErrorResult("vatandaşlık numarası doğrulanamadı");
		return null;
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
	
	Result professionId (Profession profession) {
		professionService.add(profession);
		return new SuccessResult(profession.getId()+"");
	}
	
	Result membershipId (Membership membership) {
		if(membership.getPassword().compareTo(membership.getPasswordAgain())==0) {
			membershipService.add(membership);
			 return new SuccessResult(membership.getId()+"");	
		}
		return new ErrorResult("Parola tekrarı hatalı");
	}
	
	Result phoneId (Phone phone) {
		phoneService.add(phone);
		return new SuccessResult(phone.getId()+"");
	}
	
	Result addAddressId (Address address) {
		 addressService.add(address);
		 return new SuccessResult(address.getId()+"");
	}

	@Override
	public DataResult<EmployeeCandidate> getById(int id) {
		return new SuccessDataResult<EmployeeCandidate>(employeeCandidateDao.getByid(id));
	}
	
	
	
}
	