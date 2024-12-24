module tb_bcd_adder;

    reg [7:0] A, B;  // 2-digit BCD inputs
    wire [7:0] SUM;  // 2-digit BCD sum
    wire CARRY;      // Carry-out

    // Instantiate the BCD adder module
    bcd_adder uut (
        .A(A),
        .B(B),
        .SUM(SUM),
        .CARRY(CARRY)
    );

    // Test stimulus
    initial begin
        // Test case 1: A = 45, B = 38, expected SUM = 83
        A = 8'b01000101;  // 45 in BCD
        B = 8'b00111000;  // 38 in BCD
        #10;
        
        // Test case 2: A = 19, B = 79, expected SUM = 98
        A = 8'b00010001;  // 19 in BCD
        B = 8'b01111001;  // 79 in BCD
        #10;

        // Test case 3: A = 99, B = 99, expected SUM = 198
        A = 8'b10011001;  // 99 in BCD
        B = 8'b10011001;  // 99 in BCD
        #10;

        $finish;
    end

    // Monitor the outputs
    initial begin
        $monitor("Time = %0t, A = %b, B = %b, SUM = %b, CARRY = %b", $time, A, B, SUM, CARRY);
    end

endmodule

