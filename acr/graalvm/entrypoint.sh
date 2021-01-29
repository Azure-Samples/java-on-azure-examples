#!/bin/sh
"$@" &                                                                                                                   
pid="$!"                                                                                                                 
trap "kill -TERM $pid" INT                                                                                            
wait
