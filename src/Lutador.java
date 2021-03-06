
import java.util.Random;
import java.util.Scanner;

public class Lutador implements Lutar{
    private String nome;
    private double ataque;
    private double defesa;
    private double estamina;
    private String acao;
    private int vitorias = 0;
    private int empates = 0;
    private int derrotas = 0;



    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public Lutador(String nome) {
        this.nome = nome;

        System.out.println("Distribua 100 pontos para ataque, defesa e estamina para o lutador " + this.getNome() );
        Scanner scan = new Scanner(System.in);

        System.out.print("Ataque: ");
        double valorAtaqueTemporario = scan.nextDouble();
        if(valorAtaqueTemporario < 0 || valorAtaqueTemporario > 100){
            do{
                System.out.println("Valor de defesa deve ser entre 0 e 100 ");
                System.out.print("Ataque: ");
                valorAtaqueTemporario = scan.nextDouble();
            }while(valorAtaqueTemporario < 0 || valorAtaqueTemporario > 100);
        }
        this.ataque = valorAtaqueTemporario;


        System.out.println("Ainda tem " + (100 - this.ataque  ) + " para distribuir entre defesa e estamina");

        System.out.print("Defesa: ");
        double valorDefesaTemporario = scan.nextDouble();
        if(valorDefesaTemporario  > (100 - this.ataque)){
            do{
                System.out.println("Valor de defesa deve ser menor que " + (100 - this.ataque));
                System.out.print("Defesa: ");
                valorDefesaTemporario = scan.nextDouble();
            }while(valorDefesaTemporario  > (100 - this.ataque));
        }
        this.defesa = valorDefesaTemporario;


        this.setEstamina( 100 + (100 - this.ataque - this.defesa) * 10);
        System.out.println("Estamina: " + this.getEstamina());
        this.status();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getEstamina() {
        return estamina;
    }

    public void setEstamina(double estamina) {
        this.estamina = estamina;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    @Override
    public void atacar() {
        this.setAcao("Ataque");
        Random aleatorio = new Random();
        double valor = aleatorio.nextInt(100);
        double dano = this.ataque * (valor/100);
        this.setEstamina(this.getEstamina() - dano/5);
        System.out.println(this.getNome() + " atacou com pot??ncia " + dano );
    }

    @Override
    public void defender() {
        this.setAcao("Defesa");
        Random aleatorio = new Random();
        double valor = aleatorio.nextInt(100);
        double bloqueia = this.defesa * (valor/100);
        this.setEstamina(this.getEstamina() - bloqueia/10);
        System.out.println(this.getNome() + " defendeu com prote????o " + bloqueia );
    }

    @Override
    public void recuar() {
        this.setAcao("Recua");
        this.setEstamina(getEstamina() + 1);
    }


    public void status() {
        System.out.println("----------------");
        System.out.println("Lutador{" +
                "nome = '" + this.nome + '\'' +
                ", ataque = " + this.ataque +
                ", defesa = " + this.defesa +
                ", estamina = " + this.estamina +
                '}');
    }

}
