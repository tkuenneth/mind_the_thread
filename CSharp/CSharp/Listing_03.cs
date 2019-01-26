using System;
using System.Threading.Tasks;

namespace CSharp
{
    public class Listing_03
    {
        static void Main(string[] args)
        {
            Task t1 = FibonacciTask(40);
            Console.WriteLine("1");
            Task t2 = FibonacciTask(45);
            Console.WriteLine("2");
            Task.WaitAll(new Task[] { t1, t2 });
            Console.WriteLine("Fertig");
        }

        static async Task FibonacciTask(int f)
        {
            await Task.Run(() =>
            {
                Console.WriteLine($"Berechne fib({f})");
                Console.WriteLine($"fib({f}) = {Fibonacci(f)}");
            });
        }

        static long Fibonacci(int n)
        {
            if (n <= 1)
            {
                return n;
            }
            return Fibonacci(n - 1) +
                    Fibonacci(n - 2);
        }
    }
}
