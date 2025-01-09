package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class msgdebug_aux extends GXProcedure
{
   public msgdebug_aux( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( msgdebug_aux.class ), "" );
   }

   public msgdebug_aux( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      msgdebug_aux.this.AV8programa = aP0;
      msgdebug_aux.this.AV10mensaje = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
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
   private String AV8programa ;
   private String AV10mensaje ;
}
