import java.util.Scanner;
 class StudentCalculator{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of subject");
		int subnumber=scanner. nextInt();
		int[]marks=new int[subnumber];
		int totalmarks=0;
		for(int i=0;i<subnumber;i++){
			System.out.println("Enter the marks of each subject"+(i+1)+"(out of 100)");
			marks[i]=scanner.nextInt();
			totalmarks+=marks[i];
		}
		double averagePercentage=(double)totalmarks/subnumber;
		String grade;
		if(averagePercentage>=90){
			grade="A";
		}
		else if(averagePercentage>=80){
			grade="A";
		}else if(averagePercentage>=70){
			grade="B";
		}else if(averagePercentage>=60){
			grade="C";
		}else if(averagePercentage>=50){
			grade="D";
		}else{
			grade="F";
		}
		System.out.println("Result");
		System.out.println("Total marks:"+totalmarks);
		System.out.println("Average percentage:"+averagePercentage+"%");
		System.out.println("Grade:"+grade);
		scanner.close();
		
		}
}