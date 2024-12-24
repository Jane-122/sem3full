module decodergate(i, o);
    input [3:0] i;
    output reg [15:0] o;

    always @(*)
    begin
        case(i)
            4'd0: o = 16'd1;
            4'd1: o = 16'd2;
            4'd2: o = 16'd4;
            4'd3: o = 16'd8;
            4'd4: o = 16'd16;
            4'd5: o = 16'd32;
            4'd6: o = 16'd64;
            4'd7: o = 16'd128;
            4'd8: o = 16'd256;
            4'd9: o = 16'd512;
            4'd10: o = 16'd1024;
            4'd11: o = 16'd2048;
            4'd12: o = 16'd4096;
            4'd13: o = 16'd8192;
            4'd14: o = 16'd16384;
            4'd15: o = 16'd32768;
            default: o = 16'd0;
        endcase
    end
endmodule

module orgatefinal(in, f);
    input [3:0] in;
    output f;
    wire [15:0] o;

    decodergate dg (
        .i(in),
        .o(o)
    );

    assign f = o[2] | o[3] | o[4] | o[5] | o[6] | o[7] | o[10] | o[11] | o[12] | o[15];
endmodule

