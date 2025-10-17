```mermaid
classDiagram
    class SaleableItem {
        +sellItem()
        +getPrice()
    }

    class Editable {
        +edit()
        +initialize()
        +getInput()
    }

    class Publication {
        -title : String
        -price : double
        -copies : int
        +sellItem()
        +getPrice()
    }

    class Book {
        -author : String
    }

    class Magazine {
        -orderQty : int
        -currentIssue : LocalDate
    }

    class DiscMag {
        -hasDisc : boolean
    }

    class Ticket {
        -id : int
        -description : String
        -price : double
    }

    class CashTill {
        -runningTotal : double
        +sellItem(SaleableItem)
        +showTotal()
    }

    Editable <|-- Publication
    Publication <|-- Book
    Publication <|-- Magazine
    Magazine <|-- DiscMag
    SaleableItem <|.. Publication
    SaleableItem <|.. Ticket
    CashTill --> SaleableItem
