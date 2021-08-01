/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoagente;

public class Rutas {

    private int CaminosTAM;

    private Caminos[] GenotipoDeCaminos;
    private int[] ArregloAuxiliar;
    private int[] AptitudAuxiliar;
    private String[] ReccorridoAuxilar;
    private String[] SeleecionAxuiliar;
    private int[][] GRAFO
            = {{0, 132, 217, 164, 58},
            {132, 0, 290, 201, 79},
            {217, 290, 0, 113, 303},
            {164, 201, 113, 0, 196},
            {58, 79, 303, 196, 0}};
    private int[] UbicacionBuenos;
    private int[] UbicacionMalos;
    private int[] Cache;
    private String[] PCOR;
    private String[] PINC;
    private String Caminos;
    private int AcumulaDatos;
    private int OpcionMetodo;
    private int EvolucionArepetir;
    private String GeneraNumerosAle;
    private String Mensaje;
    private String[] Mensaj2;
    private String Mensaje3;

    Rutas(int CaminosTAM) {
        this.CaminosTAM = CaminosTAM;
  Mensaje3= Mensaje= Caminos = GeneraNumerosAle = "";
        OpcionMetodo = AcumulaDatos = 0;
        ArregloAuxiliar = new int[5];
        GenotipoDeCaminos = new Caminos[CaminosTAM];
        AptitudAuxiliar = new int[CaminosTAM];
        ReccorridoAuxilar = new String[CaminosTAM];
        SeleecionAxuiliar = new String[CaminosTAM];
    }

    public void GenerarRutas() {

        int Pos = 1;

        for (int h = 0; h < CaminosTAM; h++) {
            GenotipoDeCaminos[h] = new Caminos();
            int minimo = 1, maximo = 5;

            ArregloAuxiliar[0] = (int) (minimo + Math.random() * maximo);
            for (int i = 0; i < 5; i++) {
                ArregloAuxiliar[i] = (int) (minimo + Math.random() * maximo);
                for (int j = 0; j < i; j++) {
                    if (ArregloAuxiliar[i] == ArregloAuxiliar[j]) {
                        i--;
                    }
                }
            }
            for (int j = 0; j < 5; j++) {
                GeneraNumerosAle += ArregloAuxiliar[j];
            }

            Caminos = GRAFO[ArregloAuxiliar[0] - 1][ArregloAuxiliar[1] - 1] + "+"
                    + GRAFO[ArregloAuxiliar[1] - 1][ArregloAuxiliar[2] - 1] + "+"
                    + GRAFO[ArregloAuxiliar[2] - 1][ArregloAuxiliar[3] - 1] + "+"
                    + GRAFO[ArregloAuxiliar[3] - 1][ArregloAuxiliar[4] - 1] + "+"
                    + GRAFO[ArregloAuxiliar[4] - 1][ArregloAuxiliar[0] - 1];

            AcumulaDatos = GRAFO[ArregloAuxiliar[0] - 1][ArregloAuxiliar[1] - 1]
                    + GRAFO[ArregloAuxiliar[1] - 1][ArregloAuxiliar[2] - 1]
                    + GRAFO[ArregloAuxiliar[2] - 1][ArregloAuxiliar[3] - 1]
                    + GRAFO[ArregloAuxiliar[3] - 1][ArregloAuxiliar[4] - 1]
                    + GRAFO[ArregloAuxiliar[4] - 1][ArregloAuxiliar[0] - 1];
            GenotipoDeCaminos[h].setIndi(Pos++);
            GenotipoDeCaminos[h].setCaminosSel(String.valueOf(GeneraNumerosAle));
            GenotipoDeCaminos[h].setRuta(Caminos);
            GenotipoDeCaminos[h].setCosto(String.valueOf(AcumulaDatos));
            GeneraNumerosAle = "";
        }
        switch (OpcionMetodo) {
            case 1:
                MetodoTorneo();
                break;

            case 2:
                MetodoSeleccion();
                break;
            case 3:
                MetodoCruce();
                FIXMetodoCruce();
                break;

        }
        CRUCE();

        FIXCruce();

        Muta();
        int Sum = 0;
        String Re = "";
        for (int i = 0; i < CaminosTAM; i++) {
            SeleecionAxuiliar[i] = GenotipoDeCaminos[i].getMutaci();
        }

        for (int i = 0; i < CaminosTAM; i++) {
            Sum = GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1]
                    + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1]
                    + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1]
                    + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1]
                    + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1];

            Re = String.valueOf(GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1]
                    + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1]
                    + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1]
                    + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1]
                    + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1]);

            AptitudAuxiliar[i] = Sum;
            ReccorridoAuxilar[i] = Re;
        }

    }

    public void RepetirCambio(int EvolucionArepetir) {
        this.EvolucionArepetir = EvolucionArepetir;
        Cache = new int[EvolucionArepetir];
     Mensaj2 = new String[EvolucionArepetir];
        
        for (int vc = 0; vc < EvolucionArepetir; vc++) {

            int ID = 1;
            for (int i = 0; i < CaminosTAM; i++) {
                GenotipoDeCaminos[i] = new Caminos();
                GenotipoDeCaminos[i].setIndi(ID++);
                GenotipoDeCaminos[i].setCaminosSel(String.valueOf(SeleecionAxuiliar[i]));
                GenotipoDeCaminos[i].setRuta(ReccorridoAuxilar[i]);
                GenotipoDeCaminos[i].setCosto(String.valueOf(AptitudAuxiliar[i]));
            }

            if (OpcionMetodo == 1) {
                MetodoTorneo();

            }
            if (OpcionMetodo == 2) {
                MetodoSeleccion();
            }
            if (OpcionMetodo == 3) {
                MetodoCruce();
                FIXMetodoCruce();
            }

            CRUCE();

            FIXCruce();

            Muta();

            int Sum = 0;
            String Re = "";
            for (int i = 0; i < CaminosTAM; i++) {
                SeleecionAxuiliar[i] = GenotipoDeCaminos[i].getMutaci();
            }

            for (int i = 0; i < CaminosTAM; i++) {
                Sum = GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1]
                        + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1]
                        + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1]
                        + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1]
                        + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1];

                Re = String.valueOf(GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1]
                        + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(1))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1]
                        + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(2))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1]
                        + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(3))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1]
                        + "-" + GRAFO[Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(4))) - 1][Integer.parseInt(String.valueOf(GenotipoDeCaminos[i].getMutaci().charAt(0))) - 1]);

                AptitudAuxiliar[i] = Sum;
                ReccorridoAuxilar[i] = Re;
            }

            AptitudMenor();
         MuestraEvolu();
       Cache[vc] = GenotipoDeCaminos[0].getMenor();
        }


    }
public void MuestraEvolu(){
    System.out.println("///////////////////////////////////////////////////////////////////////////");
    for (int J = 0; J < CaminosTAM; J++) {
        

              System.out.println(GenotipoDeCaminos[J].getIndi() + "\t  "
                        + GenotipoDeCaminos[J].getCaminosSel() + "\t   "
                        + GenotipoDeCaminos[J].getRuta() + "\t  "
                        + GenotipoDeCaminos[J].getCosto() + "\t   "
                        + GenotipoDeCaminos[J].getSelecc() + "\t   "
                        + GenotipoDeCaminos[J].getCruce() + "\t    "
                        + GenotipoDeCaminos[J].getMutaci() + "\t    ");

            
        }

        System.out.println("ESTE ES EL MENOR: " + GenotipoDeCaminos[0].getMenor());
        System.out.println("//////////////////////////////////////////////////////////////////////////////////");
    }

    public void MetodoTorneo() {
        int camino[] = new int[CaminosTAM];
        int camino2[] = new int[CaminosTAM];
        for (int i = 0; i < camino.length; i++) {
            camino[i] = (int) (Math.random() * CaminosTAM + 1);
            for (int j = 0; j < i; j++) {
                if (camino[i] == camino[j]) {
                    i--;
                }
            }
        }
        for (int i = 0; i < camino2.length; i++) {
            camino2[i] = (int) (Math.random() * CaminosTAM + 1);
            for (int j = 0; j < i; j++) {
                if (camino2[i] == camino2[j]) {
                    i--;
                }
            }
        }

        for (int i = 0; i < CaminosTAM; i++) {
            if (Integer.parseInt(GenotipoDeCaminos[camino[i] - 1].getCosto()) < Integer.parseInt(GenotipoDeCaminos[camino2[i] - 1].getCosto())) {
                GenotipoDeCaminos[i].setSelecc(GenotipoDeCaminos[camino[i] - 1].getCaminosSel());
            } else {
                GenotipoDeCaminos[i].setSelecc(GenotipoDeCaminos[camino2[i] - 1].getCaminosSel());
            }
        }
    }

    public void MetodoSeleccion() {
        Caminos aux;
        Caminos[] AuxCambio2 = new Caminos[CaminosTAM];
        int[] AuxPosiciones = new int[CaminosTAM];

        for (int i = 0; i < CaminosTAM; i++) {
            AuxCambio2[i] = new Caminos();
            AuxCambio2[i].setIndi(GenotipoDeCaminos[i].getIndi());
            AuxCambio2[i].setCosto(GenotipoDeCaminos[i].getCosto());
        }
        for (int i = 0; i < GenotipoDeCaminos.length; i++) {
            for (int j = i + 1; j < GenotipoDeCaminos.length; j++) {
            
                if (Integer.valueOf(AuxCambio2[i].getCosto()) >= Integer.valueOf(AuxCambio2[j].getCosto())) {
                     
                    aux = AuxCambio2[i];
                    AuxCambio2[i] = AuxCambio2[j];
                    AuxCambio2[j] = aux;

                }

            }

        }
        for (int i = 0; i < CaminosTAM; i++) {
            AuxPosiciones[i] = AuxCambio2[i].getIndi();

        }
        for (int i = 0; i < CaminosTAM; i++) {

            GenotipoDeCaminos[i].setSelecc(GenotipoDeCaminos[AuxPosiciones[i] - 1].getCaminosSel());

        }

    }



    public void MetodoCruce() {

        int vc = 0, vj = 0;

        double[] a = new double[CaminosTAM];
        for (int i = 0; i < CaminosTAM; i++) {
            a[i] = (double) (Math.random() * 1);

            if (a[i] > .4) {
                vc++;

            } else {
                GenotipoDeCaminos[i].setSelecc(GenotipoDeCaminos[i].getCaminosSel());

                vj++;
            }

        }
        int jk = 0;
        int jq = 0;
        UbicacionBuenos = new int[vc];
        UbicacionMalos = new int[vj];
        PCOR = new String[vc];
        PINC = new String[vj];
        for (int i = 0; i < CaminosTAM; i++) {
            if (a[i] > .4) {

                PCOR[jk] = GenotipoDeCaminos[i].getCaminosSel();
                UbicacionBuenos[jk] = i;

                jk++;
            } else {
                PINC[jq] = GenotipoDeCaminos[i].getCaminosSel();
                UbicacionMalos[jq] = i;
                jq++;
            }
        }
        if (vc % 2 == 0) {
            MetodoCrucePAR(vc);
        }
        if (vc % 2 == 1) {

            MetodoCruceIMPAR(vj, vc);

        }
    }

    public void MetodoCrucePAR(int vc) {

        int cag = 0;

        for (int i = 0; i < vc; i++) {
            int AleLong = (int) (Math.random() * GenotipoDeCaminos[0].getCaminosSel().length());
            cag = i + 1;
            GenotipoDeCaminos[UbicacionBuenos[i]].setSelecc(GenotipoDeCaminos[UbicacionBuenos[i]].getCaminosSel().substring(0, AleLong) + GenotipoDeCaminos[UbicacionBuenos[cag]].getCaminosSel().substring(AleLong));
            GenotipoDeCaminos[UbicacionBuenos[cag]].setSelecc(GenotipoDeCaminos[UbicacionBuenos[cag]].getCaminosSel().substring(0, AleLong) + GenotipoDeCaminos[UbicacionBuenos[i]].getCaminosSel().substring(AleLong));
            i = cag;
        }

    }

    public void MetodoCruceIMPAR(int vj, int vc) {

        int vl = vc + 1;

        int[] poc = new int[vl];
        for (int i = 0; i < vc; i++) {
            poc[i] = UbicacionBuenos[i];
        }
        int posicion = poc.length - 1;
        int AleLong2 = 0, posAl = 0;
        for (int l = 0; l < vj; l++) {

            AleLong2 = (int) (Math.random() * UbicacionMalos.length);
            poc[posicion] = UbicacionMalos[AleLong2];
        }
        int cog2 = 0;
        String[] Buenos2 = new String[vl];
        for (int i = 0; i < vl; i++) {
            Buenos2[i] = GenotipoDeCaminos[poc[i]].getCaminosSel();
        }
        for (int i = 0; i < vl; i++) {
            int AleLong = (int) (Math.random() * GenotipoDeCaminos[0].getCaminosSel().length());
            cog2 = i + 1;

            GenotipoDeCaminos[poc[i]].setSelecc(GenotipoDeCaminos[poc[i]].getCaminosSel().substring(0, AleLong) + GenotipoDeCaminos[poc[cog2]].getCaminosSel().substring(AleLong));
            GenotipoDeCaminos[poc[cog2]].setSelecc(GenotipoDeCaminos[poc[cog2]].getCaminosSel().substring(0, AleLong) + GenotipoDeCaminos[poc[i]].getCaminosSel().substring(AleLong));
            i = cog2;
        }
    }

    public void FIXMetodoCruce() {
        String Cadn1 = "12345";
        String[] AuxCad = new String[CaminosTAM];
        String[] AuxCad2 = new String[CaminosTAM];
        char Eleme = 0;
        int Cont1 = 0;
        int Cont2 = 0;

        int PosAux = 0;
        Eleme = 0;

        for (int h = 0; h < CaminosTAM; h++) {

            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 5; j++) {
                    if (GenotipoDeCaminos[h].getSelecc().charAt(i) == GenotipoDeCaminos[h].getSelecc().charAt(j)) {
                        Cont1++;
                    }
                    if (Cadn1.charAt(i) == GenotipoDeCaminos[h].getSelecc().charAt(j)) {
                        Cont2++;
                    }

                }

                if (Cont1 >= 2) {

                    PosAux = i;

                }
                if (Cont2 == 0) {

                    Eleme = Cadn1.charAt(i);

                }

                Cont1 = 0;
                Cont2 = 0;
            }

            if (PosAux == 0) {

                AuxCad[h] = GenotipoDeCaminos[h].getSelecc();

            } else {

                StringBuilder Binario2 = new StringBuilder(GenotipoDeCaminos[h].getSelecc());

                Binario2.setCharAt(PosAux, Eleme);

                AuxCad[h] = String.valueOf(Binario2);
                PosAux = 0;
                Eleme = ' ';

            }
        }

        for (int h = 0; h < CaminosTAM; h++) {

            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 5; j++) {
                    if (AuxCad[h].charAt(i) == AuxCad[h].charAt(j)) {
                        Cont1++;
                    }
                    if (Cadn1.charAt(i) == AuxCad[h].charAt(j)) {
                        Cont2++;
                    }

                }

                if (Cont1 >= 2) {

                    PosAux = i;

                }
                if (Cont2 == 0) {

                    Eleme = Cadn1.charAt(i);

                }

                Cont1 = 0;
                Cont2 = 0;
            }

            if (PosAux == 0) {

                AuxCad2[h] = AuxCad[h];

            } else {

                StringBuilder Binario2 = new StringBuilder(AuxCad[h]);

                Binario2.setCharAt(PosAux, Eleme);

                AuxCad2[h] = String.valueOf(Binario2);
                PosAux = 0;
                Eleme = ' ';

            }
        }
        for (int i = 0; i < CaminosTAM; i++) {
            GenotipoDeCaminos[i].setSelecc(AuxCad2[i]);
        }
    }
    
    
    

    public void CRUCE() {
        int vc = 0, vj = 0;
        double[] a = new double[CaminosTAM];
        for (int i = 0; i < CaminosTAM; i++) {
            a[i] = (double) (Math.random() * 1);

            if (a[i] > .4) {
                vc++;

            } else {
                GenotipoDeCaminos[i].setCruce(GenotipoDeCaminos[i].getSelecc());

                vj++;
            }

        }
        int jk = 0;
        int jq = 0;
        UbicacionBuenos = new int[vc];
        UbicacionMalos = new int[vj];
        PCOR = new String[vc];
        PINC = new String[vj];
        for (int i = 0; i < CaminosTAM; i++) {
            if (a[i] > .4) {

                PCOR[jk] = GenotipoDeCaminos[i].getSelecc();
                UbicacionBuenos[jk] = i;

                jk++;
            } else {
                PINC[jq] = GenotipoDeCaminos[i].getSelecc();
                UbicacionMalos[jq] = i;
                jq++;
            }
        }
        if (vc % 2 == 0) {
            CrucePar(vc);
        }
        if (vc % 2 == 1) {

            CruceImpar(vj, vc);

        }
    }

    public void CrucePar(int vc) {
        int cag = 0;

        for (int i = 0; i < vc; i++) {
            int AleLong = (int) (Math.random() * GenotipoDeCaminos[0].getSelecc().length());
            cag = i + 1;
            GenotipoDeCaminos[UbicacionBuenos[i]].setCruce(GenotipoDeCaminos[UbicacionBuenos[i]].getSelecc().substring(0, AleLong) + GenotipoDeCaminos[UbicacionBuenos[cag]].getSelecc().substring(AleLong));
            GenotipoDeCaminos[UbicacionBuenos[cag]].setCruce(GenotipoDeCaminos[UbicacionBuenos[cag]].getSelecc().substring(0, AleLong) + GenotipoDeCaminos[UbicacionBuenos[i]].getSelecc().substring(AleLong));
            i = cag;
        }
    }

    public void CruceImpar(int vj, int vc) {

        int vl = vc + 1;

        int[] poc = new int[vl];
        for (int i = 0; i < vc; i++) {
            poc[i] = UbicacionBuenos[i];
        }
        int posicion = poc.length - 1;
        int AleLong2 = 0, posAl = 0;
        for (int l = 0; l < vj; l++) {

            AleLong2 = (int) (Math.random() * UbicacionMalos.length);
            poc[posicion] = UbicacionMalos[AleLong2];
        }
        int cog2 = 0;
        String[] Buenos2 = new String[vl];
        for (int i = 0; i < vl; i++) {
            Buenos2[i] = GenotipoDeCaminos[poc[i]].getSelecc();
        }
        for (int i = 0; i < vl; i++) {
            int AleLong = (int) (Math.random() * GenotipoDeCaminos[0].getSelecc().length());
            cog2 = i + 1;

            GenotipoDeCaminos[poc[i]].setCruce(GenotipoDeCaminos[poc[i]].getSelecc().substring(0, AleLong) + GenotipoDeCaminos[poc[cog2]].getSelecc().substring(AleLong));
            GenotipoDeCaminos[poc[cog2]].setCruce(GenotipoDeCaminos[poc[cog2]].getSelecc().substring(0, AleLong) + GenotipoDeCaminos[poc[i]].getSelecc().substring(AleLong));
            i = cog2;
        }
    }

    public void FIXCruce() {
        String Cadn1 = "12345";
        String[] AuxCad = new String[CaminosTAM];
        String[] AuxCad2 = new String[CaminosTAM];
        char Eleme = 0;
        int Cont1 = 0;
        int Cont2 = 0;

        int PosAux = 0;
        Eleme = 0;

        for (int h = 0; h < CaminosTAM; h++) {

            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 5; j++) {
                    if (GenotipoDeCaminos[h].getCruce().charAt(i) == GenotipoDeCaminos[h].getCruce().charAt(j)) {
                        Cont1++;
                    }
                    if (Cadn1.charAt(i) == GenotipoDeCaminos[h].getCruce().charAt(j)) {
                        Cont2++;
                    }

                }

                if (Cont1 >= 2) {

                    PosAux = i;

                }
                if (Cont2 == 0) {

                    Eleme = Cadn1.charAt(i);

                }

                Cont1 = 0;
                Cont2 = 0;
            }

            if (PosAux == 0) {

                AuxCad[h] = GenotipoDeCaminos[h].getCruce();

            } else {

                StringBuilder Binario2 = new StringBuilder(GenotipoDeCaminos[h].getCruce());

                Binario2.setCharAt(PosAux, Eleme);

                AuxCad[h] = String.valueOf(Binario2);
                PosAux = 0;
                Eleme = ' ';

            }
        }

        for (int h = 0; h < CaminosTAM; h++) {

            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 5; j++) {
                    if (AuxCad[h].charAt(i) == AuxCad[h].charAt(j)) {
                        Cont1++;
                    }
                    if (Cadn1.charAt(i) == AuxCad[h].charAt(j)) {
                        Cont2++;
                    }

                }

                if (Cont1 >= 2) {

                    PosAux = i;

                }
                if (Cont2 == 0) {

                    Eleme = Cadn1.charAt(i);

                }

                Cont1 = 0;
                Cont2 = 0;
            }

            if (PosAux == 0) {

                AuxCad2[h] = AuxCad[h];

            } else {

                StringBuilder Binario2 = new StringBuilder(AuxCad[h]);

                Binario2.setCharAt(PosAux, Eleme);

                AuxCad2[h] = String.valueOf(Binario2);
                PosAux = 0;
                Eleme = ' ';

            }
        }
        for (int i = 0; i < CaminosTAM; i++) {
            GenotipoDeCaminos[i].setCruce(AuxCad2[i]);
        }
    }

    public void Muta() {

        double[] a = new double[CaminosTAM];

        int vj = 0;
        for (int i = 0; i < CaminosTAM; i++) {
            a[i] = (double) (Math.random() * 1);
            if (a[i] > .1) {
                vj++;

            } else {
                GenotipoDeCaminos[i].setMutaci(GenotipoDeCaminos[i].getCruce());

            }

        }

        String[] Mutar = new String[vj];
        int[] PosMutar = new int[vj];
        int jk = 0;
        for (int i = 0; i < CaminosTAM; i++) {
            if (a[i] > .1) {
                Mutar[jk] = GenotipoDeCaminos[i].getCruce();
                PosMutar[jk] = i;
                jk++;
            }

        }

        for (int i = 0; i < Mutar.length; i++) {
            int NumAl = (int) (Math.random() * Mutar[0].length());
            int NumAl2 = (int) (Math.random() * Mutar[0].length());
            char Ele = Mutar[i].charAt(NumAl);
            char Ele2 = Mutar[i].charAt(NumAl2);

            StringBuilder Binario2 = new StringBuilder(Mutar[i]);

            Binario2.setCharAt(NumAl, Ele2);
            Binario2.setCharAt(NumAl2, Ele);
            GenotipoDeCaminos[PosMutar[i]].setMutaci(String.valueOf(Binario2));
            NumAl = 0;
            NumAl2 = 0;
            Ele = 0;
            Ele2 = 0;
        }

    }
    
    public void AptitudMenor() {
        int mej = Integer.parseInt(GenotipoDeCaminos[0].getCosto());

        for (int j = 0; j < CaminosTAM; j++) {
            if (Integer.parseInt(GenotipoDeCaminos[j].getCosto()) < mej) {
                mej = Integer.parseInt(GenotipoDeCaminos[j].getCosto());
            }

        }
        GenotipoDeCaminos[0].setMenor(mej);
    }

    public void AptitudGanadora() {
        for (int i = 0; i < EvolucionArepetir; i++) {
            System.out.println(Cache[i]);
        }
        int mej = Cache[0];
        for (int i = 0; i < EvolucionArepetir; i++) {
            if (Cache[i] < mej) {
                mej = Cache[i];
            }
        }
        System.out.println("EL MEJOR COSTO ES: " + mej);

    }

    public String MuestraRutasA() {
        for (int i = 0; i < CaminosTAM; i++) {
            Mensaje += GenotipoDeCaminos[i].getIndi()  + "\t  "
                    + GenotipoDeCaminos[i].getCaminosSel()  + "\t  "
                    + GenotipoDeCaminos[i].getRuta()   + "\t  "
                    + GenotipoDeCaminos[i].getCosto()  + "\t  "
                    + GenotipoDeCaminos[i].getSelecc()   + "\t  "
                    + GenotipoDeCaminos[i].getCruce()   + "\t  "
                    + GenotipoDeCaminos[i].getMutaci()  + "\t   " + "\n";
        }
        return Mensaje;
    }

    public void setOp(int op) {
        this.OpcionMetodo = op;
    }

    public int getOp() {
        return OpcionMetodo;
    }

}
