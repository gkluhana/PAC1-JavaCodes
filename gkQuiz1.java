public class gkQuiz1{
	public static void main(String [] args){
		String[] words = {"apple","bananas","oranges"};
		double sum=0;
		for(int i=0;i<words.length;i++){
			sum=sum+(words[i].length());
		}
		double average=(float)sum/words.length;
		System.out.println("The average word length is\t"+average);

	}
}