class Q6 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
		
        for(int i = words.length - 1 ; i >= 0 ; i-- )
        {
            result.append(words[i] + " ");
        }
        return result.toString().trim().replaceAll(" +", " "); 
    }
}

