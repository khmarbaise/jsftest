#!/bin/bash
find -type f -name ".classpath" -print0 | xargs -0 rm
find -type f -name ".project" -print0 | xargs -0 rm
find -type d -name ".settings" -print0 | xargs -0 rm -fr
find -type d -name ".myeclipse" -print0 | xargs -0 rm -fr
find -type d -name ".metadata" -print0 | xargs -0 rm -fr
