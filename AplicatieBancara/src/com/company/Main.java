package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClasaServiciu clasaServiciu = new ClasaServiciu();

        System.out.println("Bine ați venit!\n");
        ExtrasDeCont extrasDeCont = null;

        Cont contNou = null;
        ContEconomii contNouEconomii = null;

        while (true) {
            System.out.println("Ce operație doriți să efectuați?");
            System.out.println("1 - Creează un cont bancar");
            System.out.println("2 - Retrage bani");
            System.out.println("3 - Depune bani");
            System.out.println("4 - Afișează extrasul de cont");
            System.out.println("5 - Creează un card");
            System.out.println("6 - Afișează detalii card");
            System.out.println("7 - Creează un cont de economii");
            System.out.println("8 - Retrage bani din contul de economii");
            System.out.println("9 - Depune bani în contul de economii");
            System.out.println("10 - Calculează dobânda pentru contul de economii");
            System.out.println("11 - Alte servicii");
            System.out.println("12 - Ieșire");

            int numar = scanner.nextInt();
            scanner.nextLine();

            if (numar == 1) {

                System.out.println("Care este numele titularului de cont?");
                String numeTitular = scanner.nextLine();

                System.out.println("Care este IBAN-ul contului?");
                String iban = scanner.nextLine();
                System.out.println();

                extrasDeCont = new ExtrasDeCont();
                contNou = clasaServiciu.creeazaCont(numeTitular, iban, extrasDeCont);
            }

            else if(numar == 2) {
                if(contNou != null) {
                    System.out.println("Ce sumă doriți să retrageți?");

                    int sumaRetrasa = scanner.nextInt();
                    scanner.nextLine();

                    if (sumaRetrasa <= contNou.getTotalBaniCont()) {
                        System.out.println("La ce dată doriți să retrageți banii?");
                        String dataRetragere = scanner.nextLine();

                        contNou.retrageBani(sumaRetrasa, dataRetragere);
                    } else
                        System.out.println("Nu aveți destui bani în cont.\n");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 3) {
                if(contNou != null) {
                    System.out.println("Ce sumă doriți să depuneți?");

                    int sumaDepusa = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("La ce dată doriți să depuneți banii?");
                    String dataRetragere = scanner.nextLine();

                    contNou.depuneBani(sumaDepusa, dataRetragere);
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 4) {
                if(contNou != null) {
                    if(contNou.getExtrasDeCont().getLastIndex() != 0) {
                        System.out.println("Extrasul de cont cu toate tranzacțiile efectuate:\n");
                        clasaServiciu.afiseazaExtrasulDeCont(contNou);
                    }
                    else
                        System.out.println("Nu aveți nicio tranzacție efectuată.\n");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 5) {
                if(contNou != null) {
                    if(contNou.getCard() != null)
                        System.out.println("Aveți deja un card creat.\n");
                    else {
                        System.out.println("Introduceți numărul cardului:");
                        String numarCard = scanner.nextLine();

                        System.out.println("Introduceți CVV-ul:");
                        String cvv = scanner.nextLine();

                        System.out.println("Introduceți data de expirare:");
                        String dataExpirare = scanner.nextLine();

                        Carduri cardNou = clasaServiciu.creeazaCard(numarCard, cvv, dataExpirare, contNou);
                    }
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 6) {
                if(contNou != null) {
                    if(contNou.getCard() != null)
                        clasaServiciu.afiseazaCard(contNou);
                    else
                        System.out.println("Nu aveți un card creat.\n");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 7) {
                System.out.println("Care este numele titularului de cont?");
                String numeTitular = scanner.nextLine();

                System.out.println("Care este IBAN-ul contului de economii?");
                String iban = scanner.nextLine();

                System.out.println("Începând de la ce dată va fi folosit contul?");
                String data = scanner.nextLine();

                System.out.println("Care este suma maximă pe care o poate deține contul?");
                double sumaMaximaAdmisa = scanner.nextDouble();
                scanner.nextLine();


                extrasDeCont = new ExtrasDeCont();
                contNouEconomii = clasaServiciu.creeazaContEconomii(numeTitular, iban, extrasDeCont, data, sumaMaximaAdmisa);
            }

            else if(numar == 8) {
                if(contNouEconomii != null) {
                    System.out.println("Ce sumă doriți să retrageți?");

                    int sumaRetrasa = scanner.nextInt();
                    scanner.nextLine();

                    if (sumaRetrasa <= contNouEconomii.getTotalBaniCont()) {
                        System.out.println("La ce dată doriți să retrageți banii?");
                        String dataRetragere = scanner.nextLine();

                        contNouEconomii.retrageBani(sumaRetrasa, dataRetragere);
                    } else
                        System.out.println("Nu aveți destui bani în contul de economii.\n");
                }
                else
                    System.out.println("Nu aveți un cont de economii creat.\n");
            }

            else if(numar == 9) {
                if(contNouEconomii != null) {
                    System.out.println("Ce sumă doriți să depuneți?");

                    int sumaDepusa = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("La ce dată doriți să depuneți banii?");
                    String dataRetragere = scanner.nextLine();

                    contNouEconomii.depuneBani(sumaDepusa, dataRetragere);
                }
                else
                    System.out.println("Nu aveți un cont de economii creat.\n");
            }

            else if(numar == 10) {
                if(contNouEconomii != null) {
                    System.out.println("Introduceți numărul de ani care vă interesează pentru calcularea dobânzii:");
                    int ani = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Dobânda este egală cu " + contNouEconomii.calculeazaDobanda(ani) + " lei");
                }
                else
                    System.out.println("Nu aveți un cont de economii creat.\n");
            }

            else if(numar == 11) {
                if(contNou != null) {
                    System.out.println("Alege tipul serviciului: Imprumut / ComandaCard");

                    String alegere = scanner.nextLine();

                    if (alegere == "Imprumut") {
                        System.out.println("Ce sumă doriți să împrumutați?");
                        double suma = scanner.nextDouble();
                        scanner.nextLine();

                        clasaServiciu.imprumut(suma, contNou);
                    }
                    else if (alegere == "ComandaCard") {
                        System.out.println("Ce culoare doriți să fie cardul?");
                        String culoare = scanner.nextLine();

                        clasaServiciu.comandaCard(culoare);
                    }
                    else
                        System.out.println("Ați introdus greșit tipul serviciului");
                }
                else
                    System.out.println("Nu aveți un cont creat.\n");
            }

            else if(numar == 12) {
                System.out.println("Vă mulțumim! O zi bună!");
                break;
            }

        }



    }
}
