package hiringchallenges;

/**
 * Created by hardCode on 4/6/2017.
 */
import java.util.*;
import java.util.concurrent.*;

public class Stats {

    static class Stock{
        double average,currentPrice;
        int count;

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public double getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(double currentPrice) {
            this.currentPrice = currentPrice;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void updateStock(double newPrice){
            currentPrice=newPrice;
            average=(average*count+newPrice)/(count+1);
            count++;

        }
    }

    public static class StatisticsAggregatorImpl implements StatisticsAggregator {

        ConcurrentHashMap<String,Stock>stockDetail=new ConcurrentHashMap<>();

        @Override
        public void putNewPrice(String symbol, double price) {
                if (stockDetail.containsKey(symbol)){
                    Stock s=stockDetail.get(symbol);
                    s.updateStock(price);
                }
        }

        @Override
        public double getAveragePrice(String symbol) {
            return stockDetail.get(symbol).getAverage();
            // YOUR CODE HERE
        }

        @Override
        public int getTickCount(String symbol) {
            return stockDetail.get(symbol).getCount();
            // YOUR CODE HERE
        }
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface StatisticsAggregator {
        // This is an input. Make note of this price.
        public void putNewPrice(String symbol, double price);

        // Get the average price
        public double getAveragePrice(String symbol);

        // Get the total number of prices recorded
        public int getTickCount(String symbol);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final StatisticsAggregator stats = new StatisticsAggregatorImpl();
            final Set<String> symbols = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            int threads = Integer.parseInt(inputs[0]);
            ExecutorService pool = Executors.newFixedThreadPool(threads);
            for (int i = 1; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String symbol = tokens[0];
                symbols.add(symbol);
                final double price = Double.parseDouble(tokens[1]);
                pool.submit(new Runnable() {
                    @Override
                    public void run() {
                        stats.putNewPrice(symbol, price);
                    }
                });

            }
            pool.shutdown();
            try {
                pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (String symbol : symbols) {
                System.out.println(String.format("%s %.4f %d", symbol,
                        stats.getAveragePrice(symbol),
                        stats.getTickCount(symbol)));
            }
        }
        scanner.close();

    }
}