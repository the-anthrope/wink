# Internals: how the original is put together

Background for the curious. You do not need this folder to follow the
[build track](../build/README.md); it is here so that every statement
elsewhere can be traced back to a file, a format or a class.

| Folder | Question | Notes |
|---|---|---|
| [`identity/`](identity/01-what-is-this-file.md) | What is this file, who made it, when? | [what it is](identity/01-what-is-this-file.md), [packaging and dates](identity/02-packaging-and-dates.md), [glossary](identity/03-glossary.md) |
| [`code/`](code/01-class-map.md) | How is the program organised? | [class map](code/01-class-map.md), [boot sequence](code/02-boot-sequence.md), [reading obfuscated code](code/03-reading-the-obfuscated-code.md) |
| [`assets/`](assets/01-file-inventory.md) | What ships besides code? | [file inventory](assets/01-file-inventory.md), [text and settings](assets/02-text-and-settings.md), [fonts and sound](assets/03-fonts-and-sound.md), [sprite sheets](assets/04-sprite-sheets-at-a-glance.md) |
| [`data-formats/`](data-formats/01-sn8p-text-file.md) | How is each data file laid out? | [`sn8p`](data-formats/01-sn8p-text-file.md), [`i0`](data-formats/02-i0-sprite-container.md), [`a` and `d`](data-formats/03-a-balance-tables.md), [`d0` and `ml`](data-formats/04-d0-and-ml.md), [terrain](data-formats/05-terrain-m-files.md), [missions](data-formats/06-mission-mi-files.md) |
| [`online-and-payments/`](online-and-payments/01-sms.md) | What does it do beyond the game? | [SMS](online-and-payments/01-sms.md), [online account](online-and-payments/02-herocraft-account.md), [updates and adverts](online-and-payments/03-updates-ads-more-games.md), [integrity checks](online-and-payments/04-integrity-checks.md) |

## What a builder might still take from here

- [Glossary](identity/03-glossary.md): the vocabulary used across all notes.
- [Reading obfuscated code](code/03-reading-the-obfuscated-code.md): how to
  find your way in the decompiled source when you want to check something.
- [Data formats](data-formats/03-a-balance-tables.md): compact, loader-first
  file layouts. Useful as examples, and as a list of what to name better.
- [Text and settings](assets/02-text-and-settings.md): one file that is
  both configuration and language pack.
