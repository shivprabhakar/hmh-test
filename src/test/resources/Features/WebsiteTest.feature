# new feature
# Tags: optional

Feature: public website verification

  Scenario Outline: Verify different page navigation
    Given a user launch the website <URL>
    When user navigates to <TabName> page
    Then verify the page title <PageTitle> on tab <TabName>
    Then verify page url <PageUrl>
    Then verify dayDate <TabName>

    Examples:
      | URL                  | TabName | PageTitle          | PageUrl                   |
      | https://www.bbc.com/ | Home    | Welcome to BBC.com | https://www.bbc.com/      |
      | https://www.bbc.com/ | News    | BBC News           | https://www.bbc.com/news  |
      | https://www.bbc.com/ | Sport   | SPORT              | https://www.bbc.com/sport |


  Scenario Outline: Verify search text
    Given a user launch the website <URL>
    When enter the text <SearchText> on search box
    Then verify the search results <Results>

    Examples:
      | URL                  | SearchText                | Results          |
      | https://www.bbc.com/ | Houghton Mifflin Harcourt | Houghton Mifflin |

