`timescale 1ns / 1ns
`include "addsub.v"

module addsub_tb();

    reg M;
    reg [3:0] X, Y;
    wire [3:0] S;
    wire carryout;

    addsub uut (
        .M(M),
        .X(X),
        .Y(Y),
        .S(S),
        .carryout(carryout)
    );

    initial begin
    
    $dumpfile("addsub_tb.vcd");
$dumpvars(0, addsub_tb);
 
        X = 4'b0101; Y = 4'b0011; M = 0;
        #10;
        
        X = 4'b0101; Y = 4'b0011; M = 1;
        #10;

        X = 4'b0011; Y = 4'b0101; M = 1;
        #10;

        X = 4'b1111; Y = 4'b0001; M = 0;
        #10;

        X = 4'b0010; Y = 4'b1000; M = 1;
        #10;
 
    end

endmodule

