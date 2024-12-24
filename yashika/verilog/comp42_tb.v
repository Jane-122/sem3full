module tb_comparator_4bit;

    reg [3:0] A;    // 4-bit input A
    reg [3:0] B;    // 4-bit input B
    wire A_greater, A_equal, A_less;  // Outputs for comparison

    // Instantiate the 4-bit comparator
    comparator_4bit uut (
        .A(A),
        .B(B),
        .A_greater(A_greater),
        .A_equal(A_equal),
        .A_less(A_less)
    );

    // Test stimulus
    initial begin
        // Test Case 1: A = 4'b0101 (5), B = 4'b0011 (3)
        A = 4'b0101; B = 4'b0011;
        #10;
        
        // Test Case 2: A = 4'b1001 (9), B = 4'b1001 (9)
        A = 4'b1001; B = 4'b1001;
        #10;
        
        // Test Case 3: A = 4'b0001 (1), B = 4'b1010 (10)
        A = 4'b0001; B = 4'b1010;
        #10;

        // Test Case 4: A = 4'b1100 (12), B = 4'b0111 (7)
        A = 4'b1100; B = 4'b0111;
        #10;
        
        // Test Case 5: A = 4'b0011 (3), B = 4'b0101 (5)
        A = 4'b0011; B = 4'b0101;
        #10;
        
        $finish;
    end

    // Monitor the outputs
    initial begin
        $monitor("Time = %0t, A = %b, B = %b, A_greater = %b, A_equal = %b, A_less = %b", $time, A, B, A_greater, A_equal, A_less);
    end

endmodule

