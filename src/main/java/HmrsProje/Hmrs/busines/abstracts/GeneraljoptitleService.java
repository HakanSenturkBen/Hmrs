package HmrsProje.Hmrs.busines.abstracts;

import java.util.List;

import HmrsProje.Hmrs.core.utilities.results.DataResult;
import HmrsProje.Hmrs.core.utilities.results.Result;
import HmrsProje.Hmrs.entity.concretes.Generaljobtitle;

public interface GeneraljoptitleService {
	DataResult<List<Generaljobtitle>>getAll();
	Result add(Generaljobtitle joptitle);
	DataResult<Generaljobtitle>getByjopTitleName(String jopTitleName);
}
