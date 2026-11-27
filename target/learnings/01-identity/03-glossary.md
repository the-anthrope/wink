# Words you will meet

> **In one line:** Short definitions, grouped so that look-alike terms sit
> next to each other.

## Phone Java

| Term | One-line meaning |
|---|---|
| **Java ME (J2ME)** | The cut-down Java that ran on feature phones before Android and iOS. |
| **CLDC** | The runtime layer of Java ME: the core language and a tiny class library. |
| **MIDP** | The phone layer on top of CLDC: screens, keys, storage, networking. |
| **MIDlet** | One Java ME app. Its main class extends `MIDlet`, here `aow2`. |
| **JAR** | The zip that holds a MIDlet's classes and resources. This is what we have. |
| **JAD** | A small text file shipped beside the JAR with install info and optional settings. We do not have it. |
| **APK** | Android's app package. Different bytecode, different manifest. Not this. |

## Storage and screens

| Term | One-line meaning |
|---|---|
| **RMS / RecordStore** | MIDP's only persistent storage: named lists of byte records. Saves live here. |
| **Canvas** | A MIDP screen the app draws on pixel by pixel. The whole game is one Canvas (`k`). |
| **Soft keys** | The two keys under the screen. Their key codes differ per phone, so they are settings (`LSK1`, `RSK1`). |

## Reverse engineering

| Term | One-line meaning |
|---|---|
| **Decompile** | Turn bytecode back into readable Java source. Lossy: names and comments are gone. |
| **Disassemble** | Turn bytecode into a list of raw instructions. Exact, harder to read. |
| **Obfuscation** | Renaming everything to `a`, `b`, `c` before shipping, to shrink the JAR and hide intent. |
| **JADX** | The decompiler used here. |
| **REA** | "Reverse Engineer Anything", the toolkit that wraps JADX and other engines. It only inventoried this JAR. |
| **Static analysis** | Reading code and data without running them. Everything in these notes. |

## Names these notes invent

| Term | One-line meaning |
|---|---|
| **Segment (`seg[n]`)** | One of the 139 byte arrays in the balance file `a`. |
| **Short table (`tables[n]`)** | One of the 9 arrays of 16-bit numbers at the end of file `a`. |
| **Unit type id** | Number 0..18 the code uses for a kind of unit. Not the menu order. |
| **Unit index** | Slot 1..100 of one living unit. 1..50 belong to one side, 51..100 to the other. |
| **Observed / Inferred / Unknown** | A line or value shows it / reasoned from what is shown / not established. |

## Game terms

| Term | One-line meaning |
|---|---|
| **Confederation** | The player's side in the campaign. Blue. |
| **Rebels (Resistance)** | The enemy side. Red. |
| **Command center / Headquarters** | The core building of each side. Source of money and of the build radius. |
| **Siege mode** | A stationary firing mode some units can switch into. |
| **Tick** | One step of the game loop. All timers count ticks. |
| **Frame** | One picture cut from a sprite sheet. Several frames in a row make an animation. |

**Next:** [Which class does what?](../02-code/01-class-map.md)
