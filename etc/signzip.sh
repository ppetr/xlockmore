#!/bin/sh
VERSION=`cat xlock/version.h | cut -d\" -f2`
NAME=xlock95
PROG=$NAME-$VERSION
PROGZIP=$PROG.zip

#./makezip.sh
cd ..
gpg --print-md SHA1 $PROGZIP > $PROGZIP.sha
gpg --print-md MD5 $PROGZIP > $PROGZIP.md5
gpg --armor --output $PROGZIP.asc --detach-sig $PROGZIP
gpg --verify $PROGZIP.asc $PROGZIP
