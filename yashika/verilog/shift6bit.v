module ShiftRegister_6bit (
    input wire clk,       // Clock signal
    input wire reset,     // Synchronous active-high reset
    input wire shift_in,  // Data input to the first flip-flop
    output wire [5:0] q   // 6-bit output
);

    // Declare internal flip-flops for each bit of the shift register
    wire q0, q1, q2, q3, q4, q5;

    // Instantiate 6 D Flip-Flops (one for each bit)
    DFF dff0 (
        .clk(clk),
        .reset(reset),
        .D(shift_in),   // First flip-flop gets input data
        .Q(q0)
    );

    DFF dff1 (
        .clk(clk),
        .reset(reset),
        .D(q0),         // Second flip-flop gets the value of q0
        .Q(q1)
    );

    DFF dff2 (
        .clk(clk),
        .reset(reset),
        .D(q1),         // Third flip-flop gets the value of q1
        .Q(q2)
    );

    DFF dff3 (
        .clk(clk),
        .reset(reset),
        .D(q2),         // Fourth flip-flop gets the value of q2
        .Q(q3)
    );

    DFF dff4 (
        .clk(clk),
        .reset(reset),
        .D(q3),         // Fifth flip-flop gets the value of q3
        .Q(q4)
    );

    DFF dff5 (
        .clk(clk),
        .reset(reset),
        .D(q4),         // Sixth flip-flop gets the value of q4
        .Q(q5)
    );

    // Assign the outputs to the 6-bit output register
    assign q = {q5, q4, q3, q2, q1, q0};

endmodule

// D Flip-Flop module (used for the shift register)
module DFF (
    input wire clk,    // Clock input
    input wire reset,  // Reset input
    input wire D,      // Data input
    output reg Q       // Output of the flip-flop
);

    // Always block triggered on positive edge of clock or reset
    always @(posedge clk or posedge reset) begin
        if (reset)      // If reset is high, output Q is reset to 0
            Q <= 0;
        else
            Q <= D;    // Otherwise, Q follows D on the rising edge of clk
    end

endmodule

