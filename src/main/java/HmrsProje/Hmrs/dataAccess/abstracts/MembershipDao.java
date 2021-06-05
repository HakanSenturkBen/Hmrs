package HmrsProje.Hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.Membership;

public interface MembershipDao extends JpaRepository<Membership,Integer> {
	
	Membership getByEmail(String email);

}
