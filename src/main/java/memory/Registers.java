package memory;

import exceptions.UnknownRegister;
import java.util.Arrays;
import java.util.List;

public class Registers {
	
	private final List<Integer> registers = Arrays.asList(new Integer[33]);
	
	public int getRegister(RegisterNames register) {
		return registers.get(register.getIndex());
	}
	
	public void setRegister(RegisterNames register, int value) {
		registers.set(register.getIndex(), value);
	}
	
	public enum RegisterNames {
		x0(0), zero(0),
		x1(1), ra(1),
		x2(2), sp(2),
		x3(3), gp(3),
		x4(4), tp(4),
		x5(5), t0(5),
		x6(6), t1(6),
		x7(7), t2(7),
		x8(8), s0(8), fp(8),
		x9(9), s1(9),
		x10(10), a0(10),
		x11(11), a1(11),
		x12(12), a2(12),
		x13(13), a3(13),
		x14(14), a4(14),
		x15(15), a5(15),
		x16(16), a6(16),
		x17(17), a7(17),
		x18(18), s2(18),
		x19(19), s3(19),
		x20(20), s4(20),
		x21(21), s5(21),
		x22(22), s6(22),
		x23(23), s7(23),
		x24(24), s8(24),
		x25(25), s9(25),
		x26(26), s10(26),
		x27(27), s11(27),
		x28(28), t3(28),
		x29(29), t4(29),
		x30(30), t5(30),
		x31(31), t6(31),
		pc(32);
		
		
		private final int index;
		
		RegisterNames(int index) {
			this.index = index;
		}
		
		static RegisterNames getRegisterName(int index) {
			return switch (index) {
				case 0 -> x0;
				case 1 -> x1;
				case 2 -> x2;
				case 3 -> x3;
				case 4 -> x4;
				case 5 -> x5;
				case 6 -> x6;
				case 7 -> x7;
				case 8 -> x8;
				case 9 -> x9;
				case 10 -> x10;
				case 11 -> x11;
				case 12 -> x12;
				case 13 -> x13;
				case 14 -> x14;
				case 15 -> x15;
				case 16 -> x16;
				case 17 -> x17;
				case 18 -> x18;
				case 19 -> x19;
				case 20 -> x20;
				case 21 -> x21;
				case 22 -> x22;
				case 23 -> x23;
				case 24 -> x24;
				case 25 -> x25;
				case 26 -> x26;
				case 27 -> x27;
				case 28 -> x28;
				case 29 -> x29;
				case 30 -> x30;
				case 31 -> x31;
				default -> throw new UnknownRegister(index);
			};
		}
		
		public int getIndex() {
			return index;
		}
	}
}
