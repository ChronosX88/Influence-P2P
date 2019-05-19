package io.github.chronosx88.influence.contracts

import android.content.Intent
import android.view.MenuItem

import io.github.chronosx88.influence.helpers.ChatListAdapter
import io.github.chronosx88.influence.models.roomEntities.ChatEntity
import io.github.chronosx88.influence.models.roomEntities.MessageEntity

interface CoreContracts {

    interface ViewWithLoadingScreen {
        fun loadingScreen(state: Boolean);
    }

    // -----ChatList-----

    interface IChatListLogicContract {
        fun loadAllChats(): List<ChatEntity>
    }

    interface IChatListPresenterContract {
        fun updateChatList()
        fun openChat(chatID: String)
        fun onContextItemSelected(item: MenuItem)
    }

    interface IChatListViewContract {
        fun setRecycleAdapter(adapter: ChatListAdapter)
        fun startActivity(intent: Intent)
        fun updateChatList(adapter: ChatListAdapter, chats: List<ChatEntity>)
    }

    // -----MainActivity-----

    interface IMainLogicContract {
        fun initPeer()
        fun sendStartChatMessage(username: String)
        fun shutdownPeer()
    }

    interface IMainPresenterContract {
        fun initPeer()
        fun startChatWithPeer(username: String)
        fun onDestroy()
    }

    interface IMainViewContract {
        fun showSnackbar(message: String)
        fun showProgressBar(state: Boolean)
    }

    // -----ChatActivity-----

    interface IChatLogicContract {
        fun sendMessage(message: MessageEntity)
        fun stopTrackingForNewMsgs()
    }

    interface IChatPresenterContract {
        fun sendMessage(text: String)
        fun updateAdapter()
        fun onDestroy()
    }

    interface IChatViewContract {
        fun updateMessageList(message: MessageEntity)
        fun updateMessageList(messages: List<MessageEntity>)
    }

    // -----SettingsFragment-----

    interface ISettingsLogic {
        fun checkUsernameExists(username: String) : Boolean
    }

    interface ISettingsPresenter {
        fun updateUsername(username: String)
    }

    interface ISettingsView {
        fun loadingScreen(state: Boolean)
        fun showMessage(message: String)
        fun refreshScreen()
    }

    // -----LoginActivity-----
    interface ILoginViewContract : ViewWithLoadingScreen
}
