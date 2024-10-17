package study.javapractices;//  Practice
//  다음 클래스 직접 만든 후 객체 생성
//  클래스명: Animal
//  특성: 이름, 무게, 분류
//  기능: 먹기, 잠자기, 걷기, 뛰기

class animal {
    String name;
    Double weight;
    String classification;

    animal(String name, Double weight, String classification) {
        this.name = name;
        this.weight = weight;
        this.classification = classification;
    }

    public void printInfo() {
        System.out.println("name = " + name);
        System.out.println("weight = " + weight);
        System.out.println("classification = " + classification);
    }

    public void eat() {
        System.out.println("냠냠!");
    }

    public void sleep() {
        System.out.println("쿨쿨!");
    }

    public void walk() {
        System.out.println("걷기!");
    }

    public void run() {
        System.out.println("뛰기!");
    }
}


public class 클래스객체2 {
    public static void main(String[] args) {
        // Test code
        Animal animal1 = new Animal("강아지", 5.0, "포유류");
        Animal animal2 = new Animal("구피", 0.01, "어류");

        animal1.printInfo();
        animal2.printInfo();
    }
}


public class Class3 {
		public static void main(String[] args) {

			animal animal3 = new animal("강아지", 5.0, "포유류");
			animal animal4 = new animal("구피", 0.01, "어류");

			animal3.printInfo();
			animal4.printInfo();
		}
	}


	public class Class4 {
		public static void main(String[] args) {

			String name = "강아지";
			Double weight = 5.0;
			String classification = "포유류";

			animal animal5 = new animal(name, weight, classification);

			animal5.printInfo();
		}
	}