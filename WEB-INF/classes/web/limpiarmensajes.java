package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class limpiarmensajes extends GXProcedure
{
   public limpiarmensajes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( limpiarmensajes.class ), "" );
   }

   public limpiarmensajes( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.GX_msglist.addItem(httpContext.getMessage( "<#CLEAR#>", ""));
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
}

