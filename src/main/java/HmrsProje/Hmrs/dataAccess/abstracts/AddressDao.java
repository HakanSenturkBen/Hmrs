package HmrsProje.Hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
