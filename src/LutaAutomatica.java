import java.util.Random;

public class LutaAutomatica {
    private LutadorAutomatico lutador1;
    private LutadorAutomatico lutador2;

    void combate(LutadorAutomatico lutador1, LutadorAutomatico lutador2){
        System.out.println(" ");
        System.out.println("*****************************");
        System.out.print("Luta de ");
        lutador1.status();
        System.out.print(" contra ");
        lutador2.status();
        System.out.println("*****************************");
        System.out.println(" ");

        while(lutador1.getEstamina() > 0 && lutador2.getEstamina() > 0){
            acao(lutador1);
            acao(lutador2);
            if(lutador1.getAcao().equals("Ataque") && lutador2.getAcao().equals("Ataque")){
                lutador1.setEstamina(lutador1.getEstamina() - lutador2.getAtaque()/2);
                lutador2.setEstamina(lutador2.getEstamina() - lutador1.getAtaque()/2);
            } else if(lutador1.getAcao().equals("Ataque") && lutador2.getAcao().equals("Defesa")){
                lutador2.setEstamina(lutador2.getEstamina() - lutador1.getAtaque()/5);

            }else if(lutador1.getAcao().equals("Ataque") && lutador2.getAcao().equals("Recua")){
                lutador2.setEstamina(lutador2.getEstamina() - lutador1.getAtaque());

            }else if(lutador2.getAcao().equals("Ataque") && lutador1.getAcao().equals("Defesa") ){
                lutador1.setEstamina(lutador1.getEstamina() - lutador2.getAtaque()/5);

            }else if(lutador2.getAcao().equals("Ataque") && lutador1.getAcao().equals("Recua")){
                lutador1.setEstamina(lutador1.getEstamina() - lutador2.getAtaque());
            }
            System.out.println("");


        }
        System.out.println("-------------------------");

        if(lutador1.getEstamina() > lutador2.getEstamina()){
            System.out.println("**** E o vencedor  da luta foi  ****");
            lutador1.status();
            lutador1.setVitorias(lutador1.getVitorias() + 1);
            lutador2.setDerrotas(lutador2.getDerrotas() + 1);

        }else if(lutador2.getEstamina() > lutador1.getEstamina()){
            System.out.println("**** E o vencedor  da luta foi ****");
            lutador2.status();
            lutador2.setVitorias(lutador2.getVitorias() + 1);
            lutador1.setDerrotas(lutador1.getDerrotas() + 1);
        } else{
            lutador1.setEmpates(lutador1.getEmpates() + 1);
            lutador2.setEmpates(lutador2.getEmpates() + 1);

        }

        lutador1.setEstamina((100 - lutador1.getAtaque() - lutador1.getDefesa()) * 10);
        lutador2.setEstamina((100 - lutador2.getAtaque() - lutador2.getDefesa()) * 10);

        System.out.println( " ********************************************************");
    }


    void acao(LutadorAutomatico l){
        Random aleatorio = new Random();
        int movimento = aleatorio.nextInt(3);

        switch (movimento){
            case 0 : l.atacar();
                break;

            case 1 : l.defender();
                break;

            case 2 : l.recuar();
                System.out.println(l.getNome() + " recuou " );
                break;

        }
    }
}
