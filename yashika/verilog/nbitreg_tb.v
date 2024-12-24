`timescale 1ns/1ns
module N_bit_register_TB();

    // Declare signals
    reg [7:0] D;        // 8-bit input data for this example
    reg clk;            // Clock signal
    reg reset;          // Reset signal
    wire [7:0] Q;       // 8-bit output data for this example

    // Instantiate the N-bit register with N=8 (you can change N for testing different sizes)
    N_bit_register #(.N(8)) uut (
        .D(D),
        .clk(clk),
        .reset(reset),
        .Q(Q)
    );

    // Clock generation (period = 20 ns)
    always begin
        #10 clk = ~clk;  // Toggle clock every 10 ns (clock period = 20 ns)
    end

    // Test sequence
    initial begin
        // Initialize signals
        clk = 0;
        reset = 0;
        D = 8'b00000000;  // Set D to 0 initially

        // Dump waveform to VCD file
        $dumpfile("N_bit_register_TB.vcd");
        $dumpvars(0, N_bit_register_TB);

        // Apply reset
        #5 reset = 1;   // Assert reset
        #10 reset = 0;  // Deassert reset

        // Apply input data and check the output
        D = 8'b10101010;  // Apply some value to D
        #20;              // Wait for 1 clock cycle

        D = 8'b11110000;  // Change D value
        #20;              // Wait for 1 clock cycle

        D = 8'b01010101;  // Change D value
        #20;              // Wait for 1 clock cycle

        // Test reset again
        #5 reset = 1;     // Assert reset again
        #10 reset = 0;    // Deassert reset again

        // Finish the test
        $display("Test complete");
        $finish;
    end

endmodule

