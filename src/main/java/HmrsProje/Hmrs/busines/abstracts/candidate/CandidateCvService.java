package HmrsProje.Hmrs.busines.abstracts.candidate;



import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.candidate.CandidateCv;
import HmrsProje.Hmrs.entity.dtos.CvDto;

public interface CandidateCvService {
	DataResult<CandidateCv>getByCandideId(int id);
	CvDto getFullCvById(int id);
	Result add(CandidateCv workPlace);
}
