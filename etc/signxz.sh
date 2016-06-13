#!/bin/sh
VERSION=`cat xlock/version.h | cut -d\" -f2`
NAME=xlockmore
PROG=$NAME-$VERSION
PROGZIP=$PROG.tar.xz

#./makexz.sh  [no -p]
cd ..
gpg --print-md SHA1 $PROGZIP > $PROGZIP.sha
gpg --print-md MD5 $PROGZIP > $PROGZIP.md5
gpg --armor --output $PROGZIP.asc --detach-sig $PROGZIP
gpg --verify $PROGZIP.asc $PROGZIP
