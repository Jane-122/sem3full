module bcd_adder (
    input [7:0] A,       // 2-digit BCD number A (A1A0 B1B0)
    input [7:0] B,       // 2-digit BCD number B (A1A0 B1B0)
    output [7:0] SUM,    // 2-digit BCD sum (A1A0 B1B0)
    output CARRY         // Carry output (for overflow)
);

    wire [3:0] sum0, sum1;     // Intermediate sum for each digit
    wire c0, c1;               // Carry for each digit addition

    // Add the first (least significant) digit
    full_adder fa0 (
        .A(A[3:0]),
        .B(B[3:0]),
        .Cin(0),          // No carry-in for the least significant digit
        .S(sum0),
        .Cout(c0)
    );

    // If sum0 exceeds 9, add 6 (0110) to adjust
    // sum0 > 9 if the sum is greater than 9, we need to add 6 to get a valid BCD
    assign sum0 = (sum0 > 9) ? sum0 + 6 : sum0;

    // Add the second (most significant) digit with carry-in
    full_adder fa1 (
        .A(A[7:4]),
        .B(B[7:4]),
        .Cin(c0),        // Carry-in from the previous digit
        .S(sum1),
        .Cout(c1)
    );

    // If sum1 exceeds 9, add 6 (0110) to adjust
    assign sum1 = (sum1 > 9) ? sum1 + 6 : sum1;

    // Final sum output (8 bits, A1A0 B1B0)
    assign SUM = {sum1, sum0};

    // Final carry output (if there is overflow in the tens place)
    assign CARRY = c1;

endmodule


module full_adder (
    input A,    // Single-bit input A
    input B,    // Single-bit input B
    input Cin,  // Carry-in from the previous bit
    output S,   // Sum output
    output Cout // Carry-out to the next bit
);
    // Sum is the XOR of A, B, and Cin
    assign S = A ^ B ^ Cin;

    // Carry-out is the OR of the AND combinations
    assign Cout = (A & B) | (A & Cin) | (B & Cin);
endmodule

