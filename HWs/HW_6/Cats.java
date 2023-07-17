package HW_6;

public class Cats {
    private String breed;
    private String gender;
    private String color;
    private float weight;
    private float age;
    private String sterilized;

    public Cats(String breed, String gender, String color, float weight, float age, String sterilized){
        this.breed = breed;
        this.gender = gender;
        this.color = color;
        this.weight = weight;
        this.age = age;
        this.sterilized = sterilized;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public String getBreed(){
        return breed;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public float getWeight(){
        return weight;
    }

    public void setAge(float age){
        this.age = age;
    }

    public float getAge(){
        return age;
    }

    public void setSterilized(String sterilized){
        this.sterilized = sterilized;
    }

    public String getSterilized(){
        return sterilized;
    }

    public String getInfo(){
        return "\nПорода - " + breed + "\nПол - " + gender + "\nЦвет - " + color + "\nВес - " + weight +
         "\nВозраст - " + age + "\nСтерилизация - " + sterilized;
    }
}