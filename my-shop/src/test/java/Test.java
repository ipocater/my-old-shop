 class Test {
    private int a;
            int b;
    protected int c;
    public int d;

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,3,5,7,9,11},{0,2,4,6,8,10}};
        doSomething(mat);
        for (int row = 0; row < mat.length; row++){
            for (int col = 0; col < mat[0].length; col++){
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

     public static void doSomething( int[][] mat) {
        for (int row = 0; row < mat.length; row++){
            for (int col = 0; col < mat[0].length; col++){
                mat[row][col] = mat[row][mat[0].length - 1 - col];
             }
         }
     }

}

