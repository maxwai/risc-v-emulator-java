# Risc-V emulator java

![Java](https://badgen.net/badge/language/Java/green)
![Java](https://badgen.net/badge/Java/JDK-17/green)
[![GitHub license](https://badgen.net/github/license/maxwai/risc-v-emulator-java)](LICENSE)

Emulator that I am starting to programm to execute RISC-V Instructions

## Limitations

For now only 32-bit address spaces are supported, XLEN=32 is fixed

The `FENCE` Instruction will do nothing since this would do nothing since the Emulator is alone on
the memory.

The `ECALL` and `EBREAK` will do nothing since Environment Calls are not present.

## Specification

Specification used:
[Volume 1, Unprivileged Spec v. 20191213](https://github.com/riscv/riscv-isa-manual/releases/download/Ratified-IMAFDQC/riscv-spec-20191213.pdf)

## Instruction Set


Following Instructions are planned on being implemented for the moment:

- RV32I Base Instruction Set
- RV32M Standard Extension
