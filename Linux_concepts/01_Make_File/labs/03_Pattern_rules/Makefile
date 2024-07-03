cc = gcc
INC= -I ./Includes
src = $(wildcard *.c)

obj=(src:.c=.o)

projectName= iti.elf

all: $(projectName)

%.o : %c
	$(cc) $(INC) -c $<

$(projectName) : $(obj)
	$(cc) $(INC) $(obj) -o $@


