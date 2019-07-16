package Topico8_ProblemasClassicos.JantarFilosofos;

/**
 *
 * @author jennifer
 */
public class JantarFilosofos implements Runnable {

    int id = 0;
    Garfo garfo = null;
    final int versao;

    public JantarFilosofos(int id, Garfo garfo, int versao) {
        id = id;
        garfo = garfo;
        this.versao = versao;
    }
    
    @Override
    public void run() {
        try {
            if(versao == 1) {
                tecnica1();
            } else if(versao == 2) {
                tecnica2();
            } else if(versao == 3) {
                tecnica3();
            }
         }catch (InterruptedException e){
             System.out.println(e);
         }
    }

    private void tecnica1() {
        while (true) {
            try {
                System.out.println("Filósofo " + id + " está pensando");
                Thread.sleep(3000);
                System.out.println("Filósofo " + id + " está com fome");
                garfo.pegarGarfo(id);
                System.out.println("Filósofo " + id + " está comendo");
                Thread.sleep(4000);
                garfo.soltarGarfo(id);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void tecnica2() throws InterruptedException {
        while (true) {
            try {
                System.out.println("Filósofo " + id + " está pensando");
                Thread.sleep(3000);
                System.out.println("Filósofo " + id + " está com fome");
                garfo.pegarGarfo(id);
                System.out.println("Filósofo " + id + " está comendo");
                Thread.sleep(4000);
                garfo.soltarGarfo(id);
            } catch (InterruptedException e) {         
                Thread.sleep(1000);
                continue;                              
            }
        }
    }

    private void tecnica3() throws InterruptedException {
        while (true) {
            try {
                System.out.println("Filósofo " + id + " está pensando");
                Thread.sleep(3000);
                System.out.println("Filósofo " + id + " está com fome");
                garfo.pegarGarfo(id);
                System.out.println("Filósofo " + id + " está comendo");
                Thread.sleep(4000);
                garfo.soltarGarfo(id);
            } catch (InterruptedException e) {         
                Thread.sleep(1000);
                continue;                              
            }
        }
    }
}

interface Garfo {
    public void pegarGarfo(int i) throws InterruptedException;
    public void soltarGarfo(int i) throws InterruptedException;
}
