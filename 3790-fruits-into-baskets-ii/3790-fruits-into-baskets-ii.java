class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for(int fruit:fruits){
            boolean exist = false;
            for(int i = 0;i<baskets.length;i++){
                if(fruit<=baskets[i]){
                    baskets[i]=0;
                    exist = true;
                    break;
                }
            }
            if(!exist) count++;
        }
        return count;
    }
}