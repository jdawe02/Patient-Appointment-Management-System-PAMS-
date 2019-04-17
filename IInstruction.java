
public class IInstruction extends Instruction{
	
	private int a;
	private int b;
	private int f;
	private int imm12;
	private int l;
	private int r;
	
	RegisterFile registerFile;
	public IInstruction(int instructionNumber, String instructionText, String instructionBinary) {
		super(instructionNumber, instructionText, instructionBinary);
		a = Integer.parseInt(instructionBinary.substring(6, 11),2);
		b = Integer.parseInt(instructionBinary.substring(11, 16),2);
		String fS =instructionBinary.substring(16, 20); 
		f = Integer.parseInt(fS,2);
		imm12 = Integer.parseInt(instructionBinary.substring(20, 32),2);
		String opcodeS = instructionBinary.substring(0, 6);
		int opcode = Integer.parseInt(opcodeS,2);
		setInstructionOpcode(opcode);

	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getF() {
		return f;
	}


	public int getImm12() {
		return imm12;
	}
	
	public void execute(ProgramCounter pc, RegisterFile r) {
		registerFile = r;
		if(getInstrcutionOpcode() == 32 && f == 0) {
			ADD();
		}else if(getInstrcutionOpcode() == 32 && f == 1) {
			NADD();
		}else if(getInstrcutionOpcode() == 32 && f == 2) {
			AND();
		}else if(getInstrcutionOpcode() == 32 && f == 3) {
			CAND();
		}else if(getInstrcutionOpcode() == 33 && f == 4) {
			OR();
		}else if(getInstrcutionOpcode() == 33 && f == 5) {
			COR();
		}else if(getInstrcutionOpcode() == 33 && f == 6) {
			XOR();
		}else if(getInstrcutionOpcode() == 33 && f == 7) {
			SET();
		}else if(getInstrcutionOpcode() == 34 && f == 8) {
			EQ();
		}else if(getInstrcutionOpcode() == 34 && f == 9) {
			NE();
		}else if(getInstrcutionOpcode() == 34 && f == 10) {
			LT();
		}else if(getInstrcutionOpcode() == 34 && f == 11) {
			GE();
		}else if(getInstrcutionOpcode() == 35 && f == 12) {
			LTU();
		}else if(getInstrcutionOpcode() == 35 && f == 13) {
			GEU();
		}else if(getInstrcutionOpcode() == 35 && f == 14) {
			MIN();
		}else if(getInstrcutionOpcode() == 35 && f == 15) {
			MAX();
		}else if(getInstrcutionOpcode() == 37 && f == 0) {
			SHLR();
		}else if(getInstrcutionOpcode() == 37 && f == 1) {
			SHLR();
		}else if(getInstrcutionOpcode() == 37 && f == 2) {
			SALR();
		}else if(getInstrcutionOpcode() == 37 && f == 3) {
			ROR();
		}else if(getInstrcutionOpcode() == 37 && f == 8) {
			MUL();
		}else if(getInstrcutionOpcode() == 37 && f == 12) {
			DIV();
		}else if(getInstrcutionOpcode() == 37 && f == 13) {
			MOD();
		}else if(getInstrcutionOpcode() == 37 && f == 14) {
			DIVU();
		}else if(getInstrcutionOpcode() == 37 && f == 15) {
			MODU();
		}else if(getInstrcutionOpcode() == 36 && f == 0) {
			ADD();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 1) {
			NADD();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 2) {
			AND();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 3) {
			CAND();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 4) {
			OR();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 5) {
			COR();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 6) {
			XOR();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 7) {
			SET();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 8) {
			EQ();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 9) {
			NE();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 10) {
			LT();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 11) {
			GE();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 12) {
			LTU();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 13) {
			GEU();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 14) {
			MIN();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}else if(getInstrcutionOpcode() == 36 && f == 15) {
			MAX();
                        pc.setProgramCounter(registerFile.getRegister(31));
		}

		
		
		

		pc.setProgramCounter(pc.getProgramCounter()+1);
	}
        /*
        ALU INTSTRUCTIONS (I-FORMAT)
        */
	private void ADD() {
            registerFile.setRegister(b, registerFile.getRegister(a) + imm12);
	}
        
        private void AND() {
            registerFile.setRegister(b, registerFile.getRegister(a) & imm12);
	}
        
        private void OR() {
            registerFile.setRegister(b, registerFile.getRegister(a) | imm12);
	}
        
        private void XOR() {
            registerFile.setRegister(b, registerFile.getRegister(a) ^ imm12);
	}
        
        private void NADD() {
            registerFile.setRegister(b, (registerFile.getRegister(a)*-1) + imm12);
	}
        
        private void CAND() {
            registerFile.setRegister(b, ~registerFile.getRegister(a) & imm12);
	}
        
        private void COR() {
            registerFile.setRegister(b, ~registerFile.getRegister(a) | imm12);
	}
        
        private void SET() {
            registerFile.setRegister(b,imm12);
	}
        
         private void SUB() {
             ADD();
	}
        
        private void ANDC() {
            ADD();
	}
        
        private void ORC() {
            OR();
        }
        
          private void XNOR() {
             XOR();
	}
        
        private void MOV() {
            OR();
	}
        
        private void NEG() {
            NADD();
        }
        
        private void NOT() {
            COR();
        }
        /*
        ALU INTSTRUCTIONS (I-FORMAT)
        */
        
        /*
        ALU COMPARE INTSTRUCTIONS (I-FORMAT)
        */
	private void EQ() {
            if(registerFile.getRegister(a)==imm12){
                registerFile.setRegister(b, 1);
            }else{
                registerFile.setRegister(b, -1);
            }
	}
        
        private void NE() {
           if(registerFile.getRegister(a)!=imm12){
                registerFile.setRegister(b, 1);
            }else{
                registerFile.setRegister(b, -1);
            }
	}
        
        private void LT() {
            if(registerFile.getRegister(a)<imm12){
                registerFile.setRegister(b, 1);
            }else{
                registerFile.setRegister(b, -1);
            }
	}
        
        private void GE() {
            if(registerFile.getRegister(a)>=imm12){
                registerFile.setRegister(b, 1);
            }else{
                registerFile.setRegister(b, -1);
            }
	}
        
        private void LTU() {
            if(registerFile.getRegister(a)<imm12){
                registerFile.setRegister(b, 1);
            }else{
                registerFile.setRegister(b, -1);
            }
	}
        
        private void GEU() {
            if(registerFile.getRegister(a)>=imm12){
                registerFile.setRegister(b, 1);
            }else{
                registerFile.setRegister(b, -1);
            }
	}
        
        private void MIN() {
            if(registerFile.getRegister(a)<imm12){
                registerFile.setRegister(b, registerFile.getRegister(a));
            }else if(registerFile.getRegister(a)>imm12){
                registerFile.setRegister(b, imm12);
            }else{
                registerFile.setRegister(b,1);
            }
	}
        
        private void MAX() {
            if(registerFile.getRegister(a)>imm12){
                registerFile.setRegister(b, registerFile.getRegister(a));
            }else if(registerFile.getRegister(a)<imm12){
                registerFile.setRegister(b, imm12);
            }else{
                registerFile.setRegister(b,1);
            }
	}
        
         private void GT() {
             GE();
	}
        
        private void LE() {
            LT();
	}
        
        private void GTU() {
            GEU();
        }
        
        private void LEU() {
            LEU();
        }
        /*
        ALU INTSTRUCTIONS (I-FORMAT)
        */
        
        /*
        ALU SHIFT AND ROTATE INTSTRUCTIONS (I-FORMAT)
        */
	private void SHLR() {
            int x=registerFile.getRegister(a);
                x=x<<l;
                x=x>>>r;
		registerFile.setRegister(b, x);
	}
        
        private void SALR() {
            int x=registerFile.getRegister(a);
                x=x<<l;
                x=x>>r;
		registerFile.setRegister(b, x);
	}
        
        private void ROR() {
            int x=registerFile.getRegister(a);
                x=Integer.rotateRight(x, r);
		registerFile.setRegister(b, x);
	}
        
        private void SHL() {
            SHLR();
	}
        
        private void SHR() {
            SHLR();
	}
        
        private void SAR() {
            SALR();
	}
        
	private void ROL() {
            ROR();
	}
        /*
        ALU SHIFT AND ROTATE INTSTRUCTIONS (I-FORMAT)
        */
        
        /*
        ALU MULTIPLY AND DIVIDE INTSTRUCTIONS (I-FORMAT)
        */
	private void MUL() {
            registerFile.setRegister(b, registerFile.getRegister(a) * imm12);
	}
        
        private void DIV() {
            registerFile.setRegister(b, registerFile.getRegister(a) / imm12);
	}
        
        private void MOD() {
            registerFile.setRegister(b, registerFile.getRegister(a) % imm12);
	}
        
        private void DIVU() {
            registerFile.setRegister(b, registerFile.getRegister(a) / imm12);
	}
        
        private void MODU() {
            registerFile.setRegister(b, registerFile.getRegister(a) % imm12);
	}
        /*
        ALU MULTIPLY AND DIVIDE INTSTRUCTIONS (I-FORMAT)
        */
       
}

