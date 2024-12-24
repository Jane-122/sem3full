module fulladd (Cin, x, y, s, Cout);
    input Cin, x, y;
    output s, Cout;
    assign s = x ^ y ^ Cin;
    assign Cout = (x & y) | (x & Cin) | (y & Cin);
endmodule

module addsub (M, X, Y, S, carryout);
    input M;
    input [3:0] X, Y;
    output [3:0] S;
    output carryout;
    wire [3:1] C;
    wire [3:0] Y_xor;

    assign Y_xor = Y ^ {4{M}};
    fulladd fa0 (M, X[0], Y_xor[0], S[0], C[1]);
    fulladd fa1 (C[1], X[1], Y_xor[1], S[1], C[2]);
    fulladd fa2 (C[2], X[2], Y_xor[2], S[2], C[3]);
    fulladd fa3 (C[3], X[3], Y_xor[3], S[3], carryout);
endmodule

