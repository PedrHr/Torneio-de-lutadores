class Main {
    public static void main() {
        int[] vet = new int[10];
        for (int i = 0; i < vet.length; i++) {
            vet[i] = i;
        }
        for(int i : vet){
            System.out.println(i);
        }
    }
}