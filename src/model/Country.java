package model;

public class Country implements Comparable<Country> {
	
	
	String name; 
	int maleGold;
	int maleSilver;
	int maleBronze;
	int femaleGold;
	int femaleSilver;
	int femaleBronze;
	int totalGold;
	int totalSilver;
	int totalBronze;
	
	
	public Country(String name, int maleGold, int maleSilver, int maleBronze, int femaleGold, int femaleSilver,int femaleBronze) {

		this.name = name;
		this.maleGold = maleGold;
		this.maleSilver = maleSilver;
		this.maleBronze = maleBronze;
		this.femaleGold = femaleGold;
		this.femaleSilver = femaleSilver;
		this.femaleBronze = femaleBronze;
	}

	public Country(String name,int totalGold,int totalSilver,int totalBronze){
		this.name = name;
		this.totalBronze = totalBronze;
		this.totalGold = totalGold;
		this.totalSilver = totalSilver;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMaleGold() {
		return maleGold;
	}


	public void setMaleGold(int maleGold) {
		this.maleGold = maleGold;
	}


	public int getMaleSilver() {
		return maleSilver;
	}


	public void setMaleSilver(int maleSilver) {
		this.maleSilver = maleSilver;
	}


	public int getMaleBronze() {
		return maleBronze;
	}


	public void setMaleBronze(int maleBronze) {
		this.maleBronze = maleBronze;
	}


	public int getFemaleGold() {
		return femaleGold;
	}


	public void setFemaleGold(int femaleGold) {
		this.femaleGold = femaleGold;
	}


	public int getFemaleSilver() {
		return femaleSilver;
	}


	public void setFemaleSilver(int femaleSilver) {
		this.femaleSilver = femaleSilver;
	}


	public int getFemaleBronze() {
		return femaleBronze;
	}


	public void setFemaleBronze(int femaleBronze) {
		this.femaleBronze = femaleBronze;
	}
	
	public String toStringMale() {	
		String i;
		i= "Name: " +name + "---> GoldMale: " +maleGold +" SilverMale: " + maleSilver +" BronzeMale: " + maleBronze;  
		return i;
	}
	
	public String toStringFemale() {
		
		String i;
		i= "Name: " +name +  "---> GoldFemale: " +femaleGold +" SilverFemale: " + femaleSilver +" BronzeFemale: " + femaleBronze;  
		return i;
	}

	public String toStringTotal(){
		String i;
		i= "Name: " +name +  "---> Gold: " +totalGold +" Silver: " + totalSilver +" Bronze: " + totalBronze;
		return i;

	}

	public int getTotalGold() {
		return totalGold;
	}

	public int getTotalSilver() {
		return totalSilver;
	}

	public int getTotalBronze() {
		return totalBronze;
	}

	@Override
	public int compareTo(Country obj) {
		int a = this.femaleGold - obj.femaleGold;
		if(a==0) {
			int b= this.femaleSilver - obj.femaleSilver;
			if(b==0) {
				int c = this.femaleBronze - obj.femaleBronze;
				if(c==0){
					return this.name.compareTo(obj.getName());

				}return -c;

			}else return -b;
		}else return -a;
		
	}

}
