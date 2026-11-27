# What is the HeroCraft online account for?

> **In one line:** A built-in web client for logging in, syncing
> achievements and buying extra maps with credits; switched off in this
> build.

## The short answer
- Class `f` is a small online client with its own forms: login, register,
  password recovery, profile, map shop.
- It talks plain HTTP to a server whose address is **not** in the JAR. The
  address comes from the JAD file (property `HC-P`) or a bundled file `rsu`.
  Neither is present.
- It only starts when web features are on (`WAP_JAVA`), the online flag is
  on (`HCOC`), and an SMS top-up number exists. Here `WAP_JAVA` is 0.
- So in this copy the account menu entries have nothing behind them.

## How it works

| Operation | Request name | What it does | Text shown |
|---|---|---|---|
| Register | `register` | Create an account (login, password, optional e-mail and phone) | `T3_13`, `T3_15` |
| Log in | `auth` | Check login, fetch balance and achievements | `T3_14`, `T3_16` |
| Achievements | `achievements` | Upload unlocked achievements as a bit list | `T3_35`, `T3_36` |
| Map list | `list` | Fetch `id; name; price; is_purchased` for extra maps | `T3_20` "Open maps" |
| Buy / download map | `download` | Pay credits, receive the map file | `T3_22`, `T1_45` |

Two achievements exist: "Strategist" and "God of war" (`T3_37`, `T3_38`).

Server replies carry error codes that map to texts: wrong login (`T3_24`),
wrong password (`T3_25`), insufficient funds (`T3_26`), wrong device
(`T3_27`), map locked (`T3_28`), no content (`T3_29`).

Downloaded maps are saved in phone storage as mission numbers above 6 and
loaded by the normal mission loader; see
[custom games and saves](../gameplay/14-custom-games-and-saves.md).

Requests are ordinary GET or POST with form encoding. Sensitive fields are
Base64-wrapped with a key (class `b` plus a routine in `f`), and a CRC-32
(class `e`) is attached so the server can reject altered requests.

## How we know
- [`a.java:121`](../source/decompiled/a.java#L121) to [`a.java:125`](../source/decompiled/a.java#L125) : the three conditions and the call that starts the client (Observed)
- [`f.java:760`](../source/decompiled/f.java#L760) to [`f.java:765`](../source/decompiled/f.java#L765) : server address from property `HC-` + `P`, else from file `/rsu` (Observed)
- [`f.java:261`](../source/decompiled/f.java#L261), [`f.java:326`](../source/decompiled/f.java#L326), [`f.java:389`](../source/decompiled/f.java#L389), [`f.java:472`](../source/decompiled/f.java#L472) : the `register`, `auth`, `download`, `achievements` requests (Observed)
- [`f.java:847`](../source/decompiled/f.java#L847) : the HTTP routine (Observed)
- `../source/data/sn8p.json` : `WAP_JAVA: 0`, `HCOC: 1` (Observed)
- Zip listing: no `rsu` file; manifest: no `HC-P` (Observed)
- "Nothing behind the menu entries" (Inferred from the conditions above)

## Still unknown
- The request and reply formats in detail. Not traced: the feature is off
  and the server address is unknown.
- Whether HeroCraft's servers for this still exist.

**Next:** [Updates, adverts and "More games"](03-updates-ads-more-games.md)
