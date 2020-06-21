public class television implements telephone,picture {

    public static void main(String[] args){
        System.out.println(picture);
        System.out.println(voice);
        television television = new television();
        television.havaVioce();
        television.havePicture();
    }


    public void havePicture() {
        System.out.println("have picture");
    }

    public void havaVioce() {
        System.out.println("have vioce");
    }
}
