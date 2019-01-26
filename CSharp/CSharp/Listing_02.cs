using System;
using System.Threading.Tasks;

namespace CSharp
{
    class Listing_02
    {
        static void Main(string[] args)
        {
            Task t1 = FibonacciTask(40);
            Task t2 = FibonacciTask(45);
            t1.Start();
            Console.WriteLine("1");
            t2.Start();
            Console.WriteLine("2");
            Task.WaitAll(new Task[] { t1, t2 });
            Console.WriteLine("Fertig");
        }

        static Task FibonacciTask(int n)
        {
            return new Task(() =>
            {
                Console.WriteLine($"Berechne fib({n})");
                Console.WriteLine($"fib({n}) = {Fibonacci(n)}");
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
