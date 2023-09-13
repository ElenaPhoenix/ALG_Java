using BenchmarkDotNet.Running;

namespace ArraySortTests
{
    internal class Program
    {
        static void Main(string[] args)
        {
            BenchmarkSwitcher
             .FromAssembly(typeof(Program).Assembly)
             .Run(args, new BenchmarkDotNet.Configs.DebugInProcessConfig());



            BenchmarkRunner.Run<SortTests>();
        }
    }
}