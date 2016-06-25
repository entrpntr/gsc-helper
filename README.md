# GSC Helper
GSC Helper is a DV calculator program to assist Pokemon Gold/Silver/Crystal speedrunners in determining stats, and includes a display for showing DVs on stream layouts. There are plans for future versions of the program to provide general routing tools as well.

## Screenshot
![Logo](https://dl.dropboxusercontent.com/u/460442/GSC_DV_Helper-0.99.png)

## Usage
Java 7+ Runtime Environment is required (download [here](https://java.com/en/download/)).

See [this thread](http://forums.pokemonspeedruns.com/viewtopic.php?f=116&t=512) on the PSR forums to download the latest release. Unzip the contents, and double click the .jar file to start up the helper program. 

During a run, click the buttons corresponding to in-game events that take place, and the program will track your stats and experience. Be sure to input game events in the correct order, or the stat calculations may be inaccurate.
 
Advanced users who have memorized DVs can bypass general usage and simply manually click the DV labels for each stat (you'll see a green outline appear around the adjacent button).

As in Red and Yellow Helper, custom look-and-feel settings are automatically saved for future sessions.

## Development Environment
Java 7+ SDK is assumed.

The build system uses Gradle. You can simply run the gradle wrapper to build (gradlew.bat on Windows, gradlew on UNIX systems; note that the first build with the wrapper is slow, but future builds are much faster). Alternatively, you can choose to download the Gradle distribution [here](http://gradle.org/gradle-download/); there is more setup involved, but builds will be appreciably quicker. 

By default, the gradle build creates a usable directory with the .jar executable (in the build/install/GSCHelper directory), as well as a distributable .zip file (build/distributions directory).

## Copyright and license

    GSC Helper - a DV calculator and routing tool for Pokémon Gold/Silver/Crystal speedruns
    
    GSC Helper was derived from Yellow Helper by Dailyleaf. Per Dailyleaf's request, if you choose
    to reuse this code, please credit him, as well as BobChao87 (for his work on a prior DV
    calculator that inspired Red Helper and Yellow Helper). Keeping this notice in your source code
    repository suffices for this purpose. Also per Dailyleaf's request, please do not ask for
    donations for any work that reuses this code.
    
    In addition to Yellow Helper, some GSC Helper code is borrowed from RouteTwo (created by 
    Dabomstew).
    
        Copyright (C) 2016 entrpntr
    
        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.
    
        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.
    
        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
    Pokémon is owned by Nintendo.