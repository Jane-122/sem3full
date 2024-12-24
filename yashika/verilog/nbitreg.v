module N_bit_register #(parameter N = 8) (
    input [N-1:0] D,      // Input data (N bits)
    input clk,             // Clock signal
    input reset,           // Reset signal (active high)
    output reg [N-1:0] Q   // Output data (N bits)
);

    // Always block for updating register on the rising edge of the clock
    always @(posedge clk or posedge reset) begin
        if (reset) 
            Q <= 0;      // Reset the register to 0
        else
            Q <= D;      // Load the input data (D) into the register
    end

endmodule

