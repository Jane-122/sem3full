module comparator_2bit (
    input [1:0] A,    // 2-bit input A
    input [1:0] B,    // 2-bit input B
    output reg A_greater,   // A > B
    output reg A_equal,     // A = B
    output reg A_less       // A < B
);

    always @(*) begin
        if (A > B) begin
            A_greater = 1;
            A_equal = 0;
            A_less = 0;
        end else if (A == B) begin
            A_greater = 0;
            A_equal = 1;
            A_less = 0;
        end else begin
            A_greater = 0;
            A_equal = 0;
            A_less = 1;
        end
    end
endmodule


module comparator_4bit (
    input [3:0] A,   // 4-bit input A
    input [3:0] B,   // 4-bit input B
    output reg A_greater,   // A > B
    output reg A_equal,     // A = B
    output reg A_less       // A < B
);

    // Internal wires to connect the 2-bit comparators
    wire A_greater_1, A_equal_1, A_less_1;  // For the upper 2 bits
    wire A_greater_2, A_equal_2, A_less_2;  // For the lower 2 bits

    // Instantiate two 2-bit comparators
    comparator_2bit comp1 (
        .A(A[3:2]),
        .B(B[3:2]),
        .A_greater(A_greater_1),
        .A_equal(A_equal_1),
        .A_less(A_less_1)
    );

    comparator_2bit comp2 (
        .A(A[1:0]),
        .B(B[1:0]),
        .A_greater(A_greater_2),
        .A_equal(A_equal_2),
        .A_less(A_less_2)
    );

    // Logic to determine the overall comparison for 4-bit numbers
    always @(*) begin
        if (A_greater_1) begin
            A_greater = 1;
            A_equal = 0;
            A_less = 0;
        end else if (A_equal_1 && A_greater_2) begin
            A_greater = 1;
            A_equal = 0;
            A_less = 0;
        end else if (A_equal_1 && A_equal_2) begin
            A_greater = 0;
            A_equal = 1;
            A_less = 0;
        end else if (A_equal_2 && A_less_1) begin
            A_greater = 0;
            A_equal = 0;
            A_less = 1;
        end else begin
            A_greater = 0;
            A_equal = 0;
            A_less = 1;
        end
    end
endmodule

