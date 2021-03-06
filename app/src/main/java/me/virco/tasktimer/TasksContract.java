package me.virco.tasktimer;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import static me.virco.tasktimer.AppProvider.CONTENT_AUTHORITY;
import static me.virco.tasktimer.AppProvider.CONTENT_AUTHORITY_URI;

/**
 *
 * Created by mvbrenes on 5/24/17.
 */

class TasksContract {

    static final String TABLE_NAME = "Tasks";

    // Tasks fields
    static class Columns {
        static final String _ID = BaseColumns._ID;
        static final String TASKS_NAME = "Name";
        static final String TASKS_DESCRIPTION = "Description";
        static final String TASKS_SORT_ORDER = "SortOrder";

        private Columns() {
            //  private constructor to prevent initialization
        }
    }

    /**
     * The URI to access the Tasks table
     */
    static final Uri CONTENT_URI  = Uri.withAppendedPath(
            CONTENT_AUTHORITY_URI, TABLE_NAME);

    static final String CONTENT_TYPE = "vnd.android.dir/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;
    static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;

    static Uri buildTaskUri(long taskId) {
        return ContentUris.withAppendedId(CONTENT_URI, taskId);
    }

    static long getTaskId(Uri uri) {
        return ContentUris.parseId(uri);
    }
}
