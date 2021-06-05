package HmrsProje.Hmrs.core.utilities.business;

import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import HmrsProje.Hmrs.core.utilities.results.Result;

import HmrsProje.Hmrs.entity.concretes.User;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class BusinessRules {
	public  static Result run(Result...logics) {
		for (var logic : logics) {
			if(!logic.isSuccess()) return logic; 
		}
		return null;
	}
	public static boolean isCitizenshipIdentity(String number, User user,int bornedYear) {
		
		long tcno=Long.parseLong(number);
		String ad=user.getFirstName().toUpperCase();
		String soyad=user.getSurName().toUpperCase();
		KPSPublicSoapProxy dogrula = new KPSPublicSoapProxy();
		try {
			return dogrula.TCKimlikNoDogrula(tcno, ad, soyad, bornedYear);
		} catch (RemoteException e) {
			return false;
		}
	}
	
	public static boolean isEmail(String email) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(email); 
		 
		 return  matcher.matches();
	}

}
