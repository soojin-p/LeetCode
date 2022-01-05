/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
ListNode* findloc(ListNode* list, int n)
{
    while(n--)
    {
        list=list->next;
    }
    return list;
}
    
ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {

	ListNode* tmpa, * tmpb, *tmp = list2;

	
    tmpa= findloc(list1,(a-1));
    tmpb= findloc(list1,(b+1));
    
    while(list2->next!=nullptr)
    {
      list2=list2->next;
    }
    
    tmpa->next=tmp;
    list2->next=tmpb;
	
	return list1;
}
};