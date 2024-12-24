module tb_ShiftRegister_6bit;

    // Testbench signals
    reg clk;               // Clock signal
    reg reset;             // Reset signal
    reg shift_in;          // Data input to the shift register
    wire [5:0] q;          // 6-bit output from the shift register

    // Instantiate the 6-bit Shift Register (UUT - Unit Under Test)
    ShiftRegister_6bit uut (
        .clk(clk),
        .reset(reset),
        .shift_in(shift_in),
        .q(q)
    );

    // Clock generation (period = 10 time units)
    always begin
        #5 clk = ~clk;  // Toggle clock every 5 time units (10 time units period)
    end

    // Test sequence
    initial begin
        // Initialize signals
        clk = 0;
        reset = 0;
        shift_in = 0;

        // Monitor the output of the shift register
        $monitor("Time = %0t, Reset = %b, shift_in = %b, Q = %b", $time, reset, shift_in, q);

        // Generate a random 6-bit value
        reg [5:0] random_value;
        random_value = $random;  // Get a random 32-bit value
        random_value = random_value[5:0];  // Take the lower 6 bits of the random value

        // Print the random value to verify
        $display("Random 6-bit value = %b", random_value);

        // Test 1: Shift the random 6-bit value through the shift register
        #10;  // Wait for initial clock cycle
        
        // Shift each bit from random_value into the shift register using a for loop
        for (integer i = 0; i < 6; i = i + 1) begin
            shift_in = random_value[i];  // Feed each bit of the random_value into the shift register
            #10;  // Wait for one clock cycle before feeding the next bit
        end

        // Test 2: Assert reset and verify shift register clears
        #10 reset = 1;  // Assert reset (clear the shift register)
        #10 reset = 0;  // Deassert reset
        
        // Test 3: Shift the random 6-bit value again after reset
        for (integer i = 0; i < 6; i = i + 1) begin
            shift_in = random_value[i];  // Feed each bit of the random_value into the shift register again
            #10;  // Wait for one clock cycle before feeding the next bit
        end

        // End the simulation
        #10 $finish;
    end

endmodule

