package HmrsProje.Hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HmrsProje.Hmrs.entity.concretes.Profession;

public interface ProfessionDao extends JpaRepository<Profession,Integer>{

}
