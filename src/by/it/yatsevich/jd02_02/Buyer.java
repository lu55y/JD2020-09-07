package by.it.yatsevich.jd02_02;

class Buyer extends Thread implements IBayer, IUseBasket {

    public Buyer(int number) {
        super("Bayer №"+number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        Supervisor.COUNTS_OF_GOODS= Helper.getRandomGoods();
        chooseGoods();
        putGoodsToBasket();
        goOut();
//        Supervisor.COUNTS_OF_GOODS=1;
        Supervisor.BUYER_IN_THE_SHOP--;
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n",this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s starting choose\n",this);
//        Supervisor.COUNTS_OF_GOODS=Helper.getRandomGoods();
        int timeout= Supervisor.COUNTS_OF_GOODS * Helper.getRandom(500,2000);
        Helper.buyerSleep(timeout);
        System.out.printf("%s wonna %d good\n",this, Supervisor.COUNTS_OF_GOODS);

    }

    @Override
    public void goOut() {
        System.out.printf("%s buyer go out\n",this);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s buyer get basket\n",this);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s put %d goods to basket\n",this, Supervisor.COUNTS_OF_GOODS);
        Basket.putToBasket(Supervisor.COUNTS_OF_GOODS);
        System.out.println(Basket.temp);
        System.out.printf("Total purchase value : %3d$\n", Basket.costOfGoods);
        System.out.printf("%s finished choose\n",this);
    }
}
