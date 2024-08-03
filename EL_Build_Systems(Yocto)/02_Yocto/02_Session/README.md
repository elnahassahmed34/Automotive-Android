## YOCTO principles 2

## Compnies (Third-Party)
- Push their layer
- should be compatible with poky branches


## Variables -> local vs gloabal
- local -> under .bb .bbapend .class files
- global -> in .conf files
- myvar = " string"
- debug variables with bitbake
    - bitbake getvar
```
# No Spaces are added here
# Needs to add extra space
# Parsed at the end

# Append
A = "foo"
A:append = "bar"
# The final value is A="foobar" 

# Append
A = "foo"
A:append = "bar"
A += "val"
# The final value is A="foo valbar" 

# Append
A = "foo"
A:append = " bar"
# The final value is A="foo bar" 


# Prepend
A = "foo"
A:prepend = "bar"
# The final value is A="barfoo" 

# Prepend
A = "foo"
A:prepend = "bar"
A =+ "val"
# The final value is A="barval foo" 

# Prepend
A = "foo"
A:prepend = "bar "
# The final value is A="bar foo" 

#remove

A = "foo bar"
A:remove = "foo"
# The final value is A=" bar" 

A = "foo bar"
A:remove = "var"
A += "var"
# The final value is A=" foo bar val" 
```

## Local variables
### 1. create a layer
    - outside of poky , OE and third party layers

```
bitbake-layers create-layer meta-iti
ls meta-iti/
```
```
/meta-iti $ tree
.
├── conf
│   └── layer.conf
├── COPYING.MIT
├── README
└── recipes-example
    └── example
        └── example_0.1.bb
```
- conf : has all .conf files (layer.conf)  
- COPYING.MIT  
- README  
- recipes-example


### 2. add layer
- bblayers.conf -> only one file
- include all layers that you will use
- add absolute pass 
```
cd $BUILDDIR
bitbake-layers add-layer ../meta-iti/
bitbake example
```

## oe-init-build-env
1. update path
2. create build env


## Task
1. create env
2. create layer
3. create recipe
4. edit in recipe
    - if (var == 3)
        - display "hi"
    - else
        - display "myfriend"
5. in layer.conf add this var    
6. do it with two methods 
    - bb.append
    - or if condition with python
-














