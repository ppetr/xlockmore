#!/bin/sh
#echo $1
if test -c /dev/audio; then
  cat $1 > /dev/audio
elif test -c /dev/dsp; then
  cat $1 > /dev/dsp
fi
