`timescale 1ns / 1ns
`include "bit4adder.v"
module bit4adder_tb();
reg carryin;
reg [3:0] X, Y;
wire [3:0] S;
wire carryout;
bit4adder uut(
    carryin,
    X,
    Y,
    S,
    carryout
);


initial begin

$dumpfile("bit4adder_tb.vcd");
$dumpvars(0, bit4adder_tb);
 
    // Test case 1: Adding 0000 and 0000 with carryin = 0
    #10 X = 4'b0000; Y = 4'b0000; carryin = 0;

    // Test case 2: Adding 0001 and 0001 with carryin = 0
    #10 X = 4'b0001; Y = 4'b0001; carryin = 0;

    // Test case 3: Adding 1111 and 1111 with carryin = 0
    #10 X = 4'b1111; Y = 4'b1111; carryin = 0;

    // Test case 4: Adding 1111 and 1111 with carryin = 1
    #10 X = 4'b1111; Y = 4'b1111; carryin = 1;

    // Test case 5: Adding 0101 and 1010 with carryin = 0
    #10 X = 4'b0101; Y = 4'b1010; carryin = 0;

    // Test case 6: Adding 1010 and 0101 with carryin = 1
    #10 X = 4'b1010; Y = 4'b0101; carryin = 1;

    // Test case 7: Adding 1111 and 0001 with carryin = 1
    #10 X = 4'b1111; Y = 4'b0001; carryin = 1;

    // Test case 8: Adding 0000 and 1111 with carryin = 1
    #10 X = 4'b0000; Y = 4'b1111; carryin = 1;

    
end

endmodule

