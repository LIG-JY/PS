#include <bits/stdc++.h>
using namespace std;

typedef struct node
{
	int data;
	struct node* next;
} node;

// create node
node* create_node(int data)
{
	node* new_node = (node*)malloc(sizeof(node));
	new_node->data = data;
	new_node->next = nullptr;
	return new_node;
}

node* traverse(node* head, int k)
{
	if (head == nullptr || k <= 0)
	{
		return nullptr;
	}
	node* current = head;
	int index = 1;
	while (index < k && current->next != nullptr)
	{
		current = current->next;
		index++;
	}
	return current;
}
// insert node at the end
void push_back(node** head, int data)
{
	if (*head == nullptr)
	{
		*head = create_node(data);
		return;
	}
	node* current = *head;
	while (current->next != nullptr)
	{
		current = current->next;
	}
	current->next = create_node(data);
}

// insert node at the beginning
void push_front(node** head, int data)
{
	node* new_head = create_node(data);
	new_head->next = *head;
	*head = new_head;
}

// insert node at the given position
void insert(node** head, int data, int position)
{
	if (position <= 0)
	{
		printf("Invalid position\n");
		return;
	}
	node* new_node = create_node(data);
	if (position == 1)
	{
		new_node->next = *head;
		*head = new_node;
		return;
	}
	node* previous = traverse(*head, position - 1);
	new_node->next = previous->next;
	previous->next = new_node;
}

// delete node at the end
void pop_back(node** head)
{
	node* current = *head;
	// 0개 노드
	if (current == nullptr)
	{
		return;
	}

	// 1개 노드
	if (current->next == nullptr)
	{
		free(current);
		return;
	}

	// 2개 이상 노드
	while (current->next->next != nullptr)
	{
		current = current->next;
	}
	free(current->next);
	current->next = nullptr;
}

// delete node at the beginning
void pop_front(node** head)
{
	node* current = *head;
	// 0개 노드
	if (current == nullptr)
	{
		return;
	}
	// 1개 노드
	if (current->next == nullptr)
	{
		free(current);
		*head = nullptr;
	}
	// 2개 이상
	*head = current->next;
	free(current);
}

// delete node at the given position
void remove(node** head, int position)
{
	if (position <= 0)
	{
		printf("Invalid position\n");
		return;
	}

	if (position == 1)
	{
		pop_front(head);
		return;
	}

	node* current = *head;

	if (current == nullptr)
	{
		return;
	}

	int current_position = 1;
	while (current->next != nullptr && current_position != position - 1)
	{
		current = current->next;
		current_position++;
	}
	node* temp = current->next;
	if (temp == nullptr)
	{
		return;
	}
	current->next = current->next->next;
	free(temp);
}
