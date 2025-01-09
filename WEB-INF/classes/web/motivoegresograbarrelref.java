package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class motivoegresograbarrelref extends GXProcedure
{
   public motivoegresograbarrelref( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegresograbarrelref.class ), "" );
   }

   public motivoegresograbarrelref( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      motivoegresograbarrelref.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.pendiente(remoteHandle, context).execute( ) ;
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
   private int AV8CliCod ;
}

