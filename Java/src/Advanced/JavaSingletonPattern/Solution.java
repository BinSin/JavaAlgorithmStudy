package Advanced.JavaSingletonPattern;


class Solution {
	
    private static Solution instance = new Solution();
    
    public static String str = null;
    
    private Solution() {
    }
    
    public static Solution getSingleInstance() {
        if(str != null) {
            System.out.print("Hello I am a singleton!");
            System.out.println(" Let me say " + str + " to you");
        }
        return instance;
    }
}
