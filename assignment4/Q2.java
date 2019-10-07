abstract class Q2 {
	protected abstract String getMood();
	protected abstract void expressFeelings();
	// try "I feel " + getMood() + " today!"

	// And also, don't use `==` for String. Use String.equals()
	public void queryMood() {
		// happy
		if (this.getMood() == "happy") {
			System.out.println("I feel happy today!\n");
		}
		// sad
		else {
			System.out.println("I feel sad today!\n");
		}
	}
}
 class SadObject extends Q2 {
	protected String getMood() {
		return "sad";
	}
	public void expressFeelings() {
		System.out.println("'wah' 'boo boo' 'weep' 'sob' 'weep'");
	}
	public String toString() {
		return " Subject cris a lot\n";
	}
}
 
 class HappyObject extends Q2 {

		protected String getMood() {

			return "happy";
		}
		public void expressFeelings() {

			System.out.println("hehehe...hahaha...HAHAHAHAHA!!!");

		}
		public String toString() {

			return " Subject laughs a lot\n";
		}
	}
 
 class PsychiatristObject {

		public void examine(Q2 moodyObject) {

			System.out.println("How are you feeling today?");

			moodyObject.queryMood();
		}
		public void observe(Q2 moodyObject) {

			moodyObject.expressFeelings();

			System.out.printf("Observation:" + moodyObject + "\n");
		}
	}
 
 class Test {

		public static void main(String[] args) {

			PsychiatristObject ZH = new PsychiatristObject();

			Q2 happyObject = new HappyObject();

			Q2 sadObject = new SadObject();

			ZH.examine(happyObject);

			ZH.observe(happyObject);

			ZH.examine(sadObject);

			ZH.observe(sadObject);
		}
	}