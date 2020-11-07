package br.edu.iftm.prova1;
import java.util.Scanner;

public class Revesamento {
    private int aux = 1;
    private String nomea;
    private String nomeb;
    private int tempoa;
    private int tempob;

    public void entra() throws InterruptedException{
        synchronized(this){        
            System.out.println("Inicio do treinamento primeiro aluno se dirija ao equipamento ...");
            wait();
            System.out.println("Ambos finalizaram o treinamento.");
        }
    }

    public void proximo() throws InterruptedException{
        Scanner input = new Scanner(System.in);
        Thread.sleep(2000);        
        int conta = 1, contb = 1;
        for(int i = 1; i <= 10; i++){
            if(aux == 1){
                synchronized(this){
                    Thread.sleep(tempoa);
                    System.out.println(nomea +" Finalizou o exercicio "+conta+ " Pressione ENTER para chamar o proximo aluno");
                    input.nextLine();
                    notify();
                    aux = 2;
                    conta ++;
                }                
            }else if(aux == 2){
                synchronized(this){
                    Thread.sleep(tempob);
                    System.out.println(nomeb+" Finalizou o exercicio "+contb+ " Pressione ENTER para chamar o proximo aluno");
                    input.nextLine();
                    notify();
                    aux = 1;
                    contb ++;
                }               
            }
        }
    }



    /**
     * @return int return the aux
     */
    public int getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(int aux) {
        this.aux = aux;
    }

    /**
     * @param nomea the nomea to set
     */
    public void setNomea(String nomea) {
        this.nomea = nomea;
    }

    /**
     * @param nomeb the nomeb to set
     */
    public void setNomeb(String nomeb) {
        this.nomeb = nomeb;
    }

    /**
     * @param tempoa the tempoa to set
     */
    public void setTempoa(int tempoa) {
        this.tempoa = tempoa;
    }

    /**
     * @param tempob the tempob to set
     */
    public void setTempob(int tempob) {
        this.tempob = tempob;
    }

}