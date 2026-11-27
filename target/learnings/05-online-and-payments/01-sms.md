# Can the game send text messages?

> **In one line:** The code can send paid SMS for three purposes, but this
> build ships without the phone numbers and message texts, so none can fire.

## The short answer
- One tiny class, `h`, sends a text message through the phone's SMS API.
- Three uses were designed: **unlock** the next levels, **top up** account
  credits, and **tell a friend**.
- Numbers, texts and prices are not in the code. They come from settings
  (`UNLKS`, `ADDMS`, `TAFSMS`), chosen per mobile operator.
- This build has `SMS_JAVA: 1` (feature on) but defines none of those
  settings. With no number to send to, the SMS screens cannot complete.
- On a real phone the system would also ask the user before any SMS left.

## How it works

At start-up, if `SMS_JAVA` is on, the game:

1. Reads the phone's SMS centre number (system property
   `wireless.messaging.sms.smsc`). Its prefix identifies the operator.
2. Reads the `UNLKS` setting. It is four lists separated by `%`, each list
   separated by `|`: operator prefixes, then three matching lists (number,
   message text, price label).
3. Picks the entry whose prefix matches the SMS centre number. If there is
   only one entry, it is used for everyone.
4. Does the same with `ADDMS` for the credit top-up, and reads how many
   credits one message buys from `ADDCRD`.

| Purpose | Setting | Prompt shown | In this build |
|---|---|---|---|
| Unlock levels | `UNLKS` | `T3_10` "Do you want to send SMS and unlock level? The cost of sending SMS [SMS_COST]." | Setting absent |
| Top up credits | `ADDMS`, `ADDCRD` | `T3_34` "...increase balance by [CRD] credits? SMS price [SMS_COST]." | Setting absent |
| Tell a friend | `TAFSMS` | `T3_1` "Do you want to tell a friend about this game?" | Setting absent |

Sending itself is four lines: open `sms://<number>`, create a text message,
set its text, send. The game shows `T3_5` "Sending SMS..." and then `T3_6`
(success) or `T3_7` (failure).

A fourth setting, `YAY`, feeds one more SMS call in the UI code. It is also
absent here and was not traced further.

## How we know
- [`h.java:9`](../source/decompiled/h.java#L9) : the whole SMS sender (Observed)
- [`a.java:83`](../source/decompiled/a.java#L83) to [`a.java:107`](../source/decompiled/a.java#L107) : start-up handling of `SMS_JAVA`, `TAFSMS`, `UNLKS`, `ADDMS`, `ADDCRD` (Observed)
- [`a.java:374`](../source/decompiled/a.java#L374) : the `%` and `|` template parser and the prefix match (Observed)
- [`a.java:572`](../source/decompiled/a.java#L572) : reads the SMS centre property (Observed)
- [`g.java:8572`](../source/decompiled/g.java#L8572) : the "Sending SMS..." wrapper around `h.a` (Observed)
- `../source/data/sn8p.json` : `SMS_JAVA` is 1; `UNLKS`, `ADDMS`, `TAFSMS`, `ADDCRD`, `YAY` do not exist (Observed)
- "Cannot complete" (Inferred: with the setting missing the template is `null` and the send routine has no number)

## Still unknown
- Which list in the template is the number and which the text (positions 1
  and 2); the code passes them through without naming them.
- What the unlock actually unlocks. See
  [ranks](../gameplay/10-ranks-score-difficulty.md).

**Next:** [The HeroCraft account](02-herocraft-account.md)
