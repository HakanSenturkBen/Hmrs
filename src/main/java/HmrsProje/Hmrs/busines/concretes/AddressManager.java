package HmrsProje.Hmrs.busines.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HmrsProje.Hmrs.busines.abstracts.AddressService;
import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.core.utilities.results.SuccessDataResult;
import HmrsProje.Hmrs.core.utilities.results.SuccessResult;
import HmrsProje.Hmrs.dataAccess.abstracts.AddressDao;
import HmrsProje.Hmrs.entity.concretes.Address;

@Service
public class AddressManager implements AddressService {
	AddressDao addressDao;

	@Autowired
	public AddressManager(AddressDao addressDao) {
		super();
		this.addressDao = addressDao;
	}

	@Override
	public DataResult<List<Address>> getAll() {
		return new SuccessDataResult<List<Address>>(addressDao.findAll(),"Listelendi");
	}

	@Override
	public Result add(Address address) {
		addressDao.save(address);
		return new SuccessResult("eklendi");
	}
	

}
