package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountryData {

	ArrayList<Country> countries;
	ArrayList<Country> countriesSortedBubble;

	public CountryData(){
		countriesSortedBubble = new ArrayList<>();
		countries = new ArrayList<>();
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	public ArrayList<Country> getCountriesSortedBubble() {
		return countriesSortedBubble;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}

	public void printDataMale() {

		for(Country c: countries) {
			System.out.println(c.toStringMale());
		}

	}
	public void printDataFemale() {
		for(Country c : countries) {
			System.out.println(c.toStringFemale());
		}
	}

	public void compareCountry () {

		Comparator<Country> comparator = (o1,o2)->{
			int a = o1.getMaleGold()-o2.getMaleGold();
			if(a==0) {
				int b = o1.getMaleSilver() - o2.getMaleSilver();
				if(b==0) {
					int c = o1.getMaleSilver()- o2.getMaleSilver();
					if(c==0){
						return o1.getName().compareTo(o2.getName());

					}return -c;

				} else return -b;
			}else return -a;

		};
		Collections.sort(countries,comparator);
	}
	
	public void compareCountryLower () {

		Comparator<Country> comparator = (o1,o2)->{
			int a= o2.getFemaleGold()-o1.getFemaleGold();
			if(a==0) {
				int b = o2.getFemaleSilver() - o1.getFemaleSilver();
				if(b==0) {
					int c = o2.getFemaleBronze()- o1.getFemaleBronze();
					if(c==0){
						return o1.getName().compareTo(o2.getName());

					}
					return -c;

				} 
				else {
					return -b;
				}
			}
			else {
				return -a;
			}

		};
		Collections.sort(countries,comparator);
	}

	public void sortWithBubble(){


		for(int i=0;i<countries.size();i++){
			String name = countries.get(i).getName();
			int maleGold = countries.get(i).getMaleGold();
			int maleSilver= countries.get(i).getMaleSilver();
			int maleBronze= countries.get(i).getMaleBronze();
			int femaleGold= countries.get(i).getFemaleGold();
			int femaleSilver= countries.get(i).getFemaleSilver();
			int femaleBronze= countries.get(i).getFemaleBronze();
			Country country = new Country(name,maleGold+femaleGold,maleSilver+femaleSilver,maleBronze+femaleBronze);
			countriesSortedBubble.add(country);
		}


		for(int i=0; i<countriesSortedBubble.size(); i++){

			for(int j=i + 1; j<countriesSortedBubble.size(); j++){

				if((countriesSortedBubble.get(i).getTotalGold() - countriesSortedBubble.get(j).getTotalGold())<0){
					Country temp = countriesSortedBubble.get(i);
					countriesSortedBubble.set(i,countriesSortedBubble.get(j));
					countriesSortedBubble.set(j,temp);
				}else if((countriesSortedBubble.get(i).getTotalGold() - countriesSortedBubble.get(j).getTotalGold())==0){

					if((countriesSortedBubble.get(i).getTotalSilver()-countriesSortedBubble.get(j).getTotalSilver())<0){
						Country temp1 = countriesSortedBubble.get(i);
						countriesSortedBubble.set(i,countriesSortedBubble.get(j));
						countriesSortedBubble.set(j,temp1);
					}else if((countriesSortedBubble.get(i).getTotalSilver()-countriesSortedBubble.get(j).getTotalSilver())==0){
						if((countriesSortedBubble.get(i).getTotalBronze()-countriesSortedBubble.get(j).getFemaleBronze())<0){
							Country temp2 = countriesSortedBubble.get(i);
							countriesSortedBubble.set(i,countriesSortedBubble.get(j));
							countriesSortedBubble.set(j,temp2);
						}else if((countriesSortedBubble.get(i).getTotalBronze()-countriesSortedBubble.get(j).getFemaleBronze())==0){

							if((countriesSortedBubble.get(i).getName().compareTo(countriesSortedBubble.get(j).getName()))<0){
								Country temp3 = countriesSortedBubble.get(i);
								countriesSortedBubble.set(i,countriesSortedBubble.get(j));
								countriesSortedBubble.set(j,temp3);

							}

						}

					}

				}
			}

		}

		for(Country country : countriesSortedBubble){
			System.out.println(country.toStringTotal());
		}
	}

	public void sortWithInsertion(){

		for(int a=1;a<countriesSortedBubble.size();a++){
			for(int b=0;b<a;b++){
				Country vA = countriesSortedBubble.get(a);
				Country vB = countriesSortedBubble.get(b);
				if(vA.getTotalGold()>vB.getTotalGold()){
					countriesSortedBubble.remove(a);
					countriesSortedBubble.add(b,vA);
				}else if((vA.getTotalGold()- vB.getTotalGold())==0){

					if(vA.getTotalSilver()>vB.getTotalSilver()){
						countriesSortedBubble.remove(a);
						countriesSortedBubble.add(b,vA);

					}else if((vA.getTotalSilver()- vB.getTotalSilver())==0){

						if((vA.getTotalBronze()> vB.getTotalBronze())){

							countriesSortedBubble.remove(a);
							countriesSortedBubble.add(b,vA);

						}else if((vA.getName().compareTo(vB.getName()))<0){

							countriesSortedBubble.remove(a);
							countriesSortedBubble.add(b,vA);

						}

					}

				}

			}
		}
		for(Country country : countriesSortedBubble){
			System.out.println(country.toStringTotal());
		}
	}

}